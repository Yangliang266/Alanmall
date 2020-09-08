package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseInDto;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.CardManager;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseInManager;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.StoreWarehouseOutVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 门店调拨入库设置
 *
 * @author yinxiang 2018-09-19
 */
public class StoreWarehousePrepareInAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;

	@Reference
	StoreWarehouseInManager storeWarehouseInManager;
	@Reference
	StoreWarehouseOutManager storeWarehouseOutManager;
	@Reference
	StoreManager storeManager;
	@Reference
	UserManager userManager;
	@Reference
	CardManager cardManager;

	private StoreWarehouseOut storeWarehouseOut;
	private StoreWarehouseOutDto storeWarehouseOutDto;
	private String receiptNo;
	private String choosedStoreId;
	private StoreWarehouseInDto storeWarehouseInDto;
	private String[] storeWarehouseInDtoArr;

	/**
	 * 获取历史记录列表数据
	 */
	private List<StoreWarehouseOutVo> getPage(StoreWarehouseOutDto storeWarehouseOutDto) {

		List<StoreWarehouseOut> swiList = storeWarehouseOutManager.getPagePrepareInList(storeWarehouseOutDto);

		List<StoreWarehouseOutVo> swivList = new ArrayList<StoreWarehouseOutVo>();

		if (swiList != null && swiList.size() > 0) {

			for (StoreWarehouseOut s : swiList) {
				StoreWarehouseOutVo sv = new StoreWarehouseOutVo();

				sv.setStoreInReceiptNo(s.getStoreInReceiptNo());
				sv.setReceiptNo(s.getReceiptNo());
				sv.setCardNo(s.getCardNo());

				sv.setCategoryName(s.getCategoryName());
				sv.setStatus(KeyValueConvert.getCardStatusValue(s.getStatus()));
				sv.setStoreOutTime(DateFormat.dateToString(s.getStoreOutTime()));
				Store store = storeManager.getStoreById(s.getStoreFrom());
				sv.setStoreFrom(s.getStoreFrom());
				sv.setStoreFromStr(store != null ? store.getName() : "");
				User storeOutPerson = userManager.getUserById(s.getStoreOutPerson());
				sv.setStoreOutPerson(storeOutPerson != null ? storeOutPerson.getRealName() : "");
				Store storeto = storeManager.getStoreById(s.getStoreTo());
				sv.setStoreTo(storeto != null ? storeto.getName() : "");

				swivList.add(sv);
			}
		}
		return swivList;

	}

    // 历史记录页面显示
	public String getStoreWarehousePrepareInList() {

		if (storeWarehouseOutDto == null) {
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		pageSet(storeWarehouseOutDto);
		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());
		storeWarehouseOutDto.setReceiptNo(receiptNo);

		pageData.rows = getPage(storeWarehouseOutDto);

		Integer t = storeWarehouseOutManager.getPagePrepareInTotal(storeWarehouseOutDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出历史记录数据
	 */
	public void getStoreWarehousePrepareInListEexport(){
		if(storeWarehouseOutDto == null){
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		storeWarehouseOutDto.setStart(0);
		storeWarehouseOutDto.setLimit(Integer.MAX_VALUE);
		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());
		storeWarehouseOutDto.setReceiptNo(receiptNo);


		List<StoreWarehouseOutVo> swivList= getPage(storeWarehouseOutDto);

	    String fileName = "门店调拨（调拨入库）" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("门店出库单号", "receiptNo");
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("调拨出库门店", "storeFromStr");
	    headerMaps.put("调拨出库时间", "storeOutTime");
	    headerMaps.put("调拨出库操作人", "storeOutPerson");
	    headerMaps.put("调拨入库门店（本店）", "storeTo");

		try {
			String content =  CSVUtils.formatCsvData(swivList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 门店入库状态
	public String updateStoreWarehousePrepareIn() {
		if (storeWarehouseInDtoArr == null && storeWarehouseInDtoArr.length == 0) {
			result.setSuccessInfo();
			return SUCCESS;
		}

		List<StoreWarehouseInDto> storeWarehouseInDtoList = new ArrayList<>();

		for (String storeWarehouseInDtoStr : storeWarehouseInDtoArr) {
			StoreWarehouseInDto sDto = new StoreWarehouseInDto();
			String[] strArr = storeWarehouseInDtoStr.split(":");
			sDto.setCardNo(strArr[0]);
			sDto.setWarehouseOutNo(strArr[1]);
			sDto.setStoreFrom(Long.valueOf(strArr[2]));
			storeWarehouseInDtoList.add(sDto);
		}

		StoreWarehouseIn storeWarehouseIn = new StoreWarehouseIn();

		storeWarehouseIn.setStoreTo(user.getStoreId());
		storeWarehouseIn.setCreateId(user.getId());
		storeWarehouseIn.setUpdateId(user.getId());
		storeWarehouseIn.setIsDeleted(0);
		storeWarehouseIn.setCompanyId(user.getCompanyId());

		// 操作数据
		try {
			String storeInReceiptNo = storeWarehouseInManager.OperaStoreWarehouseIn(storeWarehouseInDtoList, storeWarehouseIn);
			result.setResultInfo(0, storeInReceiptNo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "入库失败");
			return SUCCESS;
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

	public String getChoosedStoreId() {
		return choosedStoreId;
	}

	public void setChoosedStoreId(String choosedStoreId) {
		this.choosedStoreId = choosedStoreId;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public StoreWarehouseInDto getStoreWarehouseInDto() {
		return storeWarehouseInDto;
	}

	public void setStoreWarehouseInDto(StoreWarehouseInDto storeWarehouseInDto) {
		this.storeWarehouseInDto = storeWarehouseInDto;
	}

	public String[] getStoreWarehouseInDtoArr() {
		return storeWarehouseInDtoArr;
	}

	public void setStoreWarehouseInDtoArr(String[] storeWarehouseInDtoArr) {
		this.storeWarehouseInDtoArr = storeWarehouseInDtoArr;
	}

}
