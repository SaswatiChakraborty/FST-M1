import pytest

@pytest.fixture
def wallet():
    amount = 0
    return amount

@pytest.mark.parametrize("earned, spend, expected", [(30,10,20), (20,2,18)])
def test_transaction(wallet,earned,spend,expected):
    wallet+= earned

    wallet-=spend

    assert wallet == expected