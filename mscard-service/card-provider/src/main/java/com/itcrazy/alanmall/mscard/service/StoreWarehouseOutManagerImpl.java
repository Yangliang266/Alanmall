package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.StoreWarehouseOutDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 门店调拨接口实现
 *
 * @author yinxiang 2018-09-11
 */

@Slf4j
@Service
public class StoreWarehouseOutManagerImpl implements StoreWarehouseOutManager {
	@Autowired
	private StoreWarehouseOutDao storeWarehouseOutDao;

	// 门店出库
	@Override
	public List<StoreWarehouseOut> getPageList(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageList(storeWarehouseOutDto);
	}

	@Override
	public Integer getPageTotal(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageTotal(storeWarehouseOutDto);
	}

	// 门店调拨
	@Override
	public List<StoreWarehouseOut> getPageOutList(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageOutList(storeWarehouseOutDto);
	}
	@Override
	public Integer getPageOutTotal(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageOutTotal(storeWarehouseOutDto);
	}

	// 调拨入库
	@Override
	public List<StoreWarehouseOut> getPagePrepareInList(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPagePrepareInList(storeWarehouseOutDto);
	}

	@Override
	public Integer getPagePrepareInTotal(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPagePrepareInTotal(storeWarehouseOutDto);
	}

	// 调拨出库单（目的门店未入库）门店出库
	@Override
	public List<StoreWarehouseOut> getPageHistory(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageHistory(storeWarehouseOutDto);
	}
	@Override
	public Integer getPageOutHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageOutHistoryTotal(storeWarehouseOutDto);
	}

	// 已入库的《门店入库单》
	@Override
	public List<StoreWarehouseOut> getPageInHistory(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageInHistory(storeWarehouseOutDto);
	}

	@Override
	public Integer getPageInHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto) {
		return storeWarehouseOutDao.getPageInHistoryTotal(storeWarehouseOutDto);
	}

	// 出库单号
	@Override
	public String OperaStoreWarehouseOut(List<StoreWarehouseOutDto> storeWarehouseOutDtoList,
			StoreWarehouseOut storeWarehouseOut) throws Exception{

			String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");

			String lastReceiptNo = storeWarehouseOutDao.getLastReceiptNo(storeWarehouseOut.getCompanyId());

			if (lastReceiptNo == null || lastReceiptNo.equals("")) {
				receiptNo = "MDCK-" + receiptNo + String.format("%08d", 1);
			} else {
				int sl = lastReceiptNo.length();
				String yyyddmm = lastReceiptNo.substring(sl - 16, sl - 8);
				if (receiptNo.equals(yyyddmm)) {
					String no = lastReceiptNo.substring(sl - 8, sl);
					int iNum = Integer.parseInt(no);
					receiptNo = "MDCK-" + receiptNo + String.format("%08d", iNum + 1);
				} else {
					receiptNo = "MDCK-" + receiptNo + String.format("%08d", 1);
				}
			}

			for (int i = 0; i < storeWarehouseOutDtoList.size(); i++) {

				// 更新卡信息表
				storeWarehouseOut.setCardNo(storeWarehouseOutDtoList.get(i).getCardNo());
				storeWarehouseOut.setReceiptNo(receiptNo);
				// 新增门店出库表
				storeWarehouseOutDao.insertStoreWarehouseOut(storeWarehouseOut);

				// 更新门店入库信息表
				storeWarehouseOutDao.updateCardInformation(storeWarehouseOut);

		}
			return receiptNo;
	}
}







