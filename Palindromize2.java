// Problem Statement: http://community.topcoder.com/stat?c=problem_statement&pm=7406

public class Palindromize2 {
  public String minChanges(String original) {
    StringBuffer result = new StringBuffer(original);
    int i = 0; 
    int n = original.length();
    while (i < n / 2) {
      char a = original.charAt(i);
      char b = original.charAt(n - i - 1);
      if (a != b) {
        char c = (char) Math.min(a, b);
        result.setCharAt(i, c);
        result.setCharAt(n - i - 1, c);
      }
      i++;
    }
    return result.toString();
  }
}
