import java.util.Scanner;

public class Main {

    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        int N;
        int k;
        int m;

        do {
            N = input.nextInt();
            k = input.nextInt();
            m = input.nextInt();
        } while (N != 0 && k != 0 && m != 0);

        System.out.println(N +" "+" "+ k +" "+ m);
    }
}