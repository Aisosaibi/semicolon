print("\n=== Exercise 3.1 — Validating User Input ===")
passes   = 0
failures = 0

while True:
    while True:
        try:
            result = int(input("Enter result (1=pass, 2=fail, -1 to stop): "))
        except ValueError:
            print("Please enter a number.")
            continue

        if result == -1:
            break
        elif result == 1 or result == 2:
                break
        else:
             print("Invalid input. Please enter 1 or 2.")

    if result == -1:
        break
    elif result == 1:
        passes += 1
    elif result == 2:
        failures += 1

print(f"\nPassed : {passes}")
print(f"Failed : {failures}")
