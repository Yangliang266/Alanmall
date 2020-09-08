// package com.itcrazy.alanmall.user.controller.demo;
//
// import org.apache.dubbo.config.annotation.Reference;
// import com.itcrazy.alanmall.user.carddto.RoleDto;
// import com.itcrazy.alanmall.user.manager.ModuleManager;
// import com.itcrazy.alanmall.user.manager.RoleManager;
// import com.itcrazy.alanmall.user.manager.UserManager;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// @RequestMapping({"/demo/dubbo"})
// public class DubboController
// {
//   @Reference(version = "1.0.0")
//   private UserManager userManager;
//   @Reference(version = "1.0.0")
//   private ModuleManager moduleManager;
//   @Reference(version = "1.0.0")
//   private RoleManager roleManager;
//
//   @RequestMapping({"/consu"})
//   @ResponseBody
//   public String consu() {
///* 26 */     this.userManager.getUserById(Long.valueOf(-1L));
///* 27 */     this.roleManager.getPageList(new RoleDto());
//
///* 29 */     this.moduleManager.getModule(Long.valueOf(1L));
///* 30 */     return "启动成功";
//   }
// }
//
//
///* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meishi\controller\demo\DubboController.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       1.1.3
// */