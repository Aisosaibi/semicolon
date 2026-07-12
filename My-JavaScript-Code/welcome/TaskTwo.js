const promptSync = require("prompt-sync")
const prompt = promptSync()

let name = prompt("Your name: ")
let age = prompt("Your age: ")
let course = prompt("Your course: ")

const student = {"Name": String(name), "Age": Number(age), "Course": String(course)}

console.log("\n")
console.log(student)
