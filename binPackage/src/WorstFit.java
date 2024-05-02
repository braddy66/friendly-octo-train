import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class WorstFit {
    PriorityQueue<Disk> pq;
    int size;
    WorstFit(String fileNmae) throws FileNotFoundException{
      Scanner sc = new Scanner(new File(fileNmae));
      pq = new PriorityQueue<Disk>();
      PriorityQueue<Integer> files = new PriorityQueue<>(Comparator.reverseOrder());
      while(sc.hasNext()) files.add(sc.nextInt());
      size = files.poll();
      int index = 0;
      pq.add(new Disk(index++,size)); // size starts at first val of File
      while(!files.isEmpty()){
        Disk curr = pq.poll();
        int file = files.poll();
        if(!curr.add(file)) pq.add(new Disk(index++,file));
        pq.add(curr);
        size+=file;
      }
      sc.close();
    }
    @Override
    public String toString() {
       String s =  "Total size " + size/1e6+" GB\n" + "disk's required " +pq.size()+"\n";

       while(!pq.isEmpty()){
        s+=pq.poll().toString()+"\n";
       }
       return s;
    }
}
