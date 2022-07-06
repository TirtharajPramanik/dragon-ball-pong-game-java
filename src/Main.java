public class Main {
    private static int state = 0;
    private static Thread mainThread;

    public static void main(String[] args) {
        mainThread = new Thread(new MainMenu());
        mainThread.start();
    }

    public static void changeState(int newState) {
        switch (newState) {
            case 0:
                if (state != 0) {
                    mainThread.interrupt();
                    Window.isRunning = false;
                    mainThread = new Thread(new MainMenu());
                    mainThread.start();
                    MainMenu.isRunning = true;
                    MainMenu.scores = true;
                    state = 0;
                }
                break;
            case 1:
                if (state != 1) {
                    mainThread.interrupt();
                    MainMenu.isRunning = false;
                    mainThread = new Thread(new Window());
                    mainThread.start();
                    Window.isRunning = true;
                    state = 1;
                }
                break;
            default:
                break;
        }
    }
}