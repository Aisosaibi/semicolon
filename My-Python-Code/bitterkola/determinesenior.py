import datetime

birth_year = int(input("Enter birth year: "))
current_year = datetime.date.today().year
age = current_year - birth_year

if age < 65:
    print("Not eligible for senior citizen discount.")
else:
    print("Eligible for senior citizen discount.")
