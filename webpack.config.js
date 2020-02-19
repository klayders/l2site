const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
  mode: 'development',
  devtool: 'source-map',
  entry: path.join(__dirname, 'src', 'main', 'resources','static', 'js', 'main.js'),
  devServer: {
    contentBase: './dist',
    compress: true,
    port: 8000,
    allowedHosts: [
      'localhost:9000',
    ],
    stats: 'errors-only',
    clientLogLevel: 'error',
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ]
      },
      {
        test: /\.s(c|a)ss$/,
        use: [
          'vue-style-loader',
          'css-loader',
          {
            loader: 'sass-loader',
            options: {
              sassOptions: {
                indentedSyntax: true
              }
            }
          }
        ]
      },
      {
        test: /\.(eot|svg|ttf|woff|woff2)(\?\S*)?$/,
        loader: 'file-loader'
      },
      {
        test: /\.(jpeg|jpg|png|gif)$/,
        loader: 'file-loader'
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin()
  ],
  resolve: {
    extensions: ['*', '.js', '.vue', '.json'],
    modules: [
      path.join(__dirname, 'src', 'main', 'resources', 'js'),
      path.join(__dirname, 'node_modules'),
    ],
  }
}
