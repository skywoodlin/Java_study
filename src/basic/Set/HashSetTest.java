package basic.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/14.
 */
class Student{
    int id;
    public Student(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return this.id+"";
    }
    @Override
    public int hashCode() {
        return this.id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student){
            Student stu = (Student) obj;
            if (stu.id == this.id)
                return true;
        }
        return false;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        for (Student s : set) {
            System.out.println(s);
        }
    }
}
