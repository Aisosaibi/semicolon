import java.util.Arrays;

public class KataSolution {
  String shortestWord(String sentence) {
    String[] words = sentence.split(" ");
    String min = words[0];
    for (String word: words) {
      if (word.length() < min.length()) {
        min = word;
      }
    }
    return min;
  }

  int[] squareArray(int[] array) {
    int[] result = new int[array.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = array[i] * array[i];
    }
    Arrays.sort(result);
    return result;
  }

  void main(String[] args) {
    String sentence = "We are the world";
    int[] array = {1, 2, 3, 6, -2};

    System.out.println(shortestWord(sentence));
    System.out.println(Arrays.toString(squareArray(array)));
  }
}
