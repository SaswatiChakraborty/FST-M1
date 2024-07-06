def sum(numbers):
    sum = 0
    for number in numbers:
        sum +=number
    return sum

numberList =[10, 15, 23, 82]
total = sum(numberList)

print("The sum of all the elements is: " + str(total))