package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseCardActivedDto;
import com.itcrazy.alanmall.mscard.manager.StoreWareCardActivedManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.StoreWarehouseCardActivedVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 门店卡激活
 * @author huangchunbo
 * 2018-09-15
 */
public class StoreWarehouseCardActivedAction extends InterfaceBaseAction{
	private static final long serialVersionUID = 8584427876329938175L;

	private StoreWarehouseCardActivedDto storeWarehouseCardActivedDto;

	private String[] storeWarehouseCardActivedDtoArr;

	@Reference
	UserManager userManager;

	@Reference
	StoreWareCardActivedManager storeWareCardActivedManager;

	/**
	 * 获取门店卡激活列表数据
	 * @param storeWarehouseCardActivedDto
	 * @return
	 */
	private List<StoreWarehouseCardActivedVo> getPage(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto) {

        List<CardInformation> ciList = storeWareCardActivedManager.getPageList(storeWarehouseCardActivedDto);
		List<StoreWarehouseCardActivedVo> shVo = new ArrayList<StoreWarehouseCardActivedVo>();
 		if (ciList != null && ciList.size() > 0) {
			for(CardInformation c:ciList) {
				StoreWarehouseCardActivedVo sVo  = new  StoreWarehouseCardActivedVo();
				sVo.setReceiptNo(c.getReceiptNo());
				sVo.setCardNo(c.getCardNo());
				sVo.setName(c.getName());
				sVo.setIsNamed(c.getIsNamed());
				sVo.setIsNamedName(KeyValueConvert.getCardYesNoValue(c.getIsNamed()));
				sVo.setIsPswMust(c.getIsPswMust());
				sVo.setIsPswMustName(KeyValueConvert.getCardYesNoValue(c.getIsPswMust()));
				sVo.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				sVo.setStoreInTime(DateFormat.dateToString(c.getStoreInTime()));
				User storeInPerson = userManager.getUserById(c.getStoreInPerson());
				sVo.setStoreInPerson(storeInPerson!=null ? storeInPerson.getRealName() : "");
				sVo.setCategory(c.getCategory());

				shVo.add(sVo);

			}
		}
		return shVo;
	}

	// 页面显示
	public String getStoreWarehouseCardActivedList() {
		if(storeWarehouseCardActivedDto == null){
			result.setSuccessInfo();
			return SUCCESS;
		}
		pageSet(storeWarehouseCardActivedDto);
		storeWarehouseCardActivedDto.setCompanyId(user.getCompanyId());
		storeWarehouseCardActivedDto.setStoreTo(user.getStoreId());



 		pageData.rows = getPage(storeWarehouseCardActivedDto);
		Integer t = storeWareCardActivedManager.getPageTotal(storeWarehouseCardActivedDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;

	}

	/**
	 * 页面导出数据
	 */
	public void getStoreWarehouseCardActivedListEexport() {
		if (storeWarehouseCardActivedDto == null) {
			storeWarehouseCardActivedDto = new StoreWarehouseCardActivedDto();
		}


		storeWarehouseCardActivedDto.setCompanyId(user.getCompanyId());
		storeWarehouseCardActivedDto.setStoreTo(user.getStoreId());
		storeWarehouseCardActivedDto.setStart(0);
		storeWarehouseCardActivedDto.setLimit(Integer.MAX_VALUE);

		List<StoreWarehouseCardActivedVo> swcVoList = getPage(storeWarehouseCardActivedDto);

		String fileName = "门店卡激活" + DateFormat.dateToString(new Date()) + ".csv";

		 LinkedHashMap<String,String> swcMaps = new LinkedHashMap<>();
		 swcMaps.put("门店入库单号", "receiptNo");
		 swcMaps.put("卡号", "cardNo");
		 swcMaps.put("卡类别", "name");
		 swcMaps.put("是否记名卡", "isNamedName");
		 swcMaps.put("卡支付密码是否必填", "isPswMustName");
		 swcMaps.put("卡状态", "status");
		 swcMaps.put("门店入库时间", "storeInTime");
		 swcMaps.put("入库操作人", "storeInPerson");
		 try {
				String content =  CSVUtils.formatCsvData(swcVoList, swcMaps);
				CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	/**
	 * 不记名卡批量激活
	 * @return
	 */
	public String updateStoreWarehouseCardActived() {
		if (storeWarehouseCardActivedDtoArr  == null && storeWarehouseCardActivedDtoArr.length == 0) {
			result.setSuccessInfo();
			return SUCCESS;
		}
		List<StoreWarehouseCardActivedDto>  StoreWarehouseCardActivedDtoList = new ArrayList<>();
		for (String storeWarehouseCardActivedStr : storeWarehouseCardActivedDtoArr) {
			StoreWarehouseCardActivedDto sDto = new StoreWarehouseCardActivedDto();
			String[] strArr = storeWarehouseCardActivedStr.split(":");
			sDto.setCardNo(strArr[0]);
			sDto.setReceiptNo(strArr[1]);
			StoreWarehouseCardActivedDtoList.add(sDto);
		}
		StoreWarehouseIn storeWarehouseIn = new StoreWarehouseIn();
		//storeWarehouseIn.setStoreFrom(0L);
		storeWarehouseIn.setStoreTo(user.getStoreId());
		storeWarehouseIn.setCreateId(user.getId());
		storeWarehouseIn.setUpdateId(user.getId());
		storeWarehouseIn.setPublishId(user.getId());
		storeWarehouseIn.setIsDeleted(0);
		storeWarehouseIn.setCompanyId(user.getCompanyId());

		try {
			// 操作card数据
			storeWareCardActivedManager.OperaHeadWarehouseOut(StoreWarehouseCardActivedDtoList,storeWarehouseIn);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(1, "批量激活失败");
			return SUCCESS;
		}


		result.setSuccessInfo();
		return SUCCESS;

	}

	public StoreWarehouseCardActivedDto getStoreWarehouseCardActivedDto() {
		return storeWarehouseCardActivedDto;
	}

	public void setStoreWarehouseCardActivedDto(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto) {
		this.storeWarehouseCardActivedDto = storeWarehouseCardActivedDto;
	}

	public String[] getStoreWarehouseCardActivedDtoArr() {
		return storeWarehouseCardActivedDtoArr;
	}

	public void setStoreWarehouseCardActivedDtoArr(String[] storeWarehouseCardActivedDtoArr) {
		this.storeWarehouseCardActivedDtoArr = storeWarehouseCardActivedDtoArr;
	}

}
