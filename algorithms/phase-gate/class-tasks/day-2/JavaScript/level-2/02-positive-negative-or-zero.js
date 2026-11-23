// Originally: class-tasks/Day 2/JavaScript/Level 2/TaskTwo.js
const prompt = require('prompt-sync')();

let number = Number(prompt("Enter number: "));
if (number > 0) console.log("Number is positive");
else if (number < 0) console.log("Number is negative");
else console.log("Number is zero");
