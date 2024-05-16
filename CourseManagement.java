import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
  private static List<Course> courses = new ArrayList<>();
  private static Map<Student, Map<Course, Double>> studentGrades = new HashMap<>();

  public static List<Course> getCourses() {
    return courses;
  }

  public static Map<Student, Map<Course, Double>> getStudentGrades() {
    return studentGrades;
  }

  public static void addCourse(String courseCode, String courseName, int maxCapacity) {
    courses.add(new Course(courseCode, courseName, maxCapacity));
  }

  public static void enrollStudent(Student student, Course course) {
    student.enrollCourse(course);
    if (!studentGrades.containsKey(student)) {
      studentGrades.put(student, new HashMap<>());
    }
    studentGrades.get(student).put(course, null);
  }

  public static void assignGrade(Student student, Course course, double grade) {
    student.assignGrade(course, grade);
    studentGrades.get(student).put(course, grade);
  }

  public static double calculateOverallGrade(Student student) {
    Map<Course, Double> grades = studentGrades.get(student);
    if (grades == null || grades.isEmpty()) {
      return 0;
    }
    double total = 0;
    int count = 0;
    for (Double grade : grades.values()) {
      if (grade != null) {
        total += grade;
        count++;
      }
    }
    return count == 0 ? 0 : total / count;
  }
}
