const personal = {name: "Ngozi", age: 25}
const professional = {role: "Developer", company: "Semicolon"}

const profile = {...personal, ...professional}
console.log(profile)
