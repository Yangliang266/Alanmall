1. **token/cookie传递流程图**

 <img src="https://raw.githubusercontent.com/YangLiang-SoftWise/images/master/img/login verify.png" alt="login verify" style="zoom: 33%;" />



2. **实现功能: 登录验证**

3. **Code组成**

   1. 前端

      1. main.js

         > 过滤 ['/home', '/goods', '/login', '/register', '/product', '/thanks', '/search', '/refreshsearch', '/refreshgoods'] 

      2. login.vue

         > username，password，kapatcha 登录信息

   2. 后端

      1. user-service

         1. KaptchaServiceImp

            1. getKaptchaCode

               > 获取 imgcode

            2. validateKaptcha 

               > 验证 imgcode

         2. UserLoginServiceImp

            1. login

               > 验证unm,upaw,ukatc生成token

            2. validToken

               > 解析token

      2. user-sdk

         1. TokenIntercepter

            > 拦截token，通过validToken 解析判断

         2. @Anoymous注解

            > 未被标记的handerMethod 需token验证

      3. alanmall-user

         1. KaptchaController

            1. getKaptchaCode

               > 根据获取的imgcode，放入cookie

            2. validatakaptchaCode

               > redis库与request code compare

         2. LoginController

            1. login

               > 根据生成的token，放入cookie
