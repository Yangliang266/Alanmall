package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.CardInforManager;
import com.itcrazy.alanmall.mscard.manager.ParameterManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.Parameter;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.common.vo.Result;
import com.itcrazy.alanmall.mscard.vo.card.CardInformationVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 制卡管理
 *
 * @author huangchunbo
 * 2018-09-05
 */
public class CardInforAction extends InterfaceBaseAction {
    private static final long serialVersionUID = -7778065294045735854L;

    private CardInformationDto cardInformationDto;

    private CardInformation cardInformation;
    private CardInformation detailVo;
    private Long userVo;

    private String[] jumpNumber;
    private Integer amount;
    private String bin;

    @Reference
    UserManager userManager;

    @Reference
    CardInforManager cardInforManager;

    @Reference
    ParameterManager parameterManager;

    /**
     * 获取列表数据
     */
    private List<CardInformationVo> getPage(CardInformationDto cardInformationDto) {

        List<CardInformation> cardInforList = cardInforManager.getPageList(cardInformationDto);
        List<CardInformationVo> cardInforVoList = new ArrayList<CardInformationVo>();

        if (cardInforList != null && cardInforList.size() > 0) {
            for (CardInformation c : cardInforList) {
                CardInformationVo civ = new CardInformationVo();
                civ.setSerialNo(c.getSerialNo());
                civ.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
                civ.setName(c.getName());
                User createCardUser = userManager.getUserById(c.getCreateId());
                if (createCardUser != null) {
                    civ.setCreateName(createCardUser.getRealName());
                }

                cardInforVoList.add(civ);
            }
        }
        return cardInforVoList;
    }

    // 页面显示
    public String getCardInforList() {

        if (cardInformationDto == null) {
            cardInformationDto = new CardInformationDto();
        }

        pageSet(cardInformationDto);
        cardInformationDto.setCompanyId(user.getCompanyId());

        pageData.rows = getPage(cardInformationDto);
        Integer t = cardInforManager.getPageTotal(cardInformationDto);
        pageData.setTotal(t);
        result.setSuccessInfo();
        return SUCCESS;

    }

    /**
     * 导出制卡管理-首页数据
     */
    public void getCardInforListEexport() {
        if (cardInformationDto == null) {
            cardInformationDto = new CardInformationDto();
        }

        cardInformationDto.setCompanyId(user.getCompanyId());
        cardInformationDto.setStart(0);
        cardInformationDto.setLimit(Integer.MAX_VALUE);

        List<CardInformationVo> cardInforVoList = getPage(cardInformationDto);

        String fileName = "制卡管理" + DateFormat.dateToString(new Date()) + ".csv";

        LinkedHashMap<String, String> cardInforMaps = new LinkedHashMap<>();
        cardInforMaps.put("制卡批次号", "serialNo");
        cardInforMaps.put("创建时间", "createTime");
        cardInforMaps.put("卡类别", "name");
        cardInforMaps.put("创建人", "createName");
        try {
            String content = CSVUtils.formatCsvData(cardInforVoList, cardInforMaps);
            CSVUtils.exportCsv(fileName, content, getRequest(), getResponse());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建卡号
     *
     * @return
     */
    public String updateCardInfor() {

        if (cardInformation == null) {
            result.setParamErrorInfo("cardInformation");
            return SUCCESS;
        }
        if (cardInformation.getCategory() == null) {
            result.setParamErrorInfo("category");
            return SUCCESS;
        }
        if (amount == null || amount == 0) {
            result.setParamErrorInfo("amount");
            return SUCCESS;
        }

        // 获取卡号规则
        CardBaseDto baseDto = new CardBaseDto();
        baseDto.setIsDeleted(0);
        baseDto.setCompanyId(user.getCompanyId());
        Parameter paramDetail = parameterManager.getParamDetail(baseDto);

        if (paramDetail == null) {
            result.setResultInfo(1, "请先设置卡系统参数。");
            return SUCCESS;
        }

        if (paramDetail.getLength() < String.valueOf(amount).length()) {
            result.setResultInfo(1, "制卡数量大于卡号位数长度,请重新输入。");
            return SUCCESS;
        }

        if (StringUtils.isNotBlank(bin)) {
            bin = bin.trim();
            // 如果bin长度大于数据库中卡号自增的长度
            if (paramDetail.getLength() < bin.length()
                    || !StringUtils.isNumeric(bin)) {
                result.setResultInfo(1, "BIN码长度大于卡号自然增长长度，请重新输入。");
                return SUCCESS;
            }
        }
        cardInformation.setCreateId(user.getId());
        cardInformation.setCompanyId(user.getCompanyId());
        try {
            Result operaCardInformationResult = cardInforManager.OperaCardInformation(paramDetail, cardInformation, jumpNumber, amount, bin);
            if (operaCardInformationResult.getCode() == 0) {
                result.setResultInfo(0, "新建卡号成果。");
            } else {
                result.setResultInfo(operaCardInformationResult.getCode(), operaCardInformationResult.getMsg());
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultInfo(-1, "新建卡号失败");
            return SUCCESS;
        }
    }

    /**
     * 获取卡信息
     *
     * @return
     */
    public String getCardInforDetail() {

        cardInformationDto.setCompanyId(user.getCompanyId());
        cardInformationDto.setStore(user.getStoreId());
        detailVo = cardInforManager.getCardDetail(cardInformationDto);
        userVo = user.getStoreId();

        result.setSuccessInfo();
        return SUCCESS;
    }

    public CardInformationDto getCardInformationDto() {
        return cardInformationDto;
    }

    public void setCardInformationDto(CardInformationDto cardInformationDto) {
        this.cardInformationDto = cardInformationDto;
    }

    public CardInformation getCardInformation() {
        return cardInformation;
    }

    public void setCardInformation(CardInformation cardInformation) {
        this.cardInformation = cardInformation;
    }

    public CardInformation getDetailVo() {
        return detailVo;
    }

    public void setDetailVo(CardInformation detailVo) {
        this.detailVo = detailVo;
    }

    public String[] getJumpNumber() {
        return jumpNumber;
    }

    public void setJumpNumber(String[] jumpNumber) {
        this.jumpNumber = jumpNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUserVo() {
        return userVo;
    }

    public void setUserVo(Long userVo) {
        this.userVo = userVo;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

}
