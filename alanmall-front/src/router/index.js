import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Index from '@/page/index'
import Login from '@/page/login/login'
import User from '@/page/user/user'
import Test from '@/page/test/test'
import Register from '@/page/login/register'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'index',
      component: Index
    },
    {path: '/login',name: 'login',component: Login},
    {path: '/register',name: 'register',component: Register},
    {path: '/test',name: 'test',component: Test}
    
  ]
})
