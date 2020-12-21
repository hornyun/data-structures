// 引入fs模块
const fs = require('fs');

// 2.调用方法读取文件
fs.readFile('./data-structures/src/main/java/com/yuzekui/ES6_ES11/day03/文章.text', () => {
    //如果失败,则抛出错误
    if (err) throw err;
    //如果没有错误，则输出内容
    console.log(data.toString())
});
