penta_digit = int(input("Input a five digit number: "))

digit1 = penta_digit // 10000
digit5 = penta_digit % 10
total = digit1 + digit5

# BUG: First printf has an unclosed string — missing closing quote before the closing paren.
# BUG: `sum` is a Python built-in; renamed to `total`.
# BUG: The commented-out alternative has a copy-paste bug: both lines use charAt(0) — digit5 should use charAt(4).
print("Total is %d" % total)
