import java.util.Scanner;

public class evenNumberPrimeConv {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        evenNumberPrimeConv main = new evenNumberPrimeConv();
        main.run();
    }

    private void run() {
        System.out.println("Enter the bound:");
        getThosePrimeNumbers(Integer.parseInt(sc.nextLine()));
    }

    public int[] getThosePrimeNumbers(int bound) {
        //TODO
        return null;
    }
}