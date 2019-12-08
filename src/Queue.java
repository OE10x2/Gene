/*
Name: Ethan Zhang
Course: ICS4U1-01
Teacher: Mr. Radulovic
Date Finished: December 8, 2019
Assignment: ADT-Gene Assignment

Description:
This class creates an ADT named Queue. Here, Queue uses an ArrayList, but it follows LIFO.
The operations are enqueue, dequeue, and isEmpty. They all take O(1) time complexity.
*/
public class Queue<T>{
    private ArrayList<T> array = new ArrayList<>(); //Implement queue with ArrayList

    public void enqueue(T node){
        //Add node; for this queue, we add to the end of the ArrayList
        array.addNode(node);
    }

    public T dequeue(){
        //For this queue, we remove elements from the beginning of the ArrayList
        T temp = array.getNode(0); //Get the value
        array.removeFront(); //Remove node
        return temp;
    }

    public boolean isEmpty(){
        //Checks if the queue is empty or not
        return array.size() == 0;
    }
}
