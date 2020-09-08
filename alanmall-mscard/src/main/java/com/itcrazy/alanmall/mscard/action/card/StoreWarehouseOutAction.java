package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseOutManager;
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
 * 门店调拨主页设置
 *
 * @author yinxiang 2018-09-14
 */
public class StoreWarehouseOutAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;

	@Reference
	StoreWarehouseOutManager storeWarehouseOutManager;
	@Reference
	StoreManager storeManager;
	@Reference
	UserManager userManager;

	private String[] storeWarehouseOutDtoArr;
	private StoreWarehouseOut storeWarehouseOut;
	private StoreWarehouseOutDto storeWarehouseOutDto;

	/**
	 *  获取历史记录列表数据
	 */
	private List<StoreWarehouseOutVo> getPage(StoreWarehouseOutDto storeWarehouseOutDto){

		List<StoreWarehouseOut> swiList = storeWarehouseOutManager.getPageOutList(storeWarehouseOutDto);

		List<StoreWarehouseOutVo> swivList = new ArrayList<StoreWarehouseOutVo>();

		if (swiList != null && swiList.size() > 0) {

			for (StoreWarehouseOut s : swiList) {
				StoreWarehouseOutVo sv = new StoreWarehouseOutVo();

				sv.setReceiptNo(s.getReceiptNo());
				sv.setStoreInReceiptNo(s.getStoreInReceiptNo());
				Store store = storeManager.getStoreById(s.getStoreFrom());
				sv.setStoreFromStr(store != null ? store.getName() : "");
				Store storeto = storeManager.getStoreById(s.getStoreTo());
				sv.setStoreTo(storeto != null ? storeto.getName() : "");

				sv.setBusiness(KeyValueConvert.getStoreTransferValue(s.getBusiness()));
				sv.setBusinessType(s.getBusinessType());
				sv.setBusinessTypeStr(KeyValueConvert.getStoreTransferStatusValue(s.getBusinessType()));

				sv.setStoreInTime(DateFormat.dateToString(s.getStoreInTime()));
				sv.setStoreOutTime(DateFormat.dateToString(s.getStoreOutTime()));
				User storeInPerson = userManager.getUserById(s.getStoreInPerson());
				sv.setStoreInPerson(storeInPerson != null ? storeInPerson.getRealName() : "");
				User storeOutPerson = userManager.getUserById(s.getStoreOutPerson());
				sv.setStoreOutPerson(storeOutPerson != null ? storeOutPerson.getRealName() : "");

				swivList.add(sv);
			}
		}
		return swivList;

	}
	// 历史记录页面显示
	public String getStoreWarehouseOutList() {

		if (storeWarehouseOutDto == null) {
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		pageSet(storeWarehouseOutDto);

		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());



		pageData.rows =  getPage(storeWarehouseOutDto);

		Integer t = storeWarehouseOutManager.getPageOutTotal(storeWarehouseOutDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}
	/**
	 * 导出历史记录数据
	 */
	public void getStoreWarehouseOutListEexport(){
		if(storeWarehouseOutDto == null){
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStart(0);
		storeWarehouseOutDto.setLimit(Integer.MAX_VALUE);
		storeWarehouseOutDto.setStoreId(user.getStoreId());


		List<StoreWarehouseOutVo> swivList= getPage(storeWarehouseOutDto);

	    String fileName = "门店调拨" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("门店出库单号", "receiptNo");
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("业务单类型", "business");
	    headerMaps.put("业务单状态", "businessTypeStr");
	    headerMaps.put("调拨出库门店", "storeFromStr");
	    headerMaps.put("调拨入库门店", "storeTo");
	    headerMaps.put("门店出库时间", "storeOutTime");
	    headerMaps.put("出库操作人", "storeOutPerson");
	    headerMaps.put("门店入库时间", "storeInTime");
	    headerMaps.put("入库操作人", "storeInPerson");

		try {
			String content =  CSVUtils.formatCsvData(swivList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	public String[] getStoreWarehouseOutDtoArr() {
		return storeWarehouseOutDtoArr;
	}

	public void setStoreWarehouseOutDtoArr(String[] storeWarehouseOutDtoArr) {
		this.storeWarehouseOutDtoArr = storeWarehouseOutDtoArr;
	}

	public void setStoreWarehouseOutDto(StoreWarehouseOutDto storeWarehouseOutDto) {
		this.storeWarehouseOutDto = storeWarehouseOutDto;
	}

}
