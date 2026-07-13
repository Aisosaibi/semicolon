"""
guess = 0
attempt = 0

while attempt < 5:
    guess = int(input("Guess the number: "))
    if (guess >= 100 and guess < 0):
        if guess > correct_guess:
            attempt += 1
            print("Your guess was higher. Try again.")
        elif guess < correct_guess:
            attempt += 1
            print("Your guess was lower. Try again.")
        else:
            break


if attempt == 1:
    rating = "Legendary"
elif attempt == 2:
    rating == "Excellent"
elif attempt == 3:
    rating == "Good"
elif attempt == 5:
    rating == "Close!"
else:
    rating == "Better luck"
"""

import math
import random

correct_guess = math.floor(random.random() * 100)
