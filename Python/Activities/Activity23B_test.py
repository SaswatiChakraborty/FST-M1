import pytest

def test_sum_list(input_value):
    sum = 0
    for number in input_value:
        sum+=int(number)
    assert sum == 55


    # pytest -k list
