public class EratosthenesPrimeSieve implements PrimeSieve {
    private final int bound;
    private boolean[] primeNumbers;

    public EratosthenesPrimeSieve(int bound) {
        this.bound = bound;
        primeNumbers = new boolean[bound+1];
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