package com.itcrazy.alanmall.mscard.action.card;

import lombok.Data;
import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseInDto;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseInManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.StoreWarehouseInVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * 门店入库设置
 *
 * @author yinxiang 2018-09-04
 */
@Data
public class StoreWarehouseInAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;

	@Reference
	UserManager userManager;
	@Reference
	StoreWarehouseInManager storeWarehouseInManager;

	private StoreWarehouseIn storeWarehouseIn;
	private StoreWarehouseInDto storeWarehouseInDto;
	private String[] storeWarehouseInDtoArr;


	/**
	 *  获取历史记录列表数据
	 */
	private List<StoreWarehouseInVo> getPage(StoreWarehouseInDto storeWarehouseInDto){
		List<StoreWarehouseIn> swiList = storeWarehouseInManager.getHistoryPageList(storeWarehouseInDto);
		List<StoreWarehouseInVo> swivList = new ArrayList<StoreWarehouseInVo>();

		if (swiList != null && swiList.size() > 0) {
			for (StoreWarehouseIn s : swiList) {
				StoreWarehouseInVo sv = new StoreWarehouseInVo();

				sv.setHeadOutReceiptNo(s.getHeadOutReceiptNo());
				sv.setStoreInReceiptNo(s.getStoreInReceiptNo());
				sv.setCardNo(s.getCardNo());
				sv.setCategoryName(s.getCategoryName());
				sv.setStatus(KeyValueConvert.getCardStatusValue(s.getStatus()));
				sv.setHeadOutTime(DateFormat.dateToString(s.getHeadOutTime()));

				User headOutPerson = userManager.getUserById(s.getHeadOutPerson());
				sv.setHeadOutPerson(headOutPerson!=null ? headOutPerson.getRealName() : "");
				sv.setStoreInTime(DateFormat.dateToString(s.getStoreInTime()));

				User storeInPerson = userManager.getUserById(s.getStoreInPerson());
				sv.setStoreInPerson(storeInPerson!=null ? storeInPerson.getRealName() : "");

				swivList.add(sv);
			}
		}
		return swivList;
	}

	/**
	 * 历史记录页面显示
	 * @return
	 */
	public String getStoreWarehouseInHistory() {

		if (storeWarehouseInDto == null) {
			storeWarehouseInDto = new StoreWarehouseInDto();
		}

		pageSet(storeWarehouseInDto);
		storeWarehouseInDto.setCompanyId(user.getCompanyId());
		storeWarehouseInDto.setStoreTo(user.getStoreId());

		pageData.rows = getPage(storeWarehouseInDto);
		Integer t = storeWarehouseInManager.getHistoryPageTotal(storeWarehouseInDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出和打印历史纪录的数据
	 * @param storeWarehouseInDto
	 * @return
	 */
	private List<StoreWarehouseInVo> StoreWarehouseInHistoryPrepare (StoreWarehouseInDto storeWarehouseInDto){
		if(storeWarehouseInDto == null){
			storeWarehouseInDto = new StoreWarehouseInDto();
		}
		storeWarehouseInDto.setCompanyId(user.getCompanyId());
		storeWarehouseInDto.setStart(0);
		storeWarehouseInDto.setLimit(Integer.MAX_VALUE);
		storeWarehouseInDto.setStoreTo(user.getStoreId());
		List<StoreWarehouseInVo> swivList= getPage(storeWarehouseInDto);
		return swivList;
	}

	/**
	 * 历史纪录头部
	 * @return
	 */
	private LinkedHashMap<String,String> StoreWarehouseInHistoryHeader() {
		 //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("总部出库单号", "headOutReceiptNo");
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部出库时间", "headOutTime");
	    headerMaps.put("总部出库人", "headOutPerson");
	    headerMaps.put("门店入库时间", "storeInTime");
	    headerMaps.put("门店入库人", "storeInPerson");
	    return headerMaps;
	}

	/**
	 * 导出历史记录数据
	 */
	public void getStoreWarehouseInHistoryEexport(){

		List<StoreWarehouseInVo> swivList = StoreWarehouseInHistoryPrepare(storeWarehouseInDto);

	    String fileName = "门店入库管理历史记录";

		try {
			String content =  CSVUtils.formatCsvData(swivList, StoreWarehouseInHistoryHeader());
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 预览历史记录PDF（可下载，可保存）
	 */
	public void getStoreWarehouseInHistoryPDFPreview(){

		List<StoreWarehouseInVo> swivList = StoreWarehouseInHistoryPrepare(storeWarehouseInDto);

		String fileName = "门店入库管理历史记录";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(swivList, StoreWarehouseInHistoryHeader());
			// 每列宽度
			float[] columnsWidth = {30f, 30f, 30f, 23f, 23f, 30f, 25f, 30f, 28f};
			PDFUtil.preview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  获取历史记录列表数据
	 */
	private List<StoreWarehouseInVo> getPages(StoreWarehouseInDto storeWarehouseInDto){
		List<StoreWarehouseIn> swiList = storeWarehouseInManager.getPerparePageList(storeWarehouseInDto);
		List<StoreWarehouseInVo> swivList = new ArrayList<StoreWarehouseInVo>();

		if (swiList != null && swiList.size() > 0) {

			for (StoreWarehouseIn s : swiList) {
				StoreWarehouseInVo sv = new StoreWarehouseInVo();
				sv.setHeadOutReceiptNo(s.getHeadOutReceiptNo());
				sv.setCardNo(s.getCardNo());
				sv.setCategoryName(s.getCategoryName());
				sv.setStatus(KeyValueConvert.getCardStatusValue(s.getStatus()));
				sv.setHeadOutTime(DateFormat.dateToString(s.getHeadOutTime()));
				User u = userManager.getUserById(s.getHeadOutPerson());
				sv.setHeadOutPerson(u!=null ? u.getRealName() : "");
				swivList.add(sv);
			}
		}
		return swivList;
	}

	/**
	 * 总部出库状态
	 * @return
	 */
	public String getStoreWarehouseInPrepare() {

		if (storeWarehouseInDto == null) {
			storeWarehouseInDto = new StoreWarehouseInDto();
		}
		pageSet(storeWarehouseInDto);
		storeWarehouseInDto.setCompanyId(user.getCompanyId());
		storeWarehouseInDto.setStatus(CardConstants.KEY_CARD_STATE_HQ_OUT);
		storeWarehouseInDto.setStoreTo(user.getStoreId());

		pageData.rows = getPages(storeWarehouseInDto);
		Integer t = storeWarehouseInManager.getPerparePageTotal(storeWarehouseInDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出和打印待入库记录数据
	 * @param storeWarehouseInDto
	 * @return
	 */
	private List<StoreWarehouseInVo> StoreWarehouseInPreparePrepare (StoreWarehouseInDto storeWarehouseInDto){
		if (storeWarehouseInDto == null) {
			storeWarehouseInDto = new StoreWarehouseInDto();
		}
		storeWarehouseInDto.setCompanyId(user.getCompanyId());
		storeWarehouseInDto.setStart(0);
		storeWarehouseInDto.setLimit(Integer.MAX_VALUE);
		storeWarehouseInDto.setStatus(CardConstants.KEY_CARD_STATE_HQ_OUT);
		storeWarehouseInDto.setStoreTo(user.getStoreId());

		List<StoreWarehouseInVo> swivList = getPages(storeWarehouseInDto);

		return swivList;
	}

	/**
	 * 待入库记录头部
	 * @return
	 */
	private LinkedHashMap<String,String> StoreWarehouseInPrepareHeader() {
		//表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("总部出库单号", "headOutReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部出库时间", "headOutTime");
	    headerMaps.put("总部出库人", "headOutPerson");
	    return headerMaps;
	}

	/**
	 * 导出待入库记录数据
	 */
	public void getStoreWarehouseInPrepareEexport(){

		List<StoreWarehouseInVo> swivList = StoreWarehouseInPreparePrepare(storeWarehouseInDto);
		String fileName = "门店入库管理总部出库状态记录";

		try {
			String content =  CSVUtils.formatCsvData(swivList, StoreWarehouseInPrepareHeader());
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 门店入库
	 * @return
	 */
	public String updateStoreWarehouseIn() {
		if (storeWarehouseInDtoArr == null && storeWarehouseInDtoArr.length ==0) {
			result.setSuccessInfo();
			return SUCCESS;
		}

		List<StoreWarehouseInDto> storeWarehouseInDtoList = new ArrayList<>();

		for(String storeWarehouseInDtoStr : storeWarehouseInDtoArr) {
			StoreWarehouseInDto sDto = new StoreWarehouseInDto();
			String[] strArr = storeWarehouseInDtoStr.split(":");
			sDto.setCardNo(strArr[0]);
			sDto.setWarehouseOutNo(strArr[1]);
			storeWarehouseInDtoList.add(sDto);
		}

		StoreWarehouseIn storeWarehouseIn = new StoreWarehouseIn();

		storeWarehouseIn.setStoreTo(user.getStoreId());
		storeWarehouseIn.setCreateId(user.getId());
		storeWarehouseIn.setUpdateId(user.getId());
		storeWarehouseIn.setIsDeleted(0);
		storeWarehouseIn.setCompanyId(user.getCompanyId());



		//  操作数据
		try {
			// 入库成功后的单号
			String storeInReceiptNo = storeWarehouseInManager.OperaStoreWarehouseIn(storeWarehouseInDtoList,storeWarehouseIn);
			result.setResultInfo(0, storeInReceiptNo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "入库失败");
			return SUCCESS;
		}
	}
}
