package ca.bytetube._06_tree;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    int age;
    double height;


    public Student(int age, double height) {
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student:" +
//                "age=" + age;
                " height=" + height;
//                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.age - s.age;
    }

    public static void main(String[] args) {
        Student student1 = new Student(21,17.6);
        Student student2 = new Student(11,14.6);
        Student student3 = new Student(28,16.6);
        Student student4 = new Student(31,18.6);
        Student[] students = {student1,student2,student3,student4};
        Arrays.sort(students,new StudentComparator());
      for (Student s:students){
          System.out.println(s);
      }
    }
}
