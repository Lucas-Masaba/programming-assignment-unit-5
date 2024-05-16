import java.util.Scanner;

public class Administrator {
  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1. Add a new course");
      System.out.println("2. Enroll a student in a course");
      System.out.println("3. Assign a grade to a student");
      System.out.println("4. Calculate overall grade for a student");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter course code: ");
          String courseCode = scanner.next();
          System.out.print("Enter course name: ");
          String courseName = scanner.next();
          System.out.print("Enter maximum capacity: ");
          int maxCapacity = scanner.nextInt();
          CourseManagement.addCourse(courseCode, courseName, maxCapacity);
          break;

        case 2:
          System.out.print("Enter student name: ");
          String studentName = scanner.next();
          System.out.print("Enter student ID: ");
          String studentId = scanner.next();
          Student student = new Student(studentName, studentId);
          System.out.print("Enter course code: ");
          courseCode = scanner.next();
          Course course = findCourse(courseCode);
          if (course != null) {
            CourseManagement.enrollStudent(student, course);
          } else {
            System.out.println("Course not found.");
          }
          break;

        case 3:
          System.out.print("Enter student ID: ");
          studentId = scanner.next();
          student = findStudent(studentId);
          if (student != null) {
            System.out.print("Enter course code: ");
            courseCode = scanner.next();
            course = findCourse(courseCode);
            if (course != null) {
              System.out.print("Enter grade: ");
              double grade = scanner.nextDouble();
              CourseManagement.assignGrade(student, course, grade);
            } else {
              System.out.println("Course not found.");
            }
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 4:
          System.out.print("Enter student ID: ");
          studentId = scanner.next();
          student = findStudent(studentId);
          if (student != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall Grade: " + overallGrade);
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 5:
          System.out.println("Exiting...");
          scanner.close();
          return;

        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  public static Course findCourse(String courseCode) {
    for (Course course : CourseManagement.getCourses()) {
      if (course.getCourseCode().equals(courseCode)) {
        return course;
      }
    }
    return null;
  }

  private static Student findStudent(String studentId) {
    for (Student student : CourseManagement.getStudentGrades().keySet()) {
      if (student.getId().equals(studentId)) {
        return student;
      }
    }
    return null;
  }
}
