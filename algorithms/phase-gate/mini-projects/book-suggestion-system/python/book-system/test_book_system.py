import unittest
from book_system import add_book, remove_book, update_book, suggest_book, show_books
#from book_system import *

class Test_Book_System(unittest.TestCase):
    def test_add_new_book(self):
        books = []
        result = add_book(books, "Animal Farm")
        self.assertEqual("Book added successfully", result)
        self.assertIn("Animal Farm", books)

    def test_add_new_book_handles_duplicates(self):
        books = ["Animal Farm"]
        result = add_book(books, "Animal Farm")
        self.assertEqual("'Animal Farm' already exists", result)

    def test_add_new_book_handles_case(self):
        books = []
        result = add_book(books, "animal faRm")
        self.assertEqual("Book added successfully", result)
        self.assertIn("Animal Farm", books)

    def test_add_duplicate_book(self):
        books = ["Animal Farm"]
        result = add_book(books, "Animal Farm")
        self.assertEqual(len(books), 1)
        self.assertEqual("'Animal Farm' already exists!", result)

    def test_add_book_handles_case_in_checking_duplicates(self):
        books = ["Animal Farm"]
        result = add_book(books, "anImal fArm")
        self.assertEqual(len(books), 1)
        self.assertEqual("'Animal Farm' already exists!", result)

    def test_remove_book_in_books(self):
        books = ["The Hobbit", "Animal Farm"]
        result = remove_book(books, "Animal Farm")
        self.assertEqual(len(books), 1)
        self.assertNotIn("Animal Farm", books)
        self.assertEqual("'Animal Farm' removed successfully!", result)

    def test_remove_book_in_books_handles_case(self):
        books = ["The Hobbit", "Animal Farm"]
        result = remove_book(books, "anIMal farM")
        self.assertEqual(len(books), 1)
        self.assertNotIn("Animal Farm", books)
        self.assertEqual("'Animal Farm' removed successfully!", result)

    def test_remove_book_not_in_books(self):
        books = ["The Hobbit"]
        result = remove_book(books, "Animal Farm")
        self.assertEqual(len(books), 1)
        self.assertEqual("Book not found", result)

    def test_update_book_titles_in_books(self):
        books = ["The Hobbit", "Animal Farm"]
        result = update_book(books, "Animal Farm", "Farm House")
        self.assertIn("Farm House", books)
        self.assertNotIn("Animal Farm", books)
        self.assertEqual("Book title updated successfully to 'Farm House'", result)

    def test_update_book_titles_in_books_handles_case(self):
        books = ["The Hobbit", "Animal Farm"]
        result = update_book(books, "animal FARm", "Farm hOuse")
        self.assertIn("Farm House", books)
        self.assertNotIn("Animal Farm", books)
        self.assertEqual("Book title updated successfully to 'Farm House'", result)

    def test_update_book_titles_not_in_books(self):
        books = ["The Hobbit", "Animal Farm"]
        result = update_book(books, "Animals", "Farm House")
        self.assertNotIn("Farm House", books)
        self.assertEqual("Book not found", result)

    def test_suggest_book_returns_title_and_page_less_than_100_if_len_books_greater_than_zero(self):
        books = ["The Hobbit", "Animal Farm"]
        for index in range(10_000):
            book, page = suggest_book(books)
            self.assertIn(book, books)
            self.assertTrue(1 <= page <= 100)

    def test_suggest_book_returns_no_books_to_suggest_if_len_books_not_greater_than_zero(self):
        books = ["The Hobbit", "Animal Farm"]
        result = suggest_book(books)
        self.assertEqual("No books to suggest", result)

    def test_show_books(self):
        books = ["The Hobbit", "Animal Farm"]
        result = show_books(books)
        self.assertEqual(["The Hobbit", "Animal Farm"], result)

    def test_show_books_empty(self):
        books = []
        result = show_books(books)
        self.assertEqual("No books available", result)

#    def setUp(self):
#        self.books = ["The Hobbit", "Animal Farm"]


if __name__ == "__main__":
    unittest.main()
