const prompt = require('prompt-sync')();

let radius = Number(prompt("Enter radius: "));
const circum = 2 * Math.PI * radius;

console.log("Circumference: %f", circum);
