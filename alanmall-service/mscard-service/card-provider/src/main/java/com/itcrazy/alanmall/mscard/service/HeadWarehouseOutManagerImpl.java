package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.HeadWarehouseOutDao;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.HeadWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseOut;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 总部入库接口实现
 * @author luxf
 * 2018-09-04
 */
@Slf4j
@Service
public class HeadWarehouseOutManagerImpl implements HeadWarehouseOutManager{

	@Autowired
	private HeadWarehouseOutDao headWarehouseOutDao;

	@Override
	public List<HeadWarehouseOut> getPageHistory(HeadWarehouseOutDto headWarehouseOutDto) {
		return headWarehouseOutDao.getPageHistory(headWarehouseOutDto);
	}

	@Override
	public List<HeadWarehouseOut> getPagePrepare(HeadWarehouseOutDto headWarehouseInDto) {
		return headWarehouseOutDao.getPagePrepare(headWarehouseInDto);
	}

	@Override
	public int getPreparePageTotal(HeadWarehouseOutDto headWarehouseInDto) {
		return headWarehouseOutDao.getPreparePageTotal(headWarehouseInDto);
	}

	@Override
	public int getHistoryPageTotal(HeadWarehouseOutDto headWarehouseInDto) {
		return headWarehouseOutDao.getHistoryPageTotal(headWarehouseInDto);
	}

	@Override
	public String getMaxReciptNo(HeadWarehouseOut headWarehouseOut) {
		return headWarehouseOutDao.getMaxReciptNo(headWarehouseOut);
	}

	@Override
	public String OperaHeadWarehouseOut(String[] cardNoList, HeadWarehouseOut headWarehouseOut) throws Exception{


			//设置日期格式
			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");

			// 最大总部入库单号查询
			String lastReceiptNo = headWarehouseOutDao.getMaxReciptNo(headWarehouseOut);

			if(lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "ZBCK-" + receiptNo + String.format("%08d",1);
			}else{
				int iLen = lastReceiptNo.length();
				String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
				if(receiptNo.equals(strDate)) {
					String strNum = lastReceiptNo.substring(iLen - 8);
					int iNum = Integer.parseInt(strNum);
					receiptNo = "ZBCK-" + receiptNo + String.format("%08d", iNum + 1);
				}else {
					receiptNo = "ZBCK-" + receiptNo + String.format("%08d",1);
				}
			}

			headWarehouseOut.setReceiptNo(receiptNo);

			for (int i = 0; i < cardNoList.length; i++) {
				String cardNo = "";
				cardNo = cardNoList[i];
				headWarehouseOut.setCardNo(cardNo);

				// 插入总部入库表
				headWarehouseOutDao.insertHeadWarehouseOut(headWarehouseOut);

				// 更新CardInformation表的卡状态
				headWarehouseOutDao.updateCardInformation(headWarehouseOut);
			}

		return receiptNo;
	}
}
