
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create the model (Student)
        Student student = new Student("Amith", 123, "A");

        // Create the view (StudentView)
        StudentView view = new StudentView();

        // Create the controller (StudentController)
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Ankur Arora");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}

