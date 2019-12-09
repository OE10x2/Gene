/*
Name: Ethan Zhang
Course: ICS4U1-01
Teacher: Mr. Radulovic
Date Finished: December 8, 2019
Assignment: ADT-Gene Assignment

Description:
This class creates an ADT called ArrayList. This data structure can store any specified type.
The default size is set to 20001 since there are a maximum of 20000 genes.
Note that every operation in ArrayList takes O(1) time complexity.
*/
public class ArrayList<T>{
    private int size = 20001; //Default size
    private int length = 0; //Tracks the actual length of the ArrayList
    private int fix = 0; //Tracks the number of elements removed from the front
    private Node<T>[] array = new Node[size];

    public void addNode(T n){
        //We also add "fix" to the index; read document for details
        array[fix + length++] = new Node<>(n); //Convert n into a Node
    }

    public void removeFront(){
        //Removes the first element in the ArrayList
        fix++; //One more element at the front is not used
        length = Math.max(length - 1, 0); //Ensure that the value of length is non-negative
    }

    public void replaceNode(T n, int i){
        //Change the value of the Node
        array[i + fix] = new Node<>(n);
    }

    public T getNode(int i){
        //Returns the value at the given index
        return array[i + fix].getValue();
    }

    public int size(){
        //Returns the length of the ArrayList
        return length;
    }
}
