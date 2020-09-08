package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.manager.CardManager;
import com.itcrazy.alanmall.mscard.manager.StoreWarehouseOutManager;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.StoreWarehouseOutVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 门店出库设置
 *
 * @author yinxiang 2018-09-11
 */
public class StoreWarehousePrepareOutAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;

	@Reference
	private StoreWarehouseOutManager storeWarehouseOutManager;
	@Reference
	UserManager userManager;
	@Reference
	private CardManager cardManager;

	private String[] storeWarehouseOutDtoArr;
	private StoreWarehouseOut storeWarehouseOut;
	private StoreWarehouseOutDto storeWarehouseOutDto;
	private String reason;
	private long sel_ids;
    private String choosedStoreId;

    /**
	 *  获取历史记录列表数据
	 */
    private List<StoreWarehouseOutVo> getPage(StoreWarehouseOutDto storeWarehouseOutDto){

    	List<StoreWarehouseOut> swiList = storeWarehouseOutManager.getPageList(storeWarehouseOutDto);

		List<StoreWarehouseOutVo> swivList = new ArrayList<StoreWarehouseOutVo>();

		if (swiList != null && swiList.size() > 0) {

			for (StoreWarehouseOut s : swiList) {
				StoreWarehouseOutVo sv = new StoreWarehouseOutVo();

				sv.setStoreInReceiptNo(s.getStoreInReceiptNo());
				sv.setCardNo(s.getCardNo());
				sv.setCategoryName(s.getCategoryName());
				sv.setStatus(KeyValueConvert.getCardStatusValue(s.getStatus()));
				sv.setStoreInTime(DateFormat.dateToString(s.getStoreInTime()));
				User storeInPerson = userManager.getUserById(s.getStoreInPerson());
				sv.setStoreInPerson(storeInPerson != null ? storeInPerson.getRealName() : "");

				swivList.add(sv);
			}
		}

		return swivList;

	}

    // 历史记录页面显示
	public String getStoreWarehousePrepareOutList() {

		if (storeWarehouseOutDto == null) {
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		pageSet(storeWarehouseOutDto);
		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStoreId(user.getStoreId());

		pageData.rows = getPage(storeWarehouseOutDto);
		Integer t = storeWarehouseOutManager.getPageTotal(storeWarehouseOutDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 导出历史记录数据
	 */
	public void getStoreWarehousePrepareOutListEexport(){
		if(storeWarehouseOutDto == null){
			storeWarehouseOutDto = new StoreWarehouseOutDto();
		}

		storeWarehouseOutDto.setCompanyId(user.getCompanyId());
		storeWarehouseOutDto.setStart(0);
		storeWarehouseOutDto.setLimit(Integer.MAX_VALUE);
		storeWarehouseOutDto.setStoreId(user.getStoreId());


		List<StoreWarehouseOutVo> swivList= getPage(storeWarehouseOutDto);

	    String fileName = "门店调拨（调拨出库）" + DateFormat.dateToString(new Date()) + ".csv";

	    //csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("门店入库时间", "storeInTime");
	    headerMaps.put("入库操作人", "storeOutTime");
	    headerMaps.put("出库操作人", "storeInPerson");

		try {
			String content =  CSVUtils.formatCsvData(swivList, headerMaps);
			CSVUtils.exportCsv(fileName, content,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	   // 门店出库状态
		public String updateStoreWarehousePrepareOut() {
			if (storeWarehouseOutDtoArr == null && storeWarehouseOutDtoArr.length == 0) {
				result.setSuccessInfo();
				return SUCCESS;
			}

			List<StoreWarehouseOutDto> storeWarehouseOutDtoList = new ArrayList<>();

			for (String storeWarehouseOutDtoStr : storeWarehouseOutDtoArr) {
				StoreWarehouseOutDto sDto = new StoreWarehouseOutDto();
				sDto.setCardNo(storeWarehouseOutDtoStr);

				storeWarehouseOutDtoList.add(sDto);
			}

			StoreWarehouseOut storeWarehouseOut = new StoreWarehouseOut();

			storeWarehouseOut.setStoreFrom(user.getStoreId());
			storeWarehouseOut.setStoreTo(sel_ids);
			storeWarehouseOut.setCreateId(user.getId());
			storeWarehouseOut.setUpdateId(user.getId());
			storeWarehouseOut.setReason(reason);
			storeWarehouseOut.setCompanyId(user.getCompanyId());


		//  操作数据
			try {
				// 出库成功后的单号
				String storeOutReceiptNo = storeWarehouseOutManager.OperaStoreWarehouseOut(storeWarehouseOutDtoList, storeWarehouseOut);
				result.setResultInfo(0, storeOutReceiptNo);
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultInfo(-1, "出库失败");
				return SUCCESS;
			}
		}

	public StoreWarehouseOut getStoreWarehouseOut() {
		return storeWarehouseOut;
	}

	public void setStoreWarehouseOut(StoreWarehouseOut storeWarehouseOut) {
		this.storeWarehouseOut = storeWarehouseOut;
	}

	public StoreWarehouseOutDto getStoreWarehouseOutDto() {
		return storeWarehouseOutDto;
	}

	public String[] getStoreWarehouseOutDtoArr() {
		return storeWarehouseOutDtoArr;
	}

	public void setStoreWarehouseOutDtoArr(String[] storeWarehouseOutDtoArr) {
		this.storeWarehouseOutDtoArr = storeWarehouseOutDtoArr;
	}

	public void setStoreWarehouseOutDto(StoreWarehouseOutDto storeWarehouseOutDto) {
		this.storeWarehouseOutDto = storeWarehouseOutDto;
	}



	public String getChoosedStoreId() {
		return choosedStoreId;
	}

	public void setChoosedStoreId(String choosedStoreId) {
		this.choosedStoreId = choosedStoreId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getSel_ids() {
		return sel_ids;
	}

	public void setSel_ids(long sel_ids) {
		this.sel_ids = sel_ids;
	}



}
