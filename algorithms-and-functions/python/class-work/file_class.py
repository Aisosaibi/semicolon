import json as js

database = {
    1:{
        "name": "Mustafa",
        "email": "mustafalo@gmail.com",
        "password": "mustyou",
        "dob": "02/1/1978"
    },

    2:{
        "name": "Nkiruka",
        "email": "facilinkiruka@gmail.com",
        "password": "nkiri",
        "dob": "02/1/1880"
    },

    3:{
        "name": "Rukayat",
        "email": "ruka@yahoo.com",
        "password": "rukky",
        "dob": "02/1/2000"
    }
}

data = {
    "name": "Nkiruka",
    "email": "facilinkiruka@gmail.com",
    "password": "",
    "dob": "02/1/1880"
    }

with open("userDB.json", "w") as outfile:
    js.dump(database, outfile, indent=4)

with open("userDB.json", "r") as infile:
    users = js.load(infile)

print()
for key, value in users.items():
    print(key + ":", value)

print(type(users))
formatted_dictionary = js.dumps(users)

print(formatted_dictionary)
print(type(formatted_dictionary))

formatted_dictionary = js.loads(formatted_dictionary)
print(type(formatted_dictionary))
# with open("userDB.json", "a+") as db_file:
#     js.dump(database, db_file, indent=4)
#     users = js.load(db_file)

    # print(db_file.tell())
    # print(db_file.seek(5))
    # print(db_file.tell())
#

# with open("userDB.json", "r") as db_file:
#     users = js.load(db_file)

# print()
# for user in users:
#     for key, value in user.items():
#         print(key, ":", value)
#     print()

# with open("userDB.json", "a") as db_file:
#     js.dump(database, db_file, indent=4)

    # print(db_file.tell())
    # print(db_file.seek(db_file.tell() - 2))
    # print(db_file.tell())

# users = js.load(db_file)
# print()
# for user in users:
#     for key, value in user.items():
#         print(key, ":", value)
#     print()

