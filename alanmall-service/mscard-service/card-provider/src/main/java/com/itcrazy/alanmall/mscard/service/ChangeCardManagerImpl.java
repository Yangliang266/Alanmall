package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ActiveInformationDao;
import com.itcrazy.alanmall.mscard.dao.CardDiscardedDao;
import com.itcrazy.alanmall.mscard.dao.ChangeCardDao;
import com.itcrazy.alanmall.mscard.dao.ChangeHistoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.manager.ChangeCardManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 换卡接口实现
 * @author yangliang
 * 2018-09-15
 */
@Slf4j
@Service
public class ChangeCardManagerImpl implements ChangeCardManager{
	@Autowired
	private ChangeCardDao changeCardDao;

	@Autowired
	private ChangeHistoryDao changeHistoryDao;

	@Autowired
	private CardDiscardedDao cardDiscardedDao;

	@Autowired
	private ActiveInformationDao activeInformationDao;

	@Override
	public ChangeCard getActiveInfo(ChangeCardDto changeCardDto) {
		return changeCardDao.getActiveInfo(changeCardDto);
	}

	@Override
	public ChangeCard getPageNewlist(ChangeCardDto changeCardDto) {
		return changeCardDao.getPageNewlist(changeCardDto);
	}

	@Override
	public Integer getPageTotal(ChangeCardDto changeCardDto) {
		return changeCardDao.getPageTotal(changeCardDto);
	}


	@Override
	public void changeCard(ChangeHistory changeHistory,CardInformation cardInformation,ChangeCardDto changeCardDto,CardDiscarded cardDiscarded) throws Exception{
			// cardinformation新卡更新为老卡
			changeCardDao.updateCardInformation(changeCardDto);

			// 新卡激活新增到activeInformation
			//activeInformationDao.saveActiveInfo(supplementCard);

			changeCardDao.insertActiveInformation(changeCardDto);

			// 更新card_actived_information表（母卡更新为新卡号）
			SupplementCard supplementCard = new SupplementCard();
			supplementCard.setNewCardNo(changeCardDto.getNewCardNo());
			supplementCard.setOldCardNo(changeCardDto.getOldCardNo());
			activeInformationDao.updMotherCard(supplementCard);

			// 老卡cardinformation金额都为0,状态为作废
			changeCardDao.updateInformationBalance(cardInformation);


			// 老卡作废
			CardDiscardedDto dto = new CardDiscardedDto();
			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");
			// 最大总部入库单号查询
			dto.setCompanyId(cardDiscarded.getCompanyId());
			String lastReceiptNo = cardDiscardedDao.getMaxReciptNo(dto);

			if(lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "ZBZF-" + receiptNo + String.format("%08d",1);
			}else{
				int iLen = lastReceiptNo.length();
				String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
				if(receiptNo.equals(strDate)) {
					String strNum = lastReceiptNo.substring(iLen - 8);
					int iNum = Integer.parseInt(strNum);
					receiptNo = "ZBZF-" + receiptNo + String.format("%08d", iNum + 1);
				}else {
					receiptNo = "ZBZF-" + receiptNo + String.format("%08d",1);
				}
			}
			cardDiscarded.setReceiptNo(receiptNo);
			cardDiscardedDao.save(cardDiscarded);

			// 换卡记录新增
			changeHistoryDao.save(changeHistory);

			Integer getTotal = changeCardDao.getTotal(changeCardDto);

			// 新卡记名信息插入(判断是否为记名状态) 老卡记名做删除
			//int isNamed = chk.getIsNamed();
			if (getTotal == 1) {
				changeCardDao.insertRegisteredCard(changeCardDto);
				changeCardDao.updateRegisteredCard(changeCardDto);
			}

			// 新卡挂账信息插入， 老卡挂账做删除
			changeCardDao.insertCreditSetting(changeCardDto);
			changeCardDao.updateCreditSetting(changeCardDto);

			changeCardDao.updataCreditsHistory(changeCardDto);
			// 如果老卡是母卡则更新所有子卡对应的母卡，若为子卡则更新子卡
			changeCardDao.updataStorageHistory(changeCardDto);
			changeCardDao.updataStorageHistoryMother(changeCardDto);
			changeCardDao.updataOtherHistory(changeCardDto);

			// 旧卡删除activeInformation
			changeCardDao.deleteActiveInformation(changeCardDto);

	}
}
