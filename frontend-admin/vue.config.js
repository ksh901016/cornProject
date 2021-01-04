module.exports = {
  devServer: {
    https: false,
    port: 9090,
    host: "cornsworld.com",
    proxy: {
      "/api": {
        target: "localhost:8080",
        ws: true,
        changeOrigin: true
      }
    }
  }
};