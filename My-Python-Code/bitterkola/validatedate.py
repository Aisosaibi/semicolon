date = input("Enter date (dd:mm:yy): ")

parts = date.split(":")
day = int(parts[0])
month = int(parts[1])
year = int(parts[2])

    print("Invalid date: adjust year!")
elif month > 12:
    print("Invalid date: confirm month!")
elif day > 28:
    if month == 2:
        print("Invalid date: confirm date!")
    elif month in (4, 6, 9, 11) and day > 30:
        print("Invalid date: confirm date!")
    elif day > 31:
        print("Invalid date: confirm day!")
