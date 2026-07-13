number_one = int(input("Enter number: ")
number_two = int(input("Enter number: ")
numberThree = int(input("Enter number: ")

largest_number = number_one

if number_two > largest_number: largest_number = number_two
elif largest_number < number_three: largest_number = number_three

print(largest_number)
