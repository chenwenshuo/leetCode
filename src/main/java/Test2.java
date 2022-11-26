import java.util.*;

public class Test2 {



    /**
     * list 10个对象 1.2----10
     * 输出 100
     * list
     * student a->
     */

   static class Student{
        Integer id;
        String name;

        public Student(){

        }
        public Student(Integer id,String name){
            this.id=id;
            this.name=name;
        }

        public Student(Student student,int i,int j){
            this.id=(student.id-1)*10+j;
            this.name=student.name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
       String a="ABC";
       String b="ABC";
        System.out.println(a==b);
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"a"));
        students.add(new Student(2,"b"));
        students.add(new Student(3,"c"));
        List<Student> list=new ArrayList<>();
     /*   for (int i = 0; i < students.size(); i++) {
            for (int j = 1; j <= 10; j++) {
                Student student = new Student(students.get(i), i,j);
                list.add(student);
            }
        }*/
        for (int i = 1; i <= 10; i++) {
            for (Student student : students) {
                System.out.println(student.id^i|10);
            }

        }
        for (Student student : list) {
            System.out.println(student.id);
        }
    }
}
