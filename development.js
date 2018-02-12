//import path from 'path';

const src  = __dirname.resolve(__dirname, 'src')
const dist = __dirname.resolve(__dirname, 'dist')

export default {
  entry: src + '/index.jsx',

  output: {
    path: dist,
    filename: 'bundle.js'
  },

  module: {
    loaders: [
      {
        test: /\.jsx$/,
        exclude: /node_modules/,
        loader: 'babel'
      }
    ]
  },

  resolve: {
    extensions: ['', '.js']
  },

  plugins: []
}