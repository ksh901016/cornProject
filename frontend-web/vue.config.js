module.exports = {
  devServer: {
    https: false,
    port: 9090,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        ws: true,
        changeOrigin: true
      }
    }
  }
};