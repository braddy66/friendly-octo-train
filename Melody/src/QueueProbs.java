import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    Stack<Integer> sieveOfErathosthenes(int n){
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int x = 2; x < n;x++){
            q.offer(x);
        }
        while(!q.isEmpty()){
            int num = q.poll();
            st.push(num);
            int size = q.size();
            for(int x = 0 ; x  < size;x++){
                if(q.peek()%num != 0)
                    q.offer(q.peek());
                q.poll();
            }
        }
        return st;
    }
}
