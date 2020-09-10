// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import store from './store/'
// import login from './page/login/login.vue' 
// import index from './page/index.vue' 
import router from './router'
import { userInfo } from './api'

import VueLazyload from 'vue-lazyload'
import infiniteScroll from 'vue-infinite-scroll'
import VueCookie from 'vue-cookie'
// Element css
import 'element-ui/lib/theme-default/index.css'
import { Button, Pagination, Checkbox, Icon, Autocomplete, Loading, Message, Notification, Steps, Step, Table, TableColumn, Input, Dialog, Select, Option, Tabs, TabPane } from 'element-ui'
// import { getStore } from '/utils/storage'
import VueContentPlaceholders from 'vue-content-placeholders'

Vue.use(VueContentPlaceholders)
Vue.use(Button)
Vue.use(Pagination)
Vue.use(Checkbox)
Vue.use(Icon)
Vue.use(Autocomplete)
Vue.use(Steps)
Vue.use(Step)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Input)
Vue.use(Dialog)
Vue.use(Select)
Vue.use(Option)
Vue.use(Loading.directive)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.prototype.$loading = Loading.service
Vue.prototype.$notify = Notification
Vue.prototype.$message = Message
Vue.use(infiniteScroll)
Vue.use(VueCookie)
Vue.use(VueLazyload, {
  // preLoad: 1.3,
  // error: 'dist/error.png',
  loading: '/static/images/load.gif'
  // attempt: 1
})

Vue.config.productionTip = false

// const whiteList = ['/home', '/goods', '/login', '/register', '/product', '/thanks', '/search', '/refreshsearch', '/refreshgoods']

// router.beforeEach(function (to, from, next) {
//   // let params = {
//   //   params: {
//   //     token: getStore('token')
//   //   }
//   // }
//   userInfo().then(res => {
//     if (!res.success) { // 没登录
//       if (whiteList.indexOf(to.path) !== -1) { // 白名单
//         next()
//       } else {
//         next('/login')
//       }
//     } else {
//       store.commit('RECORD_USERINFO', {info: res.result})
//       if (to.path === '/login') { //  跳转到
//         next({path: '/'})
//       }
//       next()
//     }
//   })
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  render: h => h(App)
  // components: { App },
  // template: 'App'

})
