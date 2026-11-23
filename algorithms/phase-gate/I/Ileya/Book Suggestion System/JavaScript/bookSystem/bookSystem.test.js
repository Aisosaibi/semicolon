const { addBook, removeBook, updateBook, suggestBook, showBooks } = require('./bookSystem');

test("adds book title 'Animal Farm' to book list", () => {
    const books = [];
    const title = "Animal Farm";
    const result = addBook(books, title);
    expect(result).toBe("Book added successfully");
    expect(books).toContain(title);
});

test("add book handles duplicate book 'Animal Farm' in book list", () => {
    const books = ["Animal Farm"];
    const title = "Animal Farm";
    const result = addBook(books, title);
    expect(result).toEqual("'Animal Farm' already exists!");
    expect(books).toContain(title);
});

test("add book handles case 'AnIMAl Farm' in book list", () => {
    const books = ["Animal Farm"];
    const title = "AnIMAl Farm";
    const result = addBook(books, title);
    expect(result).toEqual("'Animal Farm' already exists!");
});

test("remove book title 'Animal Farm' from book list", () => {
    const books = ["Animal Farm", "Harry Potter"];
    const title = "Animal Farm";
    const result = removeBook(books, title);
    expect(result).toBe("'Animal Farm' removed successfully!");
    expect(books).not.toContain(title);
});

test("remove book handles case 'AnIMAL Farm' from book list", () => {
    const books = ["Animal Farm", "Harry Potter"];
    const title = "AnIMAL farm";
    const result = removeBook(books, title);
    expect(result).toBe("'Animal Farm' removed successfully!");
    expect(books).not.toContain(title);
});

test("remove book title not found in book list", () => {
    const books = ["Animal Farm, Harry Potter"];
    const title = "Lord of The Rings";
    const result = removeBook(books, title);
    expect(result).toBe("Book not found");
    expect(books).not.toContain(title);
});

test("update book title 'Animal Farm' in books to 'Farm House'", () => {
    const books = ["Animal Farm", "Harry Potter", "Lord of the Rings"];
    const oldTitle = "Animal Farm";
    const newTitle = "Farm House";
    const result = updateBook(books, oldTitle, newTitle);
    expect(result).toBe("Book title updated successfully to 'Farm House'")
    expect(books).toContain("Farm House");
    expect(books).not.toContain("Animal Farm");
});

test("update book title not in books", () => {
    const books = ["Animal Farm", "Harry Potter", "Lord of the Rings"];
    const oldTitle = "Chronicles of Narnia";
    const newTitle = "Aslan's tale";
    const result = updateBook(books, oldTitle, newTitle);
    expect(result).toBe("Book not found")
    expect(books).not.toContain("Aslan's tale");
});

test("suggest book title in books and a page less than 100 if book titles are in books", () => {
    const books = ["Animal Farm", "Harry Potter", "Lord of the Rings"];
    for (let index = 0; index < 10_000; index++){
        const result = suggestBook(books);
        const randomBook = result.book;
        const randomPage = result.page;
        expect(books).toContain(randomBook);
        expect(randomPage).not.toBe(1 <= randomPage <= 100);
    }
});

test("suggest no book title in books and page if no book titles are in books", () => {
    const books = [];
    for (let index = 0; index < 10_000; index++){
        const result = suggestBook(books);
        expect(result).toBe("No books to suggest");
    }
});

test("show all book titles if book titles are in books", () => {
    const books = ["Animal Farm", "Harry Potter", "Lord of the Rings"];
    const result = showBooks(books);
//    expect(result).toBe("1. Animal Farm\n2.Harry Potter\n3.Lord of the Rings");
    expect(result).toEqual(["Animal Farm", "Harry Potter", "Lord of the Rings"]);
});

test("show no book titles if no book titles are in books", () => {
    const books = [];
    const result = showBooks(books);
    expect(result).toBe("No books available");
});
