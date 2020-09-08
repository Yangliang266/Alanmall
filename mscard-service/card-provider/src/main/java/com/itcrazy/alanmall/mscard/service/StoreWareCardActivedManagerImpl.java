package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.RegisteredCardDao;
import com.itcrazy.alanmall.mscard.dao.StoreWarehouseCardActivedDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseCardActivedDto;
import com.itcrazy.alanmall.mscard.manager.StoreWareCardActivedManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 门店卡激活接口实现
 * @author huangchunbo
 * 2018-09-29
 */

@Slf4j
@Service
public class StoreWareCardActivedManagerImpl implements StoreWareCardActivedManager{

	@Autowired
	private StoreWarehouseCardActivedDao storeWarehouseCardActivedDao;
	@Autowired
	private RegisteredCardDao registeredCardDao;

	@Override
	public List<CardInformation> getPageList(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto) {
		return storeWarehouseCardActivedDao.getPageList(storeWarehouseCardActivedDto);
	}

	@Override
	public Integer getPageTotal(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto) {

		return storeWarehouseCardActivedDao.getPageTotal(storeWarehouseCardActivedDto);
	}

	// 批量发卡
	@Override
	public void OperaHeadWarehouseOut(List<StoreWarehouseCardActivedDto> storeWarehouseCardActivedDtoList,
			StoreWarehouseIn storeWarehouseIn) throws Exception{
			for(int i = 0; i < storeWarehouseCardActivedDtoList.size(); i++) {
				storeWarehouseIn.setCardNo(storeWarehouseCardActivedDtoList.get(i).getCardNo());
				storeWarehouseIn.setStoreInReceiptNo(storeWarehouseCardActivedDtoList.get(i).getReceiptNo());
				storeWarehouseCardActivedDao.updateCardInformation(storeWarehouseIn);

				// 当前数据插入到card_actived_information表中
				ActiveInformation activeInformation = new ActiveInformation();
				activeInformation.setCardNo(storeWarehouseCardActivedDtoList.get(i).getCardNo());
				activeInformation.setCompanyId(storeWarehouseIn.getCompanyId());
				activeInformation.setCreateId(storeWarehouseIn.getCreateId());
				registeredCardDao.saveActiveInfo(activeInformation);

				//修改卡信息表中的充值余额总和,充值奖励总和
				storeWarehouseCardActivedDao.updateCardInformationBill(storeWarehouseIn);
			}
	}
}
