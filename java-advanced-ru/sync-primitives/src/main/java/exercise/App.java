package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList list = new SafetyList();

        ListThread thread1 = new ListThread(list);
        ListThread thread2 = new ListThread(list);

        thread1.start();
        thread2.start();

        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // END
    }
}

