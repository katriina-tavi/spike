const vueConfig = {

  devServer: {
    port: 8087,
    proxy: {
      "/api": {
        target: 'http://localhost:9080',
        ws: false,
        changeOrigin: true,
        // logLevel: 'debug',
        pathRewrite: {
          "^/api": "/api"
        }
      }
    }
  },
};

module.exports = vueConfig;
