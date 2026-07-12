from datetime import datetime

def get_items():
    customer = input("\nWhat is the customer's name?\n")
    
    items = []
    decision = "init"

    while decision.lower() != "done":
        item = input("What did the user buy?\n")
        quantity = int(input("How many pieces?\n"))
        unit_price = float(input("How much per unit?\n"))

        items.append({"item": item, "price": unit_price, "quantity": quantity})
    
        decision = input("Add more items? (type 'done' to stop): ")        
        
    cashier = input("Cashier in station: ")

    return cashier, customer, items


def compute_total(items):
    sum_unit_total = []

    for item in items:
        unit_total = item["price"] * item["quantity"]
        sum_unit_total.append(unit_total)

    subtotal = 0
    for price in sum_unit_total:
        subtotal += price

    discount = 0.08 * subtotal
    vat = 0.175 * subtotal

    bill_total = subtotal - discount + vat
    totals = [subtotal, discount, vat, bill_total]

    return totals


def print_receipt(cashier, customer, items, totals, amount_paid, balance):
    date = datetime.now().strftime("%d-%b-%y %I:%M:%S %p")
    print(f"""
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
Date: {date}
Cashier: {cashier}
Customer Name: {customer}
=================================================
\tITEM\t\tQTY\tPRICE\tTOTAL(NGN)
-------------------------------------------------
""")
    for item in items:
        print(f"{item['item']:>20}{item['quantity']:>6}{item['price']:>10.2f}{item['price'] * item['quantity']:>12.2f}")
    print("-------------------------------------------------")
    print(f"{'Sub Total:':>30}{totals[0]:>18.2f}")
    print(f"{'Discount:':>30}{totals[1]:>18.2f}")
    print(f"{'VAT @ 17.50%:':>30}{totals[2]:>18.2f}")
    print("=================================================")
    print(f"{'Bill Total:':>30}{totals[3]:>18.2f}")
    print(f"{'Amount Paid:':>30}{amount_paid:>18.2f}")
    print(f"{'Balance:':>30}: {balance:>18.2f}")
    print("=================================================")
    print("         THANK YOU FOR YOUR PATRONAGE            ")
    print("=================================================")

def checkout():
    cashier, customer, items = get_items()
    totals = compute_total(items)
    amount_paid = float(input("How much did the customer give you?\n"))
    balance = amount_paid - totals[3]
    print_receipt(cashier, customer, items, totals, amount_paid, balance)

checkout()


#For studying...
#def print_receipt(cashier, customer, items, totals, amount_paid, balance):
#    date = datetime.now().strftime("%d-%b-%y %I:%M:%S %p")
#    print(f"""SEMICOLON STORES
#MAIN BRANCH
#LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
#TEL: 03293828343
#Date: {date}
#Cashier: {cashier}
#Customer Name: {customer}""")
#    print("=" * 50)
#    print(f"{'ITEM':>18}{'QTY':>6}{'PRICE':>10}{'TOTAL(NGN)':>12}")
#    print("-" * 50)
#    for item in items:
#        print(f"{item['item']:>18}{item['quantity']:>6}{item['price']:>10.2f}{item['price'] * item['quantity']:>12.2f}")
#    print("-" * 50)
#    print(f"{'Sub Total:':>30}{totals[0]:>18.2f}")
#    print(f"{'Discount:':>30}{totals[1]:>18.2f}")
#    print(f"{'VAT @ 17.50%:':>30}{totals[2]:>18.2f}")
#    print("=" * 50)
#    print(f"{'Bill Total:':>30}{totals[3]:>18.2f}")
#    print(f"{'Amount Paid:':>30}{amount_paid:>18.2f}")
#    print(f"{'Balance:':>30}{balance:>18.2f}")
#    print("=" * 50)
#    print(f"{'THANK YOU FOR YOUR PATRONAGE':^50}")
#    print("=" * 50)
