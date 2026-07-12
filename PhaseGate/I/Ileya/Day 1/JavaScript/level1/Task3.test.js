const processSquares = require('./Task3');

test('returns [4, 9, 16] from an array of [4, 7, 9, 10, 16, 18]', () => {
  expect(processSquares([4, 7, 9, 10, 16, 18])).toEqual([4, 9, 16]);
});
