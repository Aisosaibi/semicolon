five_digit_number = input("Enter 5-digit number: ")

five_digit_number = int(five_digit_number)

first_digit = five_digit_number // 10000

second_digit = (five_digit_number // 1000) % 10

third_digit = (five_digit_number // 100) % 10

fourth_digit = (five_digit_number // 10) % 10

fifth_digit = five_digit_number % 10

print(first_digit, second_digit, third_digit, fourth_digit, fifth_digit)

'''
Alternatively, for second, third and fourth digit, you could use:
second_digit = (five_digit_number % 10000) // 1000
third_digit = (five_digit_number % 1000) // 100
fourth_digit = (five_digit_number % 100) // 10
'''
"""
Why is this outputing a tuple?

Python 3.12.3 (main, Mar  3 2026, 12:15:18) [GCC 13.3.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> five_digit_number = "12345"
>>> type(five_digit_number)
<class 'str'>
>>> five_digit_number = int(five_digit_number)
>>> type(five_digit_number)
<class 'int'>
>>> first_digit = five_digit_number // 10,000
>>> print(first_digit)
(1234, 0)
>>> type(first_digit)
<class 'tuple'>
"""
