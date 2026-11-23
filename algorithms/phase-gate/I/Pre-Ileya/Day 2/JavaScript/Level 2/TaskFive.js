const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter number: "));
let numberTwo = Number(prompt("Enter number: "));
let numberThree = Number(prompt("Enter number: "));

let largestNumber = numberOne;

if (largestNumber < numberTwo) largestNumber = numberTwo;
else if (largestNumber < numberThree) largestNumber = numberThree;

console.log("Largest number is", largestNumber);
