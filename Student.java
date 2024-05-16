import java.util.HashMap;
import java.util.Map;

public class Student {
  private String name;
  private String id;
  private Map<Course, Double> enrolledCourses;

  public Student(String name, String id) {
    this.name = name;
    this.id = id;
    this.enrolledCourses = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Map<Course, Double> getEnrolledCourses() {
    return enrolledCourses;
  }

  public void enrollCourse(Course course) {
    if (course.getCurrentEnrollment() < course.getMaxCapacity()) {
      enrolledCourses.put(course, null);
      course.incrementEnrollment();
    } else {
      System.out.println("Course capacity reached.");
    }
  }

  public void assignGrade(Course course, double grade) {
    if (enrolledCourses.containsKey(course)) {
      enrolledCourses.put(course, grade);
    } else {
      System.out.println("Student is not enrolled in this course.");
    }
  }
}