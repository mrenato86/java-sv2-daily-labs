package day04;

public class TimetableElement {

    private String teacherName;
    private String subject;
    private String className;
    private int numberOfLessons;

    public TimetableElement(String teacherName, String subject, String className, int numberOfLessons) {
        validateArgs(teacherName, subject, className, numberOfLessons);
        this.teacherName = teacherName;
        this.subject = subject;
        this.className = className;
        this.numberOfLessons = numberOfLessons;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    @Override
    public String toString() {
        return teacherName + "(" + subject + "," + className + "," + numberOfLessons + ")";
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

    private void validateArgs(String teacherName, String subject, String className, int numberOfLessons) {
        if (isEmpty(teacherName) || isEmpty(subject) || isEmpty(className) || numberOfLessons <= 0) {
            throw new IllegalArgumentException("Invalid argument(s)!");
        }
    }
}
