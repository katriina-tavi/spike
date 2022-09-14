const vueConfig = {

  devServer: {
    port: 8086,
    proxy: {
      "/sso": {
        target: 'http://localhost:6060',
        ws: false,
        changeOrigin: true,
        // logLevel: 'debug',
        pathRewrite: {
          "^/sso": "/sso"
        }
      }
    }
  },
};

module.exports = vueConfig;
