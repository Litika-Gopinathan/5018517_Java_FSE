
public class Driver5 {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task(1, "Design the system", "In Progress");
        Task task2 = new Task(2, "Implement the system", "Pending");
        Task task3 = new Task(3, "Test the system", "Pending");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("Searching for Task with ID 1:");
        System.out.println(taskList.searchTask(1));

        System.out.println("Deleting Task with ID 2");
        taskList.deleteTask(2);

        System.out.println("All Tasks after deletion:");
        taskList.traverseTasks();
    }
}
