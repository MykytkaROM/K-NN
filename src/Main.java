import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Type "+'\"'+"exit"+'\"'+" to exit");
            System.out.println("Enter value of k: ");
            int k = sc.nextInt();
            System.out.println("Enter training data file name: ");
            KNN knn = new KNN(sc.next(),k);
            System.out.println("Testing data as file? (Y/N)");
            String test = sc.next();
            if(test.equalsIgnoreCase("Y")){
                System.out.println("Enter testing data file name: ");
                knn.predict(sc.next());
            }if(test.equalsIgnoreCase("N")){
                System.out.println("Enter testing data as vector: ");
                System.out.println(knn.predict(new Vector(sc.next().split(","))));
            }if (test.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
        }
    }
}
