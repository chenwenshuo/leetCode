import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }

    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>((o1, o2) -> o1.score > o2.score ? -1 : 1);
        Student bob = new Student("Bob",66);
        map.put(new Student("Tom",77),1);
        map.put(bob,2);
        map.put(new Student("lily",99),3);
        for (Student student : map.keySet()) {
            System.out.println(student);
        }

        System.out.println(map.get(bob));
    }


}
