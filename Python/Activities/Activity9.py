list1 = [1,2,3,4,5,6]
print("list 1 ==> ",list1)

list2 = [7,8,9,10,11,12]
print("list 2 ==> ",list2)

list3 = []

for num in list1:
    if(num%2!=0):
        list3.append(num)


for num in list2:
    if(num%2==0):
        list3.append(num)

print("list 3 ==> ",list3)