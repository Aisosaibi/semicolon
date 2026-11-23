//const { splitEvenOdd } = require('./split-odd-and-even-values');
const splitEvenOdd = require('./split-odd-and-even-values');

test('splits [45, 60, 3, 10, 9, 22] into odds and evens', () => {
  expect(splitEvenOdd([45, 60, 3, 10, 9, 22])).toEqual([[45, 3, 9], [60, 10, 22]]);
});
