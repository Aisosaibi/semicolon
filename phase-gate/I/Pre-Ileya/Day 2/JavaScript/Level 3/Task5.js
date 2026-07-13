const prompt = require('prompt-sync')();

let number = Number(prompt("Enter number: "))

let factorial = 0;
for (index = number - 1; index > 0; index--){
    factorial += number * index;
    }

console.log("Factorial of", number, " =", factorial)
