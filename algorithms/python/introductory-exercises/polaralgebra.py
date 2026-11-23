number1 = int(input("Input first digit: "))
number2 = int(input("Input second digit: "))

if number1 >= 0 and number2 >= 0:
    print(number1 + number2)
elif number1 < 0 and number2 < 0:
    print(number1 * number2)
elif number1 >= 0 and number2 < 0:
    print(number1 - number2)
else:
    print(number2 - number1)
