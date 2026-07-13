const prompt = require('prompt-sync')();

let age = Number(prompt("How old are you? "));

console.log("In five years, you will be %d", (age + 5));
