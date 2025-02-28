import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class medium {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 74.0),
            new Student("Charlie", 90.0),
            new Student("David", 67.5),
            new Student("Eve", 78.0)
        );

        // Filtering students scoring above 75%, sorting by marks, and displaying names
        List<String> topStudents = students.stream()
            .filter(s -> s.getMarks() > 75) // Filter students scoring above 75%
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) // Sort by marks in descending order
            .map(Student::getName) // Extract names
            .collect(Collectors.toList()); // Collect names in a list

        System.out.println("Students scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
