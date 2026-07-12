amount = float(input("Enter amount: "))

if amount < 300000:
    print("No tax accrued!")
elif amount < 600000:
    tax = amount * (15 / 100.0)
    print("Tax to be paid: %.2f" % tax)
else:
    tax = amount * (25 / 100.0)
    print("Tax to be paid: %.2f" % tax)
