total_purchases = int(input("Total spending: "))

if total_purchases > 1000 and total_purchases < 10000:
    total_purchases = (1 - 0.05) * total_purchases
    print(f"Your discounted price is {total_purchases}")

elif total_purchases > 10000 and total_purchases < 50000:
    total_purchases = (1 - 0.10) * total_purchases
    print(f"Your discounted price is {total_purchases}")

elif total_purchases > 50000:
    total_purchases = (1 - 0.20) * total_purchases
    print(f"Your discounted price is {total_purchases}")
