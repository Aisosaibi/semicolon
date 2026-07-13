"""
PSEUDOCODE FOR PASSWORDSTRENGTH DETERMINER:

Prompt user for password
Find out the length of password
If length is > 8: 
    if length < 16: Output "Strong"
    else: Output "Very strong"

(I chose this because it encapsulates the if statements by putting all scenarios where 8 is above 8 such that I can refrain from using the and keyword)

Else if length < 8: Output "Very weak"

Else: "Weak" 
(The only scenario that falls into this scenario is where length is exactly 8, as we've covered for greater than 9')

"""


password = input("Enter password: ")
password_length = len(password)

if password_length > 8:
    if password_length < 16:
        print("Strong password!")
    else:
        print("Very strong password!")

elif password_length < 8:
    print("Very weak password")

else:
    print("Weak password")
