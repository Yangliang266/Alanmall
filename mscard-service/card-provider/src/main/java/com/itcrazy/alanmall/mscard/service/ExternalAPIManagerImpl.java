package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.*;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.dto.Base.CreditSalesDto;
import com.itcrazy.alanmall.mscard.dto.Base.PayModeDto;
import com.itcrazy.alanmall.mscard.manager.ExternalAPIManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.util.BASE64Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

/**
 * 卡系统对外接口实现类
 * @author chenfei
 * 2018-10-10
 */
@Slf4j
@Service
public class ExternalAPIManagerImpl implements ExternalAPIManager {
	// 挂账母卡
	private final static Integer MOTHER_TYPE_CREDIT_MOTHER = 4;
	// 挂账子卡
	private final static Integer MOTHER_TYPE_CREDIT_SUB = 3;
	// 亲情母卡
	private final static Integer MOTHER_TYPE_KINSHIP_MOTHER = 2;
	// 亲情子卡
	private final static Integer MOTHER_TYPE_KINSHIP_SUB = 1;

	@Autowired
	RegisteredCardDao registeredCardDao;
	@Autowired
	ActiveInformationDao activeInformationDao;
	@Autowired
	StorageSalesHistoryDao storageSalesHistoryDao;
	@Autowired
	CreditSalesHistoryDao creditSalesHistoryDao;
	@Autowired
	OtherSalesHistoryDao otherSalesHistoryDao;
	@Autowired
	OrderListDao orderListDao;
	@Autowired
	CardInformationDao cardInformationDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	DiscountDao discountDao;
	@Autowired
	PayModeDao payModeDao;
	@Autowired
	CreditSettingDao creditSettingDao;

	@Override
	public synchronized int consume(Consume consume) throws Exception {
		return consumeWithRemarks(consume,null);
	}

	@Override
	public synchronized int consumeWithRemarks(Consume consume, String remarks) throws Exception {
		return kinshipCardConsume(consume, remarks);
	}

	@Override
	public ExternalAPICardInfo query(String cardNo, Long brandId, Long storeId, Long companyId) {
		// 1.参数验证，验证不通过，返回null
//		if(StringUtils.isBlank(cardNo) || brandId == null
//				||storeId == null || companyId == null) {
//			return null;
//		}
		if(StringUtils.isBlank(cardNo) || companyId == null) {
			return null;
		}

		ExternalAPICardInfo externalAPICardInfo = new ExternalAPICardInfo();

		// 2.通过卡号从卡激活表中查找查找 card_actived_information
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		activeInformationDto.setCardNo(cardNo);
		activeInformationDto.setCompanyId(companyId);
		ActiveInformation activeDetail = activeInformationDao.getActiveDetail(activeInformationDto);
		// 如果卡激活表有此卡，证明此卡被激活过
		if(activeDetail != null) {
			externalAPICardInfo.setRelaseStoreId(activeDetail.getStore());
			externalAPICardInfo.setStatus(activeDetail.getStatus());
			externalAPICardInfo.setStrCardStatus(getCardStatusValue(activeDetail.getStatus()));
			externalAPICardInfo.setCategoryId(activeDetail.getCategory());
			externalAPICardInfo.setCreditStatus(activeDetail.getCreditStatus());
			externalAPICardInfo.setCreditMaxQuota(new BigDecimal(activeDetail.getCreditMaxQuota()));
			externalAPICardInfo.setTotalCredit(activeDetail.getCredit());
			externalAPICardInfo.setUserName(activeDetail.getUserName());
			externalAPICardInfo.setTelephone(activeDetail.getTelephone());

			externalAPICardInfo.setRechargeBalance(activeDetail.getRechargeBalance());
			externalAPICardInfo.setReward(activeDetail.getReward());

			// 亲情卡子卡
			if (activeDetail.getMotherType() != null
					&& (activeDetail.getMotherType() == 1 || activeDetail.getMotherType() == 2)) {

				// 亲情卡不可挂账
				externalAPICardInfo.setCreditStatus(1);
				externalAPICardInfo.setCreditMaxQuota(BigDecimal.ZERO);
				// 亲情卡子卡
				if (activeDetail.getMotherType() == 1) {
					// 无母卡卡号
					if (StringUtils.isBlank(activeDetail.getMotherCardNo())) {
						externalAPICardInfo.setRechargeBalance(BigDecimal.ZERO);
						externalAPICardInfo.setReward(BigDecimal.ZERO);
					}else {
						activeInformationDto.setCardNo(activeDetail.getMotherCardNo());
						ActiveInformation activeMotherCard = activeInformationDao.getActiveDetail(activeInformationDto);

						// 母卡不是激活卡
						if(activeMotherCard == null || activeMotherCard.getStatus() != CardConstants.KEY_CARD_STATE_ACTIVATED) {
							externalAPICardInfo.setRechargeBalance(BigDecimal.ZERO);
							externalAPICardInfo.setReward(BigDecimal.ZERO);
						}else {
							// 如果此卡是亲情卡子卡，就显示其母卡的金额
							externalAPICardInfo.setRechargeBalance(activeMotherCard.getRechargeBalance());
							externalAPICardInfo.setReward(activeMotherCard.getReward());
						}
					}
				}
			}
		} else {
			// 如果卡激活表没有此卡，证明此卡未被激活，需从卡总表中查找
			CardInformationDto cardInformationDto = new CardInformationDto();
			cardInformationDto.setCardNo(cardNo);
			cardInformationDto.setCompanyId(companyId);
			CardInformation cardDetail = cardInformationDao.getCardDetail(cardInformationDto);

			// 如果卡总表中没有查出数据，即没有此卡
			if(cardDetail == null) {
				return null;
			}

			externalAPICardInfo.setRelaseStoreId(cardDetail.getStore());
			externalAPICardInfo.setStatus(cardDetail.getStatus());
			externalAPICardInfo.setCategoryId(cardDetail.getCategory().longValue());
			externalAPICardInfo.setStrCardStatus(getCardStatusValue(cardDetail.getStatus()));
			externalAPICardInfo.setRechargeBalance(cardDetail.getRechargeBalance());
			externalAPICardInfo.setReward(cardDetail.getReward());
			externalAPICardInfo.setCreditStatus(cardDetail.getCreditStatus());
			externalAPICardInfo.setCreditMaxQuota(cardDetail.getCreditMaxQuota());
			externalAPICardInfo.setTotalCredit(cardDetail.getCredit());
			externalAPICardInfo.setTelephone("");
			externalAPICardInfo.setUserName("");
		}

		externalAPICardInfo.setCardNo(cardNo);
		externalAPICardInfo.setCompanyId(companyId);

		// 卡类别
		Category category = categoryDao.getCategoryById(externalAPICardInfo.getCategoryId(), companyId);

		// 如果没有卡类别，就返回null，一般不会有这种情况
		if(category == null) {
			return null;
		}

		// 卡类别名称
		externalAPICardInfo.setStrCategory(category.getName());

		// 本店是否可消费
		String stores = category.getStores();
		String[] aStores = null;
		if(StringUtils.isBlank(stores)) {
			aStores = new String[0];
		}else {
			aStores = stores.split(",");
		}
		boolean currentStoreCanConsume = false;
		if(storeId != null){
			currentStoreCanConsume = Arrays.asList(aStores).contains(storeId.toString());
		} else {
			currentStoreCanConsume = true;
		}

		// 是否是全品牌下的门店参与
		String allJoinBrands = category.getAllJoinBrands();
		String[] aAllJoinBrands = null;
		if(StringUtils.isBlank(allJoinBrands)) {
			aAllJoinBrands = new String[0];
		}else {
			aAllJoinBrands = allJoinBrands.split(",");
		}

		boolean isAllJoinBrands  =  false;
		if(brandId != null){
			isAllJoinBrands  =  Arrays.asList(aAllJoinBrands).contains(brandId.toString());
		} else {
			isAllJoinBrands = true;
		}

		// 如果不可消费，并且不是全品牌参与，即不能消费
		if(!currentStoreCanConsume && !isAllJoinBrands) {
			externalAPICardInfo.setCurrentStoreCanConsume(false);
			externalAPICardInfo.setCanCredit(false); // 不可挂账
		} else {
			externalAPICardInfo.setCurrentStoreCanConsume(true);
		}

		Discount discount = new Discount();
		discount.setCompanyId(companyId);
		discount.setCardCategotyId(externalAPICardInfo.getCategoryId());
		discount.setType(CardConstants.CARD_DISCOUNT_TYPE_STORE);
		discount.setCode(storeId == null ? "" : storeId.toString());

		// 折扣率
		List<Discount> discountList = discountDao.getDiscountList(discount);
		if(!discountList.isEmpty()) {
			// 门店有折扣率
			externalAPICardInfo.setCurrentStoreDiscount(discountList.get(0).getDiscount());
		} else {
			// 门店没有折扣率，查找品牌折扣率
			if(isAllJoinBrands) {
				discount.setType(CardConstants.CARD_DISCOUNT_TYPE_BRAND);
				discount.setCode(brandId == null ? "" : brandId.toString());
				discountList = discountDao.getDiscountList(discount);
				if(!discountList.isEmpty()) {
					// 品牌折扣率
					externalAPICardInfo.setCurrentStoreDiscount(discountList.get(0).getDiscount());
				} else {
					// 没有品牌折扣率，就默认卡类别折扣率
					externalAPICardInfo.setCurrentStoreDiscount(category.getDiscount());
				}
			}	else {
				// 如果不是品牌全参与，就没有折扣
				externalAPICardInfo.setCurrentStoreDiscount(BigDecimal.ONE);
			}

		}

		// 本店是否可挂账
		boolean canCredit = category.getIsCredit() == CardConstants.KEY_YES ? true : false ;
		externalAPICardInfo.setCanCredit(canCredit);

		// 如果不可挂账
		if(!canCredit) {
			externalAPICardInfo.setAllowableCredit(BigDecimal.ZERO);	// 可挂账金额为0
			return externalAPICardInfo;
		}

		// 可挂账金额
		externalAPICardInfo.setAllowableCredit(surplusCreditQuota(cardNo, storeId, companyId));


		// 表registered_card中，根据卡号和商家id查支付密码，如果有密码，就是需要支付密码
		String payPwd = registeredCardDao.getPayPwdByCardNo(cardNo,companyId);

		if(StringUtils.isNotBlank(payPwd)) {
			externalAPICardInfo.setNeedPayPwd(true);
		} else {
			externalAPICardInfo.setNeedPayPwd(false);
		}

		return externalAPICardInfo;
	}

	@Override
	public synchronized int revokeConsume(String orderNo, Long companyId, Long userId) throws Exception{

		// 1.验证参数
		if(StringUtils.isBlank(orderNo) || companyId == null || userId == null) {
			return 1;
		}

		// 2.从order_list表中查找订单
		OrderList orderListByOrderNo = orderListDao.getOrderListByOrderNo(orderNo, companyId);
		// 订单不存在/被删除
		if(orderListByOrderNo == null) {
			return 2;
		}

		// 订单消费失败/已被撤销
		if(orderListByOrderNo.getStatus() != CardConstants.KEY_ORDER_STATUS_SUCCESS) {
			return 3;
		}

		// 判断消费时间和撤销时间是否在同一天，同一天才可撤销（不是24小时之内）
		if(!isSameDay(orderListByOrderNo.getCreateTime(), new Date())) {
			return 4;
		}
		// 消费方式
		String consumeMode = orderListByOrderNo.getConsumeMode();
		// 其他错误(消费模式异常)
		if (consumeMode == null || StringUtils.isBlank(consumeMode)) {
			return 5;
		}

		BigDecimal addReward = orderListByOrderNo.getAddReward();
		BigDecimal storage = new BigDecimal(0);
		BigDecimal credit = new BigDecimal(0);
		BigDecimal reward = new BigDecimal(0);
		String cardNo = "";

		// 储值消费
		StorageSalesHistory storageSalesHistoryByOrderNo =
				storageSalesHistoryDao.getStorageSalesHistoryByOrderNo(orderNo, companyId);
		String kinshipCardNo = null;
		Integer motherType = null;
		if(storageSalesHistoryByOrderNo != null) {
			storage = storageSalesHistoryByOrderNo.getBill();
			reward = storageSalesHistoryByOrderNo.getReward();
			cardNo = storageSalesHistoryByOrderNo.getCardNo();
			kinshipCardNo = storageSalesHistoryByOrderNo.getMotherCardNo();
			motherType = storageSalesHistoryByOrderNo.getMotherType();
		}
		// 挂账消费
		CreditSalesDto creditSalesDto = new CreditSalesDto();
		creditSalesDto.setId(orderNo);
		creditSalesDto.setCompanyId(companyId);
		CreditSalesHistory creditSalesHistory =
				creditSalesHistoryDao.select(creditSalesDto);
		if(creditSalesHistory != null) {
			// 该订单未清账总额
			credit = creditSalesHistory.getCredit();
			cardNo = creditSalesHistory.getCardNo();
		}
		// 其他消费不需要查询，因为不返还金额，但是要查卡号
		// 挂账消费
		OtherSalesHistory otherSalesHistory =
				otherSalesHistoryDao.getOtherSalesHistoryByOrderNo(orderNo, companyId);
		if(otherSalesHistory != null) {
			cardNo = otherSalesHistory.getCardNo();
		}

		// 亲情卡母子卡  1代表亲情子卡
		if (StringUtils.isNoneBlank(kinshipCardNo)
				&& motherType != null && motherType.equals(MOTHER_TYPE_KINSHIP_SUB)) {
			cardNo = kinshipCardNo;
		}

		// 消费卡号异常
		if(StringUtils.isBlank(cardNo)) {
			return 6;
		}
		// 表card_actived_information中，根据卡号查【状态】，【状态】查不到或不是激活
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		activeInformationDto.setCardNo(cardNo);
		activeInformationDto.setCompanyId(companyId);

		ActiveInformation activeDetail = activeInformationDao.getActiveDetail(activeInformationDto);

		if(activeDetail == null || activeDetail.getStatus() != CardConstants.KEY_CARD_STATE_ACTIVATED) {
			// 当有亲情卡母卡时
			if (StringUtils.isNoneBlank(kinshipCardNo)) {
				return 9;
			}
			// 当没有亲情卡母卡时
			return 6;
		}

		// 验证奖励/挂账额是否够撤销
		// 撤销后的奖励余额 = 现有奖励余额  - 消费产生的奖励 + 消费的奖励
		BigDecimal newReward = activeDetail.getReward().subtract(addReward).add(reward);
		// 撤销后的奖励余额 < 0 ， 奖励余额不够扣除
		if(newReward.compareTo(BigDecimal.ZERO) == -1) {
			return 7;
		}

		// 挂账订单的未清账总额 != 挂账订单的原始挂账额，即已经被清账，或者卡当前挂账总额小于撤销挂账额 不可撤销（撤销后，挂账总额会小于0）
		if(creditSalesHistory != null) {
			if(credit.compareTo(creditSalesHistory.getCredit()) !=0
					|| activeDetail.getCredit().compareTo(credit) == -1) {
				return 8;
			}
		}

		/******* 验证完毕 *******/
		// 将挂账一览表、储值消费一览表和其他消费一览表对应的记录删除
		String[] consumeModes = consumeMode.split(",");
		if (consumeModes != null && consumeModes.length > 0) {
			if (Arrays.asList(consumeModes).contains(CardConstants.KEY_CONSUME_MODE_STORAGE)) {
				storageSalesHistoryDao.delete(orderNo, companyId, userId);
			}
			if (Arrays.asList(consumeModes).contains(CardConstants.KEY_CONSUME_MODE_CREDIT)) {
				creditSalesHistoryDao.delete(orderNo, companyId, userId);
			}
			if (Arrays.asList(consumeModes).contains(CardConstants.KEY_CONSUME_MODE_OTHERS)) {
				otherSalesHistoryDao.delete(orderNo, companyId, userId);
			}
		}

		// 将order_list表中对应订单状态改为撤销
		orderListDao.revoke(orderNo, companyId, userId);

		// 更新card_actived_information
		ActiveInformation newActive = new ActiveInformation();
		newActive.setCardNo(cardNo);
		newActive.setRechargeBalance(activeDetail.getRechargeBalance().add(storage));
		newActive.setCredit(activeDetail.getCredit().subtract(credit));
		newActive.setReward(newReward);
		newActive.setUpdateId(userId);
		newActive.setCompanyId(companyId);
		activeInformationDao.save(newActive);

		return 0;
	}

	@Override
	public synchronized ExternalAPIConsumeResult autoReckonConsume(Consume consume) throws Exception {

		ExternalAPIConsumeResult externalAPIConsumeResult = new ExternalAPIConsumeResult();

		// consume.getUserId() 可以为null
		if(consume == null || consume.getCompanyId() == null
				|| StringUtils.isBlank(consume.getCardNo())
				|| StringUtils.isBlank(consume.getOrderNo())
				|| consume.getStoreId() == null
				|| consume.getBrandId() == null) {
			externalAPIConsumeResult.setReturnCode(1);
			return externalAPIConsumeResult;
		}

		String cardNo = consume.getCardNo();
		externalAPIConsumeResult.setCardNo(cardNo);
		Long storeId = consume.getStoreId();
		Long brandId = consume.getBrandId();
		Long companyId = consume.getCompanyId();

		BigDecimal amount = consume.getAmount();
		BigDecimal addReward = consume.getAddReward();

		// 1，参数中的,各种金额小于0(总消费金额不大于0)
		if((amount == null || addReward == null) ||
				(amount.compareTo(BigDecimal.ZERO) != 1 || addReward.compareTo(BigDecimal.ZERO) == -1)) {
			externalAPIConsumeResult.setReturnCode(1);
			return externalAPIConsumeResult;
		}

		ExternalAPICardInfo query = query(cardNo, brandId, storeId, companyId);
		// cardNo/brandId/storeId/companyId为null或者卡号/卡类别不存在 返回3
		if (query == null) {
			externalAPIConsumeResult.setReturnCode(2);
			return externalAPIConsumeResult;
		}
		// 到此，此卡可能非激活状态

		// 当前门店不可消费 返回3
		if (!query.isCurrentStoreCanConsume()) {
			externalAPIConsumeResult.setReturnCode(3);
			return externalAPIConsumeResult;
		}

		// 折扣率
		BigDecimal currentStoreDiscount = query.getCurrentStoreDiscount();
		if (currentStoreDiscount == null) {
			currentStoreDiscount = BigDecimal.ONE;
		}

		// 打完折的消费总额
		amount = amount.multiply(currentStoreDiscount);

		BigDecimal storage = new BigDecimal(0);
		BigDecimal credit = new BigDecimal(0);
		BigDecimal reward = new BigDecimal(0);
		BigDecimal other = new BigDecimal(0);

		BigDecimal restStorage = query.getRechargeBalance();
		BigDecimal restReward = query.getReward();
		BigDecimal allowableCredit = query.getAllowableCredit();

		// 需要扣除的储值金
		storage = getSmallerBigDecimal(amount,restStorage);
		// 不够扣的储值金
		BigDecimal oweStorage = amount.subtract(storage);

		// 不够扣的储值金 大于零
		if (oweStorage.compareTo(BigDecimal.ZERO) == 1) {
			// 扣奖励金额
			reward = getSmallerBigDecimal(oweStorage,restReward);
			// 不够扣的奖励金
			BigDecimal oweReward = oweStorage.subtract(reward);

			// 不够扣的奖励金大于零
			if (oweReward.compareTo(BigDecimal.ZERO) == 1) {
				// 判断是否可以挂账，如果不挂账，返回4，余额不足
				if (!query.isCanCredit()) {
					externalAPIConsumeResult.setReturnCode(4);
					return externalAPIConsumeResult;
				}else {
					// 如果可以挂账，就扣除挂账额
					credit = getSmallerBigDecimal(oweReward, allowableCredit);
					// 不够扣的挂账金
					BigDecimal oweCredit = oweReward.subtract(credit);
					// 不够扣的挂账金大于零 返回5，可挂账金额不足
					if (oweCredit.compareTo(BigDecimal.ZERO) == 1) {
						externalAPIConsumeResult.setReturnCode(5);
						return externalAPIConsumeResult;
					}
				}
			}
		}

		// 自动计算后的各种金额
		consume.setAmount(amount);	// 算过折扣率的消费总额
		consume.setStorage(storage);
		consume.setReward(reward);
		consume.setCredit(credit);
		consume.setOther(other);

		// 调用精确消费接口
		int consumeResult = consume(consume);

		if (consumeResult == 0) {
			externalAPIConsumeResult.setReturnCode(0);
		} else if (consumeResult == 1		// 参数验证不通过（或消费金额  != 本金消费 + 奖励金额 + 挂账消费金额+其他
				|| consumeResult == 4		// 消费金额 / 本金消费 / 奖励金额  大于对应的余额
				|| consumeResult == 5		// 此卡不可挂账
				|| consumeResult == 6		// 此卡可挂账，但是挂账消费金额大于剩余可挂账金额
				|| consumeResult == 7		// 其他错误
				|| consumeResult == 8) {	// 其他消费金额大于0时，支付方式不合法
			externalAPIConsumeResult.setReturnCode(8);		// 其他错误
		} else if (consumeResult == 2) {	// 密码验证失败（没有密码请传null）
			externalAPIConsumeResult.setReturnCode(6);		// 密码验证失败（没有密码请传null）
		} else if (consumeResult == 3) {	// 此卡非激活卡
			externalAPIConsumeResult.setReturnCode(7);		// 此卡非激活卡
		} else if (consumeResult == 9) {	// 此门店不可消费
			externalAPIConsumeResult.setReturnCode(3);		// 此门店不可消费
		} else if (consumeResult == 10) {	// 订单号已存在
			externalAPIConsumeResult.setReturnCode(9);		// 订单号已存在
		} else if (consumeResult == 11) {	// 此卡为亲情卡子卡，母卡卡号丢失
			externalAPIConsumeResult.setReturnCode(10);		// 此卡为亲情卡子卡，母卡卡号丢失
		} else if (consumeResult == 12) {	// 此卡为亲情卡子卡，母卡非激活状态
			externalAPIConsumeResult.setReturnCode(11);		// 此卡为亲情卡子卡，母卡非激活状态
		} else if (consumeResult == 13) {	// 此卡为亲情卡不可挂账
			externalAPIConsumeResult.setReturnCode(12);		// 此卡为亲情卡不可挂账
		} else {
			externalAPIConsumeResult.setReturnCode(8);		// 其他错误
		}

		if (externalAPIConsumeResult.getReturnCode() != null
				&& externalAPIConsumeResult.getReturnCode().equals(0)) {

			ExternalAPICardInfo consumedQuery = query(cardNo, brandId, storeId, companyId);

			// 本次消费扣除的金额
			externalAPIConsumeResult.setDeductedAmount(consume.getAmount());
			externalAPIConsumeResult.setDeductedRecharge(consume.getStorage());
			externalAPIConsumeResult.setDeductedReward(consume.getReward());
			externalAPIConsumeResult.setDeductedCredit(consume.getCredit());
			externalAPIConsumeResult.setDeductedOther(consume.getOther());

			// 本次消费后还剩的金额
			externalAPIConsumeResult.setRechargeBalance(consumedQuery.getRechargeBalance());
			externalAPIConsumeResult.setReward(consumedQuery.getReward());
			externalAPIConsumeResult.setAllowableCredit(consumedQuery.getAllowableCredit());
		}

		return externalAPIConsumeResult;
	}


	/**
	 * <h2>亲情卡消费</h2>
	 * <p>消费规则：</p>
	 * <ol>
	 * <li>亲情卡范围内，母卡不能为子卡，子卡也不能为其他卡的母卡</li>
	 * <li>亲情卡的母子卡都不可以挂账</li>
	 * <li>母子卡组成的家族卡范围，任意卡消费，扣除的都是母卡的本金和奖励金</li>
	 * </ol>
	 * @return
	 */
	private synchronized int kinshipCardConsume(Consume consume, String remarks) {
		// consume.getUserId() 可以为null
		if(consume == null || consume.getCompanyId() == null
				|| StringUtils.isBlank(consume.getCardNo())
				|| StringUtils.isBlank(consume.getOrderNo())
				|| consume.getStoreId() == null
				|| consume.getBrandId() == null) {
			return 1;
		}
		String orderNo = consume.getOrderNo();
		Integer countByOrderNo = orderListDao.getCountByOrderNo(orderNo);
		// 订单号已存在
		if (!(countByOrderNo == null || countByOrderNo.equals(0))) {
			return 10;
		}

		String cardNo = consume.getCardNo();

		Long storeId = consume.getStoreId();
		Long brandId = consume.getBrandId();
		Long companyId = consume.getCompanyId();

		BigDecimal amount = consume.getAmount();
		BigDecimal storage = consume.getStorage();
		BigDecimal credit = consume.getCredit();
		BigDecimal reward = consume.getReward();
		BigDecimal other = consume.getOther();
		BigDecimal addReward = consume.getAddReward();

		// 1，参数中的,各种金额小于0(总消费金额不大于0)  或者    消费金额!= 本金消费 + 奖励消费 + 挂账消费 + 其他金额，返回1
		if (storage == null) {
			storage = BigDecimal.ZERO;
		}
		if (credit == null) {
			credit = BigDecimal.ZERO;
		}
		if (reward == null) {
			reward = BigDecimal.ZERO;
		}
		if (other == null) {
			other = BigDecimal.ZERO;
		}

		if((amount == null || addReward == null) ||
				(amount.compareTo(BigDecimal.ZERO) != 1 || storage.compareTo(BigDecimal.ZERO) == -1
				|| credit.compareTo(BigDecimal.ZERO) == -1 || reward.compareTo(BigDecimal.ZERO) == -1
				|| other.compareTo(BigDecimal.ZERO) == -1 || addReward.compareTo(BigDecimal.ZERO) == -1)
			||	(amount.compareTo(storage.add(credit).add(reward).add(other)) != 0)) {
			return 1;
		}

		// 当其他消费金额大于0是，判断支付方式，如果支付方式不是充值方式中的一种（数据库中为外键），返回8
		Integer payMode = consume.getPayMode();
		if (other.compareTo(BigDecimal.ZERO) == 1) {
			if (payMode != null) {
				PayModeDto payModeDto = new PayModeDto();
				payModeDto.setCompanyId(companyId);
				payModeDto.setStatus(0);	// 支付方式启用
				payModeDto.setIsDeleted(0);	// 支付方式未删除

				List<PayMode> pageList = payModeDao.getPageList(payModeDto);
				if (pageList == null || pageList.isEmpty()) {
					return 8;
				}

				List<Long> payModeIdList = new ArrayList<>();
				for (PayMode pMode : pageList) {
					payModeIdList.add(pMode.getId());
				}
				if (!payModeIdList.contains( payMode.longValue())) {
					return 8;
				}
			}else {
				return 8;
			}
		}

		// 2，表registered_card中，根据卡号和商家id查支付密码。查到的话，验证参数中的卡密，错误返回2。
		// 根据卡号和商家id查支付密码
		String payPwd = registeredCardDao.getPayPwdByCardNo(cardNo,companyId);

		if(StringUtils.isNotBlank(payPwd)) {
			if(StringUtils.isBlank(consume.getPayPwd())){
				return 2;
			}

			if(!(payPwd.equals(consume.getPayPwd()) // 为什么要匹配明文密码？因为最开始导入的原始数据中的密码是明文未加密的 ！！！
							|| payPwd.equals(BASE64Util.encryptBASE64(consume.getPayPwd())))) {
				return 2;
			}
		}

		// 3，表card_actived_information中，根据卡号查【状态】和【挂账状态】，【状态】查不到或不是激活，则返回3。
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		activeInformationDto.setCardNo(cardNo);
		activeInformationDto.setCompanyId(companyId);
		ActiveInformation activeDetail = activeInformationDao.getActiveDetail(activeInformationDto);

		if(activeDetail == null || activeDetail.getStatus() != CardConstants.KEY_CARD_STATE_ACTIVATED) {
			return 3;
		}


		// 卡类别
		Category category = categoryDao.getCategoryById(activeDetail.getCategory(), companyId);

		// 如果没有卡类别，就返回7其他异常，一般不会有这种情况
		if(category == null) {
			return 7;
		}

		// 本店是否可消费
		String stores = category.getStores();
		String[] aStores = null;
		if(StringUtils.isBlank(stores)) {
			aStores = new String[0];
		}else {
			aStores = stores.split(",");
		}
		boolean currentStoreCanConsume = Arrays.asList(aStores).contains(storeId.toString());

		// 是否是全品牌下的门店参与
		String allJoinBrands = category.getAllJoinBrands();
		String[] aAllJoinBrands = null;
		if(StringUtils.isBlank(allJoinBrands)) {
			aAllJoinBrands = new String[0];
		}else {
			aAllJoinBrands = allJoinBrands.split(",");
		}

		boolean isAllJoinBrands  =  Arrays.asList(aAllJoinBrands).contains(brandId.toString());

		// 如果不可消费，并且不是全品牌参与，即不能消费 返回9
		if(!currentStoreCanConsume && !isAllJoinBrands) {
			return 9;
		}

		// 判断亲情卡
		String kinshipMotherCardNo = activeDetail.getCardNo();
		Integer motherType = null;
		if (activeDetail.getMotherType() != null
				&& (activeDetail.getMotherType().equals(MOTHER_TYPE_KINSHIP_SUB) || activeDetail.getMotherType().equals(MOTHER_TYPE_KINSHIP_MOTHER))) {

			// 亲情卡子卡
			if (activeDetail.getMotherType().equals(MOTHER_TYPE_KINSHIP_SUB)) {
				// 无母卡卡号
				if (StringUtils.isBlank(activeDetail.getMotherCardNo())) {
					return 11;
				}
				activeInformationDto.setCardNo(activeDetail.getMotherCardNo());
				ActiveInformation activeMotherCard = activeInformationDao.getActiveDetail(activeInformationDto);

				// 母卡不是激活卡
				if(activeMotherCard == null || activeMotherCard.getStatus() != CardConstants.KEY_CARD_STATE_ACTIVATED) {
					return 12;
				}

				// 如果此卡是亲情卡子卡，就扣其母卡的金额
				kinshipMotherCardNo = activeMotherCard.getCardNo();
				motherType = MOTHER_TYPE_KINSHIP_SUB;
				activeDetail.setRechargeBalance(activeMotherCard.getRechargeBalance());
				activeDetail.setReward(activeMotherCard.getReward());
			} else {
				motherType = MOTHER_TYPE_KINSHIP_MOTHER;
			}

			// 亲情卡不可挂账
			if (credit.compareTo(BigDecimal.ZERO) == 1) {
				return 13;
			}
		} else {

			if (activeDetail.getMotherType() == null) {
				// 挂账母子卡(兼容亲情卡上线前的数据)
				if (StringUtils.isBlank(activeDetail.getMotherCardNo())) {
					motherType = MOTHER_TYPE_CREDIT_MOTHER;
				} else {
					motherType = MOTHER_TYPE_CREDIT_SUB;
				}
			}

			// 【挂账状态】是关闭，挂账消费 大于0，则返回5；
			if(activeDetail.getCreditStatus() == CardConstants.KEY_CREDIT_STATUS_DISABLE) {
				if(credit.compareTo(BigDecimal.ZERO) == 1) {
					return 5;
				}
			}else if(activeDetail.getCreditStatus() == CardConstants.KEY_CREDIT_STATUS_ENABLE){
				//【挂账状态】是开启，消费挂账金额  大于 - 剩余可挂账金额，则返回6；
				if(credit.compareTo(surplusCreditQuota(cardNo,storeId, companyId)) == 1) {
					return 6;
				}
			}else{
				return 7;
			}
		}

		// 4，分别判断 参数中消费的本金和奖励，是否不大于数据库中的对应值，大于则返回4；
		if(storage.compareTo(activeDetail.getRechargeBalance()) == 1
				|| reward.compareTo(activeDetail.getReward()) == 1) {
			return 4;
		}

		/******验证完毕******/

		// 7，表order_list插入数据
		// 消费模式
		StringBuffer consumeMode = new StringBuffer("");
		// 储值消费
		if (storage.compareTo(BigDecimal.ZERO) == 1 || reward.compareTo(BigDecimal.ZERO) == 1)  {
			consumeMode.append(CardConstants.KEY_CONSUME_MODE_STORAGE);
			consumeMode.append(",");

			// 5，表storage_sales_history插入数据。
			StorageSalesHistory storageSalesHistory = new StorageSalesHistory();
			storageSalesHistory.setOrderNo(orderNo);	// 订单号
			storageSalesHistory.setCardNo(cardNo);	// 卡号
			storageSalesHistory.setMotherCardNo(activeDetail.getMotherCardNo());	// 母卡卡号
			storageSalesHistory.setMotherType(motherType); 	// 母子卡类型
			storageSalesHistory.setCategory(activeDetail.getCategory()); 	// 卡类别
			storageSalesHistory.setReleaseStore(activeDetail.getStore());	// 发卡门店
			storageSalesHistory.setStore(storeId);		// 消费门店
			storageSalesHistory.setBill(storage);		// 消费扣除的本金
			storageSalesHistory.setReward(reward);		// 消费扣除的奖励金
			storageSalesHistory.setCompanyId(companyId);// 商家id
			storageSalesHistory.setCreateId(consume.getUserId());	// 操作人id，可以为null，pos机？

			storageSalesHistory.setRemarks(remarks);// 备注
			storageSalesHistoryDao.addStorageSalesHistory(storageSalesHistory);
		}
		// 挂账消费
		if (credit.compareTo(BigDecimal.ZERO) == 1) {
			consumeMode.append(CardConstants.KEY_CONSUME_MODE_CREDIT);
			consumeMode.append(",");

			// 6，表credit_sales_history插入数据。
			CreditSalesHistory creditSalesHistory = new CreditSalesHistory();
			creditSalesHistory.setOrderNo(orderNo);					// 订单号
			creditSalesHistory.setCardNo(cardNo);					// 卡号
			creditSalesHistory.setMotherCardNo(activeDetail.getMotherCardNo());	// 母卡卡号
			creditSalesHistory.setMotherType(motherType); 	        // 母子卡类型
			creditSalesHistory.setReleaseStore(activeDetail.getStore());	    // 发卡门店
			creditSalesHistory.setStore(storeId);					// 消费门店
			creditSalesHistory.setBill(amount);						// 订单总金额
			creditSalesHistory.setCreditBill(credit);				// 挂账金额
			creditSalesHistory.setClearBill(new BigDecimal(0));		// 已清账金额
			creditSalesHistory.setCredit(credit);					// 未清账金额
			creditSalesHistory.setStatus(CardConstants.KEY_CREDIT_SALES_STATUS_NEVER);	// 挂账状态
			creditSalesHistory.setCompanyId(companyId);
			creditSalesHistory.setCreateId(consume.getUserId());	// 操作人id，可以为null，pos机？
			creditSalesHistoryDao.addCreditSalesHistory(creditSalesHistory);
		}
		// 其他消费
		if (other.compareTo(BigDecimal.ZERO) == 1) {
			consumeMode.append(CardConstants.KEY_CONSUME_MODE_OTHERS);
			consumeMode.append(",");

			OtherSalesHistory otherSalesHistory = new OtherSalesHistory();
			otherSalesHistory.setOrderNo(orderNo);	// 订单号
			otherSalesHistory.setCardNo(cardNo);	// 卡号
			otherSalesHistory.setCategory(activeDetail.getCategory()); 	// 卡类别
			otherSalesHistory.setStore(storeId);	// 消费门店
			otherSalesHistory.setBill(other);		// 消费金额
			otherSalesHistory.setPayMode(payMode);	// 支付方式
			otherSalesHistory.setCompanyId(companyId);// 商家id
			otherSalesHistory.setCreateId(consume.getUserId());	// 操作人id，可以为null，pos机？
			otherSalesHistoryDao.addOtherSalesHistory(otherSalesHistory);
		}


		OrderList orderList = new OrderList();
		orderList.setOrderNo(orderNo);
		orderList.setStatus(CardConstants.KEY_ORDER_STATUS_SUCCESS);
		orderList.setConsumeMode(consumeMode.toString());
		orderList.setCardNo(cardNo);
		orderList.setCategory(activeDetail.getCategory());
		orderList.setTelephone(consume.getTelephone());
		orderList.setStore(storeId);
		orderList.setBill(amount);
		orderList.setCompanyId(companyId);
		orderList.setCreateId(consume.getUserId());
		orderList.setAddReward(addReward);
		orderListDao.addOrderList(orderList);

		// 8，表card_actived_information更新金额。
		ActiveInformation activeInformation = new ActiveInformation();
		activeInformation.setCardNo(kinshipMotherCardNo);	// 更新亲情卡母卡的金额（此卡号只会在有亲情卡母卡是从本卡卡号变为母卡卡号）
		activeInformation.setRechargeBalance(activeDetail.getRechargeBalance().subtract(storage));
		activeInformation.setReward(activeDetail.getReward().subtract(reward).add(addReward));
		activeInformation.setCredit(activeDetail.getCredit().add(credit));
		activeInformation.setCompanyId(companyId);
		activeInformation.setUpdateId(consume.getUpdateId());	// 可能为null, pos操作？
		activeInformationDao.save(activeInformation);

		return 0;
	}

	/**
	 * <h2>剩余挂账额度</h2>
	 * <ul>
	 * 		<li>a_0:本卡在所有门店的剩余可挂账金额 = a_1 和 a_2 取小值</li>
	 * 		<li>a_1:本卡在所有门店的剩余可挂账金额 = 本卡在所有门店的可挂账总额度 - 本卡在所有门店的已挂账金额</li>
	 * 		<li>a_2:本卡所在家族在所有门店的剩余可挂账金额  = 本卡所在家族在所有门店的可挂账总额度（母卡总额度） - 本卡所在家族在所有门店的已挂账金额</li>
	 * 		<li>b_0:本卡在本门店的剩余可挂账金额 = b_1 和 b_2 取小值</li>
	 * 		<li>b_1:本卡在本门店的剩余可挂账金额 = 本卡在本门店的可挂账总额度 - 本卡在本门店的已挂账金额</li>
	 * 		<li>b_2:本卡所在家族在本门店的剩余可挂账金额  = 本卡所在家族在本门店的可挂账总额度（母卡总额度） - 本卡所在家族在本门店的已挂账金额</li>
	 * </ul>
	 *
	 * @param cardNo
	 * @param consumStoreId
	 * @param companyId
	 * @return 结论：本卡在本门店的剩余可挂账金额 = a_0 和 b_0  取小值
	 */
	private BigDecimal surplusCreditQuota(String cardNo,Long consumStoreId, Long companyId) {

		BigDecimal surplusCreditQuota = BigDecimal.ZERO;

		// 根据卡号获取卡信息
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		activeInformationDto.setCardNo(cardNo);
		activeInformationDto.setCompanyId(companyId);
		ActiveInformation thisCard = activeInformationDao.getActiveDetail(activeInformationDto);

		// 此卡没激活
		if(thisCard == null || consumStoreId == null) {
			return BigDecimal.ZERO;
		}

		// 此卡的母卡
		String matherCardNo = thisCard.getMotherCardNo();

		// 根据卡号获取子卡信息
		List<ActiveInformation> subCards = activeInformationDao.getSubCardByMatherCardNo(cardNo, companyId);

		// 家族只有本卡
		if(StringUtils.isBlank(matherCardNo)
				&& (subCards == null || subCards.size() == 0)) {
			// 计算家族卡在本店剩余的可挂账额（只有自己的）
			surplusCreditQuota = reckonFamilyCardSurplusCreditQuotaInStore(consumStoreId,thisCard,null);
		} else {
			// 家族不止有本卡
			// 如果此卡没有母卡，即本身就是母卡
			if (StringUtils.isBlank(matherCardNo)) {
				// 计算家族卡在本店剩余的可挂账额（自己和子卡）
				surplusCreditQuota = reckonFamilyCardSurplusCreditQuotaInStore(consumStoreId,thisCard,subCards);
			} else {
				// 如果有母卡，即本身是子卡，查找母卡
				activeInformationDto.setCardNo(matherCardNo);
				ActiveInformation matherCard = activeInformationDao.getActiveDetail(activeInformationDto);
				// 母卡被注销的情况
				if (matherCard == null) {
					return BigDecimal.ZERO;
				}
				// 寻找兄弟卡（包含自己）
				List<ActiveInformation> brotherCards = activeInformationDao.getSubCardByMatherCardNo(cardNo, companyId);

				// 计算家族卡在本店剩余的可挂账额
				surplusCreditQuota = reckonFamilyCardSurplusCreditQuotaInStore(consumStoreId,matherCard,brotherCards);

				// 计算本卡在本门店剩余的可挂账额度
				BigDecimal thisCardStoreSurplusCreditQuota = reckonFamilyCardSurplusCreditQuotaInStore(consumStoreId,thisCard, null);

				// 家族卡在本店剩余的可挂账额 和 本卡在本店剩余的可挂账额
				surplusCreditQuota = getSmallerBigDecimal(surplusCreditQuota, thisCardStoreSurplusCreditQuota);
			}
		}

		return surplusCreditQuota;
	}

	/**
	 * 计算家族卡在本门店的剩余挂账金额
	 * @param consumStoreId
	 * @param matherCard
	 * @param subCards
	 * @return
	 */
	private BigDecimal reckonFamilyCardSurplusCreditQuotaInStore ( Long consumStoreId,
			ActiveInformation matherCard, List<ActiveInformation> subCards) {

		if (matherCard == null) {
			return BigDecimal.ZERO;
		}

		String matherCardNo = matherCard.getCardNo();
		Long matherCompanyId = matherCard.getCompanyId();

		// 母卡设定的最高挂账额度
		BigDecimal matherCardTotalCreditMaxQuota = BigDecimal.ZERO;
		matherCardTotalCreditMaxQuota = new BigDecimal(matherCard.getCreditMaxQuota());

		// 母卡在本店设定的可挂账额度
		BigDecimal matherCardStoreCreditMaxQuota = BigDecimal.ZERO;
		matherCardStoreCreditMaxQuota = creditSettingDao.getCreditSettingByCardNoAndStoreId(matherCardNo, consumStoreId, matherCompanyId);
		matherCardStoreCreditMaxQuota = matherCardStoreCreditMaxQuota != null ? matherCardStoreCreditMaxQuota : BigDecimal.ZERO;

		// 获取母卡在本店的挂账总额
		BigDecimal matherCardStoreCredit = BigDecimal.ZERO;
		matherCardStoreCredit = creditSalesHistoryDao.getCreditSalesByCardNoAndStoreId(matherCardNo, consumStoreId, matherCompanyId);
		matherCardStoreCredit = matherCardStoreCredit != null ? matherCardStoreCredit : BigDecimal.ZERO;

		// 母卡和兄弟卡一共已经挂账的金额（家族卡共享并check）
		BigDecimal totalCredit = BigDecimal.ZERO;
		totalCredit = totalCredit.add(matherCard.getCredit());	// 母卡全部的挂账额
		// 母卡和兄弟卡在本店一共已经挂账的金额（家族卡共享并check）
		BigDecimal storeTotalCredit = BigDecimal.ZERO;
		storeTotalCredit = storeTotalCredit.add(matherCardStoreCredit);

		// 有子卡的情况
		if (subCards != null && !subCards.isEmpty()) {
			// 子卡挂账总额
			for(ActiveInformation subCard : subCards) {
				// 子卡所有的挂账总额
				totalCredit = totalCredit.add(subCard.getCredit());

				// 获取子卡在本店的挂账总额
				BigDecimal subCredit= creditSalesHistoryDao.getCreditSalesByCardNoAndStoreId(subCard.getCardNo(), consumStoreId, subCard.getCompanyId());
				subCredit = subCredit != null ? subCredit : BigDecimal.ZERO;
				storeTotalCredit = storeTotalCredit.add(subCredit) ;
			}
		}


		// 家族卡总的剩余挂账金额
		BigDecimal familyTotalSurplusCreditQuota = matherCardTotalCreditMaxQuota.subtract(totalCredit);

		// 家族卡在本门店剩余挂账金额
		BigDecimal familyStoreSurplusCreditQuota = matherCardStoreCreditMaxQuota.subtract(storeTotalCredit);

		// 总剩余额度 和 本门店剩余额度 取小值
		BigDecimal familyCardSurplusCreditQuota = getSmallerBigDecimal(familyTotalSurplusCreditQuota, familyStoreSurplusCreditQuota);

		return familyCardSurplusCreditQuota.compareTo(BigDecimal.ZERO) == -1 ? BigDecimal.ZERO : familyCardSurplusCreditQuota;
	}

	/**
	 * 判断两个日期是否是同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	private boolean isSameDay(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}

		Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);

        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);

        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                        .get(Calendar.DAY_OF_MONTH);
		return isSameDate;
	}

	/**
	 * 获取较小值
	 * @return
	 */
	private BigDecimal getSmallerBigDecimal(BigDecimal b1, BigDecimal b2) {
		if (b1 == null || b2 == null) {
			return null;
		}

		if (b1.compareTo(b2) == -1) {
			return b1;
		}else {
			return b2;
		}
	}

	/**
	 * 根据Key，返回相应的Value （卡状态）
	 * @param key
	 * @return
	 */
	private String getCardStatusValue(Integer key) {
		if(key == null) {
			return "";
		}

		switch (key) {
			case CardConstants.KEY_CARD_STATE_MAKE:
				return CardConstants.VALUE_CARD_STATE_MAKE;
			case CardConstants.KEY_CARD_STATE_WRITE_FAIL:
				return CardConstants.VALUE_CARD_STATE_WRITE_FAIL;
			case CardConstants.KEY_CARD_STATE_RETURN:
				return CardConstants.VALUE_CARD_STATE_RETURN;
			case CardConstants.KEY_CARD_STATE_HQ_IN:
				return CardConstants.VALUE_CARD_STATE_HQ_IN;
			case CardConstants.KEY_CARD_STATE_SCRAP:
				return CardConstants.VALUE_CARD_STATE_SCRAP;
			case CardConstants.KEY_CARD_STATE_HQ_OUT:
				return CardConstants.VALUE_CARD_STATE_HQ_OUT;
			case CardConstants.KEY_CARD_STATE_STORE_IN:
				return CardConstants.VALUE_CARD_STATE_STORE_IN;
			case CardConstants.KEY_CARD_STATE_STORE_OUT:
				return CardConstants.VALUE_CARD_STATE_STORE_OUT;
			case CardConstants.KEY_CARD_STATE_ACTIVATED:
				return CardConstants.VALUE_CARD_STATE_ACTIVATED;
			case CardConstants.KEY_CARD_STATE_LOST:
				return CardConstants.VALUE_CARD_STATE_LOST;
			default:
				return "";
			}
	}


}
