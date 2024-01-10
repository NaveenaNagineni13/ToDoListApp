package IP.TodoListApplication.Features;

import IP.TodoListApplication.DataSorting.*;
import IP.TodoListApplication.App.*;

import java.util.Scanner;



public class AddTask extends Actions {

   
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions and press ENTER:");
        System.out.println("IP.TodoListApplication.App.Task ID, IP.TodoListApplication.App.Task Title, Due Date (format: dd-mm-yyyy), IP.TodoListApplication.App.Task Status, Project Name");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }


    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter Information: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    if (DataSorting.isDateValid("dd-MM-yyyy", parts[2])) {
                        if (TodoList.tasks.get(parts[0]) == null) {
                            return userInput;
                        } else {
                            System.out.println("A task with this ID already exists, try again: ");
                        }
                    } else {
                        System.out.println("The date entered is invalid, try again: ");
                    }
                } else {
                    System.out.println("Please follow instructions, try again: ");
                }
            } else {
                return userInput;
            }
        }
    }

   
    @Override
    public void executeAction(String command) {
        String[] parts = command.split(",");
        Task task = Task.buildTask(parts[0], parts[1], DataSorting.parseDate("dd-MM-yyyy", parts[2]),
                parts[3], parts[4]);

        TodoList.tasks.put(task.getId(), task);
        System.out.println("IP.TodoListApplication.App.Task successfully added!");

    }
}