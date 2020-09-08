 package com.itcrazy.alanmall.merchant.controller;

 import java.util.Date;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.bind.annotation.RestController;


 @RestController
 @RequestMapping({"/demo/dubbo"})
 public class DubboController
 {
   @RequestMapping({"/index"})
   @ResponseBody
   public String index() {
/* 16 */     Date d = new Date();

/* 18 */     return "启动成功" + d;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\controller\DubboController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */