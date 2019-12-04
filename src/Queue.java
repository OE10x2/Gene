public class Queue<T>{
    private ArrayList<T> array = new ArrayList<>();

    public void enqueue(T node){
        array.addNode(node);
    }

    public T dequeue(){
        T temp = array.getNode(0);
        array.removeNode(0);
        return temp;
    }

    public boolean isEmpty(){
        return array.size() == 0;
    }
}
