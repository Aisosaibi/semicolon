const processNonSquare = require('./Task4');

test('returns [4, -1, 9, -1, 49 , -1] from an array of [4, 7, 9, 10, 49, 6]', () => {
  expect(processNonSquare([4, 7, 9, 10, 49, 6])).toEqual([4, -1, 9, -1, 49 , -1]);
});
