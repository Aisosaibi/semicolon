const checksPalindrome = require('./Task2');

test('checks if [45, 0, 8, 0, 45] is palindromic', () => {
  expect(checksPalindrome([45, 0, 8, 0, 46])).toBe(true);
});
