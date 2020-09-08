package com.itcrazy.alanmall.common.vo;

import java.util.ArrayList;
import java.util.List;

public class PageData {

	private int total = 0; // 分页总数
	@SuppressWarnings("rawtypes")
	public List rows = new ArrayList();// 数据列表

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	public void setRows(@SuppressWarnings("rawtypes") List rows) {
		this.rows = rows;
	}

	@SuppressWarnings("unchecked")
	public void addRow(Object obj) {
		rows.add(obj);
	}

}
