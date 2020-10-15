import java.util.Scanner;

public class evenNumberPrimeConv {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        evenNumberPrimeConv main = new evenNumberPrimeConv();
        main.run();
    }

    private void run() {
        System.out.println("Enter the bound:");
        checkIt(Integer.parseInt(scanner.nextLine()));
    }

    public void checkIt(int bound) {
        EratosthenesPrimeSieve primeSieve = new EratosthenesPrimeSieve(bound);
        boolean alreadyPrintedASum = false;

        for (int i = 4; i <= bound; i = i+2) {
            for (int primeNumber1 = 2; primeNumber1 < i; primeNumber1++) {
                for (int primeNumber2 = 2; primeNumber1 + primeNumber2 <= i; primeNumber2++) {
                    if (primeSieve.isPrime(primeNumber1) && primeSieve.isPrime(primeNumber2)) {
                        if (primeNumber1 + primeNumber2 == i && !alreadyPrintedASum) {
                            System.out.println(i + " summe: " + i + " = " + primeNumber1 + " + " + primeNumber2);
                            alreadyPrintedASum = true;
                            break;
                        }
                    }
                }
            }
            alreadyPrintedASum = false;
        }
    }

    static class EratosthenesPrimeSieve implements PrimeSieve {
        private final int bound;
        private boolean[] primeNumbers;

        public EratosthenesPrimeSieve(int bound) {
            this.bound = bound;
            primeNumbers = new boolean[bound+1];
            getPrimeNumbers();
        }

        public void getPrimeNumbers() {
            for (int i = 2; i < primeNumbers.length; i++)
                primeNumbers[i] = true;

            for (int i = 0; i < primeNumbers.length; i++) {
                if(primeNumbers[i])
                    for (int j = 2*i; j < primeNumbers.length; j += i)
                        primeNumbers[j] = false;
            }
        }

        @Override
        public boolean isPrime(int p) {
            return primeNumbers[p];
        }

        @Override
        public void printPrimes() {
            for (int i = 0; i < primeNumbers.length; i++) if(primeNumbers[i]) System.out.println(i);
        }
    }
}
interface PrimeSieve {
    boolean isPrime(int p);
    void printPrimes();
}