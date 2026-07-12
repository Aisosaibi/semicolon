//const prompt = require("prompt-sync");
//const collectInput = prompt();
//const input = collectInput("What is your age? ");

//const promptSync = require("prompt-sync")
//const prompt = promptSync()
//const input = prompt("What is your age? ")

const prompt = require("prompt-sync")()

let age = prompt("What is your age? ")
let isValid = true

console.log()

if (age || isValid){console.log("login")}

//if (age > 0 && age < 12) {
//    console.log("I am a child")
//} else if(age > 0 && age < 18) {
//    console.log("Teenager")
//} else if (age > 0 && age >= 18) {
//    console.log("Adult")
//} else {
//    console.log("Invalid age")
//}

