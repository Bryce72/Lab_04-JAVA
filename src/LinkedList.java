/******
 Name: Bryce Dunlap
 Assignment: Lab 4
 Date: 3/14/2024
 ******/


import java.util.function.Function;
public class LinkedList {
    private int size;
    private Node head;


    // this is what I know from C.. Set the node head to null and size 0.. since nothing is added yet
    public LinkedList() {
        this.size = 0;
        this.head = null;

    }


    /*
     * Here I will have my methods, respectively:
     * Add node to the back of the list
     * Add node to the front of the list
     * Add node anywhere, given position
     * Remove first node in list
     * Remove last node in list
     * Remove any node, given position
     * Find if a node exists. aka a task in the list
     * Find last node
     * Print all the nodes, aka lists
     * get the size, aka how many nodes in list
     * get how many tasks are completed
     * print nodes based on priority
     */

    //adding node to the back
    public void addBack(Task todoData) {
        Node node = new Node();
        node.todoData = todoData; // putting my todolist in the node

        //if list is empty, insert at head
        if (this.head == null) {
            this.head = node;
            this.head.next = null;
            this.size = 1;
        } else {
            addBackRecursively(this.head, node);
            this.size += 1;
        }
    }

    //helper function for above
    private void addBackRecursively(Node current, Node newNode) {
        //if the next node is null. then ik the end of the list has been reached
        if (current.next == null) {
            current.next = newNode;
        } else {
            // if the end has not been reached then traverseto the next
            addBackRecursively(current.next, newNode);
        }
    }

    // Adding a node to the front
    public void addFront(Task todoData) {
        Node node = new Node();
        node.todoData = todoData; // making sure my todo data is in my new node
        node.next = this.head; // pushing the original head to the next position
        this.head = node; // and now assigning the new node i made to the head
        this.size++;
    }

    //put node anywhere using recursion
    public void putNodeAnywhere(Task todoData, int position) {
        if (position < 1 || position > size + 1) {
            throw new IllegalArgumentException("Position not within bounds of list");
        }
        head = putNodeAnywhereRecursively(head, todoData, position);
        size++;
    }

    //helper function for ABOVE
    private Node putNodeAnywhereRecursively(Node current, Task todoData, int position) {
        if (position == 1) {
            Node node = new Node();
            node.todoData = todoData;
            node.next = current;
            return node;
        } else {
            if (current == null) {
                return null;
            }
            current.next = putNodeAnywhereRecursively(current.next, todoData, position - 1);
            return current;
        }
    }


    // remove the first node
    public void removeFirstNode() {
        // dont want to delete an "empty" list.. hence why we check if head is null
        if (head != null) {
            this.head = this.head.next;
            this.size--;
        } else {
            throw new IllegalCallerException("More than likely, you are trying to remove a node from an empty list");
        }

    }


    // remove back with recursion
    public void removeLastNode() {
        if (this.head == null || this.head.next == null) { //basically just setting the case for a 1 node list or empty
            this.head = null;
            size = 0;
        } else {
            removeLastNodeRecursively(this.head);
            size--;
        }
    }

    //helper function for above
    private void removeLastNodeRecursively(Node node) {
        if (node.next.next == null) {
            node.next = null;

        } else {
            removeLastNodeRecursively(node.next);
        }
    }

    // This function allows me to delete any node, given the position it is located in the list
    public void removeNodeAnywhere(int position) {
        // checking the bounds of the list. given the position
        if (position < 1 || position > this.size || this.head == null) {
            throw new IllegalArgumentException("Position entered is not within bounds of list.. or list is empty");
        }
        // if the head needs removed... i supposed i couldve just called one of the other methods but this is about practicing so itll be added again
        if (position == 1) {
            this.head = this.head.next;
            this.size--;
            return; // says this is unnecissary but im too used to C
        }

        // traverse starting from the head
        removeNodeAnywhereRecursively(null, this.head, position, 1);
        this.size--;

    }

    private void removeNodeAnywhereRecursively(Node prev, Node current, int position, int currentIndex) {
        // this if condition is for when we successfully traverse to the node we want to remove
        if (currentIndex == position) {
            if (prev != null) {
                prev.next = current.next;
            }
            return; // another c thing
        }
        removeNodeAnywhereRecursively(current, current.next, position, currentIndex + 1);
    }


    // Now this function will figure out if a specific task is found in the list
    public int findTask(Task todoData) {
        int position = findTaskRecursively(this.head, todoData, 1);
        if (position == -1) {
            throw new IllegalArgumentException("this isnt a negative list");
        }
        return position;
    }

    //helper function for above
    private int findTaskRecursively(Node node, Task todoData, int index) {
        if (node == null) {
            // if this if condition goes through then the task was not found
            return -1;
        }
        if (node.todoData.equals(todoData)) {
            // this means the task was found
            return index;
        }
        //traversal
        return findTaskRecursively(node.next, todoData, index + 1);
    }

    //finding what the last node is
    public void getLastNode() {
        if (head != null) {
            Node lastNode = findLastNodeRecursively(this.head);
        }
    }

    //helper for above
    private Node findLastNodeRecursively(Node node) {
        if (node.next == null) {
            // returns found node at last position... since the last node points to null
            return node;
        } else {
            return findLastNodeRecursively(node.next);
        }
    }

    // prints the nodes
    public void printNodes() {
        if (this.head == null) {
            throw new IllegalArgumentException("List is empty");
        } else {
            printNodesRecursively(this.head, 0);
        }
    }

    //helper function
    private void printNodesRecursively(Node node, int index) {
        if (node == null) { // basee case
            return;
        }
        System.out.println("Description: " + node.todoData.getDescription() + "----The size of your todo list is: " + size + " The date to do this is: " + node.todoData.getDate().getMonth() + "/" + node.todoData.getDate().getDay() + "/" + node.todoData.getDate().getYear() + " The priority is: " + node.todoData.getPriority());
        printNodesRecursively(node.next, index + 1);
    }

    public int getListSize() {
        return size;
    }

    public Node getHead() {
        return this.head;
    }

    // I knoowww this doesnt use recursion. I believe I demonstrated how to do so. I popped this function in real quick to satisfy what was on the list of todos in the google doc.
    public int countCompletedTasks() {
        int count = 0;
        Node current = this.head;
        while (current != null) {
            if (current.todoData.getCompleted()) {
                count++;
            }
            current = current.next;
        }
        return count;
    }


    public void printNodeSpecificPriority(Priority priority) {
        Node current = this.head;
        while (current != null) {
            if (current.todoData.getPriority() == priority) {
                System.out.println("These are the descriptions of tasks with the specific priority you chose: " + current.todoData.getDescription()); // for simplicity sake just printing the description
            }
            current = current.next;
        }

    }



}

// remove the last node -- keeping this here cause thts how i wrote it originally
   /*public void removeLastNode(){
            Node currentNode = this.head;
            if(size == 1){
                // next should already be null in this case so no need to modify next
                head = null;
                size = 0;
            }else{
                Node prevNode = null;
                while(currentNode.next != null){
                    prevNode = currentNode; // need to keep track of the node before the last!
                    currentNode = currentNode.next; // this will allow me to traverse the list in this while loop
        }
        //P.S i know the brackets in my commented out code are off but the code prevails

     add node anywhere -- keeping code here cause i originally wrote it with a loop
    public void putNodeAnywhere(Task todoData, int position) {
        Node node = new Node();
        node.todoData = todoData;
        Node current = this.head;

        // here I will make sure I am within the bounds of my list. So I can loop through
        if (this.head != null && position <= this.size) {
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            this.size += 1;
        } else {
            throw new IllegalArgumentException("Position does not align with size of list");
        }
    }

     making function to insert a node at the END of list
    public void addBack(Task todoData) {
        Node node = new Node();
        node.todoData = todoData;
        Node current = this.head;

        //if list is empty
        if (this.head == null) {
            this.head = node; // assigning the node to head
            this.head.next = null; // since this is adding to the END. the next node needs to be null
            this.size = 1; // since we only added head the list is only 1 node
            System.out.println(this.head.toString());
        } else {

            // so what happens here is if the head is not null it will go through a while loop
            // looking for the null node.. since the end of a linked list points to null!
            // When the null is found it will insert a node there to the end!
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
            this.size += 1;
        }
    }
     */