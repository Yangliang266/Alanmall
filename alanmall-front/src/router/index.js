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
import payment from '@/page/order/payment'
import order from '@/page/order/order'
import paysuccess from '@/page/order/paysuccess'
import Search from '@/page/Search/search'
import Alipay from '@/page/order/alipay.vue'
import Wechat from '@/page/order/wechat.vue'
import QQpay from '@/page/order/qqpay.vue'

import addressList from '@/page/user/children/addressList.vue'
import orderList from '@/page/user/children/order.vue'
import orderDetail from '@/page/user/children/orderDetail.vue'
import information from '@/page/user/children/information.vue'
import coupon from '@/page/user/children/coupon.vue'
import support from '@/page/user/children/support.vue'
import aihuishou from '@/page/user/children/aihuishou.vue'
import user from '@/page/user/user.vue'


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
    {
      path: '/order',
      name: 'order',
      component: order,
      children: [
        {path: 'paysuccess', name: 'paysuccess', component: paysuccess},
        {path: 'payment/:orderId', name: 'payment', component: payment},
        {path: '/search', name: 'search', component: Search},
        {path: 'alipay', name: 'alipay', component: Alipay},
        {path: 'wechat', name: 'wechat', component: Wechat},
        {path: 'qqpay', name: 'qqpay', component: QQpay}
      ]
    },
    {path: '/login',name: 'login',component: Login},
    {path: '/register',name: 'register',component: Register},
    {path: '/test',name: 'test',component: Test},
    {path: '/cart', name: 'cart', component: Cart},
    {path: '/refreshsearch', name: 'refreshsearch', component: refreshsearch},
    {path: '/checkout/:productId?/:num?', name: 'checkout', component: checkout},
    {
      path: '/user',
      name: 'user',
      component: user,
      redirect: '/user/orderList',
      children: [
        {path: 'orderList', name: '订单列表', component: orderList},
        {path: 'orderDetail', name: '订单详情', component: orderDetail},
        {path: 'information', name: '账户资料', component: information},
        {path: 'addressList', name: '收货地址', component: addressList},
        {path: 'coupon', name: '我的优惠', component: coupon},
        {path: 'support', name: '售后服务', component: support},
        {path: 'aihuishou', name: '以旧换新', component: aihuishou}
      ]
    }
    
  ]
})
