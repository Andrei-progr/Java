package com.company;

public interface Collection<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Object[] toArray();
    boolean add(E e);
    boolean remove(Object e);
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    void clear();

}
