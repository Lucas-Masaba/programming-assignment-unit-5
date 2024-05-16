import java.util.ArrayList;

public class Student {
  private String id;
  private String name;
  private ArrayList<Course> enrolledCourses;
  private ArrayList<Double> grades = new ArrayList<Double>();

  public Student(String id, String name) {
    this.id = id;
    this.name = name;
    this.enrolledCourses = new ArrayList<Course>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Double> getGrades() {
    return grades;
  }

  public void getStudentInformation(String id, ArrayList<Student> students) {
    for (Student student : students) {
      if (student.id.equals(id)) {
        System.out.println("Student ID: " + student.id);
        System.out.println("Student Name: " + student.name);
        System.out.println("Enrolled Courses: ");
        for (Course course : student.enrolledCourses) {
          System.out.println(course.getCourseName());
        }
      } else {
        System.out.println("The Student you are trying to see the details of does not exist.");
      }
    }
  }

  public void setStudentInformation(String id, String name, ArrayList<Student> students) {
    for (Student student : students) {
      if (student.id.equals(id)) {
        student.name = name;
        System.out.println("Student ID: " + student.id);
        System.out.println("Student Name: " + student.name);
      } else {
        System.out.println("The Student you are trying to update the details of does not exist.");
      }
    }
  }

  public void enrollCourse(String CourseCode, ArrayList<Course> courses) {
    for (Course course : courses) {
      if (course.getCourseCode().equals(CourseCode)) {
        enrolledCourses.add(course);
      } else {
        System.out.println("The Course you are trying to enroll in does not exist.");
      }
    }
  }

  public void assignGrade(String CourseCode, double grade) {
    for (Course course : enrolledCourses) {
      if (course.getCourseCode().equals(CourseCode)) {
        course.assignGrade(id, grade);
        grades.add(grade);
      } else {
        System.out.println("The Course you are trying to assign a grade to does not exist.");
      }
    }
  }
}