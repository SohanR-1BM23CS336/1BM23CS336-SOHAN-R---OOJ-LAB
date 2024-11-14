package SEE;

import CIE.Student;

public class External extends Student {
    private int[] seeMarks = new int[5];

    public External(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void setSeeMarks(int[] marks) {
        if (marks.length == 5) {
            System.arraycopy(marks, 0, seeMarks, 0, 5);
        } else {
            System.out.println("Please provide exactly 5 marks.");
        }
    }

    public int[] getSeeMarks() {
        return seeMarks;
    }
}