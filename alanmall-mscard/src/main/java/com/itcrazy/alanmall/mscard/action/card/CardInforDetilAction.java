package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.CardInforDetilManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.CSVUtils;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.CardInformationVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

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
public class CardInforDetilAction extends InterfaceBaseAction {

    private static final long serialVersionUID = 3462952821139591864L;

    private CardInformationDto cardInformationDto;

    public String serialNo;

    @Reference
    private CardInforDetilManager cardInforDetilManager;

    @Reference
    UserManager userManager;

    /**
     * 获取制卡批次详情页列表数据
     *
     * @param cardInformationDto
     * @return
     */
    private List<CardInformationVo> getPage(CardInformationDto cardInformationDto) {

        List<CardInformation> cardInforList = cardInforDetilManager.getPageDetilList(cardInformationDto);
        List<CardInformationVo> cardInforVoList = new ArrayList<CardInformationVo>();

        if (cardInforList != null && cardInforList.size() > 0) {
            for (CardInformation c : cardInforList) {
                CardInformationVo civ = new CardInformationVo();
                civ.setSerialNo(c.getSerialNo());
                civ.setCardNo(c.getCardNo());
                civ.setName(c.getName());
                civ.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
                civ.setCreateTime(DateFormat.dateToString(c.getCreateTime()));
                User createCardUser = userManager.getUserById(c.getCreateId());
                if (createCardUser != null) {
                    civ.setCreateName(createCardUser.getRealName());
                }
                cardInforVoList.add(civ);
            }
        }
        return cardInforVoList;
    }

    /**
     * 页面显示
     *
     * @return
     */
    public String getCardInforDetilList() {
        if (cardInformationDto == null) {
            cardInformationDto = new CardInformationDto();
        }
        cardInformationDto.setSerialNo(serialNo);

        pageSet(cardInformationDto);
        cardInformationDto.setCompanyId(user.getCompanyId());


        pageData.rows = getPage(cardInformationDto);
        Integer t = cardInforDetilManager.getPageDetilTotal(cardInformationDto);
        pageData.setTotal(t);
        result.setSuccessInfo();
        return SUCCESS;
    }

    /**
     * 导出制卡管理-制卡批次详情页数据
     *
     * @return
     */
    public void getCardInforDetilListEexport() {
        if (cardInformationDto == null) {
            cardInformationDto = new CardInformationDto();
        }

        cardInformationDto.setSerialNo(serialNo);
        cardInformationDto.setCompanyId(user.getCompanyId());
        cardInformationDto.setStart(0);
        cardInformationDto.setLimit(Integer.MAX_VALUE);

        List<CardInformationVo> cardInforVoList = getPage(cardInformationDto);

        String fileName = "制卡管理-制卡批次详情" + DateFormat.dateToString(new Date()) + ".csv";

        LinkedHashMap<String, String> cardInforMaps = new LinkedHashMap<>();
        cardInforMaps.put("制卡批次号", "serialNo");
        cardInforMaps.put("卡号", "cardNo");
        cardInforMaps.put("卡类别", "name");
        cardInforMaps.put("卡状态", "status");
        cardInforMaps.put("制卡时间时间", "createTime");
        cardInforMaps.put("制卡人", "createName");
        try {
            String content = CSVUtils.formatCsvData(cardInforVoList, cardInforMaps);
            CSVUtils.exportCsv(fileName, content, getRequest(), getResponse());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public CardInformationDto getCardInformationDto() {
        return cardInformationDto;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setCardInformationDto(CardInformationDto cardInformationDto) {
        this.cardInformationDto = cardInformationDto;
    }


}
