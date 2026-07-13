minutes = int(input("Enter minutes: "))

if minutes >= 60:
    hours = minutes // 60
    minutes = minutes % 60
    if hours >= 24:
        days = hours // 24
        hours = hours % 24
        print("Total time: %d days, %d hours and %d minutes" % (days, hours, minutes))
    else:
        print("Total time: %d hours and %d minutes" % (hours, minutes))
else:
    print("Total time: %d minutes" % minutes)
