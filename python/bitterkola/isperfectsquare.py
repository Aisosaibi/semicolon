number = int(input("Input number: "))

square_root = math.sqrt(number)
compare = int(square_root)
difference = square_root - compare

if difference == 0.0:
    print("Number is a perfect square")
else:
    print("Number is not a perfect square")
