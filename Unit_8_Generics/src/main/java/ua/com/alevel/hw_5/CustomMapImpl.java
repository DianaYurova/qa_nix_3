package ua.com.alevel.hw_5;

import java.util.*;

public class CustomMapImpl<K, V> implements CustomMap<K, V> {

    private List<Node<K, V>> nodes = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        for (Node<K, V> node : nodes) {
            if(key.hashCode() == node.getKey().hashCode()) {
                if(key.equals(node.key)) {
                    nodes.get(nodes.indexOf(node)).setValue(value);
                    return;
                }
            }
        }
        nodes.add(new Node<>(key, value));
    }

    @Override
    public Set<K> setKeys() {
        //как из листа Node вытащить лист K key
        Set<K> keys = new HashSet<>();
        for (Node<K, V> node : nodes) {
            keys.add(node.getKey());
        }
        return keys;
    }

    @Override
    public List<V> listValues() {
        List<V> values = new ArrayList<>();
        for (Node<K, V> node : nodes) {
            values.add(node.getValue());
        }
        return values;
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node : nodes) {
            if (node.getKey().equals(key)) {
                return node.getValue();
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
