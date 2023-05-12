package ts4;
//Task class for a CPU task
class Task {
	//priority of the task
    int priority;
    //time taken by task to complete job
    int time;
    //task name
    String name;
   //constructor for task object
    public Task(String name, int priority, int time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }
    //check if  tasks have same priority
    public static boolean equalpri(Task[] tasks) {
        // Iterate over the array of tasks
        for (int i = 0; i < tasks.length - 1; i++) {
            // Compare the priority of the current task with the priority of the next task
            if (tasks[i].priority != tasks[i + 1].priority) {
                // If their priorities are different, return false
                return false;
            }
        }
        // If all tasks have the same priority, return true
        return true;
    }
   
    //method for first come first served
    public static void first(Task[] tasks, int taskIndex) {
        System.out.println("First Come First Served:");
     // for each time slice needed to complete the task
        Task task = tasks[taskIndex];
        for (int i = 0; i < task.time; i++) { 
        	// print the system time and the name of the scheduled task
            System.out.println("System time: " + i + ", Task: " + task.name); 
        }
    }

    //method for scheduling the task with the highest priority
	public static void highPri(Task[] tasks) {
	    System.out.println("Highest Priority:");
	 // variable to keep track of the highest priority task
	    Task hp = null; 
	 // for each task in the array
	    for (Task task : tasks) { 
	    	// if this is the first task or if its priority is higher than the current highest priority task
	        if (hp == null || task.priority > hp.priority) { 
	            hp = task; // update the highest priority task
	        }
	    }
	    for (int i = 0; i < hp.time; i++) { // for each time slice needed to complete the highest priority task
	        System.out.println("System time: " + i + ", Task: " + hp.name);
	    }
	}
	//method for shortest task
	public static void ShortestTask(Task[] tasks) {
	    System.out.println("Shortest task:");
	    Task shorttask = null; // variable to keep track of the highest priority task
	    for (Task task : tasks) { // for each task in the array
	        if (shorttask == null || task.time < shorttask.time) { // if this is the first task or if its priority is higher than the current highest priority task
	        	shorttask = task; // update the highest priority task
	        }
	    }
	    for (int i = 0; i < shorttask.time; i++) { // for each time slice needed to complete the highest priority task
	        System.out.println("System time: " + i + ", Task: " + shorttask.name);
	    }
	}
}

public class Schcpu {
    public static void main(String[] args) {
    	//array of task objects
        Task[] tasks = new Task[2];
        tasks[0] = new Task("Task1", 10, 10);
        tasks[1] = new Task("Task2", 12, 5);

        
        //Take First come first served
        if (Task.equalpri(tasks)) {
        	Task.first(tasks,0);
        } 
        //Take highest priority
        else if(Task.equalpri(tasks)==false) {
        	Task.highPri(tasks);
        	
        }
        //Take shortest job first
        else
        {
        	Task.ShortestTask(tasks);
        }
//        
    }
}




