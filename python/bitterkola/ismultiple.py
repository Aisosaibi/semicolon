multiple = int(input("Input first digit: "))
factor = int(input("Input second digit: "))

if multiple % factor == 0:
    print("%d is a multiple of %d" % (multiple, factor))
else:
    print("%d is not a multiple of %d" % (multiple, factor))

