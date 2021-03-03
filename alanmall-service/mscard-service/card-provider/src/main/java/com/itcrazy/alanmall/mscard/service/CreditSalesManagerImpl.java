package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ActiveInformationDao;
import com.itcrazy.alanmall.mscard.dao.CreditSalesHistoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditSalesDto;
import com.itcrazy.alanmall.mscard.manager.CreditSalesManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CreditSalesHistory;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;


/**
 * 挂账卡信息接口实现
 * @author zhangzhongtian
 * 2018-10-09
 */
@Slf4j
@Service
public class CreditSalesManagerImpl implements CreditSalesManager{
	@Autowired
	private CreditSalesHistoryDao creditSalesDao;
	@Autowired
	private ActiveInformationDao activeInformationDao;
	@Override
	public List<CreditSalesHistory> getCreditSalesList(CreditSalesDto creditSalesDto) {
		return creditSalesDao.getCreditSalesList(creditSalesDto);
	}

	@Override
	public CreditSalesHistory getTotalInfo(CreditSalesDto creditSalesDto) {
		return creditSalesDao.getTotalInfo(creditSalesDto);
	}

	@Override
	public Integer getPageTotal(CreditSalesDto creditSalesDto) {

		return creditSalesDao.getPageTotal(creditSalesDto);
	}

	/**
	 * 清账
	 */
	@Override
	public int updateCreditSales(String[] salesIds,CreditSalesHistory creditSales,String clearFlag) {
			// 需清账金额
			BigDecimal amount = creditSales.getCredit();
			//未清账金额
			BigDecimal credit = BigDecimal.ZERO;
			//已清账金额
			BigDecimal clearBill = BigDecimal.ZERO;
			//挂账状态
			int status;

			CreditSalesDto creditSalesDto = new CreditSalesDto();

			//更新激活卡信息表中的挂账总额
			ActiveInformation activeInformation = new ActiveInformation();
			activeInformation.setCredit(amount);
			activeInformation.setCardNo(creditSales.getCardNo());
			activeInformation.setCompanyId(creditSales.getCompanyId());
			activeInformation.setUpdateId(creditSales.getUpdateId());
			activeInformationDao.updateActiveCardInformation(activeInformation);

			for(String id : salesIds) {
				// 获取当前挂账信息
				creditSalesDto.setId(id);
				CreditSalesHistory creditSalesHistory = creditSalesDao.select(creditSalesDto);
				//挂账总额

				if("1".equals(clearFlag)) {
					// 手动选择清账的场合
					// 已清账金额设置为挂账金额
					creditSalesHistory.setClearBill(creditSalesHistory.getCreditBill());
					// 未清账金额设置为0
					creditSalesHistory.setCredit(BigDecimal.ZERO);
					// 挂账状态设置为已清账
					creditSalesHistory.setStatus(0);
				}else {
					// 自动选择清账的场合
					// 当前记录未清账金额
					credit = creditSalesHistory.getCredit();
					// 当前记录已清账金额
					clearBill = creditSalesHistory.getClearBill();

					// 计算已清账金额，未清账金额和挂账状态
					if(credit.compareTo(amount) != 1 ) {
						amount = amount.subtract(credit);
						clearBill = clearBill.add(credit);
						credit = BigDecimal.ZERO;
						status = 0;
					} else {
						clearBill = amount.add(clearBill);
						credit = credit.subtract(amount);
						status = 1;
					}
					creditSalesHistory.setClearBill(clearBill);
					creditSalesHistory.setCredit(credit);
					creditSalesHistory.setStatus(status);
				}
				creditSalesHistory.setOrderNo(id);
				creditSalesHistory.setUpdateId(creditSales.getUpdateId());
				creditSalesDao.update(creditSalesHistory);
			}
		return 1;
	}
}
