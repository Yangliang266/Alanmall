package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardInformationDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.CardInforManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.Parameter;
import com.itcrazy.alanmall.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 制卡管理接口实现
 * @author huangchunbo
 * 2018-09-13
 */
@Slf4j
@Service
public class CardInforManagerImpl implements CardInforManager{

	@Autowired
	private CardInformationDao cardInformationDao;

	@Override
	public List<CardInformation> getPageList(CardInformationDto cardInformationDto) {
		return cardInformationDao.getPageList(cardInformationDto);
	}

	@Override
	public int getPageTotal(CardInformationDto cardInformationDto) {
		return cardInformationDao.getPageTotal(cardInformationDto);
	}

	@Override
	public CardInformation getCardDetail(CardInformationDto cardInformationDto) {
		return cardInformationDao.getCardDetail(cardInformationDto);
	}

	@Override
	public Result OperaCardInformation(Parameter parameter,
			CardInformation cardInformation, String[] jumpNumber, Integer amount, String bin) throws Exception{

		Result result = new Result();
		String cardNo = "";

		// 获取卡号前缀
		String prefix = parameter.getPrefix();
		prefix = prefix != null ? prefix : "";
		// bin码
		String strBin = bin != null ? bin : "";

		// 卡号自然增长的长度
		int naturalGrowthLen = 0;
		// 卡号自然增长的长度 = 设定的自然增长长度 - bin码的长度
		naturalGrowthLen = parameter.getLength() - strBin.length();
		//
		if (naturalGrowthLen <= 0) {
			result.setResultInfo(-1, "制卡失败，可制卡张数为0");
			return result;
		}

		// 自然增长开始值
		long growthBegin = 0L;
		// 自然增长结束值
		long growthEnd = (long) Math.pow(10,naturalGrowthLen);

		// 取当前前缀+bin下的最大卡号
		prefix = prefix + strBin;
		String maxCardNo= cardInformationDao.getMaxCardNoByPrefix(prefix,cardInformation.getCompanyId());
		if(maxCardNo != null) {
			growthBegin = Long.parseLong(maxCardNo.substring(prefix.length()));
		}

		// 当可增长的开始值 == 可增长的最大值
		if(growthBegin == growthEnd) {
			result.setResultInfo(-1, "制卡失败，可制卡张数为0");
			return result;
		}

		List<CardInformation> newCardList = new ArrayList<>(amount);

		long newCardSize = 0L;
		// (从数据库最大卡到的下一张开始)判断跳号
		L:for (long i = growthBegin + 1; i < growthEnd; i++) {

			// 生成卡号
			cardNo = prefix + String.format("%0"+ naturalGrowthLen + "d", i);

			if (jumpNumber != null) {
				for (String endNumber : jumpNumber) {
					if(cardNo.endsWith(endNumber)) {
						continue L;
					}
				}
			}

			CardInformation newCard = new CardInformation();
			newCard.setCardNo(cardNo);
			newCard.setSerialNo(cardInformation.getSerialNo());
			newCard.setCategory(cardInformation.getCategory());
			newCard.setStatus(1);
			newCard.setCreditStatus(1);
			newCard.setCreditMaxQuota(BigDecimal.ZERO);
			newCard.setRechargeBalance(BigDecimal.ZERO);
			newCard.setReward(BigDecimal.ZERO);
			newCard.setCredit(BigDecimal.ZERO);
			newCard.setCreateId(cardInformation.getCreateId());
			newCard.setCompanyId(cardInformation.getCompanyId());

			newCardList.add(newCard);
			newCardSize++;
			// 如果达到到制卡数量
			if (newCardSize == amount.intValue()) {
				break L;
			}
		}

		if (newCardSize != amount.intValue()) {
			result.setResultInfo(-1, "制卡失败，可制卡张数为" + newCardSize);
			return result;
		}

		if (newCardList.size() != 0) {
			cardInformationDao.batchInsert(newCardList);
		}
		result.setSuccessInfo();
		return result;
	}

	@Override
	public String getMaxSerilNo(CardBaseDto cardBaseDto) {

		CardInformation cardInof = new CardInformation();
		cardInof = cardInformationDao.getMaxSerilNo(cardBaseDto);

		String newSerilNo = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		if(cardInof == null) {
			newSerilNo = dateString + String.format("%06d", 1);
		}else {
			String serialNo = cardInof.getSerialNo();
			if (dateString.equals(serialNo.substring(0,8))) {
				int iNum = Integer.parseInt(serialNo.substring(8));
				newSerilNo = dateString + String.format("%06d", iNum + 1);
			}else {
				newSerilNo = dateString + String.format("%06d", 1);
			}
		}

		return newSerilNo;
	}

}
