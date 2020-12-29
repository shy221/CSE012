import java.util.EmptyStackException;

//-------------------------------------------------------------------------
/**
 * An implementation of the stack data type that uses a linked chain of
 * {@code Node<E>} objects to store its contents.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <E> the type of elements stored in the stack
 *
 * @author Tony Allevato (authored class skeleton)
 * @author  Shenyi Yu
 * @version 2018.10.26
 */
public class LinkedStack<E> implements StackInterface<E>
{
    //~ Fields ...............................................................
    /**
     * Creates a new Node with the specified data.
     *
     */
    private Node<E> head;


    //~ Constructors .........................................................


    // ----------------------------------------------------------
    /**
     * Creates a new Node with the specified data.
     * 
     */
    public LinkedStack()
    {

        this.head = new Node<E>(null);
//        data = null;
    }


    //~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * Pushes the specified item onto the top of the stack.
     * @param item the item being pushed
     */
    public void push(E item)
    {
        Node<E> newNode = new Node<E>(item);
        //only with split and join
        //first split head from the start of list 
        if (!isEmpty()) {
            
            Node<E> oldStart = head.split();
            newNode.join(oldStart); 
        }
        head.join(newNode);

    }


    // ----------------------------------------------------------
    /**
     * Pops an item off the top of the stack.
     * @throws EmptyStackException if the stack is empty
     */
    public void pop()
    {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            Node<E> newFirst = head.next().next();
            head.next().split();
            head.split();
            head.join(newFirst);
        }
    }


    // ----------------------------------------------------------
    //return head.next.data1;
    /**
     * Get the item at the top if the stack
     * @return the item at the top
     * @throws EmptyStackException if the stack is empty
     */
    public E peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
            
        }
        else {
            return head.next().data();
        }

    }


    // ----------------------------------------------------------
    /**
     * get the boolean value of whether stack is empty
     * @return the value determining if it is empty
     */
    public boolean isEmpty()
    {
        return head.next() == null;
    }
}
