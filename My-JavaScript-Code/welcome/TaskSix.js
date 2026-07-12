//const order = {status: "Pending"}
//
//if (order.status == "Pending"){
//    let message = "Processing"
//} else if (order.status == "Shipped"){
//    message = "Shipped"
//} else if (order.status == "Delivered"){
//    message = "Delivered"
//}
//
//console.log(message)

const order = {status: "Pending"}

let message

if (order.status == "Pending"){
    message = "Processing"
} else if (order.status == "Shipped"){
    message = "Shipped"
} else if (order.status == "Delivered"){
    message = "Delivered"
}

console.log(message)
