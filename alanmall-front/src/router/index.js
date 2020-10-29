import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Index from '@/page/index'
import Login from '@/page/login/login'
import User from '@/page/user/user'
import Test from '@/page/test/test'
import Register from '@/page/login/register'
import Home from '@/page/home/home'
import Product from '@/page/goods/goodsDetails'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      redirect: "/home",
      children: [
        {path: "home", component: Home},
        {path: "/product/:productId", name: 'product', component: Product}
      ]
    },
    {path: '/login',name: 'login',component: Login},
    {path: '/register',name: 'register',component: Register},
    {path: '/test',name: 'test',component: Test}
    
  ]
})
