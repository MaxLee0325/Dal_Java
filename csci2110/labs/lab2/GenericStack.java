package csci2110.labs.lab2;
import java.util.ArrayList;
public class GenericStack<T> {
    private ArrayList<T> stack;
    private int size = 0;

    public GenericStack(){
        stack = new ArrayList<>();
    }

    public int getSize(){return size;}

    public T peek(){
        if(size == 0)
            return null;
        else
            return stack.get(size - 1);
    }
    public void push(T item){
        stack.add(item);
        size++;
    }
    public T pop(){
        if(size == 0)
            return null;
        else {
            T temp = stack.get(size - 1);
            stack.remove(size - 1);
            size--;
            return temp;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
