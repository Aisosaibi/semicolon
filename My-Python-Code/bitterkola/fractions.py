fraction = input("Input fraction (e.g. 3/4): ")

parts = fraction.split("/")
numerator = int(parts[0])
denominator = int(parts[1])
print("%.4f" % (numerator / denominator))
