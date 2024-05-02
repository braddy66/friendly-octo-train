import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseTester {

    public static void main(String[] args) {
        DataBaseTester d = new DataBaseTester();
    }

    /*Make sure your code has the following:

    Default Constructor
    collision instance variable
    resetCollisions()
    getCollisions()
    setSize()
    getSize()
    getLinear()
    putLinear()
    getQuad()
    putQuad()

    */
    DataBaseTester(){
        String filename = "Large Data Set.txt";
        Scanner scan = null;
        try {
            scan = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Employee> data = new ArrayList<>();
        while(scan.hasNextLine()) {
            int id = scan.nextInt();
            String line = scan.nextLine();
            data.add(new Employee(line,id));
        }

        EmployeeDatabase ed = new EmployeeDatabase();

        double[] alpha = {0.99,0.9,0.8,0.7,0.6,0.5};

        for(double a : alpha) {

            ed.setSize((int)(data.size()/a));
            System.out.println("------------Alpha: "+(a)+"------------");
            System.out.println("Num Entries: "+data.size());
            System.out.println("Database Size: "+ed.getSize());
            ed.resetCollisions();
            for(Employee e: data) {
                ed.putLinear(e);
            }
            System.out.println("---Type Linear---");
            System.out.println("Number of collisions :"+ed.getCollisions());

            try {
                scan = new Scanner(new File("Successful Search Records.txt"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ArrayList<Employee> succ = new ArrayList<>();
            while(scan.hasNextLine()) {
                int id = scan.nextInt();
                String line = scan.nextLine();
                succ.add(new Employee(line,id));
            }
            try {
                scan = new Scanner(new File("Unsuccessful Search Records.txt"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ArrayList<Employee> unsucc = new ArrayList<>();
            while(scan.hasNextLine()) {
                int id = scan.nextInt();
                String line = scan.nextLine();
                unsucc.add(new Employee(line,id));
            }

            ed.resetCollisions();
            for(Employee e: succ) {
                ed.getLinear(e.getId());
            }

            System.out.println("Number of collisions Succ Search:"+ed.getCollisions());
            ed.resetCollisions();
            for(Employee e: unsucc) {
                ed.getLinear(e.getId());
            }

            System.out.println("Number of collisions UnSucc Search:"+ed.getCollisions());


            ed.setSize((int)(data.size()/a));
            ed.resetCollisions();
            for(Employee e: data) {
                ed.putQuad(e);
            }
            System.out.println("---Type Quad---");
            System.out.println("Number of collisions :"+ed.getCollisions());

            try {
                scan = new Scanner(new File("Successful Search Records.txt"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            succ = new ArrayList<>();
            while(scan.hasNextLine()) {
                int id = scan.nextInt();
                String line = scan.nextLine();
                succ.add(new Employee(line,id));
            }
            try {
                scan = new Scanner(new File("Unsuccessful Search Records.txt"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            unsucc = new ArrayList<>();
            while(scan.hasNextLine()) {
                int id = scan.nextInt();
                String line = scan.nextLine();
                unsucc.add(new Employee(line,id));
            }

            ed.resetCollisions();
            for(Employee e: succ) {
                ed.getQuad(e.getId());
            }

            System.out.println("Number of collisions Succ Search:"+ed.getCollisions());
            ed.resetCollisions();
            for(Employee e: unsucc) {
                ed.getQuad(e.getId());
            }

            System.out.println("Number of collisions UnSucc Search:"+ed.getCollisions());
        }

    }
}
