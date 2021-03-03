package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.ReturnCardDto;
import com.itcrazy.alanmall.mscard.manager.ReturnCardManager;
import com.itcrazy.alanmall.mscard.model.ReturnCard;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.ReturnCardVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 总部退货管理
 * @author yangliang
 * 2018-09-05
 */
public class ReturnCardAction extends InterfaceBaseAction{


	private static final long serialVersionUID = 7431677120439673622L;
	private ReturnCard returnCard;
	private ReturnCardDto returnCardDto;
	private String reason;
	private String[] cardNoList;

	@Reference
	ReturnCardManager returnCardManager;
	@Reference
	UserManager userManager;

	/**
	 *  获取历史记录列表数据
	 */
	private List<ReturnCardVo> getPage(ReturnCardDto returnCardDto){

		List<ReturnCard> returnCardList = returnCardManager.getPageList(returnCardDto);
		List<ReturnCardVo> returnCardVoList = new ArrayList<ReturnCardVo>();

		if (returnCardList != null && returnCardList.size() > 0) {
			for (ReturnCard c : returnCardList) {
				ReturnCardVo cv = new ReturnCardVo();
				cv.setReceiptNO(c.getReceiptNO());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateId(createCardUser.getRealName());
                }
				returnCardVoList.add(cv);
			}
		}
		return returnCardVoList;
	}

	// 历史记录
	public String getReturnCardHistory(){
		if(returnCardDto == null){
			returnCardDto = new ReturnCardDto();
		}

		pageSet(returnCardDto);
		returnCardDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPage(returnCardDto);
		Integer iTotalRows = returnCardManager.getPageTotal(returnCardDto);
		pageData.setTotal(iTotalRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出和打印历史纪录的数据
	 * @param returnCardDto
	 * @return
	 */
	private List<ReturnCardVo> ReturnCardHistoryPrepare(ReturnCardDto returnCardDto){
		if(returnCardDto == null){
			returnCardDto = new ReturnCardDto();
		}
		returnCardDto.setCompanyId(user.getCompanyId());
		returnCardDto.setStart(0);
		returnCardDto.setLimit(Integer.MAX_VALUE);
		List<ReturnCardVo> swivList= getPage(returnCardDto);
		return swivList;
	}

	/**
	 * 历史纪录头部
	 * @return
	 */
	private LinkedHashMap<String,String> ReturnCardHistoryHeader() {
		 //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("退货单号", "receiptNO");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部退货时间", "createTime");
	    headerMaps.put("总部退货人", "createId");
	    return headerMaps;
	}


	/**
	 * 导出历史记录数据
	 */
	public void getReturnCardHistoryEexport(){
		List<ReturnCardVo> swivList = ReturnCardHistoryPrepare(returnCardDto);

	    String fileName = "总部退货管理历史记录" + DateFormat.dateToString(new Date()) + ".csv";

		try {
			String content =  CSVUtils.formatCsvData(swivList, ReturnCardHistoryHeader());
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
	public void getReturnCardHistoryPDFPreview(){
 		List<ReturnCardVo> swivList = ReturnCardHistoryPrepare(returnCardDto);

		String fileName = "总部退货管理历史记录";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(swivList, ReturnCardHistoryHeader());
			// 每列宽度
			float[] columnsWidth = {35f, 35f, 25f, 25f, 35f, 30f};
			PDFUtil.preview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  获取待退货卡号列表数据
	 */
	private List<ReturnCardVo> getPages(ReturnCardDto returnCardDto){

		List<ReturnCard> returnCardList = returnCardManager.getReturnCardNo(returnCardDto);
		List<ReturnCardVo> returnCardVoList = new ArrayList<ReturnCardVo>();

		if (returnCardList != null && returnCardList.size() > 0) {
			for (ReturnCard c : returnCardList) {
				ReturnCardVo cv = new ReturnCardVo();
				cv.setReceiptNO(c.getReceiptNO());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateId(createCardUser.getRealName());
                }
				returnCardVoList.add(cv);
			}
		}
		return returnCardVoList;
	}


	// 查询待退货的卡号
	public String getReturnCardPrepare() {
		if (returnCardDto == null) {
			returnCardDto = new ReturnCardDto();
		}

		pageSet(returnCardDto);
		returnCardDto.setCompanyId(user.getCompanyId());

		pageData.rows = getPages(returnCardDto);
		Integer iTotalRows = returnCardManager.getReturnCardTotal(returnCardDto);
		pageData.setTotal(iTotalRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出待退货卡号数据
	 */
	public void getReturnCardPrepareEexport(){
		if(returnCardDto == null){
			returnCardDto = new ReturnCardDto();
		}

		returnCardDto.setCompanyId(user.getCompanyId());
		returnCardDto.setStart(0);
		returnCardDto.setLimit(Integer.MAX_VALUE);

		List<ReturnCardVo> returnCardVoList= getPages(returnCardDto);

	    String fileName = "待提取退货卡号记录" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("退货单号", "receiptNO");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部退货时间", "createTime");
	    headerMaps.put("总部退货人", "createId");

		try {
			String content =  CSVUtils.formatCsvData(returnCardVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// 总部退货
	public String updateReturnCard() {
		try {
			if(cardNoList == null){
			}

			ReturnCard returnCard = new ReturnCard();
			returnCard.setCompanyId(user.getCompanyId());
			returnCard.setCreateId(user.getId());
			returnCard.setUpdateId(user.getId());
			returnCard.setIsDeleted(0);
			returnCard.setReason(reason);

			returnCardManager.OperaReturnCard(cardNoList, returnCard);
			result.setSuccessInfo();
			return SUCCESS;
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}

	}


	public ReturnCard getReturnCard() {
		return returnCard;
	}

	public void setReturnCard(ReturnCard returnCard) {
		this.returnCard = returnCard;
	}

	public ReturnCardDto getReturnCardDto() {
		return returnCardDto;
	}

	public void setReturnCardDto(ReturnCardDto returnCardDto) {
		this.returnCardDto = returnCardDto;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String[] getCardNoList() {
		return cardNoList;
	}

	public void setCardNoList(String[] cardNoList) {
		this.cardNoList = cardNoList;
	}
}
