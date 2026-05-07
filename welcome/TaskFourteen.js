const prompt = require("prompt-sync")()

let points = Number(prompt("Enter score: "))
const user = {points: points}

let message = user.points >= 100 ? "Gold" : "Silver"
console.log(message)
