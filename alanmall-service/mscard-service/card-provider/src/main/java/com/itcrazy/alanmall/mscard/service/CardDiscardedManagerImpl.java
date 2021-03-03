package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardDiscardedDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.manager.CardDiscardedManager;
import com.itcrazy.alanmall.mscard.model.CardDiscarded;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 总部退货接口实现
 * @author yangliang
 * 2018-09-04
 */
@Slf4j
@Service
public class CardDiscardedManagerImpl implements CardDiscardedManager{
	@Autowired
	private CardDiscardedDao cardDiscardedDao;

	@Override
	public List<CardDiscarded> getPageList(CardDiscardedDto cardDiscardedDto) {
		return cardDiscardedDao.getPageList(cardDiscardedDto);
	}

	@Override
	public List<CardDiscarded> getCardDiscardedNo(CardDiscardedDto cardDiscardedDto) {
		return cardDiscardedDao.getCardDiscardedNo(cardDiscardedDto);
	}

	@Override
	public Integer getPageTotal(CardDiscardedDto cardDiscardedDto) {
		return cardDiscardedDao.getPageTotal(cardDiscardedDto);
	}

	@Override
	public Integer getCardDiscardedTotal(CardDiscardedDto cardDiscardedDto) {
		return cardDiscardedDao.getCardDiscardedTotal(cardDiscardedDto);
	}

	@Override
	public void OperaCardDiscarded(String[] cardNoList, CardDiscarded cardDiscarded) throws Exception{
			CardDiscardedDto dto = new CardDiscardedDto();
			//设置日期格式
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

			for (int i = 0; i < cardNoList.length; i++) {
				String cardNo = "";
				cardNo = cardNoList[i];
				// 卡号
				cardDiscarded.setCardNo(cardNo);
				// 退货单号
				cardDiscarded.setReceiptNo(receiptNo);
				// 更新卡状态
				cardDiscardedDao.updateCardInformation(cardDiscarded);
				// 退货记录
				cardDiscardedDao.save(cardDiscarded);
			}
	}

}
