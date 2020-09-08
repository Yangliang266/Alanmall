package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CreditSalesDto;
import com.itcrazy.alanmall.mscard.manager.CreditSalesManager;
import com.itcrazy.alanmall.mscard.model.CreditSalesHistory;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.CreditSalesVo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 清账
 * @author zhangzhongtian
 * 2018-10-09
 */
public class CreditSalesAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -7778065294045735854L;

	private CreditSalesDto creditSalesDto;
	private String[] salesIds;
	private BigDecimal amount;
	private String clearFlag;
	private String cardNo;

	@Reference
	CreditSalesManager creditSalesManager;
	@Reference
	StoreManager storeManager;

	/*
	 *  获取挂账卡信息
	 */
	private List<CreditSalesVo> getPage(CreditSalesDto creditSalesDto){
		if("1".equals(creditSalesDto.getStatusFlag())) {
			// 清账弹出画面的场合，无需分页
			creditSalesDto.setLimit(Integer.MAX_VALUE);
		}

		List<CreditSalesHistory> creditSalesList = creditSalesManager.getCreditSalesList(creditSalesDto);
		List<CreditSalesVo> creditSalesVoList = new ArrayList<CreditSalesVo>();

		if (creditSalesList != null && creditSalesList.size() > 0) {

			for (CreditSalesHistory c : creditSalesList) {
				CreditSalesVo cs = new CreditSalesVo();

				cs.setCreditSalesId(c.getOrderNo());
				cs.setCardNo(c.getCardNo());
				cs.setConsumeTime(DateFormat.dateToString(c.getConsumeTime()));
				Store store = storeManager.getStoreById(c.getStore());
				cs.setStore(store != null ? store.getName() : "");
				cs.setCreditBill(c.getCreditBill());
				cs.setClearBill(c.getClearBill());
				cs.setCredit(c.getCredit());
				cs.setStatus(KeyValueConvert.getCreditSalesStatusValue(c.getStatus()));

				creditSalesVoList.add(cs);
			}
		}

		if("0".equals(creditSalesDto.getStatusFlag())) {
			Integer t = creditSalesManager.getPageTotal(creditSalesDto);
			pageData.setTotal(t);

			if(creditSalesDto.getStart() + creditSalesDto.getLimit() >= t) {
				// 查询合计信息
				CreditSalesHistory totalInfo = creditSalesManager.getTotalInfo(creditSalesDto);
				if(totalInfo != null) {
					CreditSalesVo totalInfoVo = new CreditSalesVo();
					totalInfoVo.setCardNo("合计");
					totalInfoVo.setCreditBill(totalInfo.getCreditBill());
					totalInfoVo.setClearBill(totalInfo.getClearBill());
					totalInfoVo.setCredit(totalInfo.getCredit());
					creditSalesVoList.add(totalInfoVo);
				}
			}
		}
		return creditSalesVoList;
	}
	/*
	 * 挂账卡信息一览页面显示
	 */
	public String getCreditSalesList() {
		if (creditSalesDto == null) {
			creditSalesDto = new CreditSalesDto();
		}

		pageSet(creditSalesDto);
		creditSalesDto.setCompanyId(user.getCompanyId());

		List<CreditSalesVo> creditSalesVoList = getPage(creditSalesDto);

		pageData.rows = creditSalesVoList;

		result.setSuccessInfo();
		return SUCCESS;
	}

	/*
	 * 清账
	 */
	public String updateCreditSales() {
		if (salesIds == null) {
			result.setParamErrorInfo("salesIds");
			return SUCCESS;
		}
		if (amount.compareTo(BigDecimal.ZERO) != 1) {
			result.setParamErrorInfo("amount");
			return SUCCESS;
		}

		CreditSalesHistory creditSales = new CreditSalesHistory();
		creditSales.setCredit(amount);
		creditSales.setUpdateId(user.getId());
		creditSales.setCardNo(cardNo);
		creditSales.setCompanyId(user.getCompanyId());

		creditSalesManager.updateCreditSales(salesIds,creditSales,clearFlag);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/*
	 * 导出挂账信息数据
	 */
	public void getCreditSalesHistoryEexport(){
		if(creditSalesDto == null){
			creditSalesDto = new CreditSalesDto();
		}

		creditSalesDto.setCompanyId(user.getCompanyId());
		creditSalesDto.setStart(0);
		creditSalesDto.setLimit(Integer.MAX_VALUE);

		List<CreditSalesVo> creditSalesVoList= getPage(creditSalesDto);

		String fileName = "挂账信息记录" + DateFormat.dateToString(new Date()) + ".csv";
		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("挂账卡号", "cardNo");
	    headerMaps.put("挂账订单号", "creditSalesId");
	    headerMaps.put("挂账时间", "consumeTime");
	    headerMaps.put("挂账门店", "store");
	    headerMaps.put("挂账金额", "creditBill");
	    headerMaps.put("已清账金额", "clearBill");
	    headerMaps.put("未清账金额", "credit");
	    headerMaps.put("清账状态", "status");

		try {
			String content =  CSVUtils.formatCsvData(creditSalesVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CreditSalesDto getCreditSalesDto() {
		return creditSalesDto;
	}

	public void setCreditSalesDto(CreditSalesDto creditSalesDto) {
		this.creditSalesDto = creditSalesDto;
	}

	public String[] getSalesIds() {
		return salesIds;
	}

	public void setSalesIds(String[] salesIds) {
		this.salesIds = salesIds;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getClearFlag() {
		return clearFlag;
	}
	public void setClearFlag(String clearFlag) {
		this.clearFlag = clearFlag;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}

