numList = list(input("Enter value : ").split(","))

print(numList)
num1 = int(numList[0])
num2 = int(numList[-1])

print(num1)
print(num2)

if(int(numList[0])==int(numList[-1])):
    print(True)
else:
    print(False)