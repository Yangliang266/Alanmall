import http from './public'
import {apis} from './api'

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

export const initKaptcha = (params) => {
    return http.fetchGet('/user/kaptcha?t=' + (new Date()).getTime(), params)
}

