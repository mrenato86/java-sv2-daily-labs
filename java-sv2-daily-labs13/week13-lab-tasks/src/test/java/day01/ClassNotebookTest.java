package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    ClassNotebook classNotebook = new ClassNotebook();

    @Test
    void testAddStudent() {
        Student student = new Student(1, "Test Student");
        classNotebook.addStudent(student);

        assertEquals(1, classNotebook.getNotebook().size());
        assertTrue(classNotebook.getNotebook().containsKey(student));
        assertEquals(0, classNotebook.getNotebook().get(student).size());
    }

    @Test
    void testAddStudentDuplicate() {
        Student student = new Student(1, "Test Student");
        Student studentDuplicate = new Student(1, "Duplicate Student");
        classNotebook.addStudent(student);
        classNotebook.addStudent(studentDuplicate);

        assertEquals(1, classNotebook.getNotebook().size());
    }

    @Test
    void testAddStudentOrder() {
        Student studentOne = new Student(1, "One Student");
        Student studentTwo = new Student(2, "Two Student");
        Student studentThree = new Student(3, "Three Student");

        classNotebook.addStudent(studentThree);
        classNotebook.addStudent(studentOne);
        classNotebook.addStudent(studentTwo);

        assertEquals(List.of(studentOne, studentTwo, studentThree), new ArrayList<>(classNotebook.getNotebook().keySet()));
    }

    @Test
    void testAddMark() {
        Student student = new Student(1, "Test Student");
        classNotebook.addStudent(student);
        classNotebook.addMark(1, 5);

        assertEquals(5, classNotebook.getNotebook().get(student).get(0));
        assertEquals(1, classNotebook.getNotebook().get(student).size());
    }

    @Test
    void testAddMarkNotFoundException() {
        classNotebook.addStudent(new Student(1, "Test Student"));

        assertThrows(IllegalArgumentException.class, () -> classNotebook.addMark(2, 5));
    }
}