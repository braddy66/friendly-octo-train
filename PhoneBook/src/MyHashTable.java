import java.util.Collection;

@SuppressWarnings({"unchecked", "hiding"})
public class MyHashTable<Key, Value> {
   
    private class Entry<Key, Value> {
        Key key;
        Value val;
        @SuppressWarnings("rawtypes")
        Entry next;
        Entry(Key key, Value val){
            this.key = key;
            this.val = val;
        }
        Entry(){};
    }
    Object [] table;
    int size;
    public  MyHashTable(){
        table = new Object[100]; // has to be an object array cause doesnt work with 
        size = 0;
    }
    Value put(Key key, Value val){
        int n = key.hashCode()%table.length;
        Entry<Key, Value> root = new Entry<>();
        root.next = get(n);
        Entry<Key, Value> curr = root;
        while(curr!= null){
            if(key.equals(curr.key)){
                Value prev = curr.val;
                curr.val = val;
                return prev;
            }
            if(curr.next== null) break;
            curr = curr.next;

        }
        size++;
        curr.next = new Entry<Key, Value>(key, val);
        table[n] = root.next;
        return null;   
    }
    Value get (Key key){
        int n = key.hashCode()%table.length;
        Entry<Key, Value> curr = get(n);
        while(curr!= null){ 
            if(curr.key.equals(key)) return curr.val;
            curr = curr.next;
        }
        return null;
    }
    Value remove(Key key){
        Entry<Key, Value> root = new Entry<>();
        int n = key.hashCode()%table.length;
        root.next = get(n);
        if(root.next == null) return null;
        Entry<Key, Value> curr = root;
        while(curr.next!= null){
            if(curr.next.key.equals(key)){
                size--;
                Value temp = (Value) curr.next.val;
                curr.next = curr.next.next;
                table[n] = root.next;
                return temp;
            }
            curr = curr.next;
        }
        return null;
    }
    int size(){
        return size;
    }
    Entry<Key, Value> get(int i){
        final Entry<Key, Value> e = (Entry<Key, Value>) table[i];
        return e;
    }
    public Collection<? extends Person> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }
}