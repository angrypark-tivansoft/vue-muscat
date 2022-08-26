const path = require("path");

module.exports = {
  devServer: {
    proxy: {
      '/vue': {
        target: 'http://localhost:9000',
        changeOrigin: true,
        ws:true
      }
    }
  },

}

