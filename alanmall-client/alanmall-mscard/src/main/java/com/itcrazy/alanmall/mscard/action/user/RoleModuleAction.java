package com.itcrazy.alanmall.mscard.action.user;


import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.vo.user.RoleModuleVo;
import com.itcrazy.alanmall.user.carddto.ModuleDto;
import com.itcrazy.alanmall.user.carddto.RoleModuleDto;
import com.itcrazy.alanmall.user.manager.HandleManager;
import com.itcrazy.alanmall.user.manager.ModuleManager;
import com.itcrazy.alanmall.user.manager.RoleHandleManager;
import com.itcrazy.alanmall.user.manager.RoleModuleManager;
import com.itcrazy.alanmall.user.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取用户角色下面的模块
 * 
 * @author DDD
 * 
 */
public class RoleModuleAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -7526601896812986409L;
	private Long roleId;
	private Long roleLevelId;
	@Reference
	private ModuleManager moduleManager;
	@Reference
	private RoleModuleManager roleModuleManager;
	@Reference
	private HandleManager handleManager;
	@Reference
	private RoleHandleManager roleHandleManager;

	public String getRoleModuleList() {

		if (roleLevelId == null || roleLevelId<RoleLevel.ID_COMPANY) {
			roleLevelId = RoleLevel.ID_COMPANY;
		}
		Map<Long, RoleModule> checkMap = null;
		Map<Long, RoleHandle> checkHandleMap = null;
		if (roleId == null) {
			checkMap = new HashMap<Long, RoleModule>();
			checkHandleMap = new HashMap<Long, RoleHandle>();
		} else {
			RoleModuleDto rmDto = new RoleModuleDto();
			rmDto.setRoleId(roleId);
			checkMap = roleModuleManager.getRoleModuleMap(rmDto);
			checkHandleMap = roleHandleManager.getRoleHandleMap(roleId);
		}

		List<RoleModuleVo> rmvList = new ArrayList<RoleModuleVo>();
       
        RoleModuleVo crmVo=this.getRoleModuleVo(System5i.ID_CRM, checkMap, checkHandleMap);
        if(crmVo!=null && crmVo.getSubs().size()>0){
        	rmvList.add(crmVo);
        }
        
        RoleModuleVo shopVo=this.getRoleModuleVo(System5i.ID_SHOP, checkMap, checkHandleMap);
        if(shopVo!=null && shopVo.getSubs().size()>0){
        	rmvList.add(shopVo);
        }

        RoleModuleVo psVo=this.getRoleModuleVo(System5i.ID_PS, checkMap, checkHandleMap);
        if(psVo!=null && psVo.getSubs().size()>0){
        	rmvList.add(psVo);
        }
        
        RoleModuleVo wechatVo=this.getRoleModuleVo(System5i.ID_WECHAT, checkMap, checkHandleMap);
        if(wechatVo!=null && wechatVo.getSubs().size()>0){
        	rmvList.add(wechatVo);
        }
        
		pageData.rows = rmvList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	private RoleModuleVo getRoleModuleVo(Integer systemId,Map<Long, RoleModule> checkMap,Map<Long, RoleHandle> checkHandleMap ){
				
		
			if (systemId==System5i.ID_SHOP && roleLevelId!=RoleLevel.ID_SHOP) {//只有门店角色使用shop系统
			     return null;
			}
			if (systemId==System5i.ID_PS && roleLevelId==RoleLevel.ID_OFFICE) {//office角色不可以使用配送系统
			     return null;
			}
			if (systemId==System5i.ID_WECHAT && roleLevelId==RoleLevel.ID_OFFICE) {//微信端不可以office角色使用
			     return null;
			}
			
			RoleModuleVo rmVo = new RoleModuleVo();
			Integer isCheckAll = 1;
			ModuleDto dto = new ModuleDto();
			dto.setSystem(systemId);
			dto.setRoleLevelId(roleLevelId);
			List<Module> mList = moduleManager.getPageList(dto);// 获取指定角色模块
			List<RoleModuleVo> voList = this.getChildListByParentId(mList, 0L,
					checkMap, checkHandleMap);
			for (RoleModuleVo rv : voList) {
				if (rv.getChecked() == RoleModule.IS_FLAG_NO) {
					isCheckAll = RoleModule.IS_FLAG_NO;
					break;
				}
			}
			rmVo.setChecked(isCheckAll);
			rmVo.setId(0L);
			rmVo.setLeaf(0);
			rmVo.setName(System5i.getSystemName(systemId));
			rmVo.setSubs(voList);
			return rmVo;
		
	}

	private List<RoleModuleVo> getChildListByParentId(List<Module> mList,
			Long parentId, Map<Long, RoleModule> checkMap,
			Map<Long, RoleHandle> checkHandleMap) {
		List<RoleModuleVo> rmvList = new ArrayList<RoleModuleVo>();

		for (Module m : mList) {
			if (m.getParentId().equals(parentId)) {
				RoleModuleVo rmv = new RoleModuleVo();

				rmv.setId(m.getId());
				rmv.setName(m.getName());

				List<RoleModuleVo> subRmvList = this.getChildListByParentId(
						mList, m.getId(), checkMap, checkHandleMap); // 迭代查找

				if (subRmvList != null && subRmvList.size() > 0) {
					Integer isAllCheck = 1;
					for (RoleModuleVo srmv : subRmvList) {
						if (srmv.getChecked() == 0) {
							isAllCheck = 0;
							break;
						}
					}
					rmv.setChecked(isAllCheck);
				} else {
					if (checkMap.get(m.getId()) == null) {
						rmv.setChecked(0);
					} else {
						rmv.setChecked(1);
					}

				}

				if (subRmvList == null || subRmvList.size() == 0) {

					List<Handle> hList = handleManager.getListByModuleId(m
							.getId());

					if (hList != null && hList.size() > 0) {
						for (Handle h : hList) {
							RoleModuleVo hmv = new RoleModuleVo();
							if (checkHandleMap.get(h.getId()) == null) {
								hmv.setChecked(0);
							} else {
								hmv.setChecked(1);
							}

							hmv.setId(h.getId() + Handle.ID_MIN);
							hmv.setLeaf(1);
							hmv.setName(h.getName());
							rmv.getSubs().add(hmv);
						}
					} else {

						RoleModuleVo hmv = new RoleModuleVo();
						hmv.setChecked(0);
						hmv.setId(-1L);
						hmv.setLeaf(1);
						hmv.setName("无特殊操作");
						rmv.getSubs().add(hmv);
					}

					rmv.setLeaf(0);
				} else {
					rmv.setSubs(subRmvList);
					rmv.setLeaf(0);
				}

				rmvList.add(rmv);
			}
		}
		return rmvList;
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setHandleManager(HandleManager handleManager) {
		this.handleManager = handleManager;
	}

	public void setRoleModuleManager(RoleModuleManager roleModuleManager) {
		this.roleModuleManager = roleModuleManager;
	}

	public void setRoleHandleManager(RoleHandleManager roleHandleManager) {
		this.roleHandleManager = roleHandleManager;
	}

	public Long getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Long roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

}
