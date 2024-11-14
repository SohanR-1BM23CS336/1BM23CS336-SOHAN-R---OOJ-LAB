package CIE;

public class Internals {
    private int[] internalMarks = new int[5];

    public void setInternalMarks(int[] marks) {
        if (marks.length == 5) {
            System.arraycopy(marks, 0, internalMarks, 0, 5);
        } else {
            System.out.println("Please provide exactly 5 marks.");
        }
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}

