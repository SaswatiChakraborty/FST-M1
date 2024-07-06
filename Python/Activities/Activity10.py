numTuple = tuple(input("Enter value : ").split(","))

print(numTuple)

for num in numTuple:
    num1=int(num)
    if(num1%5==0):
        print(num)