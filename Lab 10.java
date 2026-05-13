import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Course {
    private String code;
    private String title;
    private int credits;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, int credits, int capacity) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return enrolled < capacity;
    }

    public void incrementEnrolled() {
        if (!isAvailable()) {
            throw new IllegalArgumentException("Course is full.");
        }
        enrolled++;
    }

    public void decrementEnrolled() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    public String toString() {
        return code + " - " + title + " (" + credits + " cr) [" + enrolled + "/" + capacity + " enrolled]";
    }
}

class Student {
    private String name;
    private String studentId;
    private double gpa;
    private List<Course> courses;

    public Student(String name, String studentId, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void enroll(Course course) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(course.getCode())) {
                throw new IllegalStateException(name + " is already enrolled in " + course.getCode());
            }
        }

        if (!course.isAvailable()) {
            throw new IllegalArgumentException(course.getCode() + " is full.");
        }

        courses.add(course);
    }

    public void drop(String courseCode) {
        Iterator<Course> iterator = courses.iterator();

        while (iterator.hasNext()) {
            Course c = iterator.next();

            if (c.getCode().equalsIgnoreCase(courseCode)) {
                iterator.remove();
                c.decrementEnrolled();
                return;
            }
        }

        throw new IllegalArgumentException("Course " + courseCode + " not found for " + name);
    }

    public int getTotalCredits() {
        int total = 0;

        for (Course c : courses) {
            total += c.getCredits();
        }

        return total;
    }

    public String toString() {
        return name + " (" + studentId + "), GPA: " + gpa + ", Total Credits: " + getTotalCredits();
    }
}

class Registrar {
    private List<Course> courses;
    private List<Student> students;

    public Registrar() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void register(Student student, Course course) {
        if (!students.contains(student)) {
            students.add(student);
        }

        student.enroll(course);
        course.incrementEnrolled();
    }

    public Course findCourse(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }

        return null;
    }

    public void printRoster(String code) {
        Course course = findCourse(code);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nRoster for " + course.getCode() + " - " + course.getTitle());

        for (Student s : students) {
            for (Course c : s.getCourses()) {
                if (c.getCode().equalsIgnoreCase(code)) {
                    System.out.println(s);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Registrar registrar = new Registrar();

        Course cs101 = new Course("CS101", "Intro to Programming", 3, 3);
        Course math110 = new Course("MATH110", "College Algebra", 4, 2);
        Course eng101 = new Course("ENG101", "English Composition", 3, 2);

        registrar.addCourse(cs101);
        registrar.addCourse(math110);
        registrar.addCourse(eng101);

        Student s1 = new Student("Ved Patel", "S001", 3.7);
        Student s2 = new Student("Aarav Shah", "S002", 3.5);
        Student s3 = new Student("Maya Singh", "S003", 3.9);
        Student s4 = new Student("Rohan Mehta", "S004", 3.2);

        registrar.register(s1, cs101);
        registrar.register(s1, math110);

        registrar.register(s2, cs101);
        registrar.register(s2, eng101);

        registrar.register(s3, cs101);

        s1.drop("MATH110");

        try {
            registrar.register(s4, cs101);
        } catch (Exception e) {
            System.out.println("Enrollment failed: " + e.getMessage());
        }

        System.out.println(cs101);
        System.out.println(math110);
        System.out.println(eng101);

        registrar.printRoster("CS101");
    }
}