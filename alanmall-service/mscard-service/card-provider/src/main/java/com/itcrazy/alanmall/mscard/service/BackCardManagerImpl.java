package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.*;
import com.itcrazy.alanmall.mscard.dto.Base.BackCardDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.manager.BackCardManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 退卡接口实现
 * @author yangliang
 * 2018-09-15
 */
@Slf4j
@Service
public class BackCardManagerImpl implements BackCardManager{

	@Autowired
	private BackCardDao backCardDao;

	@Autowired
	private CardDiscardedDao cardDiscardedDao;

	@Autowired
	private RegisteredCardDao registeredCardDao;

	@Autowired
	private CreditSettingDao creditSettingDao;

	@Autowired
	private CustomReturnHistoryDao customReturnHistoryDao;

	@Autowired
	private ChangeCardDao changeCardDao;


	@Override
	public BackCard getPageList(BackCardDto backCardDto) {
		return backCardDao.getPageList(backCardDto);
	}

	@Override
	public List<BackCard> getPayModeList(BackCardDto backCardDto) {
		return backCardDao.getPayModeList(backCardDto);
	}

	@Override
	public void returnCard(BackCardDto backCardDto) throws Exception {
			// 1 原卡变为作废
			CardInformation cardInformation = new CardInformation();
			cardInformation.setStatus(5);
			cardInformation.setCompanyId(backCardDto.getCompanyId());
			cardInformation.setIsDeleted(0);
			cardInformation.setCardNo(backCardDto.getCardNo());
			cardInformation.setUpdateId(backCardDto.getCreateId());
			backCardDao.updateInformation(cardInformation);


			// 2 insert到card_discarded
			CardDiscarded cardDiscarded = new CardDiscarded();
			cardDiscarded.setCardNo(backCardDto.getCardNo());
			cardDiscarded.setReason("门店退卡");
			cardDiscarded.setCreateId(backCardDto.getCreateId());
			cardDiscarded.setCompanyId(backCardDto.getCompanyId());


			// 退卡时如果初始余额为0，退卡时新增一条退卡余额数据（在新增之前数据不存在的情况下）
			if ("0".equals(String.valueOf(backCardDto.getRechargeBalance()))) {
				if (backCardDao.getCustomReturnHistoryCount(backCardDto) == 0) {
					CustomReturnHistory customReturnHistory = new CustomReturnHistory();
					customReturnHistory.setCardNo(backCardDto.getCardNo());
					customReturnHistory.setCompanyId(backCardDto.getCompanyId());
					customReturnHistory.setCreateId(backCardDto.getCreateId());
					// 余额退款不能为空
					customReturnHistory.setReturnPrice(BigDecimal.valueOf(0));
					customReturnHistory.setReason("余额为0");
					customReturnHistory.setPayMode(-1);
					customReturnHistory.setFileName(backCardDto.getFileName());
					customReturnHistory.setCredit(backCardDto.getCredit());
					customReturnHistory.setReward(backCardDto.getReward());
					customReturnHistory.setRechargeBalance(backCardDto.getRechargeBalance());
					customReturnHistoryDao.insertCustomReturnHistory(customReturnHistory);
				}
			}

			CardDiscardedDto dto = new CardDiscardedDto();
			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");
			// 最大总部入库单号查询
			dto.setCompanyId(cardDiscarded.getCompanyId());
			String lastReceiptNo = cardDiscardedDao.getMaxReciptNo(dto);

			if(lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "ZBTK-" + receiptNo + String.format("%08d",1);
			}else{
				int iLen = lastReceiptNo.length();
				String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
				if(receiptNo.equals(strDate)) {
					String strNum = lastReceiptNo.substring(iLen - 8);
					int iNum = Integer.parseInt(strNum);
					receiptNo = "ZBTK-" + receiptNo + String.format("%08d", iNum + 1);
				}else {
					receiptNo = "ZBTK-" + receiptNo + String.format("%08d",1);
				}
			}
			cardDiscarded.setReceiptNo(receiptNo);
			cardDiscardedDao.save(cardDiscarded);

			// 3  记名卡删除
			RegisteredCard registeredCard = new RegisteredCard();
			registeredCard.setUpdateId(backCardDto.getUpdateId());
			registeredCard.setCompanyId(backCardDto.getCompanyId());
			registeredCard.setCardNo(backCardDto.getCardNo());
			registeredCard.setIsDeleted(1);
			registeredCardDao.remove(registeredCard);

			// 4  挂账卡删除
			CreditSetting creditSetting = new CreditSetting();
			creditSetting.setUpdateId(backCardDto.getUpdateId());
			creditSetting.setCompanyId(backCardDto.getCompanyId());
			creditSetting.setCardNo(backCardDto.getCardNo());
			creditSetting.setIsDeleted(1);
			creditSettingDao.remove(creditSetting);

			// 如果子卡有母卡则把母卡变为null
			backCardDao.updateMother(backCardDto);

			// 6 active delete
			ChangeCardDto changeCardDto = new ChangeCardDto();
			changeCardDto.setOldCardNo(backCardDto.getCardNo());
			changeCardDto.setCompanyId(backCardDto.getCompanyId());
			changeCardDao.deleteActiveInformation(changeCardDto);
	}

	@Override
	public void returnbalance(BackCardDto backCardDto) throws Exception {
			//1 添加到custom_return_history
			CustomReturnHistory customReturnHistory = new CustomReturnHistory();
			customReturnHistory.setCardNo(backCardDto.getCardNo());
			customReturnHistory.setCompanyId(backCardDto.getCompanyId());
			customReturnHistory.setCreateId(backCardDto.getCreateId());
			customReturnHistory.setReturnPrice(backCardDto.getReturnPrice());
			customReturnHistory.setReason(backCardDto.getBackPaySeason());
			customReturnHistory.setFileName(backCardDto.getFileName());
			customReturnHistory.setPayMode(backCardDto.getBackPay());
			customReturnHistory.setCredit(backCardDto.getCredit());
			customReturnHistory.setReward(backCardDto.getReward());
			customReturnHistory.setRechargeBalance(backCardDto.getRechargeBalance());
			customReturnHistoryDao.insertCustomReturnHistory(customReturnHistory);

			// 2更新cardinformation 充值余额
			backCardDao.updateCardInformationBalance(backCardDto);

			// 3更新activecardinformation 充值余额
			backCardDao.updateActiveBalance(backCardDto);
	}

	@Override
	public BackCard getPageHistory(BackCardDto backCardDto) {
		return backCardDao.getPageHistory(backCardDto);
	}

	@Override
	public BackCard getDialogHistory(BackCardDto backCardDto) {
		return backCardDao.getDialogHistory(backCardDto);
	}

	@Override
	public int getCustomReturnHistoryCount(BackCardDto backCardDto) {
		return backCardDao.getCustomReturnHistoryCount(backCardDto);
	}

	@Override
	public int getActivedInformationCount(BackCardDto backCardDto) {
		return backCardDao.getActivedInformationCount(backCardDto);
	}

}
