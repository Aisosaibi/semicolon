// Originally: class-tasks/Day 2/JavaScript/Level 1/TaskNine.js
const prompt = require('prompt-sync')();

let price = Number(prompt("Enter price: "));
const finalPrice = price * 1.10;

console.log("Price (+10% VAT): %f", finalPrice);
