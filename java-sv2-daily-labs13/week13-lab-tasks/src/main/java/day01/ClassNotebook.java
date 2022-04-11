package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {

    private Map<Student, List<Integer>> notebook = new TreeMap<>();

    public void addStudent(Student student) {
        if (!notebook.containsKey(student)) {
            notebook.put(student, new ArrayList<>());
        }
    }

    public void addMark(int id, int mark) {
        for (Map.Entry<Student, List<Integer>> entry : notebook.entrySet()) {
            if (entry.getKey().getId() == id) {
                entry.getValue().add(mark);
                return;
            }
        }
        throw new IllegalArgumentException("Student not found with id: " + id);
    }

    public Map<Student, List<Integer>> getNotebook() {
        return new TreeMap<>(notebook);
    }
}
