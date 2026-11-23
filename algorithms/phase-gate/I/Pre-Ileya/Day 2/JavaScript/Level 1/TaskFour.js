const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter first number: "));
let numberTwo = Number(prompt("Enter second number: "));

const product = numberOne * numberTwo;
console.log("Product of %f and %f is %f", numberOne, numberTwo, product);
