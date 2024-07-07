import pytest

def test_sum():
    num1 = 25
    num2 = 30
    assert num1 + num2 == 55

def testDifference():
    num1 = 7
    num2 = 5
    assert num1-num2 == 2


@pytest.mark.activity
def test_Product():
    num1 = 7
    num2 = 5
    assert num1*num2 == 35

@pytest.mark.activity
def test_quotient():
    num1 = 35
    num2 = 5
    assert num1/num2 == 7

#pytest -m 'activity'
#pytest -m 'activity' -rA -v
#pytest -m activity
