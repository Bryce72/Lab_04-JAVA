public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        System.out.println("Current size of the list is: "+ list.getListSize());

        // here is where i will make my date objects
        Date thisWeekend = new Date(16, 3, 2024);
        Date endOfSemester = new Date(15, 4, 2024);

        // cs5004 task object that is urgent
        Task cs5004 = new Task("This is my 5004 task, do module 5", thisWeekend, Priority.URGENT);
        // cs5008 task object that is low priority
        Task cs5008 = new Task("This is my 5008 task, relax", thisWeekend, Priority.LOW);


        //fun task that is kinda important
        Task funTask = new Task("Have some fun, get some sun", thisWeekend, Priority.KINDA_IMPORTANT);

        // need to insert my tasks into the linked list
        list.addFront(cs5004);
        list.addFront(funTask);
        list.addBack(cs5008);

        // Lets see if it will print them!
        list.printNodes();

        // it was a success
    }
}
