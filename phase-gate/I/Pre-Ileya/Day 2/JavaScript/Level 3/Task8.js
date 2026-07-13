const prompt = require('prompt-sync')();

let sum = 0;
let entry = Number(prompt("Enter number: "))
while (entry != 0){
    sum += entry;
    console.log("Enter another number: ");
    entry = scanner.nextInt();
}

console.log("Sum total =", sum);
