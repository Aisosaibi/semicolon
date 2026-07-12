const student = {name: "Amaka", score: 75}

if (student.score > 90){
    message = "A"
} else if (student.score >= 80 && student.score < 90){
    message = "B"
} else if (student.score >= 70 && student.score < 79){
    message = "C"
} else message = "F"

console.log(message)
