import java.util.Scanner;

public class Administrator {
  public void run() {
    Scanner scanner = new Scanner(System.in);

    // Display menu
    System.out.println("1. Add a new course");
    System.out.println("2. Enroll a student in a course");
    System.out.println("3. Assign grades to a student");
    System.out.println("4. Calculate overall course grades");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        System.out.print("Enter max capacity: ");
        int maxCapacity = scanner.nextInt();
        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
        break;
      case 2:
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        courseCode = scanner.next();
        Student student = new Student(studentId, "");
        Course course = new Course("", "", 0);
        CourseManagement.enrollStudent(student, course);
        break;
      case 3:
        System.out.print("Enter student ID: ");
        studentId = scanner.next();
        System.out.print("Enter course code: ");
        courseCode = scanner.next();
        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();
        student = new Student(studentId, "");
        course = new Course("", "", 0);
        CourseManagement.assignGrade(student, course, grade);
        break;
      case 4:
        System.out.print("Enter student ID: ");
        studentId = scanner.next();
        student = new Student(studentId, "");
        CourseManagement.calculateOverallGrade(student);
        break;
      case 5:
        System.out.println("Exiting...");
        scanner.close();
        return;
      default:
        System.out.println("Invalid choice.");
    }
  }
}
