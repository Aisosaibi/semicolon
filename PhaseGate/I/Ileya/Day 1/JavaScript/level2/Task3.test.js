const moveZeroesToEnd = require('./Task3');

test('moves zeroes in [5, 0, 3, 0, 2, 0] to end as [5, 3, 2, 0, 0, 0]', () => {
  expect(moveZeroesToEnd([5, 0, 3, 0, 2, 0])).toEqual([5, 3, 2, 0, 0, 0]);
});
