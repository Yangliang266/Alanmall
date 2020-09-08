# Alanmall
Distributed ecological technology

## card系统重构

1. **分布式搭建**

   1. **user 服务 - user 后端控制**

      1. 登录控制

      2. 个人信息

      3. 付款个人地址

      4. **<span style='color:red'>具体实现  如下</span>**

         ### login

         #### 1. 页面区分

         #####     未登录

         1. 用户图标和购物车图标不显示任何信息
         2. 主页面正常展示

         

         #####     已登录

         1. 用户图标和购物车图标显示用户和购物车信息

         2. 主页面正常显示

            ---

            

         #### 2. 登录方法

         #####     主页面触发

         1. 商品详情
         2. 商品加入购物车

         #####     导航栏触发

         1. 用户图标

         2. 导航栏图标

            ---

            

         #### 3. 登录页面

         #####     页面内容

         1. 用户名密码
         2. 图像验证
         3. 登录确认
         4. 注册

         #####     前端处理

         1. **mounted** 

            1. `getRemembered  -> localStorage` 
            2. `login_addCart` 登陆时将本地的添加到用户购物车
               1. `window.localStorage.getItem(name)`
               2. 作用可以在下次登录检查localstorage，如果存在不需要二次登录
            3. 获取图形验证: `init_geetest -> getKaptchaCode`
               1. 生成uuid
               2. redis:`getBucket`
               3. 返回response

         2. **login**

            1. <span style='color:red'>`userLogin -> login`</span>

               1. check

               2. 数据库查询

               3. 验证激活

               4. MD5验证

               5. 返回response

                  1. 返回成功success

                  2. 获取购物车信息: `addToCart`

                     1. 缓存存在，获取
                     2. 不存在,从数据库获取
                     3. 添加到redis
                     4. 跳转到  ***/***  目录

                     

            **后端处理**

            <span style='color:red'>todo</span>

            

   2. **shopping 服务 - shopping 后端控制**

      1. 商品选择
      2. 商品购买
      3. <span style='color:red'>具体实现 todo</span>

   3. **casher 业务 - cahser 后端控制**

      1. 付款方式
      2. <span style='color:red'>具体实现 todo</span>

   4. **card 服务 - card 后端控制**

      1. card 生成前置流程
      2. card 生成后置流程
      3. card 报表流程
      4. <span style='color:red'>具体实现 todo</span>

   5. **<span style='color:red'>ToDo 后续待开发</span>**

      

2. **技术选型**

   1. dubbo 远程通信
   2. zookeeper 注册中心
   3. redis 缓存
   4. rabbitmq 消息队列
   5. mysql 数据库
   6. vuejs 前端控制







​																																															write by  yliang 2020/9/7
