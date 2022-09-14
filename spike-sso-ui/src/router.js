import Vue from 'vue'
import Router from 'vue-router'

import menus from './config/menu-config'
import Layout from './views/Layout'

Vue.use(Router)

const routes = []


// 侧边栏二级菜单路由
let LayoutChildren = []
menus.forEach((item) => {
    item.sub.forEach((cell) => {
        LayoutChildren.push({
            path: cell.name,
            name: cell.name,
            meta: cell.meta,
            component: () => import(`./components/${cell.name}`)
        })
    })
})


const router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect:'/home/Welcome'
        },
        {
            path: '/Home',
            name: 'Home',
            component: Layout,
            children: LayoutChildren
        },
        {
            path: '/login',
            name: 'login',
            component: () => import(`./views/Login`)
        },
        {
            path: '/preLogin',
            name: 'preLogin',
            component: () => import(`./views/preLogin`)
        }
    ]
});

// 路由拦截器
router.beforeEach(async (to, from, next) => {
    //localStorage.setItem("returnServerUrl",to.path);
    next();
});
export default router
