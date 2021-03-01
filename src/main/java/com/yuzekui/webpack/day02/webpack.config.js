/*
loader:1.下载 2.使用(配置loader)
pligins:1.下载 2.引入 3.使用
* */

const {resolve}= require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: './data-structures/src/main/java/com/yuzekui/webpack/day02',
    output: {
        filename:'built.js',
        path: resolve(__dirname,'build')
    },
    module: {
        rules:[
            //loader的配置
        ],
    },
    plugins: [
        // plugins的配置
        // html-webpack-plugins
        //功能:默认会创建一个空的HTML,并自动引入打包输出的所有资源（JS/CSS）
        // 需求：需要有结构的HTML文件
        new HtmlWebpackPlugin({
            //template 相当于模板把 webpack全部打包好的资源放到我们指定的index模板当中
            template: './data-structures/src/main/java/com/yuzekui/webpack/day02/index.html'
        }),
    ],

    mode: 'development'
}
