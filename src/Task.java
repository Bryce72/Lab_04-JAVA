/******
 Name: Bryce Dunlap
 Assignment: Lab 4
 Date: 3/14/2024
 ******/


// this basically holds the data I will make for my tasks
public class Task {
    private String description;
    private Date date;
    private boolean completed = false;
    private Priority priority;



    public Task(String description, Date date, Priority priority) {
        this.description = description;
        this.date = date;
        this.priority = priority;
    }



    //setters
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void completed(boolean isCompleted) {
        this.completed = isCompleted;
    }
    public void Priority(Priority priority) {
        this.priority = priority;
    }


    // making my getters


    public String getDescription() {
        return this.description;
    }
    public Date getDate() {
        return this.date;
    }
    public boolean getCompleted() {
        return this.completed;
    }
    public Priority getPriority() {
        return this.priority;
    }
}
