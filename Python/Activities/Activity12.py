# Calculate the sum of numbers

def sum(n):
    if n <= 1:
        return n
    else:
        return n + sum(n-1)
num = 10
print("The sum is: ", sum(num))