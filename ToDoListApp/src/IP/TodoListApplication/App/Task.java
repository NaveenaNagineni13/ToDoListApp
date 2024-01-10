package IP.TodoListApplication.App;

import IP.TodoListApplication.DataSorting.*;

import java.time.LocalDate;




public class Task {

    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String projectName;

    

    public String getId() {
        return id;
    }

    

    public String getTitle() {
        return title;
    }

    
    public LocalDate getDueDate() {
        return dueDate;
    }

   

    public String getStatus() {
        return status;
    }

    
    public String getProjectName() {
        return projectName;
    }

   
    public void setId(String id) {
        this.id = id;
    }

   

    public void setTitle(String title) {
        this.title = title;
    }

   
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

  
    public void setStatus(String status) {
        this.status = status;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

   
    public static Task buildTask(String id, String title, LocalDate dueDate, String status, String projectName) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setProjectName(projectName);

        return task;
    }


    @Override
    public String toString() {
        return id + "," + title + "," + DataSorting.convertDateToString(dueDate, "dd-MM-yyyy") + "," + status + "," + projectName;
    }

}