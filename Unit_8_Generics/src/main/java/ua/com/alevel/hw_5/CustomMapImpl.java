package ua.com.alevel.hw_5;

import java.util.*;

public class CustomMapImpl<K, V> implements CustomMap<K, V> {

    private List<Node<K, V>> nodes = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        for (Node<K, V> node : nodes) {
            if(key.hashCode() != node.key.hashCode()) {
                if(!key.equals(node.key)) {
                    nodes.add(new Node<>(key, value));
                }
                else {
                    nodes.get(nodes.indexOf(node)).setValue(value);
                }
            }
        }
    }

    @Override
    public Set<K> setKeys() {
        //как из листа Node вытащить лист K key
        for (Node<K, V> node : nodes) {
            Set<K> keys = new Set<>() {
                @Override
                public int size() { return 0; }

                @Override
                public boolean isEmpty() { return false; }

                @Override
                public boolean contains(Object o) { return false; }

                @Override
                public Iterator<K> iterator() { return null; }

                @Override
                public Object[] toArray() { return new Object[0]; }

                @Override
                public <T> T[] toArray(T[] a) { return null; }

                @Override
                public boolean add(K k) { return false; }

                @Override
                public boolean remove(Object o) { return false; }

                @Override
                public boolean containsAll(Collection<?> c) { return false; }

                @Override
                public boolean addAll(Collection<? extends K> c) { return false; }

                @Override
                public boolean retainAll(Collection<?> c) { return false; }

                @Override
                public boolean removeAll(Collection<?> c) { return false; }

                @Override
                public void clear() { }
            };
            System.out.println("keys = " + keys);
        }
        return null;
    }

    @Override
    public List<V> listValues() {
        for (Node<K, V> node : nodes) {
            List<V> values = new ArrayList<>();
            System.out.println("values = " + values);
        }
        return null;
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node : nodes) {
            if (node.getKey().equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    private static class Node<K, V> {

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
