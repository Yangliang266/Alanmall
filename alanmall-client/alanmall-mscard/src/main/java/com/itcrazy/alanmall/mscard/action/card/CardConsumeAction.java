package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.OrderListDto;
import com.itcrazy.alanmall.mscard.manager.OrderListManager;
import com.itcrazy.alanmall.mscard.model.OrderList;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.PDFUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 订单消费表
 *
 * @author zhangzhongtian
 *
 */
public class CardConsumeAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 4221146948555325083L;

	private OrderListDto orderListDto;
	private OrderList detailVo;

	@Reference
	OrderListManager orderListManager;

	/**
	 * //查询订单消费详情
	 * @return
	 */
	public String getCardConsumeDetail(){

		if(orderListDto == null){
			orderListDto = new OrderListDto();
		}

		orderListDto.setCompanyId(user.getCompanyId());

		// 根据查询条件获取订单消费详情
		detailVo = orderListManager.getOrderList(orderListDto);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 打印预览（可下载，可保存）
	 */
	public void getCardConsumePreparePDFPreview(){

		List<OrderList> orderList = new ArrayList<>();
		orderList.add(detailVo);

		 String fileName = "订单结账详情";

		try {
			List<List<String>> tableData = PDFUtil.formatPDFData(orderList, getOrderHeader());
			// 每列宽度
			float[] columnsWidth = {30f, 30f};
			PDFUtil.portraitPreview(fileName, tableData,columnsWidth, getRequest(), getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 订单结账详情头部
	 * @return
	 */
	private LinkedHashMap<String,String> getOrderHeader() {
		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("ERP/POS订单结算时间", "balanceTime");
	    headerMaps.put("结算操作人", "operator");
	    headerMaps.put("ERP/POS订单编号", "orderNo");
	    headerMaps.put("本订单扣款总金额", "bill");
	    headerMaps.put("本金消费", "storageBill");
	    headerMaps.put("奖励消费", "storageReward");
	    headerMaps.put("挂账消费", "creditBill");
	    headerMaps.put("其他支付方式", "payModeName");
	    headerMaps.put("其他支付方式消费", "payModeBill");
	    return headerMaps;
	}

	public OrderListDto getOrderListDto() {
		return orderListDto;
	}

	public void setOrderListDto(OrderListDto orderListDto) {
		this.orderListDto = orderListDto;
	}

	public OrderList getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(OrderList detailVo) {
		this.detailVo = detailVo;
	}

}
