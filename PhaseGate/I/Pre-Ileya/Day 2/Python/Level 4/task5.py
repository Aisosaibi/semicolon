def is_prime(number):
    if number < 0:
        return "Input positive numbers"
    elif number == 1:
        return "1 is not considered a prime number"
    elif number == 2 or number == 3:
        return "Prime number"
    else:
        for index in range (number):
            if number % index == 0:
                return "Not a prime number"
        return "Prime number"
