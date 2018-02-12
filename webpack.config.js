require('babel-core/register'); // development.jsでES6を使えるようにする
//module.exports = require('./development');

//const src  = __dirname.resolve(__dirname, 'src')
//const dist = __dirname.resolve(__dirname, 'dist')

module.exports = {
  entry: __dirname + "/src/main/js/App.js",
  output: {
	  path: __dirname + "/src/main/resources/static",
	  filename: 'bundle.js'
  },
  devtool: 'inline-source-map',
	  module: {
      loaders: [
         {
           test: /\.(js|jsx)$/,
           loader: 'babel-loader',
           exclude: /node_modules/,
           query: {
             presets: ["es2015", "react"],
           }
         },
         {
           test: /\.css$/,
           loaders: ['style', 'css?modules'],
         }
      ]
  },



  plugins: []
};

//module.exports = {
//		  entry: __dirname + "/src/main/js/App.js",
//		  output: {
//		    path: __dirname + "/dist",
//		    filename: "bundle.js"
//		  },
//		  module: {
//			    loaders: [
//			      {test: /\.js$/, loader: "babel-loader"}
//			    ]
//			  }
//		};