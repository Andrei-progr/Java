package com.company;
import java.util.Objects;
import java.util.Stack;

public class HashMap <K,V> {

    private Node<K, V>[] table;
    private int size;
    private int treshold;

    private static class Node<K,V> {
        private int hash;
        private K key;
        private V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;

        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public String toString(){
            return key + "=" + value;
        }

        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }


    public HashMap(){

        table = new Node[16];
        size = 0;
        treshold = 16;
        
    }

    public boolean containsKey(K key){

        for (Node<K,V> node : table){
            for (Node<K,V> i = node; i != null; i = i.next) {
                if (i.key == key || i.key.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean put(K key, V value){

        for (Node<K,V> node : table){
            for (Node<K,V> i = node; i != null; i = i.next) {
                if (i.key == key || i.key.equals(key)){
                    i.value = value;
                    return true;
                }
            }
        }
        if (size == treshold){
            recize();
        }

        if (key == null){
            putNullKeyValue(value);
        }else{
            int hash = hash(key.hashCode());
            int index = indexFor(hash, treshold);
            addNode(this.table, hash, key, value, index);
            size++;
        }
        return true;
    }

    private void putNullKeyValue(V value){
        addNode(this.table, 0, null, value, 0);
    };

    private int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int hash, int tableLength){
        return hash & (tableLength - 1);
    }

    private void addNode(Node<K,V>[] t, int hash, K key, V value, int index)
    {

        Node<K, V> node = t[index];
        t[index] = new Node<K, V>(hash, key, value, node);

    }

    public void print() {
        for (Node<K, V> node : table) {
            for (Node<K, V> i = node; i != null; i = i.next) {
                System.out.print(i.key + "=" + i.value);
                if (i.next == null) {
                    System.out.println("");
                } else {
                    System.out.print(" -> ");
                }
            }
        }
    }


    private void recize(){

        treshold = treshold * 2;
        int hash;
        int index;

        Node<K,V>[] newTable = new Node[treshold];

        for (Node<K,V> node : table){
            for (Node<K,V> i = node; i != null; i = i.next) {
                hash = hash(i.key.hashCode());
                index = indexFor(hash, treshold);
                addNode(newTable, hash, i.key, i.value, index);
            }
        }

        table = newTable;

    }

    public Object get(K key){
        for (Node<K,V> node : table){
            for (Node<K,V> i = node; i != null; i = i.next) {
                if (key == i.key || key.equals(i.key)){
                    return i.value;
                }
            }
        }
        return null;
    }

    public boolean containsValue(V value){

        for (Node<K,V> node : table){
            for (Node<K,V> i = node; i != null; i = i.next) {
                if (i.value == value || i.key.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean remove(K key){

        if (!containsKey(key)){
            return false;
        }

        int arrayIndex;
        int listIndex = 0;
        boolean founded = false;

        for (arrayIndex = 0; arrayIndex < treshold; arrayIndex++){
            listIndex = 0;
            for (Node<K,V> node = table[arrayIndex]; node != null; node = node.next){
                if (node.key == key || node.key.equals(key)) {
                    founded = true;
                    break;
                }
                listIndex++;
            }
            if (founded){
                break;
            }
        }
        Node<K,V> node = table[arrayIndex];
        if (listIndex == 0) {
            table[arrayIndex] = node.next;
            size--;
            return true;
        }else{
            for (int i = 0; i < listIndex - 1; i++){
                node = node.next;
            }
            node.next = node.next.next;
            size--;
            return true;
        }
    }

    public Object[] keySet() {

        Object[] arr = new Object[size];
        int j = 0;
        for (Node<K, V> node : table) {
            for (Node<K, V> i = node; i != null; i = i.next) {
                arr[j] = i.key;
                j++;
            }
        }
        return arr;
    }

}
