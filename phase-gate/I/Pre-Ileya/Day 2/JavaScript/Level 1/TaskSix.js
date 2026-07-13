const prompt = require('prompt-sync')();

let length = Number(prompt("Enter length: "));
let width = Number(prompt("Enter width: "));
const area = length * width;

console.log("Area: %f units squared", area);
