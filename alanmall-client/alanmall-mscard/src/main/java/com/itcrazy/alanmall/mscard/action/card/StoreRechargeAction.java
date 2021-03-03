package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeManager;
import com.itcrazy.alanmall.mscard.model.Recharge;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.RechargeVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 门店卡充值
 * @author chenfei
 * 2018-10-18
 */
public class StoreRechargeAction extends InterfaceBaseAction{
	private static final long serialVersionUID = 1587778601766337489L;

	@Reference
	RechargeManager rechargeManager;
	@Reference
	UserManager userManager;

	private RechargeDto rechargeDto;
	private RechargeHistory rechargeHistory;
	private String[] cardNoArr;

	/**
	 * 页面显示
	 * @return
	 */
	public String getStoreRechargeList(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}
		pageSet(rechargeDto);
		pageData.rows = getPage(rechargeDto);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取列表数据
	 */
	private List<RechargeVo> getPage(RechargeDto rechargeDto){

		rechargeDto.setCompanyId(user.getCompanyId());
		rechargeDto.setBrandId(user.getBrandId());
		rechargeDto.setStoreId(user.getStoreId());
		// 门店只可以对激活后的卡进行充值，总部可以对总部入库状态的卡进行充值
		rechargeDto.setStatus(CardConstants.KEY_CARD_STATE_ACTIVATED);

		List<Recharge> rechargeList = rechargeManager.getStorePageList(rechargeDto);
		Integer t = rechargeManager.getStorePageTotal(rechargeDto);
		pageData.setTotal(t);

		List<RechargeVo> rechargeVoList = new ArrayList<RechargeVo>();

		if(rechargeList != null && rechargeList.size()>0){

			for(Recharge r : rechargeList){
				RechargeVo rv = new RechargeVo();

				rv.setStoreInReceiptNo(r.getStoreInReceiptNo());
				rv.setCardNo(r.getCardNo());
				rv.setCategoryName(r.getCategoryName());
				rv.setCategory(r.getCategory());
				rv.setStatus(KeyValueConvert.getCardStatusValue(r.getStatus()));
				rv.setStoreInTime(DateFormat.dateToString(r.getStoreInTime()));

				User storeInPerson = userManager.getUserById(r.getStoreInPerson());
				rv.setStoreInPerson(storeInPerson != null ? storeInPerson.getRealName() : "");

				rv.setIsRecharge(r.getIsRecharge());
				rv.setRechargeBalance(r.getRechargeBalance());
				rv.setIsNamed(r.getIsNamed());
				rv.setMaxRechargeCount(r.getMaxRechargeCount());
				rv.setRechargeCount(r.getRechargeCount());

				rechargeVoList.add(rv);
			}
		}

		return rechargeVoList;
	}

	/**
	 * 导出数据
	 */
	public void getStoreRechargeListEexport(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		rechargeDto.setStart(0);
		rechargeDto.setLimit(Integer.MAX_VALUE);
		List<RechargeVo> rechargeVoList= getPage(rechargeDto);

	    String fileName = "门店充值 ";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("门店入库时间", "storeInTime");
	    headerMaps.put("门店入库操作人", "storeInPerson");

		try {
			String content =  CSVUtils.formatCsvData(rechargeVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 充值
	 */
	public String updateStoreRecharge(){

		if(rechargeHistory == null) {
			result.setResultInfo(-1, "充值内容丢失。");
			return SUCCESS;
		}
		if(cardNoArr == null || cardNoArr.length == 0) {
			result.setResultInfo(-1, "请选择充值卡号。");
			return SUCCESS;
		}

		List<RechargeHistory> rechargeHistoryList = new ArrayList<>();
		for(String cardNo : cardNoArr) {
			RechargeHistory r = new RechargeHistory();
			r.setPayMode(rechargeHistory.getPayMode());
			r.setRechargeAmount(rechargeHistory.getRechargeAmount());
			r.setReward(rechargeHistory.getReward());

			r.setCardNo(cardNo);
			r.setCompanyId(user.getCompanyId());
			r.setCreateId(user.getId());
			r.setRechargeStore(user.getStoreId());
			rechargeHistoryList.add(r);
		}

		try {
			rechargeManager.updateStoreRecharge(rechargeHistoryList);
			result.setResultInfo(0, "充值成功。");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "充值失败。");
			return SUCCESS;
		}

	}


	public RechargeDto getRechargeDto() {
		return rechargeDto;
	}

	public void setRechargeDto(RechargeDto rechargeDto) {
		this.rechargeDto = rechargeDto;
	}

	public String[] getCardNoArr() {
		return cardNoArr;
	}

	public void setCardNoArr(String[] cardNoArr) {
		this.cardNoArr = cardNoArr;
	}

	public RechargeHistory getRechargeHistory() {
		return rechargeHistory;
	}

	public void setRechargeHistory(RechargeHistory rechargeHistory) {
		this.rechargeHistory = rechargeHistory;
	}

}
