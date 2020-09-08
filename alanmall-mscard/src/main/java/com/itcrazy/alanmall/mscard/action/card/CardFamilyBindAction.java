package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.mscard.dto.Base.CardFamilyDto;
import com.itcrazy.alanmall.mscard.vo.card.CardFamilyVo;
import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.manager.CardFamilyManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardFamily;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.vo.Result;
import com.itcrazy.alanmall.user.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 亲情卡管理绑定子卡
 *
 * @author huangchunbo
 * 2018-11-13
 */
public class CardFamilyBindAction extends InterfaceBaseAction {
    private static final long serialVersionUID = -2637549889945818883L;

    private CardFamilyDto cardFamilyDto;
    private String[] cardNumbers;
    private String motherCardNo;

    @Reference
    CardFamilyManager cardFamilyManager;
    @Reference
    UserManager userManager;

    /*
     * 未绑定子卡一览
     */
    public String getCardFamilyBindList() {

        if (cardFamilyDto == null) {
            cardFamilyDto = new CardFamilyDto();
        }
        cardFamilyDto.setCompanyId(user.getCompanyId());
        List<CardFamily> cardFamilyList = cardFamilyManager.getCardBindFamilyList(cardFamilyDto);
        List<CardFamilyVo> cardFamilyVoList = new ArrayList<CardFamilyVo>();

        if (cardFamilyList != null && cardFamilyList.size() > 0) {

            for (CardFamily c : cardFamilyList) {
                CardFamilyVo cv = new CardFamilyVo();

                cv.setCardNo(c.getCardNo());
                cv.setName(c.getName());
                cv.setUserName(c.getUserName());
                cv.setSex(KeyValueConvert.getCardSexValue(c.getSex()));
                cv.setTelephone(c.getTelephone());
                cv.setIdNumber(c.getIdNumber());
                cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));

                cardFamilyVoList.add(cv);
            }
        }

        pageData.rows = cardFamilyVoList;
        result.setSuccessInfo();
        return SUCCESS;
    }

    /*
     * 绑定子卡
     */
    public String updateCardFamilyBind() {
        if (cardNumbers == null) {
            result.setParamErrorInfo("cardNumbers");
            return SUCCESS;
        }
        if (motherCardNo == null) {
            result.setParamErrorInfo("motherCardNo");
            return SUCCESS;
        }
        List<ActiveInformation> activeInfoList = new ArrayList<>();
        for (String subCardNo : cardNumbers) {
            ActiveInformation active = new ActiveInformation();
            active.setCardNo(subCardNo);
            active.setMotherCardNo(motherCardNo);
            active.setUpdateId(user.getId());
            active.setCompanyId(user.getCompanyId());
            activeInfoList.add(active);

        }
        // 子卡绑定（更新激活卡信息表、母卡信息复制到子卡）
        try {
            Result operaCardInformationResult = cardFamilyManager.bindSubCrads(activeInfoList);
            if (operaCardInformationResult.getCode() == 0) {
                result.setResultInfo(0, "子卡绑定成功。");
            } else {
                result.setResultInfo(operaCardInformationResult.getCode(), operaCardInformationResult.getMsg());
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultInfo(-1, "绑定失败");
            return SUCCESS;
        }
    }

    public CardFamilyDto getCardFamilyDto() {
        return cardFamilyDto;
    }

    public void setCardFamilyDto(CardFamilyDto cardFamilyDto) {
        this.cardFamilyDto = cardFamilyDto;
    }

    public String[] getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(String[] cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public String getMotherCardNo() {
        return motherCardNo;
    }

    public void setMotherCardNo(String motherCardNo) {
        this.motherCardNo = motherCardNo;
    }

}
