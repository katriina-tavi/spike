import { axios } from '@/utils/request'

/**
 * 合同查询列表
 * @param {Object} parameter
 * @returns
 */
export function demo() {
    return axios({
        url: '/sso/demo/get',
        method: 'get',
    })
}

export function page(data) {
    return axios.post('/sso/productInfo/page',data);
}

/**
 * 客户详情
 * @param {JSON} parameter
 * @returns
 */
export function login(parameter) {
    return axios({
        url: '/sso/app/login',
        method: 'post',
        data: parameter,
    })
}
/**
 * 客户详情
 * @param token
 * @returns
 */
export function logout(sessionId) {
    return axios({
        url: '/sso/app/logout?sessionId='+sessionId,
        method: 'get',
    })
}

/**
 * 客户详情
 * @param {JSON} parameter
 * @returns
 */
export function getUserInfo() {
    return axios({
        url: '/sso/user/index',
        method: 'get',
    })
}

/**
 * 客户详情
 * @param {JSON} parameter
 * @returns
 */
export function logincheck(token) {
    return axios({
        url: '/sso/app/logincheck?sessionId='+token,
        method: 'get',
    })
}
