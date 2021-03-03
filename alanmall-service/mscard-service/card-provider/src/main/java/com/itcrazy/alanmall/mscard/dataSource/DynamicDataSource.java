package com.itcrazy.alanmall.mscard.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 配置动态数据源
 * @author chenfei
 * 2018-10-08
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<DataSources> contextHolder = new ThreadLocal<DataSources>();

    /**
     * 设置当前线程使用的数据源,使用方法如下（使用完成后，需要手动设置回原始数据源）
     * @param customerType
     */
    public static void setCustomerType(DataSources customerType) {
        contextHolder.set(customerType);
    }

    public static DataSources getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }

	@Override
	protected Object determineCurrentLookupKey() {
		return getCustomerType();
	}
}
