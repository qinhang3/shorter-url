var path = require('path');

var config = {
    entry: './js/main.js',
    output: {
        path:'./static',
        filename: 'index.js',
    },
    devServer: {
        inline: true,
        port: 7777
    },
    module: {
        loaders: [
            {
                test: /.jsx?$/,
                exclude: /node_modules/,
                loader: 'babel',
                query: {
                    presets: ['es2015', 'react']
                }
            },
            {
                test : /\.css$/,
                loader: 'style!css'
            },
            {
                test: /\.(png|jpg)$/,
                loader: 'url-loader?limit=819200'
                // loader: 'file-loader'
            }
        ]
    }
}

module.exports = config;
