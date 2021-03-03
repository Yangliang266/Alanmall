package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

import java.util.Date;

@Data
public class CardInformationResDto extends CardBaseResponseDto {
	// 卡号
	private String cardNo;

	// 开始时间
	private Date beginTime;

	//结束时间
	private Date endTime;

	// 卡类别
	private int category;

	// 制卡人
//	private String createId; 2020

	//卡类别名称
	private String name;

	// 卡状态
	private String status;

	// 制卡批次号
	private String serialNo;

	// 卡类别编号
	private int id;

	// 跳号数字
	private int jumpNumber;

	// 商家ID
	private Long companyId;

    // 删除标记
//	private String isDeleted; 2020

	// 制卡数量
	private String amount;

	// 卡号前缀
	private String prefix;

	// 自然增长段长度
	private int length;

	// 所属门店
	private Long store;

}
