const pSum = require('./find-pair-for-sum');

test('returns {8, -2} from {8, 6, 12, 4, -2}', () => {
    number = 6
    array = [8, 6, 12, 4, -2]
    expected = [8, -2]
    expect(pSum(array, number)).toEqual(expected);
});

