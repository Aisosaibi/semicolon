const prompt = require('prompt-sync')();

let number = Number(prompt("Enter number: "));

let square = number ** 2;
console.log("%f squared is %f", number, square)
