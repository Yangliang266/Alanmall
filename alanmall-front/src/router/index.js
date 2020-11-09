import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Index from '@/page/index'
import Login from '@/page/login/login'
import Test from '@/page/test/test'
import Register from '@/page/login/register'
import Home from '@/page/home/home'
import Product from '@/page/goods/goodsDetails'
import Cart from '@/page/cart/cart'
import checkout from '@/page/checkout/checkout'
import refreshsearch from '@/page/refresh/refreshsearch'
import RefreshGoods from '@/page/refresh/refreshgoods'
import GoodS from '@/page/goods/goods'


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
        {path: "product/:productId", name: 'product', component: Product},
        {path: 'goods', component: GoodS},
        {path: 'goods/cate/:cateId', component: GoodS},
        {path: '/refreshgoods', name: 'refreshgoods', component: RefreshGoods}
      ]
    },
    {path: '/login',name: 'login',component: Login},
    {path: '/register',name: 'register',component: Register},
    {path: '/test',name: 'test',component: Test},
    {path: '/cart', name: 'cart', component: Cart},
    {path: '/refreshsearch', name: 'refreshsearch', component: refreshsearch},
    {path: '/checkout/:productId?/:num?', name: 'checkout', component: checkout}
    
  ]
})
