// DiscreteSignal.java
public class DiscreteSignal {
    private double[] signal;

    public DiscreteSignal(double[] signal) {
        if (signal == null || signal.length == 0) {
            throw new IllegalArgumentException("Signal array cannot be null or empty.");
        }
        this.signal = signal;
    }

    public double response(int n) {
        double result = 0.0;
        for (int k = 0; k < signal.length; k++) {
            result += signal[k] * delta(n - k);
        }
        return result;
    }

    private int delta(int n) {
        return (n == 0) ? 1 : 0;
    }

    public double[] getSignal() {
        return signal;
    }
}

// Radar.java
public class Radar {
    private static final int N = 15;

    public double[] analyzeSignal(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        double[] result = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            result[i] = (n == 0) ? 1.0 / 15 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] signalData = {1, 2, 3, 4, 5};
        DiscreteSignal discreteSignal = new DiscreteSignal(signalData);
        System.out.printf("Response at n=4: %.2f%n", discreteSignal.response(4));

        Radar radar = new Radar();
        double[] radarSignal = radar.analyzeSignal(0);
        System.out.println("Radar Signal Analysis for n=0:");
        for (int i = 0; i < radarSignal.length; i++) {
            System.out.printf("X(%d) = %.2f%n", i, radarSignal[i]);
        }
    }
}
