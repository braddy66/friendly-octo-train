public class Person {
    String name;
    Person(String name){
        this.name = name;
    }
    @Override
    public int hashCode(){
        return Math.abs(name.hashCode());
    }
    public boolean equals(Object other){
        if(other == null) return name == null;
        Person p = (Person) other;
        return name.equals(p.name);
    }
}
