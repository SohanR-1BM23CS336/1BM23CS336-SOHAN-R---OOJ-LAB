class StatementPrinter extends Thread {
    private final String statement;
    private final int interval;

    public StatementPrinter(String statement, int interval) {
        this.statement = statement;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(statement);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + statement);
        }
    }
}

public class TwoStatementsThreads {
    public static void main(String[] args) {
        StatementPrinter printer1 = new StatementPrinter("BMS College Of Engineering", 10000);
        StatementPrinter printer2 = new StatementPrinter("CSE", 2000);

        printer1.start();
        printer2.start();
    }
}
