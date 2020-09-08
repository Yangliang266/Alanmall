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
 * 总部卡充值
 * @author chenfei
 * 2018-10-18
 */
public class RechargeAction extends InterfaceBaseAction{


	private static final long serialVersionUID = -2504724997904054974L;

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
	public String getRechargeList(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}
		pageSet(rechargeDto);
		pageData.rows = getPage(rechargeDto);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 *  获取列表数据
	 */
	private List<RechargeVo> getPage(RechargeDto rechargeDto){

		rechargeDto.setCompanyId(user.getCompanyId());
		// 门店只可以对激活后的卡进行充值，总部可以对总部入库状态的卡进行充值
		rechargeDto.setStatus(CardConstants.KEY_CARD_STATE_HQ_IN);

		List<Recharge> rechargeList = rechargeManager.getHeadPageList(rechargeDto);
		Integer t = rechargeManager.getHeadPageTotal(rechargeDto);
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
	public void getRechargeListEexport(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		rechargeDto.setStart(0);
		rechargeDto.setLimit(Integer.MAX_VALUE);
		List<RechargeVo> rechargeVoList= getPage(rechargeDto);

	    String fileName = "总部充值 ";

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
	 * check卡类别，
	 * 最大充值次数与当前充值次数
	 */
	public String getRechargePrepare() {
		if (rechargeDto == null) {
			rechargeDto = new RechargeDto();
		}

		// 根据条件查询卡信息
		rechargeDto.setCompanyId(user.getCompanyId());
		rechargeDto.setStart(0);
		rechargeDto.setLimit(Integer.valueOf(rechargeDto.getRechargeNum()));
		List<Recharge> rechargeList = rechargeManager.getHeadPageList(rechargeDto);
		// check卡类别
		for(int i = 1; i < rechargeList.size(); i++){
			int k = rechargeList.get(i-1).getCategory();
			int m = rechargeList.get(i).getCategory();
	    	if(k != m){
	    		result.setResultInfo(-1, "请指定同类型的卡。");
	    		return SUCCESS;
	    	}
	    }

		// check充值次数
		for(int j = 0; j < rechargeList.size(); j++){
	    	if(rechargeList.get(j).getMaxRechargeCount() != null
	    			&& rechargeList.get(j).getMaxRechargeCount() <= rechargeList.get(j).getRechargeCount()){
	    		result.setResultInfo(-2, "指定的卡中" + rechargeList.get(j).getCardNo() + "卡已达到最大充值次数。");
	    		return SUCCESS;
	    	}
	    }
		pageSet(rechargeDto);
		pageData.rows = getPage(rechargeDto);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 充值
	 */
	public String updateRecharge(){
		if (rechargeDto == null) {
			rechargeDto = new RechargeDto();
		}

		if(rechargeHistory == null) {
			result.setResultInfo(-1, "充值内容丢失。");
			return SUCCESS;
		}
		if((cardNoArr == null || cardNoArr.length == 0) &&
				((rechargeDto.getRechargeNum()) == "") && (rechargeDto.getRechargeNum()) == null) {
			result.setResultInfo(-1, "请选择充值卡号。");
			return SUCCESS;
		}

		try {
			if (rechargeDto.getRechargeNum() == "" || rechargeDto.getRechargeNum() == null) {
				// 仅选择指定
				List<RechargeHistory> rechargeHistoryList = new ArrayList<>();
				for(String cardNo : cardNoArr) {
					RechargeHistory r = new RechargeHistory();
					r.setPayMode(rechargeHistory.getPayMode());
					r.setRechargeAmount(rechargeHistory.getRechargeAmount());
					r.setReward(rechargeHistory.getReward());

					r.setCardNo(cardNo);
					r.setCompanyId(user.getCompanyId());
					r.setCreateId(user.getId());
					r.setRechargeStore(0L);// 总部没事storeId
					rechargeHistoryList.add(r);
				}
				rechargeManager.updateHeadRecharge(rechargeHistoryList);
				result.setResultInfo(0, "充值成功。");
				return SUCCESS;
			} else {
				// 仅数量指定
				// 根据条件查询卡信息
				rechargeDto.setCompanyId(user.getCompanyId());
				Integer rechargeTotal = rechargeManager.getHeadPageTotal(rechargeDto);
				rechargeDto.setStart(0);
				rechargeDto.setLimit(Integer.valueOf(rechargeDto.getRechargeNum()));
				List<Recharge> rechargeListNum = rechargeManager.getHeadPageList(rechargeDto);

			    cardNoArr = new String[rechargeListNum.size()];
				for (int i = 0; i < rechargeListNum.size(); i++) {
					cardNoArr[i] = rechargeListNum.get(i).getCardNo();
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
					r.setRechargeStore(0L);
					rechargeHistoryList.add(r);
				}
				rechargeManager.updateHeadRecharge(rechargeHistoryList);
				if (rechargeTotal < Integer.valueOf(rechargeDto.getRechargeNum())) {
					result.setResultInfo(-3, "充值成功，实际充值记录数：" + rechargeTotal + "张。");
				} else {
					result.setResultInfo(0, "充值成功。");
				}

				return SUCCESS;
			}
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
