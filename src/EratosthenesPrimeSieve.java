public class EratosthenesPrimeSieve implements PrimeSieve {
    private final int bound;
    private boolean[] primeNumbers;

    public EratosthenesPrimeSieve(int bound) {
        this.bound = bound;
        primeNumbers = new boolean[bound+1];
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