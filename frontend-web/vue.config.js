const path = require("path");
module.exports = {
  outputDir: path.resolve(__dirname, "./docker/dist"),
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