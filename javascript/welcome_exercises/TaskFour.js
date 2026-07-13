const product = {price: 1200, inStock: true}

//if (product[inStock] == false){
//    return "Out of stock"
//} else if (product[price] > 1000){
//    return "Expensive"
//} else return "Affordable"


//const product = {price: 1200, inStock: true}
//
//if (product.inStock == false){
//    let message = "Out of stock"
//    return message
//} else if (product.price > 1000){
//    message = "Expensive"
//    return message
//} else message = "Affordable"
//    return message
//    
//console.log(message)

if (product.inStock == false){
    let message = "Out of stock"
    console.log(message)
} else if (product.price > 1000){
    message = "Expensive"
    console.log(message)
} else {message = "Affordable"
    console.log(message)}
