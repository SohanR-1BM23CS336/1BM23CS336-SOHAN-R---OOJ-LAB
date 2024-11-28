class BMSDisplay extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CSEDisplay extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        BMSDisplay bmsThread = new BMSDisplay();
        CSEDisplay cseThread = new CSEDisplay();
        bmsThread.start();
        cseThread.start();
    }
}