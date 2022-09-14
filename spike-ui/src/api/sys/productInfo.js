import { axios } from '@/utils/request'

export function page(data) {
    return axios.post('/api/productInfo/pageData',data);
}
