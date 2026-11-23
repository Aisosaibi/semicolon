number_one = float(input("Enter first number (e.g. '1.0'): "))
number_two = float(input("Enter second number (e.g. '1.0'): "))
number_three = float(input("Enter third number (e.g. '1.0'): "))

largest_number = 0
second_largest_number = 0
third_largest_number = 0

if number_one > number_two:
    largest_number = number_one
    second_largest_number = number_two

else:
    largest_number = number_two
    second_largest_number = number_one

if number_three > largest_number:
    third_largest_number = second_largest_number
    second_largest_number = largest_number
    largest_number = number_three
    
elif number_three > second_largest_number:
    third_largest_number = second_largest_number
    second_largest_number = number_three

else:
    third_largest_number = number_three

print(largest_number, " > ", second_largest_number, " > ", third_largest_number)


#number_one = float(input("Enter first number (e.g. '1.0'): "))
#number_two = float(input("Enter second number (e.g. '1.0'): "))
#number_three = float(input("Enter third number (e.g. '1.0'): "))
#
#largest_number = 0
#second_largest_number = 0
#third_largest_number = 0
#
#if number_one > number_two:
#    largest_number = number_one
#    second_largest_number = number_two
#
#else:
#    largest_number = number_two
#    second_largest_number = number_one
#
#if number_three > second_largest_number:
#    if number_three > largest_number:
#        third_largest_number = second_largest_number
#        second_largest_number = largest_number
#        largest_number = number_three
#    else:
#        third_largest_number = second_largest_number
#        second_largest_number = number_three
#        largest_number = largest_number
#else:
#    third_largest_number = number_three
#
#print(largest_number, " > ", second_largest_number, " > ", third_largest_number)
