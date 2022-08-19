const path = require("path");

module.exports = {
  devServer: {
    proxy: {
      '/vue': {
        target: 'http://localhost:9000',
        changeOrigin: true,
      },
    }
  },
  indexPath: '../../templates/vue/index.html',
  publicPath: '/vue',
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static/vue")
}