// Originally: class-tasks/Day 2/JavaScript/Level 1/TaskFive.js
const prompt = require('prompt-sync')();

let celsius = Number(prompt("Temperature in celsius: "));
const fahrenheit = 32 + 1.8 * celsius;
console.log("Temperature in Fahrenheit: %f degrees", fahrenheit);
