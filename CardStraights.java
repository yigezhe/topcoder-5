// Problem Statement: http://community.topcoder.com/stat?c=problem_statement&pm=7417&rd=10661

import java.util.Set;
import java.util.TreeSet;

public class CardStraights {
  public int longestStraight(int[] cards) {
    Set<Integer> list = new TreeSet<Integer>();
    
    int jokers = 0;
    for (int i = 0; i < cards.length; i++) {
      if (cards[i] == 0) {
        jokers++;
      } else {
        list.add(cards[i]);
      }
    }
    
    int a[] = new int[list.size()];
    int i = 0;
    for (int x : list) {
      a[i++] = x;
    }
    
    int longest = jokers;
    for (int j = 0; j < a.length; j++) {
      int left = jokers;
      int length = 1;
      int k = j + 1;
      while(k < a.length) {
        int diff = a[k] - a[k - 1] - 1;
        if (diff == 0) {
          length++;
        } else if (diff <= left) {
          length += diff + 1;
          left -= diff;
        } else {
          break;
        }
        k++;
      }
      longest = Math.max(longest, length + left);
    }
    return longest;
  }
}
