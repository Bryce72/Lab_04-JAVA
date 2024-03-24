/******
 Name: Bryce Dunlap
 Assignment: Lab 4
 Date: 3/14/2024
 ******/

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Current size of the list is: " + list.getListSize());

        // here is where i will make my date objects
        Date thisWeekend = new Date(16, 3, 2024);
        Date endOfSemester = new Date(15, 4, 2024);

        // cs5004 task object that is urgent
        Task cs5004 = new Task("This is my 5004 task, do module 5", thisWeekend, Priority.URGENT);
        // cs5008 task object that is low priority
        Task cs5008 = new Task("This is my 5008 task, relax", thisWeekend, Priority.LOW);


        //fun task that is kinda important
        Task funTask = new Task("Have some fun, get some sun", thisWeekend, Priority.KINDA_IMPORTANT);

        // lets test and see if we can add the tasks to the list!
        list.addFront(cs5004);
        list.addFront(funTask);
        list.addBack(cs5008);

        // Lets see if it will print them!
        list.printNodes();

        System.out.println(list.getHead().todoData.getDescription()); // just want to verify.. this should print funtask

        // it was a success
        System.out.println();

        //now lets see if I can remove a task
        list.removeFirstNode();
        System.out.println(list.getHead().todoData.getDescription()); // this should print the cs5004 description now!
        //it worked!

        // just to make sure I want to print all the nodes to make sure the funtask is gone
        list.printNodes();
        //Success!

        System.out.println();

        //Now lets add a node and then remove it, via the position we want
        list.addFront(cs5004);
        list.addFront(funTask);
        list.addFront(cs5004);
        list.addFront(cs5004);
        //and yes I know they are duplicate nodes but I just want to show removing a node from a specific spot

        list.printNodes();
        // at this point we should see that there are 6 nodes in our list. I want to delete the funTask.
        list.removeNodeAnywhere(3);
        // now this should print 5 nodes. None of which will have the funtask.
        System.out.println();
        list.printNodes();

        // perfect. That was a success
        System.out.println();

        //Now what if the list is too large to be able to just know what position its at. We need to find the node. I'll demonstate that below.
        System.out.println(list.findTask(cs5008)); // since currently all the nodes are duplicated except my cs5008 task. Lets find the cs5008!
        // success, we received a 5. Thats exactly where cs5008 task was in the list! We can use that info to remove it if we wanted on larger scales!

        System.out.println();

        // alright so we now want to count how many tasks are completed. Lets first make sure our value is set to zero:
        System.out.println("There are this many tasks completed: " + list.countCompletedTasks()); // should be 0
        // lets complete a task
        cs5008.completed(true);
        System.out.println("There are this many tasks completed: " + list.countCompletedTasks()); // should print 1
        //success!

        System.out.println();

        //lets print all the URGENT priority tasks. We can essentially do this with any priority but because I am having fun with it lets just print kinda important priority
        list.addFront(funTask); // we can change priority when we instantiate it or by calling the task and changing the setter
        list.printNodeSpecificPriority(Priority.KINDA_IMPORTANT);

        //success it printed the description of the task with KINDA_IMPORTANT priority!

        System.out.println();

        /*
        * There were a few other functions not being displayed here. Please understand. I know how to use the functions. I know how to write them.
        * */







    }
}
