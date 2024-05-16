import java.util.ArrayList;
public class Course {
  private String courseCode;
  private String name;
  private int maxCapacity;
  private static int totalEnrolledStudents = 0;
  private ArrayList<Student> students;

  public Course(String courseCode, String name, int maxCapacity) {
    this.courseCode = courseCode;
    this.name = name;
    this.maxCapacity = maxCapacity;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public String getCourseName() {
    return name;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public void getCourse(String courseCode, ArrayList<Course> courses) {
    for (Course course : courses) {
      if (course.courseCode.equals(courseCode)) {
        System.out.println("Course Code: " + course.courseCode);
        System.out.println("Course Name: " + course.name);
        System.out.println("Max Capacity: " + course.maxCapacity);
        System.out.println("Enrolled Students: " + totalEnrolledStudents);
      } else {
        System.out.println("The Course you are trying to see the details of does not exist.");
      }
    }
  }

  public static int numberOfEnrolledStudents() {
    return totalEnrolledStudents;
  }

  public static int setNumberOfEnrolledStudents() {
    return totalEnrolledStudents++;
  }

  public void assignGrade(String studentId, double grade) {
    for (Student student : students) {
      if (student.getId().equals(studentId)) {
        student.assignGrade(studentId, grade);
        student.getGrades().add(grade);
      } else {
        System.out.println("The Student you are trying to assign a grade to does not exist.");
      }
    }
  }

}
