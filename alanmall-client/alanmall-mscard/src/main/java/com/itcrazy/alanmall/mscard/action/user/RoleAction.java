package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.vo.user.RoleVo;
import com.itcrazy.alanmall.user.carddto.ModuleDto;
import com.itcrazy.alanmall.user.carddto.RoleDto;
import com.itcrazy.alanmall.user.manager.ModuleManager;
import com.itcrazy.alanmall.user.manager.RoleHandleManager;
import com.itcrazy.alanmall.user.manager.RoleManager;
import com.itcrazy.alanmall.user.manager.RoleModuleManager;
import com.itcrazy.alanmall.user.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 * @author DDD
 *
 */
public class RoleAction extends InterfaceBaseAction{


	private static final long serialVersionUID = 1014571471579764209L;

	private Long roleId;
	private Role role;
	private Role detailVo;
	private String moduleIds;
	private RoleDto roleDto;

	@Reference
	private RoleManager roleManager;
	@Reference
	private RoleModuleManager roleModuleManager;
	@Reference
	private RoleHandleManager roleHandleManager;
	@Reference
	private ModuleManager moduleManager;
	public String updateRole(){
		if(role==null){
			result.setParamErrorInfo("role");
			return SUCCESS;
		}
		if(role.getName()==null){
			result.setParamErrorInfo("name");
			return SUCCESS;
		}
		if(role.getRoleLevelId()==null){
			result.setParamErrorInfo("roleLevelId");
			return SUCCESS;
		}

		role.setUpdateId(user.getId());
		role.setCompanyId(user.getCompanyId());
		role.setBrandId(user.getBrandId());
		role.setIsDefault(Role.IS_FLAG_NO);
		if(role.getId()==null){
			role.setCreateId(user.getId());

			role=roleManager.addRole(role);
		}else{
			roleModuleManager.removeRoleModuleByRole(role.getId(),user.getId());///删除角色下模块
			roleHandleManager.removeByRole(role.getId(), user.getId()); //删除角色下操作

			RoleHandle rh=new RoleHandle();
			rh.setRoleId(role.getId());
			rh.setUpdateId(user.getId());
			roleManager.updateRole(role);
		}
		//增加模块功能
		String[] idsArr=moduleIds.split(",");
		roleId=role.getId();

		ModuleDto dto=new ModuleDto();
		List<Module> mList=moduleManager.getPageList(dto);
		List<RoleModule> rmList=new ArrayList<RoleModule>();
		for(String ids:idsArr){
			Long id=Long.valueOf(ids);
			if(id==-1){
				continue;
			}
			if(id<Handle.ID_MIN){//模块
				if(this.isParentModule(mList, id)){
					continue ;
				}


				RoleModule rm=new RoleModule();
				rm.setCompanyId(user.getCompanyId());
				rm.setCreateId(user.getId());
				rm.setModuleId(id);
				rm.setRoleId(role.getId());
				rm.setUpdateId(user.getId());
				rmList.add(rm);
			}else{//模块操作
				RoleHandle rh=new RoleHandle();
				rh.setCreateId(user.getId());
				rh.setHandleId(id-Handle.ID_MIN);
				rh.setRoleId(role.getId());
				rh.setUpdateId(user.getId());
				roleHandleManager.addRoleHandle(rh);
			}
		}
		roleModuleManager.saveBatch(rmList);
		result.setSuccessInfo();
		return SUCCESS;
	}
	public String getRoleList(){

		if(roleDto==null){
			roleDto=new RoleDto();
		}

		roleDto.setCompanyId(user.getCompanyId());
		roleDto.setBrandId(user.getBrandId());
		roleDto.setRoleLevelIds(RoleLevel.ID_COMPANY+","+RoleLevel.ID_BRAND+","+RoleLevel.ID_SHOP);
		pageSet(roleDto);
		List<Role> rList=roleManager.getPageList(roleDto);

		List<RoleVo> rvList=new ArrayList<RoleVo>();
		if(rList!=null && rList.size()>0){


			String name="公司名称";


			for(Role r:rList){
				RoleVo rv=new RoleVo();
				rv.setId(r.getId());
				rv.setIsDefault(r.getIsDefault());
				if(r.getCompanyId()==null){
					rv.setCompanyName("");
				}else{
					rv.setCompanyName(name);
				}
				rv.setName(r.getName());
				rv.setRemark(r.getRemark());
				rv.setRoleLevelName(RoleLevel.getName(r.getRoleLevelId()));
				rv.setStatus(r.getStatus());
				rvList.add(rv);
			}
		}
		pageData.rows=rvList;
		Integer t=roleManager.getPageTotal(roleDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getRoleDetail(){
		if(roleId==null){
			result.setSuccessInfo();
			return SUCCESS;
		}
		detailVo=roleManager.getRoleById(roleId);
		result.setSuccessInfo();
		return SUCCESS;
	}

	private Boolean isParentModule(List<Module> mList,Long id){
		for(Module m:mList){
			if(m.getParentId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public Role getDetailVo() {
		return detailVo;
	}
	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}
	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}
	public Role getRole() {
		return role;
	}
	public void setRoleModuleManager(RoleModuleManager roleModuleManager) {
		this.roleModuleManager = roleModuleManager;
	}
	public void setRoleHandleManager(RoleHandleManager roleHandleManager) {
		this.roleHandleManager = roleHandleManager;
	}
	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}


}
