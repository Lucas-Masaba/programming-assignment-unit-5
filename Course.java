public class Course {
  private String courseCode;
  private String courseName;
  private int maxCapacity;
  private int currentEnrollment;

  private static int totalEnrolledStudents = 0;

  public Course(String courseCode, String courseName, int maxCapacity) {
      this.courseCode = courseCode;
      this.courseName = courseName;
      this.maxCapacity = maxCapacity;
      this.currentEnrollment = 0;
  }

  public String getCourseCode() {
      return courseCode;
  }

  public String getCourseName() {
      return courseName;
  }

  public int getMaxCapacity() {
      return maxCapacity;
  }

  public int getCurrentEnrollment() {
      return currentEnrollment;
  }

  public void incrementEnrollment() {
      if (currentEnrollment < maxCapacity) {
          currentEnrollment++;
          totalEnrolledStudents++;
      }
  }

  public static int getTotalEnrolledStudents() {
      return totalEnrolledStudents;
  }
}