package com.itcrazy.alanmall.mscard.service;


import com.itcrazy.alanmall.mscard.dao.StoreWarehouseInDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseInDto;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseInManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 门店入库接口实现
 * @author yinxiang
 * 2018-09-04
 */

@Slf4j
@Service
public class StoreWarehouseInManagerImpl implements StoreWarehouseInManager{


	@Autowired
	private StoreWarehouseInDao storeWarehouseInDao;

	@Override
	public List<StoreWarehouseIn> getHistoryPageList(StoreWarehouseInDto storeWarehouseInDto) {
		return storeWarehouseInDao.getHistoryPageList(storeWarehouseInDto);
	}

	@Override
	public Integer getHistoryPageTotal(StoreWarehouseInDto storeWarehouseInDto) {
		return storeWarehouseInDao.getHistoryPageTotal(storeWarehouseInDto);
	}

	@Override
	public List<StoreWarehouseIn> getPerparePageList(StoreWarehouseInDto storeWarehouseInDto) {
		return storeWarehouseInDao.getPerparePageList(storeWarehouseInDto);
	}

	@Override
	public Integer getPerparePageTotal(StoreWarehouseInDto storeWarehouseInDto) {
		return storeWarehouseInDao.getPerparePageTotal(storeWarehouseInDto);
	}

    // 门店入库单号
	@Override
	public String OperaStoreWarehouseIn(List<StoreWarehouseInDto> storeWarehouseInDtoList, StoreWarehouseIn storeWarehouseIn) throws Exception{
		String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");

		String lastReceiptNo = storeWarehouseInDao.getLastStoreInReceiptNo(storeWarehouseIn.getCompanyId());

		if(lastReceiptNo==null || lastReceiptNo.equals("")) {
			receiptNo = "MDRK-" + receiptNo + String.format("%08d",1);
		}else{
			int sl = lastReceiptNo.length();
			String yyyddmm = lastReceiptNo.substring(sl-16, sl-8);
			if(receiptNo.equals(yyyddmm)) {
				String no = lastReceiptNo.substring(sl-8, sl);
				int iNum = Integer.parseInt(no);
				receiptNo = "MDRK-" + receiptNo + String.format("%08d",iNum + 1);
			}else {
				receiptNo = "MDRK-" + receiptNo + String.format("%08d",1);
			}
		}

		for (int i = 0; i < storeWarehouseInDtoList.size(); i++) {

			// 更新卡信息表
			storeWarehouseIn.setCardNo(storeWarehouseInDtoList.get(i).getCardNo());
			storeWarehouseIn.setWarehouseOutNo(storeWarehouseInDtoList.get(i).getWarehouseOutNo());
			storeWarehouseIn.setStoreInReceiptNo(receiptNo);

			// 门店调拨入库和门店入库的判断
	    	storeWarehouseIn.setStoreFrom(storeWarehouseInDtoList.get(i).getStoreFrom() == null ? 0L : storeWarehouseInDtoList.get(i).getStoreFrom());
			// 新增门店入库表
			storeWarehouseInDao.insertStoreWarehouseIn(storeWarehouseIn);
			// 更新卡信息表
		    storeWarehouseInDao.updateCardInformation(storeWarehouseIn);
		}
		return receiptNo;
	}
}

