import axios from "axios";
import { Message } from 'element-ui';
// 创建 axios 实例

// 添加请求拦截器
axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    let token = localStorage.getItem("token");
    if (token != null && token != 'null') {
        config.headers["xxl_sso_sessionid"] = token;
    }
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    console.log("response",response);
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    if (response.data.code == 501) {
        window.location.href="/login";
    }
    return response;
}, function (error) {
    let status = error.response.status;
    if (403 == status) {
        Message.error("未登录");
        let returnUrl = localStorage.getItem("returnUrl");
        // if (returnUrl != 'null') {
        //     window.location.href="/login?returnUrl="+returnUrl;
        // }else {
            window.location.href="/login";
        // }
        //this.$router.push("/");
    }
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});

export {axios as axios };

