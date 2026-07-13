const prompt = require('prompt-sync')();

let price = Number(prompt("Enter price: "));
const finalPrice = price * 1.10;

console.log("Price (+10% VAT): %f", finalPrice);
