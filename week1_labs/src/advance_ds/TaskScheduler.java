package intermediate.src.week1_labs.advance_ds;

import java.util.PriorityQueue;

// Task class representing a task with a priority
class Task implements Comparable<Task> {
    String name;
    int priority; // Lower number means higher priority
    
    public Task (String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    @Override
    public int compareTo (Task other) {
        // Min-Heap based on priority (lower priority number means higher priority)
        return Integer.compare( this.priority, other.priority );
    }
    
    @Override
    public String toString () {
        return "Task{name='" + name + "', priority=" + priority + '}';
    }
}

public class TaskScheduler {
    // Priority queue to act as a min heap
    private final PriorityQueue<Task> taskQueue;
    
    public TaskScheduler () {
        // Min Heap (default PriorityQueue in Java is a Min Heap)
        taskQueue = new PriorityQueue<>();
    }
    
    // Method to add a task to the schedule
    public void addTask (String taskName, int priority) {
        Task newTask = new Task( taskName, priority );
        taskQueue.add( newTask );
        System.out.println( "Added: " + newTask );
    }
    
    // Method to schedule the next task based on priority
    public void scheduleNextTask () {
        if ( !taskQueue.isEmpty() ) {
            Task nextTask = taskQueue.poll(); // Retrieves and removes the task with the highest priority
            System.out.println( "Scheduled: " + nextTask );
        } else {
            System.out.println( "No tasks to schedule." );
        }
    }
    
    // Method to display the remaining tasks in the queue
    public void displayPendingTasks () {
        if ( taskQueue.isEmpty() ) {
            System.out.println( "No pending tasks." );
        } else {
            System.out.println( "Pending tasks: " + taskQueue );
        }
    }
    
    public static void main (String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        // Adding tasks with different priorities
        scheduler.addTask( "Task 1", 3 ); // Medium priority
        scheduler.addTask( "Task 2", 1 ); // Highest priority
        scheduler.addTask( "Task 3", 5 ); // Lowest priority
        scheduler.addTask( "Task 4", 2 ); // High priority
        
        // Scheduling tasks
        System.out.println( "\nScheduling tasks..." );
        scheduler.scheduleNextTask(); // Task 2 (priority 1)
        scheduler.scheduleNextTask(); // Task 4 (priority 2)
        scheduler.scheduleNextTask(); // Task 1 (priority 3)
        
        // Display remaining tasks
        System.out.println( "\nDisplaying remaining tasks:" );
        scheduler.displayPendingTasks(); // Task 3 (priority 5)
        
        // Schedule the last task
        scheduler.scheduleNextTask(); // Task 3
    }
}
