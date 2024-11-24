package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[0];;


    public synchronized void add(int number) {
        var newArr = new int[numbers.length + 1];
        for (var i = 0 ; i < numbers.length ; i++) {
            newArr[i] = numbers[i];
        }
        newArr[numbers.length] = number;
        this.numbers = newArr;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int get(int i) {
        return numbers[i];
    }

    public int getSize() {
        return numbers.length;
    }

    // END
}
