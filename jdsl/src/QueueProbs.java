import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

public class QueueProbs {
    Queue<Integer> evenFirst(Queue<Integer> nums){
        Queue<Integer> even = new LinkedList<Integer>();
        Queue<Integer> odd = new LinkedList<Integer>();
        while(!nums.isEmpty()) {
            int n = nums.poll();
            if (n % 2 == 0) {
                even.offer(n);
            } else {
                odd.offer(n);
            }
        }
        while(!odd.isEmpty()){
            even.offer(odd.poll());
        }
      return even;
 }
  boolean numPalindrome(Queue<Integer> nums){
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    Queue<Integer> copy = new LinkedList<>();
    while(!nums.isEmpty()){
      int x = nums.poll();
      q1.offer(x);
      copy.offer(x);
    } 
    while(!q1.isEmpty()){
      for(int x = 0; x < q1.size()-1; x++){
        q1.offer(q1.poll());
      }
      q2.add(q1.poll());
    }
    return q2.equals(copy);
  }
  
  
}