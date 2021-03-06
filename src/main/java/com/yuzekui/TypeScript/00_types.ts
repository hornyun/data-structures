let b : '张三'| '李四'

b = '张三'
//any 就是任何类型都可以
// let a : any
// let a

// let s : string
// s = number

// unknown
let  s : unknown
s = 'sss'
s = true


// 类型断言，可以用来告诉解析器变量实际类型
//格式：变量 as 类型
// 告诉计算机 这个变量是什么类型，以免有些情况计算机不能区分这是 变量类型的情况


function f(): void {
}
// void 表示没有返回值


function f1(): never {
 throw new Error("信息错误")
}
// never表示永远不会返回结果  用于报错，立刻终止程序，不需要返回值的情况。