// let a : object
// a = {}
// a = function f() {
//
// }
// object js中范围太广，不宜直接对变量使用

// let b : {name: string}
// b = {name : '天天'}


//变量名后面添加? 代表这个变量可以加 也可以不加
// let b : {name: string, age? : number}
// b = {name : '天天'}

// [xx : string]: any         表示任意类型的属性
//       |        |
//     字符串  ： any
// let c : {name: string , [propName : string] : any}
// c = {name : '猪八戒',age : 18 , sex : 1};


// let d : (a: number , b: number) => number

// 字符串数组
// let t : string[]
// let ar : Array<string>
// 数值数组
// let tt : number[]
// let arr : Array<number>


// TypeScript 新类型
// 元组
// let h : [string , string]
// h = ['aaaaa','ssssss']


// enum 枚举
// enum Gender{
//     Male,
//     Female
// }
// let i : { name : string , gender : Gender}
// i = {name : '拉拉',gender : Gender.Male}
// console.log(i.gender === Gender.Male)


// 创建类型别名
type  myType = 1|2|3|4|5;

let K : myType;
// let s : myType;
// let t : myType;

K : 6
console.log(K);