package com.itcrazy.alanmall.mscard.util;


import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.constains.TableConstants;

public class KeyValueConvert {

	/**
	 * 根据Key，返回相应的Value （是/否）
	 * @param key
	 * @return
	 */
	public static String getYesNoValue(Integer key) {
		if(key == TableConstants.KEY_YES) {
			return TableConstants.VALUE_YES;
		} else if(key == TableConstants.KEY_NO) {
			return TableConstants.VALUE_NO;
		} else {
			return "";
		}
	}

	/**
	 * 根据Key，返回相应的Value （启用/停用）
	 * @param key
	 * @return
	 */
	public static String getStatusValue(Integer key) {
		if(key == TableConstants.KEY_ENABLE) {
			return TableConstants.VALUE_ENABLE;
		} else if(key == TableConstants.KEY_DISABLE) {
			return TableConstants.VALUE_DISABLE;
		} else {
			return "";
		}
	}


	/**
	 * 根据Key，返回相应的Value （是/否）
	 * @param key
	 * @return
	 */
	public static String getCardYesNoValue(Integer key) {
		if(key == CardConstants.KEY_YES) {
			return CardConstants.VALUE_YES;
		} else if(key == CardConstants.KEY_NO) {
			return CardConstants.VALUE_NO;
		} else {
			return "";
		}
	}

	/**
	 * 根据Key，返回相应的Value （卡状态）
	 * @param key
	 * @return
	 */
	public static String getCardStatusValue(Integer key) {
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

	/**
	 * 根据Key，返回相应的Value （性别）
	 * @param key
	 * @return
	 */
	public static String getCardSexValue(Integer key) {
		if (key == null) {
			return "";
		}
		switch (key) {
			case CardConstants.KEY_CARD_SEX_MAN:
				return CardConstants.VALUE_CARD_SEX_MAN;
			case CardConstants.KEY_CARD_SEX_WOMAN:
				return CardConstants.VALUE_CARD_SEX_WOMAN;
			default:
				return "";
			}
	}


	/**
	 * 根据Key，返回相应的Value （卡调拨状态）
	 * @param key
	 * @return
	 */
	public static String getStoreTransferStatusValue(Integer key) {
		switch (key) {
			case CardConstants.KEY_STORE_TRANSFER_STATU_OUR_IN:
				return CardConstants.VALUE_STORE_TRANSFER_STATU_OUR_IN;
			case CardConstants.KEY_STORE_TRANSFER_STATU_OUR_NOT_IN:
				return CardConstants.VALUE_STORE_TRANSFER_STATU_OUR_NOT_IN;
			case CardConstants.KEY_STORE_TRANSFER_STATU_OTHER_IN:
				return CardConstants.VALUE_STORE_TRANSFER_STATU_OTHER_IN;
			case CardConstants.KEY_STORE_TRANSFER_STATU_OTHER_NOT_IN:
				return CardConstants.VALUE_STORE_TRANSFER_STATU_OTHER_NOT_IN;
			default:
				return "";
			}
	}

	/**
	 * 根据Key，返回相应的Value （调拨状态）
	 * @param key
	 * @return
	 */
	public static String getStoreTransferValue(Integer key) {
		switch (key) {
			case CardConstants.KEY_STORE_TRANSFER_IN:
				return CardConstants.VALUE_STORE_TRANSFER_IN;
			case CardConstants.KEY_STORE_TRANSFER_OUT:
				return CardConstants.VALUE_STORE_TRANSFER_OUT;
			default:
				return "";
			}
	}


	/**
	 * 根据Key，返回相应的Value （卡挂账状态）
	 * @param key
	 * @return
	 */
	public static String getCreditStatusValue(Integer key) {
		switch (key) {
			case CardConstants.KEY_CREDIT_STATUS_ENABLE:
				return CardConstants.VALUE_CREDIT_STATUS_ENABLE;
			case CardConstants.KEY_CREDIT_STATUS_DISABLE:
				return CardConstants.VALUE_CREDIT_STATUS_DISABLE;
			default:
				return "";
			}
	}


	/**
	 * 根据Key，返回相应的Value （卡清账状态）
	 * @param key
	 * @return
	 */
	public static String getCreditSalesStatusValue(Integer key) {
		switch (key) {
			case CardConstants.KEY_CREDIT_SALES_STATUS_ALL:
				return CardConstants.VALUE_CREDIT_SALES_STATUS_ALL;
			case CardConstants.KEY_CREDIT_SALES_STATUS_PART:
				return CardConstants.VALUE_CREDIT_SALES_STATUS_PART;
			case CardConstants.KEY_CREDIT_SALES_STATUS_NEVER:
				return CardConstants.VALUE_CREDIT_SALES_STATUS_NEVER;
			default:
				return "";
			}
	}


}
