public class LinkedList {
    private int size;
    private Node head;


    // this is what I know from C.. Set the node head to null and size 0.. since nothing is added yet
    public LinkedList() {
        this.size = 0;
        this.head = null;


        // making function to insert a node at the END of list
        public void addBack (Task todoData){
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
        // Adding a node to the front
        public void addFront (Task todoData){
            Node node = new Node();
            node.todoData = todoData; // making sure my todo data is in my new node
            node.next = this.head; // pushing the original head to the next position
            this.head = node; // and now assigning the new node i made to the head
            this.size++;
        }

        // add node anywhere
        public void putNodeAnywhere (Task todoData,int position){
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

        // remove the first node
        public void removeFirstNode () {
            // dont want to delete an "empty" list.. hence why we check if head is null
            if (head != null) {
                this.head = this.head.next;
                this.size--;
            } else {
                throw new IllegalCallerException("More than likely, you are trying to remove a node from an empty list");
            }

        }


        // remove back with recursion
        public void removeLastNode () {
            if (this.head == null || this.head.next == null) { //basically just setting the case for a 1 node list or empty
                this.head = null;
                size = 0;
            } else {
                removeLastNodeRecursively(this.head);
                size--;
            }
        }
    }
        private void removeLastNodeRecursively(Node node){
            if(node.next.next == null){
                node.next = null;

            }else {
                removeLastNodeRecursively(node.next);
            }
        }
    // remove the last node
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
            }
         }
    */




}
