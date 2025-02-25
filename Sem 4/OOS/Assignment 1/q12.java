class Student {
    String name;
    int rollNo;
    String[] subjects;

    Student(String name, int rollNo, String[] subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
    }
}

class TabulationSheet {
    String subject;
    int[] rollNos;
    int[] marks;
    int count;

    TabulationSheet(String subject, int capacity) {
        this.subject = subject;
        rollNos = new int[capacity];
        marks = new int[capacity];
        count = 0;
    }

    void addMarks(int rollNo, int mark) {
        rollNos[count] = rollNo;
        marks[count] = mark;
        count++;
    }

    int getMark(int rollNo) {
        for (int i = 0; i < count; i++) {
            if (rollNos[i] == rollNo) {
                return marks[i];
            }
        }
        return -1;
    }
}

class MarkSheet {
    String studentName;
    String[] subjects;
    int[] marks;
    int count;

    MarkSheet(String studentName, int subjectCount) {
        this.studentName = studentName;
        subjects = new String[subjectCount];
        marks = new int[subjectCount];
        count = 0;
    }

    void addMarks(String subject, int mark) {
        subjects[count] = subject;
        marks[count] = mark;
        count++;
    }

    void printMarkSheet() {
        System.out.println("Marksheet for: " + studentName);
        for (int i = 0; i < count; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println();
    }
}

class q12 {
    public static void main(String[] args) {
        String[] subjects = {"CoA", "CPNM", "OOP", "DBMS", "OOS"};

        Student[] students = {
                new Student("Soham Das", 101, subjects),
                new Student("Debodit Ray", 102, subjects),
                new Student("Anuska Nath", 103, subjects)
        };

        TabulationSheet[] tabSheets = new TabulationSheet[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            tabSheets[i] = new TabulationSheet(subjects[i], students.length);
        }

        int[][] marksData = {
                {85, 90, 75},
                {80, 88, 70},
                {78, 84, 65},
                {92, 85, 80},
                {88, 79, 82}
        };

        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < students.length; j++) {
                tabSheets[i].addMarks(students[j].rollNo, marksData[i][j]);
            }
        }

        MarkSheet[] markSheets = new MarkSheet[students.length];
        for (int i = 0; i < students.length; i++) {
            markSheets[i] = new MarkSheet(students[i].name, subjects.length);
            for (TabulationSheet tabSheet : tabSheets) {
                markSheets[i].addMarks(tabSheet.subject, tabSheet.getMark(students[i].rollNo));
            }
        }

        for (MarkSheet markSheet : markSheets) {
            markSheet.printMarkSheet();
        }
    }
}
