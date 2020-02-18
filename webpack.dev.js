const merge = require('webpack-merge');
const common = require('./webpack.common.js');

module.exports = merge(common, {
  mode: 'development',
  devtool: 'source-map',
  devServer: {
    contentBase: './dist',
    compress: true,
    port: 8000,
    allowedHosts: [
      'localhost:9001',
      '94.130.78.245:9001'
    ],
    stats: 'errors-only',
    clientLogLevel: 'error',
  },
});
