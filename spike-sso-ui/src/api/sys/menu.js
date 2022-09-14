import { axios } from '@/utils/request'

export function page(data) {
    return axios.post('/sso/menu/pageData',data);
}
