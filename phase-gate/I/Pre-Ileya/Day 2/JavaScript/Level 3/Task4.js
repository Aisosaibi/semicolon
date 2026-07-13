const prompt = require('prompt-sync')();

let number = Number(prompt("Enter number: "))

for (num = 1; num <= 12; num++){
    console.log(number, "*", num, "=", number * num)
    }
