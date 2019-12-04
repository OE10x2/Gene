public class ArrayList<T>{
    private int size = 1;
    private int length = 0;
    private Node<T>[] array = new Node[size];

    public void create(){
        size *= 2; //Double the size of the array whenever the length is not enough
        Node<T>[] newArray = new Node[size];
        for (int i = 0; i < length; i++) newArray[i] = array[i];
        array = newArray;
    }

    public void addNode(T n){
        if (length >= size) create();
        array[length++] = new Node<>(n);
    }

    public void removeNode(int i){
        for (int loop = i; loop < length - 1; loop++) array[loop] = array[loop + 1];
        length = Math.max(length - 1, 0);
    }

    public void replaceNode(T n, int i){
        array[i] = new Node<>(n);
    }

    public T getNode(int i){
        return array[i].getValue();
    }

    public int size(){
        return length;
    }
}
