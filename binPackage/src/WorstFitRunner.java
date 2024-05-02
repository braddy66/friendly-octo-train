import java.io.FileNotFoundException;

public class WorstFitRunner {
    public static void main(String[] args) throws FileNotFoundException {
        WorstFit wf = new WorstFit("input20.txt");
        System.out.println(wf.toString());
    }
}
