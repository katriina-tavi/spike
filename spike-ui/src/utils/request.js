import axios from "axios";
import { Message } from 'element-ui';
// 创建 axios 实例
const service = axios.create({
    baseURL: "/api", // api base_url
    timeout: 6000, // 请求超时时间
});

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
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    console.log("response",response);
    if (response.data.code == 501) {
        let returnUrl = "http://localhost:8087" + localStorage.getItem("returnUrl");
        window.location.href="http://localhost:8086/preLogin?returnUrl="+returnUrl;
    }
    return response;
}, function (error) {
    console.log("error",error);
    let status = error.response.status;
    if (403 == status) {
        Message.error("未登录");
        window.location.href="/login";
        //this.$router.push("/");
    }
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});

export {axios as axios };

