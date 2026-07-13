const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter numberOne: "));
let numberTwo = Number(prompt("Enter numberTwo: "));
let numberThree = Number(prompt("Enter numberThree: "));
let COUNT = 3;

const sum = numberOne + numberTwo + numberThree;
const avg = sum/COUNT;

console.log("Average:", avg);
