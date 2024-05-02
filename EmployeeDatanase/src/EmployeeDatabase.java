class EmployeeDatabase{
    private class Entry{
        int ID;
        Employee employee;
        @SuppressWarnings("unused")
        Entry(int ID, Employee employee){
            this.ID = ID;
            this.employee = employee;
        }
        public String toString() {
            return ID+ " " +employee.name;
        }
    }
    int collision = 0;
    int vals = 0;
    Entry[] arr;
    void setSize(int size){
        arr = new Entry[size];
    }
    boolean putLinear(Employee value){
        if(vals == arr.length) return false;
        int i = hash(value.ID);
        if(arr[i] == null){
            vals++;
            arr[i] = new Entry(value.ID, value);
            return true;
        }
        collision++;
        for(int ind = i+1; i != ind;i++){ 
            if(ind == arr.length) ind%=arr.length;
            if(arr[ind] == null) {
                vals++;
               arr[ind] = new Entry(value.ID, value);
                return true;
            }
        }
        return false;
    }    
    int hash(int key){
        return (((int)Math.E*key) >> 1)%arr.length;
    }
    Employee getLinear(int key){
        int i = hash(key);
        if(arr[i] != null &&arr[i].ID == key) return arr[i].employee;
        collision++;
        for(int ind = i+1; i != ind;i++){ 
            if(ind == arr.length) ind%=arr.length;
            if(arr[ind] != null && arr[ind].ID == key)
                return arr[ind].employee;
            
        }
        return null;
    }
    int poor(int key){
        return key%1;
    }
    boolean putQuad(Employee value){
        int i = hash(value.ID);
        if(arr[i] == null){
            vals++;
            arr[i] = new Entry(value.ID, value);
            return true;
        }
        collision++;
        for(int m = 1; m <= arr.length;m++){  
            int ind = Math.abs((i+m*m)%arr.length);
            if(arr[ind]!= null){
                arr[ind] = new Entry(value.getId(), value);
                return true;
            }
        }
        return false;
    }
    Employee getQuad(int key){
        int i = hash(key);
        if(arr[i]!= null&&arr[i].ID == key) return arr[i].employee;
        int counter = 0;
        collision++;
        for(int m = 1; m < arr.length;m++){
            int ind = Math.abs((i+m*m)%arr.length);
            if(arr[ind]!= null && arr[ind].ID == key)
                  return arr[ind].employee;
            counter++;
            if(counter == arr.length) break;
        }
        return null;
    }
    int getSize(){
        return arr.length;
    }
    int getCollisions(){
        return collision;
    }
    void resetCollisions(){
        collision = 0;
    }
}