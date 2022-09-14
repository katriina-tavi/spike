import { axios } from '@/utils/request'
/**
 * 合同查询列表
 * @param {Object} parameter
 * @returns
 */
export function demo() {
    return axios({
        url: '/api/demo/get',
        method: 'get',
    })
}

export function page(data) {
    return axios.post('/api/productInfo/page',data);
}
/**
 * 客户详情
 * @param {JSON} parameter
 * @returns
 */
export function getUserInfo() {
    return axios({
        url: '/api/user/index',
        method: 'get',
    })
}

/**
 * 客户详情
 * @param token
 * @returns
 */
export function logout(sessionId) {
    return axios({
        url: '/api/app/logout?sessionId='+sessionId,
        method: 'get',
    })
}
