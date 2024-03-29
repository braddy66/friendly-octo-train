public class PhoneNumber {
    String number;
    PhoneNumber(String number){
        this.number = number;
    }
    public int hashCode(){
        return number.hashCode();
    }
}
