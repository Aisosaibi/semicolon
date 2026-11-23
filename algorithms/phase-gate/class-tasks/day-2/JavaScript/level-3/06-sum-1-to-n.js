// Originally: class-tasks/Day 2/JavaScript/Level 3/Task6.js
const prompt = require('prompt-sync')();

let number = Number(prompt("Enter number: "))

let sumN = 0;
for (index = number; index > 0; index--){
    sumN += index;
    }

console.log("Sum of all numbers fro 1 to", number, " =", sumN)
