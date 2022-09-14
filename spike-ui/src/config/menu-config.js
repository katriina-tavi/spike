export default [{
  name: 'basic',
  meta: {
    title: '商品管理',
    icon: 'fa fa-camera-retro'
  },
  sub: [{
    name: 'ProductInfo',
    meta: {
      index: `/home/ProductInfo`,
      title: '商品管理',
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
