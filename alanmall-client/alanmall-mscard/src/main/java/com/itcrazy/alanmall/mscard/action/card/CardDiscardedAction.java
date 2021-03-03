package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.manager.CardDiscardedManager;
import com.itcrazy.alanmall.mscard.model.CardDiscarded;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.CardDiscardedVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 总部作废管理
 * @author yangliang
 * 2018-09-05
 */
public class CardDiscardedAction extends InterfaceBaseAction{
	private static final long serialVersionUID = 7431677120439673622L;
	private CardDiscarded cardDiscarded;
	private CardDiscardedDto cardDiscardedDto;
	private String reason;
	private String[] cardNoList;

	@Reference
	CardDiscardedManager cardDiscardedManager;
	@Reference
	UserManager userManager;

	/**
	 *  获取历史记录列表数据
	 */
	private List<CardDiscardedVo> getPage(CardDiscardedDto cardDiscardedDto){

		List<CardDiscarded> cardDiscardedList = cardDiscardedManager.getPageList(cardDiscardedDto);
		List<CardDiscardedVo> cardDiscardedVoList = new ArrayList<CardDiscardedVo>();

		if (cardDiscardedList != null && cardDiscardedList.size() > 0) {
			for (CardDiscarded c : cardDiscardedList) {
				CardDiscardedVo cv = new CardDiscardedVo();
				cv.setReceiptNo(c.getReceiptNo());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateId(createCardUser.getRealName());
                }
				cardDiscardedVoList.add(cv);
			}
		}
		return cardDiscardedVoList;
	}


	// 历史记录
	public String getCardDiscardedHistory(){
		if(cardDiscardedDto == null){
			cardDiscardedDto = new CardDiscardedDto();
		}
		cardDiscardedDto.setCompanyId(user.getCompanyId());
		pageSet(cardDiscardedDto);

		pageData.rows = getPage(cardDiscardedDto);
		Integer iTotalRows = cardDiscardedManager.getPageTotal(cardDiscardedDto);
		pageData.setTotal(iTotalRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出历史记录数据
	 */
	public void getCardDiscardedHistoryEexport(){
		if(cardDiscardedDto == null){
			cardDiscardedDto = new CardDiscardedDto();
		}

		cardDiscardedDto.setCompanyId(user.getCompanyId());
		cardDiscardedDto.setStart(0);
		cardDiscardedDto.setLimit(Integer.MAX_VALUE);

		List<CardDiscardedVo> cardDiscardedVoList= getPage(cardDiscardedDto);

	    String fileName = "总部作废管理历史记录" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("作废单号", "receiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部作废时间", "createTime");
	    headerMaps.put("总部作废人", "createId");
		try {
			String content =  CSVUtils.formatCsvData(cardDiscardedVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 *  获取待作废卡号列表数据
	 */
	private List<CardDiscardedVo> getPages(CardDiscardedDto cardDiscardedDto){

		List<CardDiscarded> cardDiscardedList = cardDiscardedManager.getCardDiscardedNo(cardDiscardedDto);
		List<CardDiscardedVo> cardDiscardedVoList = new ArrayList<CardDiscardedVo>();

		if (cardDiscardedList != null && cardDiscardedList.size() > 0) {
			for (CardDiscarded c : cardDiscardedList) {
				CardDiscardedVo cv = new CardDiscardedVo();
				cv.setReceiptNo(c.getReceiptNo());
				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
				User createCardUser = userManager.getUserById(c.getCreateId());
				if(createCardUser != null) {
                	cv.setCreateId(createCardUser.getRealName());
                }
				cardDiscardedVoList.add(cv);
			}
		}
		return cardDiscardedVoList;
	}

	// 查询待作废的卡号
	public String getCardDiscardedPrepare() {
		if (cardDiscardedDto == null) {
			cardDiscardedDto = new CardDiscardedDto();
		}
		cardDiscardedDto.setCompanyId(user.getCompanyId());
		pageSet(cardDiscardedDto);

		pageData.rows = getPages(cardDiscardedDto);
		Integer iTotalRows = cardDiscardedManager.getCardDiscardedTotal(cardDiscardedDto);
		pageData.setTotal(iTotalRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出待作废卡号数据
	 */
	public void getCardDiscardedPrepareEexport(){
		if(cardDiscardedDto == null){
			cardDiscardedDto = new CardDiscardedDto();
		}

		cardDiscardedDto.setCompanyId(user.getCompanyId());
		cardDiscardedDto.setStart(0);
		cardDiscardedDto.setLimit(Integer.MAX_VALUE);

		List<CardDiscardedVo> cardDiscardedVoList= getPages(cardDiscardedDto);

	    String fileName = "提取待作废卡号记录" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("作废单号", "receiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "name");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("总部作废时间", "createTime");
	    headerMaps.put("总部作废人", "createId");
		try {
			String content =  CSVUtils.formatCsvData(cardDiscardedVoList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 总部作废
	public String updateCardDiscarded() {
		try {
			if(cardNoList == null){
			}

			CardDiscarded cardDiscarded = new CardDiscarded();
			cardDiscarded.setCompanyId(user.getCompanyId());
			cardDiscarded.setCreateId(user.getId());
			cardDiscarded.setUpdateId(user.getId());
			cardDiscarded.setIsDeleted(0);
			cardDiscarded.setReason(reason);

			cardDiscardedManager.OperaCardDiscarded(cardNoList, cardDiscarded);
			result.setSuccessInfo();
			return SUCCESS;
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}

	}

	public CardDiscarded getCardDiscarded() {
		return cardDiscarded;
	}

	public void setCardDiscarded(CardDiscarded cardDiscarded) {
		this.cardDiscarded = cardDiscarded;
	}

	public CardDiscardedDto getCardDiscardedDto() {
		return cardDiscardedDto;
	}

	public void setCardDiscardedDto(CardDiscardedDto cardDiscardedDto) {
		this.cardDiscardedDto = cardDiscardedDto;
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

	public CardDiscardedManager getCardDiscardedManager() {
		return cardDiscardedManager;
	}

	public void setCardDiscardedManager(CardDiscardedManager cardDiscardedManager) {
		this.cardDiscardedManager = cardDiscardedManager;
	}


}
