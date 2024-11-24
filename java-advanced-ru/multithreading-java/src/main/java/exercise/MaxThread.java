package exercise;

// BEGIN
public class MaxThread extends Thread {
    int[] numbers;
    private int max = Integer.MIN_VALUE;

    public int getMax() {
        return max;
    }

    public MaxThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (var i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
    }
}
// END
