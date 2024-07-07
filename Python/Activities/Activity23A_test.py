import pytest

@pytest.fixture
def input_value():
    numberList = []
    for i in range (11):
        numberList.append(i)
    print(numberList)
    return numberList

def test_sum_list(input_value):
    sum = 0
    for number in input_value:
        sum+=int(number)
    assert sum == 55


    # pytest -k list
