package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CategoryDto;
import com.itcrazy.alanmall.mscard.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 卡类别DAO层接口
 * @author chenfei
 * 2018-09-03
 */
@Component
public interface CategoryDao extends BaseDao<Category, Long> {

	public List<Category> getPageList(CategoryDto categoryDto);

	public Integer getPageTotal(CategoryDto categoryDto);

	public Category getCategoryById(@Param("id") Long id, @Param("companyId") Long companyId);

	public Long addCategory(Category category);

	public Long updateCategory(Category category);

	public int updateCategoryStatus(Category category);

	public int deleteCategory(Category category);

}
