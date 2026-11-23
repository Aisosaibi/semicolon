const prompt = require('prompt-sync')();

let numberOne = Number(prompt("Enter number: "));
let numberTwo = Number(prompt("Enter number: "));
if (numberOne > numberTwo) console.log("Largest number is", numberOne);
else if (numberOne < numberTwo) console.log("Largest number is", numberTwo);
else console.log("Both numbers are equal");
