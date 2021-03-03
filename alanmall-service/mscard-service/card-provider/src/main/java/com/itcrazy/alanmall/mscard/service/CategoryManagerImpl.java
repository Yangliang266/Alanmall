package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardInformationDao;
import com.itcrazy.alanmall.mscard.dao.CategoryDao;
import com.itcrazy.alanmall.mscard.dao.DiscountDao;
import com.itcrazy.alanmall.mscard.dto.Base.CategoryDto;
import com.itcrazy.alanmall.mscard.manager.CategoryManager;
import com.itcrazy.alanmall.mscard.model.Category;
import com.itcrazy.alanmall.mscard.model.Discount;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 卡类别接口实现
 * @author chenfei
 * 2018-09-03
 */
@Slf4j
@Service
public class CategoryManagerImpl implements CategoryManager{

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private DiscountDao discountDao;
	@Autowired
	private CardInformationDao cardInformationDao;

	@Override
	public List<Category> getPageList(CategoryDto categoryDto) {
		List<Category> pageList = categoryDao.getPageList(categoryDto);
		if(pageList == null ) return null;
		for(Category category: pageList) {
			category.setDiscountList(getDiscountByCategroy(category));
		}
		return pageList;
	}

	@Override
	public Integer getPageTotal(CategoryDto categoryDto) {
		return categoryDao.getPageTotal(categoryDto);
	}

	@Override
	public Category getCategoryById(Long id, Long companyId) {
		Category category = categoryDao.getCategoryById(id, companyId);
		category.setDiscountList(getDiscountByCategroy(category));
		return category;
	}

	@Override
	public int addCategory(Category category, List<Discount> discountList) throws Exception{
		// 新增卡类别
		categoryDao.addCategory(category);

		updateDiscountList(discountList, category.getId(), category.getCompanyId());
		// 更新消费折扣率表
		if(discountList != null && !discountList.isEmpty()) {
			// 删除折扣表中，原有此卡类别的折扣信息
			discountDao.deleteDiscountByCategoryId(category.getId(), category.getCompanyId());
			for(Discount discount : discountList) {
				discount.setCardCategotyId(category.getId());
				discountDao.addDiscount(discount);
			}
		}
		return 1;

	}

	@Override
	public int updateCategory(Category category, List<Discount> discountList) throws Exception{
		// 新增卡类别
		categoryDao.updateCategory(category);
		updateDiscountList(discountList, category.getId(), category.getCompanyId());
		return 0;
	}

	@Override
	public int updateCategoryStatus(Category category) throws Exception{
		return categoryDao.updateCategoryStatus(category);
	}

	@Override
	public int deleteCategory(Category category) throws Exception{
		// 判断此类别卡是否被使用
		Long count = cardInformationDao.selectCardCountByCategoryId(category.getId(), category.getCompanyId());

		// 当此卡类别没有被使用，就将其删除
		if(count == null || count == 0) {
			int deleteCount = categoryDao.deleteCategory(category);
			return  deleteCount;
		}
		return -1;
	}

	/**
	 * 根据卡类别 查询折扣率
	 * @param category
	 * @return
	 */
	private List<Discount> getDiscountByCategroy(Category category) {
		Discount discount = new Discount();
		discount.setCompanyId(category.getCompanyId());
		discount.setCardCategotyId(category.getId());
		List<Discount> discountList = discountDao.getDiscountList(discount);
		return discountList;
	}

	/**
	 * 更新折扣表
	 * @param discountList
	 * @param categoryId
	 * @param CompanuId
	 * @return
	 */
	private int updateDiscountList(List<Discount> discountList,Long categoryId, Long CompanuId) {
		// 更新消费折扣率表
		if(discountList != null && !discountList.isEmpty()) {
			// 删除折扣表中，原有此卡类别的折扣信息
			discountDao.deleteDiscountByCategoryId(categoryId,  CompanuId);
			for(Discount discount : discountList) {
				discount.setCardCategotyId(categoryId);
				discountDao.addDiscount(discount);
			}
		}
		return 0;
	}

}
