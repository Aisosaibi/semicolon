const prompt = require("prompt-sync")()
let username = String(prompt("Enter username: "))
let password = String(prompt("Enter password: "))

const login = {username: username, password: password}

let message

if (login.username == "admin" && login.password == "1234"){
    message = "Login success"
    console.log(message)
} else {
    message = "Invalid credentials"
    console.log(message)
}
