const account = {balance: 500, isBlocked: false}
let message

if (account.isBlocked == true){
    message = "Account blocked"
} else if (account.balance < 100) {
    message = "Low balance"
} else message = "OK"

console.log(message)
