package hw4;

interface PriorityQueue<E> {

    public E dequeue();
    
    public void enqueue(E item);

    public boolean isEmpty();
}