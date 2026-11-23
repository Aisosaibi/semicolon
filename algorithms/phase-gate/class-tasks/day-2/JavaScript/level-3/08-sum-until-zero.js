// Originally: class-tasks/Day 2/JavaScript/Level 3/Task8.js
const prompt = require('prompt-sync')();

let sum = 0;
let entry = Number(prompt("Enter number: "))
while (entry != 0){
    sum += entry;
    console.log("Enter another number: ");
    entry = scanner.nextInt();
}

console.log("Sum total =", sum);
