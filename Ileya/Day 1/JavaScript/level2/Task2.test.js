const processDuplicates = require('./Task2');

test('returns an array of showing duplicates and their index [[-11, [0, 5]], ...] in array input of [-11, -9, 3, -9, 2, 11]', () => {
  expect(processDuplicates([-11, -9, 3, -9, 2, -11])).toEqual([[-11, [0, 5]], [-9, [1, 3]]]);
});
