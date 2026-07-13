def get_card_type(number):
    digit_length = len(str(number))

    while number > 10:
        prefix = number = number // 10
        if prefix == 37:
            break

    match prefix:
        case 4:
            if 13 <= digit_length <= 16:
                card_type = "Visa"
        case 5:
            if 13 <= digit_length <= 16:
                card_type =  "Mastercard"
        case 37:
            if 13 <= digit_length <= 16:
                card_type = "American Express"
        case 6:
            if 13 <= digit_length <= 16:
                card_type = "Discover"
        case _:
            card_type = "Unknown"

    return card_type, digit_length

#    number_str = str(number)
#    prefix = int(number_str[0])       # first digit
#    prefix_2 = int(number_str[:2])    # first two digits
#    digit_length = len(number_str)
#
#    match prefix_2:
#        case 37 if 13 <= digit_length <= 16:
#            card_type = "American Express"
#        case _ if prefix == 4 and 13 <= digit_length <= 16:
#            card_type = "Visa"
#        case _ if prefix == 5 and 13 <= digit_length <= 16:
#            card_type = "Mastercard"
#        case _ if prefix == 6 and 13 <= digit_length <= 16:
#            card_type = "Discover"
#        case _:
#            card_type = "Unknown"


def is_valid(number):
    sum_a = 0
    sum_2b = 0
    count = 0
    
    while number > 0:
        if count % 2 == 0:
            to_sum_2b = (number % 10) * 2

            if to_sum_2b >= 10:
                sum_2b += (to_sum_2b // 10 + to_sum_2b % 10)
            else: sum_2b += to_sum_2b % 10

            number = number // 10

        else: 
            sum_a += (number % 10)
            number = number // 10
        count += 1

    sums = sum_2b + sum_a
    if sums % 10 == 0:
        return "Valid"
    else: return "Invalid"


def credit_card_validator():
    number = int(input("Hello. Kindly enter card details to verify:"))
    card_type, digit_length = get_card_type(number)
    validity_status = is_valid(number)

    print(f"\nCredit Card Type: {card_type}")
    print(f"Credit Card Number: {number}")
    print(f"Credit Card Digit Length: {digit_length}")
    print(f"Credit Card Validity Status: {validity_status}")

