package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.JumpNumberRuleManager;
import com.itcrazy.alanmall.mscard.model.JumpNumberRule;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.JumpNumberRuleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳号规则设置
 *
 * @author zhangzhongtian
 *
 */
public class JumpNumberRuleAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -6163014905612692030L;

	public JumpNumberRule jumpNumberRule;

	@Reference
	JumpNumberRuleManager jumpNumberRuleManager;

	/*
	 * 跳号规则设置一览
	 */
	public String getJumpNumberRuleList() {
		CardBaseDto baseDto = new CardBaseDto();
		baseDto.setIsDeleted(0);
		baseDto.setCompanyId(user.getCompanyId());
		List<JumpNumberRule> jumpNumberRuleList = jumpNumberRuleManager.getJumpNumberRuleList(baseDto);
		List<JumpNumberRuleVo> jumpNumberRuleVoList = new ArrayList<JumpNumberRuleVo>();

		if(jumpNumberRuleList != null && jumpNumberRuleList.size()>0){

			for(JumpNumberRule p : jumpNumberRuleList){
				JumpNumberRuleVo pv = new JumpNumberRuleVo();

				pv.setId(p.getId());
				pv.setJumpNumber(p.getJumpNumber());
				pv.setStatus(p.getStatus());
				pv.setStatusName(KeyValueConvert.getStatusValue(p.getStatus()));

				jumpNumberRuleVoList.add(pv);
			}
		}

		pageData.rows = jumpNumberRuleVoList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 新增修改跳号规则
	 * @return
	 */
	public String updateJumpNumberRule(){
		if(jumpNumberRule == null){
			result.setParamErrorInfo("jumpNumberRule");
			return SUCCESS;
		}
		if (jumpNumberRule.getId() == null) {
			// 新增
			jumpNumberRule.setStatus(1);
			jumpNumberRule.setCreateId(user.getId());
			jumpNumberRule.setCompanyId(user.getCompanyId());
			jumpNumberRuleManager.addJumpNumberRule(jumpNumberRule);
		}else {
			// 修改
			jumpNumberRule.setUpdateId(user.getId());
			jumpNumberRuleManager.updateJumpNumberRule(jumpNumberRule);
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 删除跳号数字(逻辑删除)
	 * @return
	 */
	public String deleteJumpNumberRule(){
		if (jumpNumberRule.getId() == null) {
			result.setParamErrorInfo("id");
			return SUCCESS;
		}

		JumpNumberRule pm = new JumpNumberRule();
		pm.setId(jumpNumberRule.getId());
		pm.setIsDeleted(1);
		pm.setUpdateId(user.getId());
		jumpNumberRuleManager.updateJumpNumberRule(pm);
		result.setSuccessInfo();
		return SUCCESS;
	}


	public JumpNumberRule getJumpNumberRule() {
		return jumpNumberRule;
	}

	public void setJumpNumberRule(JumpNumberRule jumpNumberRule) {
		this.jumpNumberRule = jumpNumberRule;
	}

}
