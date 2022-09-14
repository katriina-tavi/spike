import Vue from 'vue'
import Router from 'vue-router'

import menus from './config/menu-config'
import Layout from './views/Layout'

Vue.use(Router)

// const routes = []
//
//
// // 登录路由
// routes.push({
//   path: '/',
//   name: 'Login',
//   component: () => import('./views/Login')
// })
//
// // 侧边栏二级菜单路由
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
//
// // 侧边栏菜单路由
// routes.push({
//   path: '/Home',
//   name: 'Home',
//   component: Layout,
//   children: LayoutChildren
// })

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
    }
  ]
});

// 路由拦截器
router.beforeEach(async (to, from, next) => {
  let token = to.query.token;
  if (token != undefined && token != 'null' && token !=null) {
    localStorage.setItem("token",token);
  }
  // 跳转url保存到localstorage
  localStorage.setItem("returnUrl",to.path);
  // if (to.matched.some(record => record.meta.auth) && to.meta.auth) { // 判断该路由是否需要登录权限
  //   let token = localStorage.getItem('token');
  //   if (token) { // 获取当前的 token 是否存在
  //     next()
  //   } else {
  //     // 不存在 token，需要重新认证
  //     next({
  //       path: '/auth/login',
  //       query: {
  //         redirect: to.fullPath
  //       }
  //     })
  //   }
  // }
  next();
});
export default router
