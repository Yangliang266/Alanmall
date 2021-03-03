package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.CardManager;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.StoreWarehouseOutVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 门店调拨主页设置
 *
 * @author luxf
 */
public class StoreWarehouseOutHistoryAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;

	@Reference
	StoreWarehouseOutManager storeWarehouseOutManager;
	@Reference
	UserManager userManager;
	@Reference
	CardManager cardManager;
	@Reference
	StoreManager storeManager;

	private StoreWarehouseOut storeWarehouseOut;
	private StoreWarehouseOutDto storeWarehouseOutDto;
	private String receiptNo;

	/**
	 *  获取历史记录列表数据
	 */
	private List<StoreWarehouseOutVo> getPage(StoreWarehouseOutDto storeWarehouseOutDto){
		List<StoreWarehouseOut> swiList = storeWarehouseOutManager.getPageHistory(storeWarehouseOutDto);

		List<StoreWarehouseOutVo> swivList = new ArrayList<StoreWarehouseOutVo>();

		if (swiList != null && swiList.size() > 0) {

			for (StoreWarehouseOut s : swiList) {
				StoreWarehouseOutVo sv = new StoreWarehouseOutVo();

				sv.setReceiptNo(s.getReceiptNo());
				sv.setStoreInReceiptNo(s.getStoreInReceiptNo());
				sv.setCardNo(s.getCardNo());
				sv.setCategoryName(s.getCategoryName());
				sv.setStatus(KeyValueConvert.getCardStatusValue(s.getStatus()));
				Store store = storeManager.getStoreById(s.getStoreFrom());
				sv.setStoreFromStr(store != null ? store.getName() : "");
				sv.setStoreOutTime(DateFormat.dateToString(s.getStoreOutTime()));
				User storeOutPerson = userManager.getUserById(s.getStoreOutPerson());
				sv.setStoreOutPerson(storeOutPerson != null ? storeOutPerson.getRealName() : "");
				Store storeto = storeManager.getStoreById(s.getStoreTo());
				sv.setStoreTo(storeto != null ? storeto.getName() : "");

				swivList.add(sv);
			}
		}
		return swivList;
	}

	/**
	 *  历史记录页面显示
	 */
	public String getStoreWarehouseOutHistoryList() {

		if (storeWarehouseOutDto == null) {
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		pageSet(storeWarehouseOutDto);

		storeWarehouseOutDto.setReceiptNo(receiptNo);
		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());

		pageData.rows = getPage(storeWarehouseOutDto);

		Integer t = storeWarehouseOutManager.getPageOutHistoryTotal(storeWarehouseOutDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 *  导出和打印历史纪录的数据
	 * @return
	 */
	private List<StoreWarehouseOutVo> StoreWarehouseOutHistoryPrepare(StoreWarehouseOutDto storeWarehouseOutDto){
		if(storeWarehouseOutDto == null){
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		storeWarehouseOutDto.setReceiptNo(receiptNo);
		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());
		storeWarehouseOutDto.setStart(0);
		storeWarehouseOutDto.setLimit(Integer.MAX_VALUE);

		List<StoreWarehouseOutVo> storeWarehouseOutVoList= getPage(storeWarehouseOutDto);
		return storeWarehouseOutVoList;
	}

	/**
	 *  历史纪录头部
	 * @return
	 */
	private LinkedHashMap<String,String> StoreWarehouseOutHistoryHeader() {
		  //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("门店出库单号", "receiptNo");
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("调拨出库门店（本店）", "storeFromStr");
	    headerMaps.put("调拨出库时间", "storeOutTime");
	    headerMaps.put("调拨出库操作人", "storeOutPerson");
	    headerMaps.put("调拨入库门店", "storeTo");
	    return headerMaps;
	}

	/**
	 *  导出历史记录数据
	 */
	public void getStoreWarehouseOutHistoryListEexport(){

		List<StoreWarehouseOutVo> storeWarehouseOutVoList= StoreWarehouseOutHistoryPrepare(storeWarehouseOutDto);

	    String fileName = "已入库的《门店入库单》";

		try {
			String content =  CSVUtils.formatCsvData(storeWarehouseOutVoList, StoreWarehouseOutHistoryHeader());
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  预览历史记录PDF（可下载，可保存）
	 */
	public void getStoreWarehouseOutHistoryHistoryPDFPreview(){

		List<StoreWarehouseOutVo> storeWarehouseOutVoList= StoreWarehouseOutHistoryPrepare(storeWarehouseOutDto);

		String fileName = "已入库的《门店入库单》";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(storeWarehouseOutVoList, StoreWarehouseOutHistoryHeader());
			// 每列宽度
			float[] columnsWidth = {30f, 30f, 30f, 23f, 23f, 30f, 25f, 30f, 28f};
			PDFUtil.preview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StoreWarehouseOut getStoreWarehouseOut() {
		return storeWarehouseOut;
	}

	public void setStoreWarehouseOut(StoreWarehouseOut storeWarehouseOut) {
		this.storeWarehouseOut = storeWarehouseOut;
	}

	public StoreWarehouseOutDto getStoreWarehouseOutDto() {
		return storeWarehouseOutDto;
	}

	public void setStoreWarehouseOutDto(StoreWarehouseOutDto storeWarehouseOutDto) {
		this.storeWarehouseOutDto = storeWarehouseOutDto;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

}
