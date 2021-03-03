package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseInDto;
import com.itcrazy.alanmall.mscard.manager.HeadWarehouseInManager;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseIn;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.HeadWarehouseInVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 总部入库设置
 *
 * @author luxf
 *
 */
public class HeadWarehouseInAction extends InterfaceBaseAction {

	private static final long serialVersionUID = 1014571471579764209L;

	private HeadWarehouseInDto headWarehouseInDto;
	private String[] cardNoList;
	private String cardNoNum;

	@Reference
	UserManager userManager;
	@Reference
	HeadWarehouseInManager headWarehouseInManager;

	/**
	 * 获取历史记录列表数据
	 */
	private List<HeadWarehouseInVo> getPage(HeadWarehouseInDto headWarehouseInDto){

		List<HeadWarehouseIn> headWarehouseInList = headWarehouseInManager.getPageHistory(headWarehouseInDto);
		List<HeadWarehouseInVo> headWarehouseInVoList = new ArrayList<HeadWarehouseInVo>();

		if (headWarehouseInList != null && headWarehouseInList.size() > 0) {
			for (HeadWarehouseIn c : headWarehouseInList) {
				HeadWarehouseInVo cv = new HeadWarehouseInVo();
				cv.setSerialNo(c.getSerialNo());
				cv.setReceiptNo(c.getReceiptNo());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateName(createCardUser.getRealName());
                }
				User headinUser = userManager.getUserById(c.getHeadinPerson());
				if(headinUser != null) {
                	cv.setHeadInPersonName(headinUser.getRealName());
                }
				cv.setHeadInTime(DateFormat.dateToString(c.getHeadinTime()));
				headWarehouseInVoList.add(cv);
			}
		}
		return headWarehouseInVoList;
	}

	/**
	 * 历史记录页面显示
	 */
	public String getHeadWarehouseInHistory() {

		if (headWarehouseInDto == null) {
			headWarehouseInDto = new HeadWarehouseInDto();
		}

		pageSet(headWarehouseInDto);
		headWarehouseInDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPage(headWarehouseInDto);
		int iRows = headWarehouseInManager.getHistoryPageTotal(headWarehouseInDto);
		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出和打印历史纪录的数据
	 * @param headWarehouseInDto
	 * @return
	 */
	private List<HeadWarehouseInVo> HeadWarehouseInHistoryPrepare(HeadWarehouseInDto headWarehouseInDto){
		if(headWarehouseInDto == null){
			headWarehouseInDto = new HeadWarehouseInDto();
		}
		headWarehouseInDto.setCompanyId(user.getCompanyId());
		headWarehouseInDto.setStart(0);
		headWarehouseInDto.setLimit(Integer.MAX_VALUE);
		List<HeadWarehouseInVo> headWarehouseInVoList= getPage(headWarehouseInDto);
		return headWarehouseInVoList;
	}

	/**
	 * 历史纪录头部
	 * @return
	 */
	private LinkedHashMap<String,String> HeadWarehouseInHistoryHeader() {
		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("制卡批次号", "serialNo");
	    headerMaps.put("总部入库单号", "receiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("制卡时间", "createTime");
	    headerMaps.put("制卡人", "createName");
	    headerMaps.put("总部入库时间", "headInTime");
	    headerMaps.put("总部入库人", "headInPersonName");
	    return headerMaps;
	}

	/**
	 * 导出历史记录数据
	 */
	public void getHeadWarehouseInHistoryEexport(){

		List<HeadWarehouseInVo> headWarehouseInVoList= HeadWarehouseInHistoryPrepare(headWarehouseInDto);

		 String fileName = "总部入库管理历史记录";

		try {
			String content =  CSVUtils.formatCsvData(headWarehouseInVoList, HeadWarehouseInHistoryHeader());
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
	public void getHeadWarehouseInHistoryPDFPreview(){

		List<HeadWarehouseInVo> headWarehouseInVoList= HeadWarehouseInHistoryPrepare(headWarehouseInDto);

		 String fileName = "总部入库管理历史记录";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(headWarehouseInVoList, HeadWarehouseInHistoryHeader());
			// 每列宽度
			float[] columnsWidth = {30f, 30f, 30f, 23f, 23f, 30f, 25f, 30f, 28f};
			PDFUtil.preview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取历史记录列表数据
	 */
	private List<HeadWarehouseInVo> getPages(HeadWarehouseInDto headWarehouseInDto){

		List<HeadWarehouseIn> headWarehouseInList = headWarehouseInManager.getPagePrepare(headWarehouseInDto);
		List<HeadWarehouseInVo> headWarehouseInVoList = new ArrayList<HeadWarehouseInVo>();

		if (headWarehouseInList != null && headWarehouseInList.size() > 0) {
			for (HeadWarehouseIn c : headWarehouseInList) {
				HeadWarehouseInVo cv = new HeadWarehouseInVo();
				cv.setSerialNo(c.getSerialNo());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateName(createCardUser.getRealName());
                }
				headWarehouseInVoList.add(cv);
			}
		}
		return headWarehouseInVoList;
	}

	/**
	 * 制卡状态
	 */
	public String getHeadWarehouseInPrepare() {
		if (headWarehouseInDto == null) {
			headWarehouseInDto = new HeadWarehouseInDto();
		}
		pageSet(headWarehouseInDto);
		headWarehouseInDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPages(headWarehouseInDto);
		Integer iRows = headWarehouseInManager.getPreparePageTotal(headWarehouseInDto);
		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出和打印历史纪录的数据
	 * @param headWarehouseInDto
	 * @return
	 */
	private List<HeadWarehouseInVo> HeadWarehouseInPreparePrepare(HeadWarehouseInDto headWarehouseInDto){
		if(headWarehouseInDto == null){
			headWarehouseInDto = new HeadWarehouseInDto();
		}
		headWarehouseInDto.setCompanyId(user.getCompanyId());
		headWarehouseInDto.setStart(0);
		headWarehouseInDto.setLimit(Integer.MAX_VALUE);
		List<HeadWarehouseInVo> headWarehouseInVoList= getPages(headWarehouseInDto);
		return headWarehouseInVoList;
	}

	/**
	 * 待入库记录头部
	 * @return
	 */
	private LinkedHashMap<String,String> HeadWarehouseInPrepareHeader() {
		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("制卡批次号", "serialNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("制卡时间", "createTime");
	    headerMaps.put("制卡人", "createName");
	    return headerMaps;
	}

	/**
	 * 总部入库管理制卡状态记录
	 */
	public void getHeadWarehouseInPrepareEexport(){

		List<HeadWarehouseInVo> headWarehouseInVoList= HeadWarehouseInPreparePrepare(headWarehouseInDto);

		String fileName = "总部入库管理制卡状态记录";

		try {
			String content =  CSVUtils.formatCsvData(headWarehouseInVoList, HeadWarehouseInPrepareHeader());
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 总部入库
	 */
	public String updateHeadWarehouseIn() {
		if (headWarehouseInDto == null) {
			headWarehouseInDto = new HeadWarehouseInDto();
		}
		if (cardNoList == null && headWarehouseInDto.getCardNoNum() == "") {
			result.setParamErrorInfo("cardNoList");
			return SUCCESS;
		}

		try {
			// 勾选情况
			if (cardNoList != null) {
				// 入库成功后的单号
				String headInReceiptNo = headWarehouseInManager.OperaHeadWarehouseIn(cardNoList, user.getId(), user.getCompanyId());
				result.setResultInfo(0, headInReceiptNo);
			}

			// 指定数量情况
			if (headWarehouseInDto.getCardNoNum() != "" && headWarehouseInDto.getCardNoNum() != null) {
				// 根据条件，取得总记录数
				headWarehouseInDto.setCompanyId(user.getCompanyId());
				Integer iRowsNum = headWarehouseInManager.getPreparePageTotal(headWarehouseInDto);

				// 根据条件，取得前cardNoNum条数据
				headWarehouseInDto.setStart(0);
				headWarehouseInDto.setLimit(Integer.valueOf(headWarehouseInDto.getCardNoNum()));
				List<HeadWarehouseIn> headWarehouseInCardList = headWarehouseInManager.getPagePrepare(headWarehouseInDto);

				// 构建cardNoList字符串数组
				String[] cardNoList = new String[headWarehouseInCardList.size()];
				for (int i = 0; i < headWarehouseInCardList.size(); i++) {
					cardNoList[i] = headWarehouseInCardList.get(i).getCardNo();
				}
				// 入库成功后的单号
				String headInReceiptNo = headWarehouseInManager.OperaHeadWarehouseIn(cardNoList, user.getId(), user.getCompanyId());

				// 判断cardNoNum和总记录数关系
				if (iRowsNum < Integer.valueOf(headWarehouseInDto.getCardNoNum())) {
					result.setResultInfo(-1, headInReceiptNo + "," + iRowsNum.toString());
				}else {
					result.setResultInfo(0, headInReceiptNo);
				}
			}
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "入库失败");
			return SUCCESS;
		}
	}


	public String getCardNoNum() {
		return cardNoNum;
	}

	public void setCardNoNum(String cardNoNum) {
		this.cardNoNum = cardNoNum;
	}

	public HeadWarehouseInDto getHeadWarehouseInDto() {
		return headWarehouseInDto;
	}

	public void setHeadWarehouseInDto(HeadWarehouseInDto headWarehouseInDto) {
		this.headWarehouseInDto = headWarehouseInDto;
	}

	public String[] getCardNoList() {
		return cardNoList;
	}

	public void setCardNoList(String[] cardNoList) {
		this.cardNoList = cardNoList;
	}
}
