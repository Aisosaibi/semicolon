weight = float(input("Weight (kg): "))
height = float(input("Height (m): "))

import math
bmi = weight / math.pow(height, 2)

if bmi < 18.5:
    print("Underweight (<18.5)")
elif bmi <= 24.9:
    print("Normal (18.5 - 24.9)")
else:
    print("Overweight (>24.9)")
