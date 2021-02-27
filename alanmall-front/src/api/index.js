import http from './public'
import {apis} from './api'

// 上传图片
export const upload = (params) => {
    return http.fetchPost(apis.upload, params)
}

// http://localhost:8082/test
export const getAllTest = () => {
    return http.fetchGet(apis.test)
}

export const userInfo = (params) => {
    return http.fetchGet(apis.userInfo, params)
}

export const userLogin = (params) => {
    return http.fetchPost(apis.userInfo, params)
}

// 注册账号
export const register = (params) => {
    return http.fetchPost(apis.register, params)
}

// 退出登陆
export const loginOut = (params) => {
    return http.fetchGet(apis.loginOut, params)
}

// 首页接口
export const productHome = (params) => {
    return http.fetchGet(apis.productHome, params)
}
  // 首页接口
export const navList = (params) => {
return http.fetchGet(apis.navList, params)
}
// 推荐板块
export const recommend = (params) => {
return http.fetchGet(apis.recommend, params)
}

export const initKaptcha = (params) => {
    return http.fetchGet('/user/kaptcha?t=' + (new Date()).getTime(), params)
}

