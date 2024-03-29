import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
    int size;
    private final int capacity = 1000000;
    int index;
    ArrayList<Integer> files;
    public Disk(int index,int file){
        size = 0;
        files = new ArrayList<Integer>();
        this.indx = index;
        add(file);
    }
    public int compareTo(Disk other){
        if(other.size < size) return 1;
        if(other.size > size) return -1;
        return 0;
    }
    boolean add(int file){
        if(size+file > capacity) return false;
        files.add(file);
        size+=file;
        // System.out.println(size);
        return true;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String s = files.toString().replace("," , "");
        return index +" " + (capacity-size)+": "+ s.substring(1,s.length()-1);
    }         
}