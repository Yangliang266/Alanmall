package com.itcrazy.alanmall.common.framework.dto;

import lombok.Data;

@Data
public abstract class CardBaseRequestDto extends CardBaseDto {

	public abstract void requestCheck();

	@Override
	public String toString() {
		return "AbstractRequest{}";
	}

}
