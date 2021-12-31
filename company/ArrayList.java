package com.company;

public class ArrayList <E> implements Collection<E>{

    private Object[] data;
    private int size;

    public ArrayList(){
        this.data = new Object[]{};
        this.size = 0;
    }

    public ArrayList(int size){
        this.data = new Object[size];
        this.size = size;
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
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return true;
                }
            }
            for (int j = 0; j < size; j++) {
                if (o.equals(data[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        for (int i = 0; i < this.size; i++){
            arr[i] = data[i];
        }
        return arr;
    }

    @Override
    public boolean add(E e) {

        Object[] arr = new Object[size + 1];
        for (int i = 0; i < size; i++){
            arr[i] = data[i];
        }
        arr[size] = e;
        data = arr;
        size += 1;
        return true;
    }

    @Override
    public boolean remove(Object e) {

        int found = -1;

        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    found = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    found = i;
                    break;
                }
            }
        }

        if (found == -1){
            return false;
        }

        Object[] arr = new Object[size - 1];
        for (int i = 0; i < found; i++){
            arr[i] = data[i];
        }
        for (int j = found; j < size - 1; j++){
            arr[j] = data[j + 1];
        }
        data = arr;
        size--;
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {

        int res = 0;
        Object[] arr = c.toArray();

        for (Object iter : arr){
            for (Object s : data){
                if (s == iter){
                    res++;
                    break;
                }
            }
        }
        return res == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        Object[] help = c.toArray();
        Object[] arr = new Object[size + c.size()];
        for (int i = 0; i < size; i++){
            arr[i] = data[i];
        }
        for (int j = size; j < size + c.size(); j++){
            arr[j] = help[j - size];
        }
        size = size + c.size();
        data = arr;
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

    public Object get(int i){
        return data[i];
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.print(data[i] + ", ");
        }
    }
}
