fruits =	{
    "apple": 99,
    "orange": 75,
    "grapes": 65,
    "mango": 150
}
print(fruits)

keyCheck = input("Which fruit you are looking for? ").lower()

print(keyCheck)
if keyCheck in fruits:
    print("Fruit is available")
else:
    print("This fruit is not in stock")