numList = list(input("Enter value : ").split(","))

print(numList)

sum = 0

for num in numList:
    sum+=int(num)

print(sum)