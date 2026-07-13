const prompt = require('prompt-sync')();

let celsius = Number(prompt("Temperature in celsius: "));
const fahrenheit = 32 + 1.8 * celsius;
console.log("Temperature in Fahrenheit: %f degrees", fahrenheit);
