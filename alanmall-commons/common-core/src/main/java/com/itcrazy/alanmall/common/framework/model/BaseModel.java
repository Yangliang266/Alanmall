package com.itcrazy.alanmall.common.framework.model;

import java.io.Serializable;

public interface BaseModel extends Serializable {

	public abstract String toString();

	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public Long getId();

	public Long getUpdateId();

}
