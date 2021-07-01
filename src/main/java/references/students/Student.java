package references.students;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    String name;
    Integer course;
    Double mark;

    public Student(String name, Integer course, Double mark) {
        this.name = name;
        this.course = course;
        this.mark = mark;
    }
}
