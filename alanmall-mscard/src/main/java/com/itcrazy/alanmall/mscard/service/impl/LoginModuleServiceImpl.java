package com.itcrazy.alanmall.mscard.service.impl;

import com.itcrazy.alanmall.mscard.service.LoginModuleService;
import com.itcrazy.alanmall.mscard.vo.user.ModuleVo;
import com.itcrazy.alanmall.user.carddto.ModuleDto;
import com.itcrazy.alanmall.user.manager.ModuleManager;
import com.itcrazy.alanmall.user.manager.ModuleUrlManager;
import com.itcrazy.alanmall.user.model.Module;
import com.itcrazy.alanmall.user.model.RoleLevel;
import com.itcrazy.alanmall.user.model.System5i;
import com.itcrazy.alanmall.user.model.User;
import org.apache.dubbo.config.annotation.Reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LoginModuleServiceImpl implements LoginModuleService {
	@Reference
	private ModuleUrlManager moduleUrlManager;
	@Reference
	private ModuleManager moduleManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleVo> getLoginModuleList(User user,
											 Long parentId, String excludes) {
		if (parentId == null) {
			parentId = 0L;
		}

		ModuleDto mdto = new ModuleDto();
		mdto.setCompanyId(user.getCompanyId());
		mdto.setRoleLevelId(user.getRoleLevelId());
		if(user.getRoleLevelId()== RoleLevel.ID_OFFICE){//运营级别管理员
			mdto.setOfficeRoleId(user.getRoleId());
		}else{ //商家管理员
			mdto.setCompanyRoleId(user.getRoleId());
		}

		mdto.setSystem(System5i.ID_CRM);

		List<Module> mList = moduleManager.getPageList(mdto);

		Map<Long, Module> moduleMap = moduleManager
				.getSystemModuleMap(System5i.ID_CRM);

		List<Long> moduleIdList = new ArrayList<Long>();
		for (Module m : mList) {
			moduleIdList.add(m.getId());
		}

		for (int i = 0; i < mList.size(); i++) {// 补充父节点
			Module m = mList.get(i);
			while (!moduleIdList.contains(m.getParentId())) {
				m = moduleMap.get(m.getParentId());
				if (m == null) {
					break;
				}
				mList.add(m);
				moduleIdList.add(m.getId());
			}
		}
		if(excludes!=null && excludes.contains(",") && mList.size()>0){
			for(int i = 0; i < mList.size(); i++){//删除对应不显示菜单
				Module m=mList.get(i);
				if(excludes.contains(","+m.getId()+",")){
					mList.remove(i);
					i--;
				}

			}
		}


		List<ModuleVo> mvList = new ArrayList<ModuleVo>();
		Map<Long, String> moduleUrl = moduleUrlManager
				.getModuleUrlMapBySystem(System5i.ID_CRM);
		if (mList != null && mList.size() > 0) {
			for (Module m : mList) {
				if (m.getParentId().equals(parentId)) {
					ModuleVo mv = new ModuleVo();
					mv.setShowOrder(m.getShowOrder());
					mv.setId(m.getId());
					mv.setName(m.getName());
					String url = moduleUrl.get(m.getId());
					if (url != null) {
						mv.setUrl(url);
					} else {
						mv.setUrl("");
					}
					mvList.add(mv);
					for (Module m1 : mList) {// 两层循环
						if (m1.getParentId().equals(m.getId())) {
							ModuleVo mv1 = new ModuleVo();
							mv1.setId(m1.getId());
							mv1.setName(m1.getName());
							String url2 = moduleUrl.get(m1.getId());
							if (url2 != null) {
								mv1.setUrl(url2);
							} else {
								mv1.setUrl("");
							}
							mv.getSubModule().add(mv1);
						}
					}
				}
			}
			//SessionData.setModuleList(companyId, roleId, parentId, mvList);
		}
		if(mvList!=null){
			Collections.sort(mvList);
			for(ModuleVo mv:mvList){
				Collections.sort(mv.getSubModule());
			}
		}
		return mvList;
	}

	public void setModuleUrlManager(ModuleUrlManager moduleUrlManager) {
		this.moduleUrlManager = moduleUrlManager;
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}


}
