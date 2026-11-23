PIN = 4278

passcode = int(input("Guess 4 digit pin: "))

if passcode == PIN:
    print("Valid pin!")
else:
    print("Invalid pin!")

