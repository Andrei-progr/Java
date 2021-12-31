package com.company;

public class HashSet <E> implements Collection<E>{

    private int size;
    private HashMap<E, Object> map;
    private final Object present = new Object();


    HashSet(){
        size = 0;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey((E)o);
    }

    @Override
    public Object[] toArray() {
        return map.keySet();
    }

    @Override
    public boolean add(E e) {
        map.put(e, present);
        return true;
    }

    @Override
    public boolean remove(Object e) {
        map.remove((E)e);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        Object[] keySet = map.keySet();
        Object[] arr = c.toArray();
        int res = 0;

        for (Object iter : arr){
            for (Object i : keySet){
                if (i == iter || i.equals(iter)){
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
        for (Object iter : arr){
            map.put((E)iter, present);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {


        for (Object iter : c.toArray()){
            map.remove((E)iter);
        }
        return true;

    }

    @Override
    public void clear() {
        removeAll(this);
    }

    public void print(){
        Object[] arr = this.toArray();
        for (Object iter : arr){
            System.out.println(iter);
        }
    }
}
