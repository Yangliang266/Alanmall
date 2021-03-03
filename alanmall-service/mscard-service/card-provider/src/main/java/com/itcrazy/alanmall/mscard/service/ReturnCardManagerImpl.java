package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ReturnCardDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReturnCardDto;
import com.itcrazy.alanmall.mscard.manager.ReturnCardManager;
import com.itcrazy.alanmall.mscard.model.ReturnCard;
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
public class ReturnCardManagerImpl implements ReturnCardManager{
	@Autowired
	private ReturnCardDao returnCardDao;

	@Override
	public List<ReturnCard> getPageList(ReturnCardDto returnCardDto) {
		return returnCardDao.getPageList(returnCardDto);
	}

	@Override
	public List<ReturnCard> getReturnCardNo(ReturnCardDto returnCardDto) {
		return returnCardDao.getReturnCardNo(returnCardDto);
	}

	@Override
	public Integer getPageTotal(ReturnCardDto returncardDto) {
		return returnCardDao.getPageTotal(returncardDto);
	}

	@Override
	public Integer getReturnCardTotal(ReturnCardDto returncardDto) {
		return returnCardDao.getReturnCardTotal(returncardDto);
	}

	@Override
	public void OperaReturnCard(String[] cardNoList, ReturnCard returnCard) throws Exception {
			ReturnCardDto dto = new ReturnCardDto();
			//设置日期格式
			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");

			// 最大总部入库单号查询
			dto.setCompanyId(returnCard.getCompanyId());
			String lastReceiptNo = returnCardDao.getMaxReciptNo(dto);

			if(lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "ZBTH-" + receiptNo + String.format("%08d",1);
			}else{
				int iLen = lastReceiptNo.length();
				String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
				if(receiptNo.equals(strDate)) {
					String strNum = lastReceiptNo.substring(iLen - 8);
					int iNum = Integer.parseInt(strNum);
					receiptNo = "ZBTH-" + receiptNo + String.format("%08d", iNum + 1);
				}else {
					receiptNo = "ZBTH-" + receiptNo + String.format("%08d",1);
				}
			}

			for (int i = 0; i < cardNoList.length; i++) {
				String cardNo = "";
				cardNo = cardNoList[i];
				// 卡号
				returnCard.setCardNo(cardNo);
				// 退货单号
				returnCard.setReceiptNO(receiptNo);
				// 更新卡状态
				returnCardDao.updateCardInformation(returnCard);
				// 退货记录
				returnCardDao.insertReturnCard(returnCard);
			}
	}

}
