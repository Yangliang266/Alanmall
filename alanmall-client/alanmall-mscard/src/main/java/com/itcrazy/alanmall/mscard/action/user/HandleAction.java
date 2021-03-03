package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.user.manager.HandleManager;
import com.itcrazy.alanmall.user.manager.RoleHandleManager;
import com.itcrazy.alanmall.user.model.Handle;
import com.itcrazy.alanmall.user.model.RoleHandle;

import java.util.List;
import java.util.Map;

/**
 * 根据模块查看操作
 * @author DDD
 *
 */
public class HandleAction extends InterfaceBaseAction {

	private static final long serialVersionUID = 6898239907257920082L;

	private Long moduleId;
	@Reference
	private RoleHandleManager roleHandleManager;
	@Reference
	private HandleManager handleManager;
	public String getHandleList(){
		if(moduleId==null){
			result.setParamErrorInfo("moduleId");
			return SUCCESS;
		}
		Map<Long,RoleHandle> m= roleHandleManager.getRoleHandleMap(user.getRoleId());
		List<Handle> hList=handleManager.getListByModuleId(moduleId);
		if(hList!=null && hList.size()>0){
			result.setSuccessInfo();
			return SUCCESS;
		}
		for(int i=hList.size()-1;i>=0;i--){
			Handle h=hList.get(i);
			if(m.get(h.getId())==null){
				hList.remove(i);
			}
		}
		pageData.rows=hList;
		result.setSuccessInfo();
		return SUCCESS;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public void setRoleHandleManager(RoleHandleManager roleHandleManager) {
		this.roleHandleManager = roleHandleManager;
	}
	public void setHandleManager(HandleManager handleManager) {
		this.handleManager = handleManager;
	}

	
}
