function addBook(books, title){
    title = toTitleCase(title)
    if (books.includes(title)) return `'${title}' already exists!` //template literals
    books.push(title)
    return "Book added successfully"
}

function removeBook(books, title) {
    title = toTitleCase(title);
    if (books.includes(title)) {
        books.splice(books.indexOf(title), 1);
        return `'${title}' removed successfully!`;
    }
    else return "Book not found";
}

function updateBook(books, oldTitle, newTitle) {
    oldTitle = toTitleCase(oldTitle);
    newTitle = toTitleCase(newTitle);
    if (books.includes(oldTitle)) {
        let instance = books.indexOf(oldTitle);
        books[instance] = newTitle;
        return `Book title updated successfully to '${newTitle}'`;
    }
    else return "Book not found";
}
    
function suggestBook(books) {
    if (books.length > 0) {
        let randomBook = books[Math.floor(Math.random() * books.length)];
        let randomPage = Math.floor(Math.random() * 100) + 1;
        return { book: randomBook, page: randomPage };
    }
    else return "No books to suggest";
}

function showBooks(books) {
    if (books.length == 0) {
        return "No books available";
    }
    for (let i = 0; i < books.length; i++) {
        console.log(`${i + 1}. ${books[i]}`);
    }
    return books;
}

function toTitleCase(str) {
  let words = str.toLowerCase().split(' ');
  let result = [];

  for (let index = 0; index < words.length; index++) {
    let word = words[index];
    result.push(word.charAt(0).toUpperCase() + word.slice(1));
  }

  return result.join(' ');
}

//function toTitleCase(str) {
//  return str
//    .toLowerCase()
//    .split(' ')
//    .map(word => 
//      word.charAt(0).toUpperCase() +
//      word.slice(1)
//    )
//    .join(' ');
//}

module.exports = { addBook, removeBook, updateBook, suggestBook, showBooks };
