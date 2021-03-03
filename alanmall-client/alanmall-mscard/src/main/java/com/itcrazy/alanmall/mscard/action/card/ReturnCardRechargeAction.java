package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeManager;
import com.itcrazy.alanmall.mscard.manager.ReturnCardRechargeManager;
import com.itcrazy.alanmall.mscard.model.ReturnCardRechargeHistory;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.ReturnCardRechargeHistoryVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 退卡充值记录
 * @author softwise
 *
 */

public class ReturnCardRechargeAction extends InterfaceBaseAction{

	private static final long serialVersionUID = -2504724997904054974L;

	@Reference
	RechargeManager rechargeManager;
	@Reference
	ReturnCardRechargeManager returnCardRechargeManager;
	@Reference
	UserManager userManager;
	@Reference
	StoreManager storeManager;

	public String cardNo;

	private RechargeDto rechargeDto;


	/**
	 *  获取充值历史记录列表数据
	 */
	private List<ReturnCardRechargeHistoryVo> getPage(RechargeDto rechargeDto){


		List<ReturnCardRechargeHistory> returnCardRechargeHistoryList = returnCardRechargeManager.getPageList(rechargeDto);
		List<ReturnCardRechargeHistoryVo> returnCardRechargeHistoryVoList = new ArrayList<ReturnCardRechargeHistoryVo>();

		if (returnCardRechargeHistoryList != null && returnCardRechargeHistoryList.size() > 0) {
			for (ReturnCardRechargeHistory rrh : returnCardRechargeHistoryList) {
				ReturnCardRechargeHistoryVo rrhv = new ReturnCardRechargeHistoryVo();
				rrhv.setCardNo(rrh.getCardNo()+"");
				rrhv.setCategoryName(rrh.getCategoryName());
				//rrhv.setPayModeStr(rrh.getPayModeStr());
				rrhv.setPayModeStr(rrh.getPayMode());
				rrhv.setRechargeAmount(rrh.getRechargeAmount().toString());
				rrhv.setRechargeTime(DateFormat.dateToString(rrh.getRechargeTime()));
				rrhv.setReward(rrh.getReward().toString());
				rrhv.setStatus(KeyValueConvert.getCardStatusValue(rrh.getStatus()));

				Store rechargeStore = storeManager.getStoreById(rrh.getRechargeStore());
				rrhv.setRechargeStore(rechargeStore != null ? rechargeStore.getName() : "卡中心");

				User rechargePerson = userManager.getUserById(rrh.getRechargePerson());
				rrhv.setRechargePerson(rechargePerson != null ? rechargePerson.getRealName() : "");
				returnCardRechargeHistoryVoList.add(rrhv);
			}
		}
		return returnCardRechargeHistoryVoList;
	}

	// 充值历史记录
	public String getReturnCardRechargeHistory() {
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		rechargeDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPage(rechargeDto);
		Integer iTotalRows = returnCardRechargeManager.getPageTotal(rechargeDto);
		pageData.setTotal(iTotalRows);
		result.setSuccessInfo();
		return SUCCESS;
	}


	/**
	 * 导出充值历史记录数据
	 */
	public void getReturnCardRechargeHistoryEexport(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		rechargeDto.setCompanyId(user.getCompanyId());
		rechargeDto.setStart(0);
		rechargeDto.setLimit(Integer.MAX_VALUE);

		List<ReturnCardRechargeHistoryVo> returnCardRechargeHistoryVoList= getPage(rechargeDto);

	    String fileName = "充值历史记录" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("充值门店", "rechargeStore");
	    headerMaps.put("充值支付方式", "payModeStr");
	    headerMaps.put("充值金额", "rechargeAmount");
	    headerMaps.put("奖励", "reward");
	    headerMaps.put("充值时间", "rechargeTime");
	    headerMaps.put("充值操作人", "rechargePerson");

		try {
			String content =  CSVUtils.formatCsvData(returnCardRechargeHistoryVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public RechargeDto getRechargeDto() {
		return rechargeDto;
	}

	public void setRechargeDto(RechargeDto rechargeDto) {
		this.rechargeDto = rechargeDto;
	}

}
