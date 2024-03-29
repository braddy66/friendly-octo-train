public class Person {
    String name;
    Person(String name){
        this.name = name;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
