import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private ArrayList<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Removed task: " + removedTask);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. List Tasks\n4. Exit\nEnter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task to add:");
                    String taskToAdd = scanner.nextLine();
                    taskList.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.println("Enter index of task to remove:");
                    int indexToRemove = scanner.nextInt();
                    taskList.removeTask(indexToRemove - 1);
                    break;
                case 3:
                    taskList.listTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
        System.out.println("Exiting program.");
    }
}