/*
Name: Ethan Zhang
Course: ICS4U1-01
Teacher: Mr. Radulovic
Date Finished: December 8, 2019
Assignment: ADT-Gene Assignment

Description:
This class is used to store any information as a Node. It's easier to organize elements this way.
The Nodes are used in ArrayList. This allows the ArrayList to contain any type of element.
*/
public class Node<T>{
    private T data; //Make the data any type, so the node can contain any data

    public Node(T n){
        //Assigns the value of the node
        data = n;
    }

    public T getValue(){
        //Returns the value of the node, in type T
        return data;
    }
}