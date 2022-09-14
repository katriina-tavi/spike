export default [{
  name: 'basic',
  meta: {
    title: '权限管理',
    icon: 'fa fa-camera-retro'
  },
  sub: [{
    name: 'Menu',
    meta: {
      index: `/home/Menu`,
      title: '菜单管理',
      type: 'menu',
      active: false
    }
  },{
    name: 'User',
    meta: {
      index: `/home/User`,
      title: '用户管理',
      type: 'menu',
      active: false
    }
  },{
    name: 'Welcome',
    meta: {
      index: `/home/Welcome`,
      title: '首页',
      type: 'menu',
      active: true
    }
  }]
}]
