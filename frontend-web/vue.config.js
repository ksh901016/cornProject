module.exports = {
  devServer: {
    https: false,
    port: 9090,
    host: "www.cornsworld.com",
    proxy: {
      "/api": {
        target: "www.cornsworld.com:8080",
        ws: true,
        changeOrigin: true
      }
    }
  }
};