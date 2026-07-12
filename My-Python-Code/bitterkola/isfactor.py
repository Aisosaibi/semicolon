factor = int(input("Input first digit: "))
multiple = int(input("Input second digit: "))

if multiple % factor == 0:
    print("%d is a factor of %d" % (factor, multiple))
else:
    print("%d is not a factor of %d" % (factor, multiple))
