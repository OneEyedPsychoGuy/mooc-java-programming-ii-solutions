import java.util.List;
import java.util.ArrayList;

public class HashMap<K, V> {
    private List<Pair<K, V>>[] map;
    private int size;

    public HashMap() {
        this.map = new ArrayList[32];
        this.size = 0;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public V get(K key) {
        List<Pair<K, V>> pairsAtKey = this.map[Math.abs(key.hashCode() % this.map.length)];
        if(pairsAtKey == null) {
            return null;
        }

        for (int i = 0; i < pairsAtKey.size(); i++) {
            if (pairsAtKey.get(i).getKey().equals(key)) {
                return pairsAtKey.get(i).getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> pairsAtKey = getListBasedOnKey(key);
        int index = getIndexOfKey(pairsAtKey, key);

        if (index < 0) {
            pairsAtKey.add(new Pair<>(key, value));
            this.size++;
        } else {
            pairsAtKey.get(index).setValue(value);
        }

        if (1.0 * this.size / this.map.length > 0.75) {
            this.grow();
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> pairs = getListBasedOnKey(key);
        if (pairs.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(pairs, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = pairs.get(index);
        pairs.remove(pair);
        return pair.getValue();
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        List<Pair<K, V>> pairsAtKey = this.map[Math.abs(key.hashCode() % this.map.length)];

        if (pairsAtKey == null) {
            pairsAtKey = new ArrayList<>();
        }

        return pairsAtKey;
    }

    private int getIndexOfKey(List<Pair<K, V>> pairs, K key) {
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        List<Pair<K, V>>[] newMap = new ArrayList[this.map.length * 2];

        for (int i = 0; i < this.map.length; i++) {
            this.copy(newMap, i);
        }

        this.map = newMap;
    }

    private void copy(List<Pair<K, V>>[] newMap, int index) {
        for(int i = 0; i < this.map[index].size(); i++) {
            Pair<K, V> pair = this.map[index].get(i);
            
            List<Pair<K, V>> newPairs = newMap[pair.getKey().hashCode() % newMap.length];
            if(newPairs == null) {
                newPairs = new ArrayList<>();
            }

            newPairs.add(pair);
        }
    }
}