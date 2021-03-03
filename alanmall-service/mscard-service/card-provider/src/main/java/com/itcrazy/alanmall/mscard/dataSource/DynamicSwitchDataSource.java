package com.itcrazy.alanmall.mscard.dataSource;

import java.lang.annotation.*;

/**
 * 切换数据源的注解
 * @author chenfei
 * 2018-10-09
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDataSource {

	DataSources dataSource() default DataSources.CARD;
}
