package cs2114;


/**
 * @author Shenyi Yu
 * @version 2018.10.26
 * @param <E>
 *            - the type E used in this lab
 
 */
public class Lab08Deque<E> extends DoubleLinkDeque<E> {

    /**
     * constructor
     */
    public Lab08Deque() {
        super();
        head = new DoubleLinkDeque.Node<E>(null);
        tail = new DoubleLinkDeque.Node<E>(null);
        head.setPrevious(null);
        head.setNext(tail);
        tail.setPrevious(head);
        tail.setNext(null);
        
    }
    //enque at front= push, but need to translate set next set previous 
    //to split and join
    @Override
    public void enqueueAtFront(E value) {
        //make a new node, next is getNext();,
        //previous is head.
        Node<E> node = new Node<E>(value);
        node.setNext(head.getNext());
        node.setPrevious(head);
        head.getNext().setPrevious(node);
        head.setNext(node);
        size++;

    }
    

    //pop = deq at front, just not set next and get next
    @Override
    public E dequeueAtFront() {
        if (size == 0) {
            return null;
        }
        
        Node<E> node = head.getNext(); 
        //the node we are moving
        head.setNext(node.getNext());
        head.getNext().setPrevious(head);
        
        //fix the node we removed 
        node.setNext(null);
        node.setPrevious(null);
        size--;
        return node.getData();
    }

    @Override
    public void enqueueAtRear(E value) {
        Node<E> node = new Node<E>(value);
        node.setNext(tail);
        node.setPrevious(tail.getPrevious());
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);
        size++;
        

    }

    @Override
    public E dequeueAtRear() {
        if (size == 0) {
            return null;
        }
        Node<E> node = tail.getPrevious();
        node.getPrevious().setNext(tail);
        tail.setPrevious(node.getPrevious());
        node.setNext(null);
        node.setPrevious(null);
        size--;
        return node.getData();
    }

    @Override
    public E frontItem() {
        
        return head.getNext().getData();
    }

    @Override
    public E rearItem() {
        return tail.getPrevious().getData();
    }

    @Override
    public void clear() {
        /*Node<E> first = head.getNext();
        Node<E> last = tail.getPrevious();
        for (int i = 0; i < size; i++) {
            first.setPrevious(null);
            first = first.getNext();
            last.setNext(null);
            last = last.getPrevious();
            first.setData(null);
        }*/
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }
    
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        Node<E> node = head.getNext();
        for (int i = 0; i < size - 1; i++) {
            result += node.getData() + ", ";
            node = node.getNext();
        }
        result += node.getData() + "]";
        return result;
    }

}
