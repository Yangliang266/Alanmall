package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.HeadWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseOut;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.HeadWarehouseOutVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 总部出库设置
 * @author luxf
 *
 */
public class HeadWarehouseOutAction extends InterfaceBaseAction{

	private static final long serialVersionUID = 3086849648027093518L;

	private HeadWarehouseOutDto headWarehouseOutDto;
	private String[] cardNoList;
	private String choosedStoreId;

	@Reference
	UserManager userManager;
	@Reference
	HeadWarehouseOutManager headWarehouseOutManager;
	@Reference
	StoreManager storeManager;

	/**
	 *  获取历史记录列表数据
	 */
	private List<HeadWarehouseOutVo> getPage(HeadWarehouseOutDto headWarehouseOutDto){

			List<HeadWarehouseOut> headWarehouseOutList = headWarehouseOutManager.getPageHistory(headWarehouseOutDto);
			List<HeadWarehouseOutVo> headWarehouseOutVoList = new ArrayList<HeadWarehouseOutVo>();

			if (headWarehouseOutList != null && headWarehouseOutList.size() > 0) {

				for (HeadWarehouseOut c : headWarehouseOutList) {
					HeadWarehouseOutVo cv = new HeadWarehouseOutVo();

					cv.setHeadInReceiptNo(c.getHeadInReceiptNo());
					cv.setReceiptNo(c.getReceiptNo());
					cv.setCardNo(c.getCardNo());
					cv.setName(c.getName());
					//cv.setStoreTo(c.getStoreTo());
					Store storeto = storeManager.getStoreById(c.getStoreTo());
					cv.setStoreTo(storeto != null ? storeto.getName() : "");
					cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
					cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
					User createCardUser = userManager.getUserById(c.getCreateId());
					if(createCardUser != null) {
		            	cv.setCreateId(createCardUser.getRealName());
		            }
					User headOutUser = userManager.getUserById(c.getHeadOutPerson());
					if(headOutUser != null) {
		            	cv.setHeadOutPerson(headOutUser.getRealName());
		            }
					cv.setHeadOutTime(DateFormat.dateToString(c.getHeadOutTime()));
					headWarehouseOutVoList.add(cv);
				}
			}
			return headWarehouseOutVoList;
		}

	/**
	 *  历史记录页面显示
	 */
	public String getHeadWarehouseOutHistory() {

		if (headWarehouseOutDto == null) {
			headWarehouseOutDto = new HeadWarehouseOutDto();
		}

		pageSet(headWarehouseOutDto);
		headWarehouseOutDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPage(headWarehouseOutDto);

		int iRows = headWarehouseOutManager.getHistoryPageTotal(headWarehouseOutDto);

		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 *  导出和打印历史纪录的数据
	 * @param headWarehouseOutDto
	 * @return
	 */
	private List<HeadWarehouseOutVo> HeadWarehouseOutHistoryPrepare(HeadWarehouseOutDto headWarehouseOutDto){
		if(headWarehouseOutDto == null){
			headWarehouseOutDto = new HeadWarehouseOutDto();
		}

		headWarehouseOutDto.setCompanyId(user.getCompanyId());
		headWarehouseOutDto.setStart(0);
		headWarehouseOutDto.setLimit(Integer.MAX_VALUE);

		List<HeadWarehouseOutVo> headWarehouseOutVoList= getPage(headWarehouseOutDto);

		return headWarehouseOutVoList;
	}

	/**
	 *  历史纪录头部
	 * @return
	 */
	private LinkedHashMap<String,String> HeadWarehouseOutHistoryHeader() {
		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("总部入库单号", "headInReceiptNo");
	    headerMaps.put("总部出库单号", "receiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("出库门店", "storeTo");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部入库时间", "createTime");
	    headerMaps.put("总部入库操作人", "createId");
	    headerMaps.put("总部出库时间", "headOutTime");
	    headerMaps.put("总部出库操作人", "headOutPerson");
	    return headerMaps;
	}

	/**
	 *  导出历史记录数据
	 */
	public void getHeadWarehouseOutHistoryEexport(){

		List<HeadWarehouseOutVo> headWarehouseOutVoList= HeadWarehouseOutHistoryPrepare(headWarehouseOutDto);

	    String fileName = "总部出库管理历史记录";

		try {
			String content =  CSVUtils.formatCsvData(headWarehouseOutVoList, HeadWarehouseOutHistoryHeader());
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
	public void getHeadWarehouseOutHistoryPDFPreview(){

		List<HeadWarehouseOutVo> headWarehouseOutVoList= HeadWarehouseOutHistoryPrepare(headWarehouseOutDto);

		 String fileName = "总部出库管理历史记录";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(headWarehouseOutVoList, HeadWarehouseOutHistoryHeader());
			// 每列宽度
			float[] columnsWidth = {30f, 30f, 30f, 20f, 20f, 20f, 30f, 32f, 30f, 32f};
			PDFUtil.preview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  获取总部入库状态数据
	 */
	private List<HeadWarehouseOutVo> getPages(HeadWarehouseOutDto headWarehouseOutDto){
		List<HeadWarehouseOut> headWarehouseOutList = headWarehouseOutManager.getPagePrepare(headWarehouseOutDto);
		List<HeadWarehouseOutVo> headWarehouseOutVoList = new ArrayList<HeadWarehouseOutVo>();

		if (headWarehouseOutList != null && headWarehouseOutList.size() > 0) {
			for (HeadWarehouseOut c : headWarehouseOutList) {
				HeadWarehouseOutVo cv = new HeadWarehouseOutVo();
				cv.setHeadInReceiptNo(c.getHeadInReceiptNo());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));//总部入库时间
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateId(createCardUser.getRealName());
                }
				headWarehouseOutVoList.add(cv);
			}
		}
		return headWarehouseOutVoList;
	}

	/**
	 *  总部入库状态
	 */
	public String getHeadWarehouseOutPrepare() {
		if (headWarehouseOutDto == null) {
			headWarehouseOutDto = new HeadWarehouseOutDto();
		}
		pageSet(headWarehouseOutDto);
		headWarehouseOutDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPages(headWarehouseOutDto);
		Integer iRows = headWarehouseOutManager.getPreparePageTotal(headWarehouseOutDto);
		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 *  导出总部入库状态数据
	 */
	public void getHeadWarehouseOutPrepareEexport(){
		if(headWarehouseOutDto == null){
			headWarehouseOutDto = new HeadWarehouseOutDto();
		}

		headWarehouseOutDto.setCompanyId(user.getCompanyId());
		headWarehouseOutDto.setStart(0);
		headWarehouseOutDto.setLimit(Integer.MAX_VALUE);

		List<HeadWarehouseOutVo> headWarehouseOutVoList= getPages(headWarehouseOutDto);

	    String fileName = "总部出库管理总部入库状态记录";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("总部入库单号", "headInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部入库时间", "createTime");
	    headerMaps.put("总部入库操作人", "createId");

		try {
			String content =  CSVUtils.formatCsvData(headWarehouseOutVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  总部出库
	 */
	public String updateHeadWarehouseOut() {
		if (headWarehouseOutDto  == null) {
			headWarehouseOutDto = new HeadWarehouseOutDto();
		}
		/*if (cardNoList  == null) {
			result.setParamErrorInfo("cardNoList");
			return SUCCESS;
		}*/
		if (choosedStoreId  == null && cardNoList  == null) {
			result.setParamErrorInfo("choosedStoreId");
			return SUCCESS;
		}

		HeadWarehouseOut headWarehouseOut = new HeadWarehouseOut();
		headWarehouseOut.setCreateId(user.getId());
		headWarehouseOut.setUpdateId(user.getUpdateId());
		headWarehouseOut.setCompanyId(user.getCompanyId());
		headWarehouseOut.setStoreTo(Long.parseLong(choosedStoreId));

       //  操作数据
		try {
			// 仅选择
			if (cardNoList != null) {
				// 出库成功后的单号
				String headOutReceiptNo = headWarehouseOutManager.OperaHeadWarehouseOut(cardNoList, headWarehouseOut);
				result.setResultInfo(0, headOutReceiptNo);
			}

			// 仅指定数量
			if (headWarehouseOutDto.getCardNoNum() != null) {
				// 根据条件取得总记录数
				headWarehouseOutDto.setCompanyId(user.getCompanyId());
				Integer iRowsNum = headWarehouseOutManager.getPreparePageTotal(headWarehouseOutDto);

				// 查询所有入库卡号
				headWarehouseOutDto.setStart(0);
				headWarehouseOutDto.setLimit(Integer.valueOf(headWarehouseOutDto.getCardNoNum()));
				List<HeadWarehouseOut> headWarehouseOutList = headWarehouseOutManager.getPagePrepare(headWarehouseOutDto);
				String[] cardNoList = new String[headWarehouseOutList.size()];
				for (int i = 0; i < headWarehouseOutList.size(); i++) {
					cardNoList[i] = headWarehouseOutList.get(i).getCardNo();
				}
				// 遍历查询结果，将卡号插入cardNoList数组

				String headOutReceiptNo = headWarehouseOutManager.OperaHeadWarehouseOut(cardNoList, headWarehouseOut);
				result.setResultInfo(0, headOutReceiptNo);
				if (iRowsNum > Integer.valueOf(headWarehouseOutDto.getCardNoNum())) {
					// 小于等于总记录数
					result.setResultInfo(0, headOutReceiptNo);
				} else {
					// 大于总记录数
					result.setResultInfo(-1, headOutReceiptNo + "," + iRowsNum.toString());
				}
			}

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "出库失败");
			return SUCCESS;
		}
	}

	public HeadWarehouseOutDto getHeadWarehouseOutDto() {
		return headWarehouseOutDto;
	}

	public void setHeadWarehouseOutDto(HeadWarehouseOutDto headWarehouseOutDto) {
		this.headWarehouseOutDto = headWarehouseOutDto;
	}

	public String[] getCardNoList() {
		return cardNoList;
	}

	public void setCardNoList(String[] cardNoList) {
		this.cardNoList = cardNoList;
	}

	public String getChoosedStoreId() {
		return choosedStoreId;
	}

	public void setChoosedStoreId(String choosedStoreId) {
		this.choosedStoreId = choosedStoreId;
	}
}
