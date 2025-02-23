package org.example;

import java.util.List;
import java.util.Scanner;
import org.example.ToDoDAO;
import org.example.ToDoItem;
import org.example.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoDAO toDoDAO = new ToDoDAO(); //  Ensure DAO is declared correctly

        while (true) {
            System.out.println("\n=== To-Do List Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    toDoDAO.addToDo(task); //  Fixed
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    List<ToDoItem> tasks = toDoDAO.getAllToDos(); //  Fixed
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("\nYour To-Do List:");
                        for (ToDoItem item : tasks) {
                            System.out.println(item.getId() + ". " + item.getTask() + " (Completed: " + item.isCompleted() + ")");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the ID of the task to delete: ");
                    int id = scanner.nextInt(); //  Declare 'id' properly
                    scanner.nextLine(); // Clear the buffer

                    toDoDAO.deleteToDo(id); //  Call correctly

                    System.out.println("Task deleted successfully.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    HibernateUtil.shutdown();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

