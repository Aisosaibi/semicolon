//condition ? "value if true" : "value if false"

let prompt = require("prompt-sync")()
let isLoggedIn = prompt("Enter 0/1: ")

let message = isLoggedIn == 0 ? "Welcome back!" : "Please log in"
console.log(message)
