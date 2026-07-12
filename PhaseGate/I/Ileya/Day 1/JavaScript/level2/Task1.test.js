const processDuplicates = require('./Task1');

test('returns an array of duplicates [2, 3] in array input of [1, 2, 3, 2, 4, 3]', () => {
  expect(processDuplicates([1, 2, 3, 2, 4, 3])).toEqual([2, 3]);
});

//let array = [1, 2, 3, 2, 4, 3]
//test('returns an array of duplicates [2, 3] in array input of [1, 2, 3, 2, 4, 3]' () => {
//  expect(processDuplicates(array)).toEqual([2, 3]);
//});
