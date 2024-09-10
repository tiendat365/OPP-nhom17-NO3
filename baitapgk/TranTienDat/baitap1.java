public interface Signal {
    void displayInfo();
}

public class DiscreteSignal implements Signal {
    private double amplitude;
    private int duration;

    public DiscreteSignal(double amplitude, int duration) {
        this.amplitude = amplitude;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Discrete Signal - Amplitude: " + amplitude + ", Duration: " + duration);
    }
}

public class ContinuousSignal implements Signal {
    private double frequency;
    private double phase;

    public ContinuousSignal(double frequency, double phase) {
        this.frequency = frequency;
        this.phase = phase;
    }

    @Override
    public void displayInfo() {
        System.out.println("Continuous Signal - Frequency: " + frequency + ", Phase: " + phase);
    }
}

public class Main {
    public static void main(String[] args) {
        new DiscreteSignal(5.0, 10).displayInfo();
        new ContinuousSignal(50.0, 30.0).displayInfo();
    }
}
