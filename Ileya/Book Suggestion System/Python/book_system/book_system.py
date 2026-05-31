import random

def add_book(books, title):
    title = title.title()
    if title in books:
        return f"'{title}' already exists!"
    books.append(title)
    return "Book added successfully"

def remove_book(books, title):
    title = title.title()
    if title in books:
        books.remove(title)
        return f"'{title}' removed successfully!"
    else:
        return "Book not found"

def update_book(books, old_title, new_title):
    old_title = old_title.title()
    new_title = new_title.title()
    if old_title in books:
        instance = books.index(old_title)
        books[instance] = new_title
        return f"Book title updated successfully to '{new_title}'"
    else:
        return "Book not found"
    
def suggest_book(books):
#    random_book = books[(random.randint(1, len(books)) - 1)]
    if len(books) > 0:
        random_book = random.choice(books)
        random_page = random.randint(1, 100)
        return random_book, random_page
    else:
        return "No books to suggest"

def show_books(books):
    if len(books) == 0:
        return "No books available"
    for index, book in enumerate(books, start=1):
        print(f"{index}. {book}")
    return books
