import java.util.ArrayList;

public class CourseManagement {
  private static ArrayList<Course> courses;
  private static ArrayList<Double> grades;

  public static void addCourse(String courseCode, String name, int maxCapacity) {
    Course course = new Course(courseCode, name, maxCapacity);
    courses.add(course);
  }

  public static void enrollStudent(Student student, Course course) {
    // Check if course has reached max capacity
    if (course.getMaxCapacity() > Course.numberOfEnrolledStudents()) {
      student.enrollCourse(course.getCourseCode(), courses);
      Course.setNumberOfEnrolledStudents();
    } else {
      System.out.println("Course has reached maximum capacity.");
    }
  }

  public static void assignGrade(Student student, Course course, int grade) {
    student.assignGrade(course.getCourseCode(), grade);
  }

  public static double calculateOverallGrade(Student student) {
    double sum = 0;
    for (double grade : student.getGrades()) {
      sum += grade;
    }
    grades.add(sum);
    return sum;
  }
}
