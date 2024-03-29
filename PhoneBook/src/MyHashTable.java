public class MyHashTable<Key, Value> {
    private class Entry {
        Key key;
        Value val;
        Entry next;
        Entry(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }
    Object [] table;
    int size;
    Value put(Key key, Value val){
        int n = key.hashCode()%table.length;
        size++;
        Entry temp = (Entry) table[n];
        if(temp == null){
            table[n] = new Entry(key, val); 
            return null;
        }
        else if(temp.key == key){
            Value prev = temp.val;
            temp.val = val;
            size--;
            return prev;
        }
        while(temp.next!= null){
            temp = temp.next;
            if(temp.key == key){
                Value prev = temp.val;
                temp.val = val;
                size--;
            }
        }
        temp.next = new Entry(key, val);
        return null; // may need to switch to temp.val
    }
    Value get(Person key){
        int n = key.hashCode()%table.length;
        Entry temp = (Entry) table[n];
        if(temp == null) return null; // name doesn't exist
        while(temp.next!= null) temp = temp.next;
        return temp.val;
    }
    Value remove(Person key){
        int n = key.hashCode()%table.length;
        if(table[n] == null) return null;
        Entry temp = (Entry) table[n];
        if(temp.key == key){
            Value prev = temp.val;
            temp.next = temp.next;
            size--;
            return prev;
        }
        while(temp.next.key != key) temp = temp.next;
        if(temp.next == null) return null;
        size--;
        Value prev = temp.next.val;
        temp.next = temp.next.next;
        return prev;
    }
    int size(){
        return 0;
    }
}

