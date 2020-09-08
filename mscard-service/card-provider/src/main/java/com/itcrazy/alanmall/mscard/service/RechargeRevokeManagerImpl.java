package com.itcrazy.alanmall.mscard.service;


import com.itcrazy.alanmall.mscard.dao.*;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeRevokeManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.mscard.model.StorageSalesHistory;
import com.itcrazy.alanmall.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 卡充值撤销接口实现
 * @author chenfei
 * 2018-11-08
 */
@Slf4j
@Service
public class RechargeRevokeManagerImpl implements RechargeRevokeManager{

	@Autowired
	private RechargeRevokeDao rechargeRevokeDao;
	@Autowired
	private RechargeHistoryDao rechargeHistoryDao;
	@Autowired
	private ActiveInformationDao activeInformationDao;
	@Autowired
	private  CardInformationDao cardInformationDao;
	@Autowired
	private  StorageSalesHistoryDao storageSalesHistoryDao;

	@Override
	public List<RechargeHistory> getPageList(RechargeDto rechargeDto) {
		return rechargeRevokeDao.getPageList(rechargeDto);
	}

	@Override
	public Integer getPageTotal(RechargeDto rechargeDto) {
		return rechargeRevokeDao.getPageTotal(rechargeDto);
	}

	@Override
	public Result revokeById(Long id, String cardNo, String remarks,Long storeId, Long companyId,Long userId) {

		Result result = new Result();
		// 根据id获取充值记录
		RechargeHistory rechargeHistoryById = rechargeHistoryDao.getRechargeHistoryById(id,companyId);

		if (rechargeHistoryById == null) {
			result.setResultInfo(-1, "充值记录不存在，撤销失败。");
			return result;
		}

		// 验证目标卡号
		if (!cardNo.equals(rechargeHistoryById.getCardNo())) {
			result.setResultInfo(-1, "卡号验证错误，撤销失败。");
			return result;
		}

		// 判断本金消费时间
		StorageSalesHistory lastStorageSalesHistoryByCardNo = storageSalesHistoryDao.getLastStorageSalesHistoryByCardNo(cardNo, companyId);

		if(lastStorageSalesHistoryByCardNo != null) {
			Date rechargeTime = rechargeHistoryById.getRechargeTime();
			Date lastConsumeTime = lastStorageSalesHistoryByCardNo.getCreateTime();

			// 创建时间不会是null
			if (rechargeTime == null  || lastConsumeTime == null) {
				result.setResultInfo(-1, "充值/消费时间异常，撤销失败。");
				return result;
			}

			// 判断此条充值记录以后，是否有消费
			if (rechargeTime.compareTo(lastConsumeTime) < 0 ) {
				result.setResultInfo(-1, "此充值已被消费，撤销失败。");
				return result;
			}
		}

		CardInformationDto cardInformationDto = new CardInformationDto();
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		CardInformation cardDetail = null;
		ActiveInformation activeDetail = null;

		BigDecimal rechargeBalance = BigDecimal.ZERO;
		BigDecimal reward = BigDecimal.ZERO;

		// 总部充值撤销
		if (storeId == null) {
			cardInformationDto.setCompanyId(companyId);
			cardInformationDto.setCardNo(cardNo);
			cardDetail = cardInformationDao.getCardDetail(cardInformationDto);
			if (cardDetail == null) {
				result.setResultInfo(-1, "此卡不存在，撤销失败。");
				return result;
			}
			cardDetail.setCompanyId(companyId);
			rechargeBalance = cardDetail.getRechargeBalance();
			reward = cardDetail.getReward();
		}else {
			// 门店充值撤销
			activeInformationDto.setCompanyId(companyId);
			activeInformationDto.setCardNo(cardNo);
			activeDetail = activeInformationDao.getActiveDetail(activeInformationDto );
			if (activeDetail == null) {
				result.setResultInfo(-1, "此卡非激活状态，撤销失败。");
				return result;
			}
			activeDetail.setCompanyId(companyId);
			rechargeBalance = activeDetail.getRechargeBalance();
			reward = activeDetail.getReward();
		}

		// 判断金额
		if (rechargeBalance.compareTo(rechargeHistoryById.getRechargeAmount()) == -1
				|| reward.compareTo(rechargeHistoryById.getReward()) == -1) {
			result.setResultInfo(-1, "卡内本金或奖励金小于撤销值，撤销失败。");
			return result;
		}

		// 暂不考虑卡此时的状态

		// 更新充值记录
		rechargeRevokeDao.revokeById(id, remarks, userId);

		// 更新卡的余额
		if (storeId == null) {
			cardDetail.setRechargeBalance(BigDecimal.ZERO.subtract(rechargeHistoryById.getRechargeAmount()));
			cardDetail.setReward(BigDecimal.ZERO.subtract(rechargeHistoryById.getReward()));
			cardInformationDao.updateRechargeByCardNo(cardDetail);
		}else {
			activeDetail.setRechargeBalance(BigDecimal.ZERO.subtract(rechargeHistoryById.getRechargeAmount()));
			activeDetail.setReward(BigDecimal.ZERO.subtract(rechargeHistoryById.getReward()));
			activeInformationDao.updateRechargeByCardNo(activeDetail);
		}

		result.setSuccessInfo();
		return result;
	}

}
