const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter first number: "));
let numberTwo = Number(prompt("Enter second number: "));

const sum = numberOne + numberTwo;

console.log("Sum:", sum);
