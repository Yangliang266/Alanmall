package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.HeadWarehouseInDao;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseInDto;
import com.itcrazy.alanmall.mscard.manager.HeadWarehouseInManager;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseIn;
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
public class HeadWarehouseInManagerImpl implements HeadWarehouseInManager{

	@Autowired
	private HeadWarehouseInDao headWarehouseInDao;

	@Override
	public List<HeadWarehouseIn> getPageHistory(HeadWarehouseInDto headWarehouseInDto) {
		return headWarehouseInDao.getPageHistory(headWarehouseInDto);
	}

	@Override
	public List<HeadWarehouseIn> getPagePrepare(HeadWarehouseInDto headWarehouseInDto) {
		return headWarehouseInDao.getPagePrepare(headWarehouseInDto);
	}

	@Override
	public int getPreparePageTotal(HeadWarehouseInDto headWarehouseInDto) {
		return headWarehouseInDao.getPreparePageTotal(headWarehouseInDto);
	}

	@Override
	public int getHistoryPageTotal(HeadWarehouseInDto headWarehouseInDto) {
		return headWarehouseInDao.getHistoryPageTotal(headWarehouseInDto);
	}

	@Override
	public String getMaxReciptNo(HeadWarehouseIn headWarehouseIn) {
		return headWarehouseInDao.getMaxReciptNo(headWarehouseIn);
	}

	@Override
	public String OperaHeadWarehouseIn(String[] cardNoList, Long userId, Long companyId) throws Exception{

			HeadWarehouseIn headWarehouseIn = new HeadWarehouseIn();

			//设置日期格式
			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");

			// 最大总部入库单号查询
			headWarehouseIn.setCompanyId(companyId);
			String lastReceiptNo = headWarehouseInDao.getMaxReciptNo(headWarehouseIn);

			if(lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "ZBRK-" + receiptNo + String.format("%08d",1);
			}else{
				int iLen = lastReceiptNo.length();
				String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
				if(receiptNo.equals(strDate)) {
					String strNum = lastReceiptNo.substring(iLen - 8);
					int iNum = Integer.parseInt(strNum);
					receiptNo = "ZBRK-" + receiptNo + String.format("%08d", iNum + 1);
				}else {
					receiptNo = "ZBRK-" + receiptNo + String.format("%08d",1);
				}
			}

			headWarehouseIn.setReceiptNo(receiptNo);
			headWarehouseIn.setCreateId(userId);
			headWarehouseIn.setUpdateId(userId);

			for (int i = 0; i < cardNoList.length; i++) {
				headWarehouseIn.setCardNo(cardNoList[i]);
				// 插入总部入库表
				headWarehouseInDao.insertHeadWarehouseIn(headWarehouseIn);
				// 更新CardInformation表的卡状态
				headWarehouseInDao.updateCardInformation(headWarehouseIn);
		   }
		return receiptNo;
	}
}
