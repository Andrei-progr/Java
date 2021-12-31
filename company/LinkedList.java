package com.company;

public class LinkedList <E> implements Collection <E>{

    private int size;
    private Node <E> header;


    public LinkedList(){
        size = 0;
        header = new Node<>(null, null, null);
        header.next = header;
        header.prev = header;
        header.value = null;
    }


    private class Node<E> {

        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> next, Node<E> prev)
        {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> i = header.next; i != header; i = i.next) {
                if (i.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> i = header.next; i != header; i = i.next) {
                if (o.equals(i.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }


    @Override
    public Object[] toArray() {

        Object[] arr = new Object[this.size];
        int index = 0;
        for (Node<E> i = header.next; i != header; i = i.next) {
                arr[index] = i.value;
                index++;
            }

        return arr;
    }

    @Override
    public boolean add(E e) {

        Node<E> node = header;
        Node<E> newNode = new Node<E>(e, node, node.prev);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
        return true;
    }


    public boolean add(int index, E e) {

        int i = 0;
        if (index < size) {
            Node<E> node = header.next;
            for (; node != header; node = node.next) {
                if (i == index) {
                    break;
                }
                i++;
            }
            Node<E> newNode = new Node<E>(e, node, node.prev);
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
        }else{
            add(e);
        }
        size++;
        return true;
    }



    @Override
    public boolean remove(Object e) {

        if (e == null) {
            for (Node<E> node = header.next; node != header; node = node.next) {
                if (node.value == null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                    return true;
                }
            }
        } else {
            for (Node<E> node = header.next; node != header; node = node.next) {
                if (e.equals(node.value)) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        int res = 0;
        Object[] arr = c.toArray();

        for (Object iter : arr){
            for (Node<E> node = header.next; node != header; node = node.prev){
                if (node.value == iter){
                    res++;
                    break;
                }
            }
        }
        return res == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        Object[] arr = c.toArray();
        for (int i = 0; i < c.size(); i++){
            add((E)arr[i]);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        int newSize = c.size();
        Object[] arr = c.toArray();
        for (int i = 0; i < newSize; i++){
            remove(arr[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        removeAll(this);
    }

    public void print(){
        for (Node<E> i = header.next; i != header; i = i.next) {
            System.out.println(i.value);
        }
    }
}
