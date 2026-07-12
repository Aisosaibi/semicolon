const prompt = require("prompt-sync")()
let number = Number(prompt("Enter number: "))

if (number < 0){
    console.log("%d is negative number", number)
} else if (number > 0){
    console.log("%d is positive number", number)
} else {
    console.log("Number is zero")
}  
