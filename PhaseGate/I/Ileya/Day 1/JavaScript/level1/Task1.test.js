//const { splitEvenOdd } = require('./Task1');
const splitEvenOdd = require('./Task1');

test('splits [45, 60, 3, 10, 9, 22] into odds and evens', () => {
  expect(splitEvenOdd([45, 60, 3, 10, 9, 22])).toEqual([[45, 3, 9], [60, 10, 22]]);
});
