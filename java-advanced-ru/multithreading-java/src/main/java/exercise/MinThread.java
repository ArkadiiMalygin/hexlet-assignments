package exercise;

// BEGIN
public class MinThread extends Thread {
    int[] numbers;
    private int min = Integer.MAX_VALUE;

    public int getMin() {
        return min;
    }

    public MinThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (var i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
    }
}
// END
