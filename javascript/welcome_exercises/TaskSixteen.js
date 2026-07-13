const prompt = require("prompt-sync")()

let age = Number(prompt("Enter age: "))
let country = String((prompt("Enter country: ")))

const user = {age: age, country: country}

let message

if (user.age >= 18 && user.country == "Nigeria"){
    message = "Welcome!"
    console.log(message)
} else {
    message = "Access denied!"
    console.log(message)
}
