const prompt = require('prompt-sync')();

let name = String(prompt("What's your name? "));

console.log("Hello, %s", name);
