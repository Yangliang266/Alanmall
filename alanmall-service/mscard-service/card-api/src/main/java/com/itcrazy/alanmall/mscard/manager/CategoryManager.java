package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CategoryDto;
import com.itcrazy.alanmall.mscard.model.Category;
import com.itcrazy.alanmall.mscard.model.Discount;

import java.sql.SQLException;
import java.util.List;

/**
 * 卡类别接口
 * @author chenfei
 * 2018-09-03
 */
public interface CategoryManager {

	public List<Category> getPageList(CategoryDto categoryDto);

	public Integer getPageTotal(CategoryDto categoryDto);

	public Category getCategoryById(Long id, Long companyId);

	/**
	 * 新增卡类别
	 * @param category
	 * @param discountList
	 * @throws SQLException
	 */
	public int addCategory(Category category, List<Discount> discountList) throws Exception;

	/**
	 * 编辑卡类别
	 * @param category
	 * @throws SQLException
	 */
	public int updateCategory(Category category, List<Discount> discountList) throws Exception;

	/**
	 * 修改卡类别状态
	 * @param category
	 * @throws SQLException
	 */
	public int updateCategoryStatus(Category category) throws Exception;

	/**
	 * 删除卡类别（仅限从未启用）
	 * @param category
	 * @return
	 */
	public int deleteCategory(Category category) throws Exception;

}
