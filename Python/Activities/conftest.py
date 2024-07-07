import pytest

@pytest.fixture
def input_value():
    numberList = []
    for i in range (11):
        numberList.append(i)
    print(numberList)
    return numberList