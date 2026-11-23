const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter first number: "))
let numberTwo = Number(prompt("Enter second number: "))
let numberThree = Number(prompt("Enter third number: "))
let numberFour = Number(prompt("Enter fourth number: "))
let numberFive = Number(prompt("Enter fifth number: "))

let sumN = numberOne + numberTwo + numberThree + numberFour + numberFive

console.log("Sum:" sumN)
