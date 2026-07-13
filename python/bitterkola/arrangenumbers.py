first_number = int(input("Input first number: "))
second_number = int(input("Input second number: "))
third_number = int(input("Input third number: "))

largest, second_largest, third_largest = sorted(
    [first_number, second_number, third_number], reverse=True
)

print("%d > %d > %d" % (largest, second_largest, third_largest))
