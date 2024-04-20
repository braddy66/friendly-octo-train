import java.awt.Color;
import java.io.FileNotFoundException;

public class PhotoMagic {
    public static Picture transform(Picture pic, LFSR lfsr){
        for(int i = 0; i < pic.width();i++){
            for(int j = 0; j < pic.height(); j++){
                Color origional = pic.get(i,j);
                Color c = new Color(origional.getRed()^lfsr.generate(8), origional.getGreen()^lfsr.generate(8), origional.getBlue()^lfsr.generate(8));
                pic.set(i,j,c);
            }
        }
        return pic;
    }
    public static void main(String [] args) throws FileNotFoundException{
        String s = "86433";
        int tap = 58;
        Picture pic = new Picture(s+".jpg");
        String pswd = "OPENSESAME";
        pic.show();
        String alphanumericKey = convertAlphaNumeric(pswd);
        PhotoMagic.transform(pic, new LFSR(alphanumericKey, tap));
        pic.save(s+".jpg");
        pic.show();
        PhotoMagic.transform(pic, new LFSR(alphanumericKey, tap));
        pic.save(s+".jpg");
        pic.show();
    }
    static String convertAlphaNumeric(String word){
        String alpha = "";
        for(int i = 0; i < word.length();i++){
            alpha+=String.format("%06d", Integer.parseInt(Integer.toBinaryString(word.charAt(i)-65)));
        }
        return alpha;
    }

}
