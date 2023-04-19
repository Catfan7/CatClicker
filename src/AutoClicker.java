public class AutoClicker extends Thread {
    long speed = 1500;
    @Override
    public void run() {
        while (true) {
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Interface.addCookies(1);
        }
    }
}
