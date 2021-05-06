//I worked on the homework assignment alone, using only course material
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
*This class implements a linked list with various functionalities
*@author Athena Wu
*@version 1.0
*@param <T> of generic class type
*/
public class LinkedList<T> {
    private Node<T> head;
    private int size;
    /**
    *Sets the head to null and size to 0 to instantiate LinkedList
    */
    public LinkedList() {
        head = null;
        size = 0;
    }
    /**
    *Method that adds another Node at the specified index in the
    *Linked List.
    * @param data of the Node
    * @param index of where the Node should be inserted
    */
    public void addAtIndex(T data, int index) {
        int tempIndex = 1;
        Node<T> current = head;
        try {
            if (index == 0) {
                //System.out.print("1");
                size += 1;
                head = new Node<T>(data, head);
            } else if (index > size || index < 0) {
                throw new IllegalArgumentException();
            } else if (index == 0) {
                //System.out.print("2");
                Node<T> copy = current;
                Node<T> addNode = new Node<T>(data, copy);
                head = addNode;
                current = head;
                size++;
            } else if (index == size) {
                    //System.out.print("3");
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                Node<T> addNode = new Node<T>(data, null);
                current.setNext(addNode);
                size++;
            } else {
                while (tempIndex != index) {
                    //System.out.print("again");
                    current = current.getNext();
                    tempIndex++;
                }
                //System.out.print("9");
                if (tempIndex == index) {
                    Node<T> node1 = current.getNext();
                    Node<T> addNode = new Node<T>(data, node1);
                    current.setNext(addNode);
                    size++;
                }
            }
        } catch (IllegalArgumentException a) {
            System.out.println("Sorry, the index is out of bounds");
        }
    }
    /**
    *Method that removes the Node at the index that is specified
    *@return T data of the removed Node at that particular index
    *@param index of the removed Node
    */
    public T removeFromIndex(int index) {
        int tempIndex = 1;
        T dataVal;
        Node<T> current = head;
        while (true) {
            if (index >= size || index < 0) {
                throw new IllegalArgumentException("Sorry, the index is out of bounds");
            } else if (index == 0 && index != size) {
                dataVal = current.getData();
                head = current.getNext();
                current = head;
                size--;
                return dataVal;
            } else if (tempIndex == size && index == size - 1) {
                dataVal = current.getData();
                current.setNext(null);
                return dataVal;
            } else if (tempIndex != index) {
                current = current.getNext();
                tempIndex++;
            } else {
                dataVal = current.getNext().getData();
                Node<T> value = current.getNext().getNext();
                current.setNext(value);
                size--;
                return dataVal;
            }
        }
    }
    /**
    *Method will clear out the entire linked list
    */
    public void clear() {
        head = null;
        size = 0;
    }
    /**
    *Method will get the data at the specified index in the LinkedList
    *@param index of the data
    *@return data at that index
    */
    public T get(int index) {
        int tempIndex = 0;
        Node<T> current = head;
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Sorry, the index is out of bounds");
        }
        while (tempIndex != index) {
            current = current.getNext();
            tempIndex++;
        }
        return current.getData();
    }
    /**
    *Method that returns true or false depending on if the
    *LinkedList is currently empty
    *@return true or false value
    */
    public boolean isEmpty() {
        return (head == null);
    }
    /**
    *Convert the LinkedList to an ArrayList
    *@return the ArrayList created
    */
    public ArrayList<T> toArrayList() {
        Node<T> current = head;
        ArrayList<T> linkedValues = new ArrayList<T>(size);
        while (current != null) {
            linkedValues.add(current.getData());
            current = current.getNext();
        }
        return linkedValues;
    }
    /**
    *Method that takes in data that's in the linkedList, removes
    *that element, and moves that element to the front
    *@param data that is removed and moved to the front
    */
    public void toTheFront(T data) {
        Node<T> current = head;
        if (size == 1) {
            if (!(current.getData().equals(data))) {
                throw new NoSuchElementException();
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        while (!((current.getNext().getData()).equals(data))) {
        //do you use .equals?
        //also, why is the exception not throwing...
            current = current.getNext();
            if (current.getNext() == null) {
                throw new NoSuchElementException();
            }
        }
        Node<T> tempNode = current.getNext().getNext();
        T storedData = current.getNext().getData();
        current.setNext(tempNode);
        this.addAtIndex(storedData, 0);
    }
    /**
    *Method finds the middle of the linked list
    *@return the middle value of the linked list
    */
    public T accessMiddle() {
        int length = 0;
        Node<T> current = head;
        if (current == null) {
            return null;
        }
        while (current.getNext() != null) {
            current = current.getNext();
            length += 1;
        }
        current = head;
        int steps = length / 2;
        for (int i = 0; i < steps; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
}