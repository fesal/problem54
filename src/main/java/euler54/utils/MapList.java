package euler54.utils;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.*;

/*
 *  @author Fesal.Baxhaku
 */
@Data
@Builder
public class MapList<K,V> {
    @Singular("mapList")
    private final Map<K, List<V>> mapList = new HashMap<>();

    public V add(K key, V value) {
        List<V> values = mapList.computeIfAbsent(key, k -> new ArrayList<>());
        values.add(value);

        return value;
    }

    public void addAll(K key, List<V> values) {
        mapList.put(key, values);
    }

    public List<V> get(K key) {
        return mapList.get(key);
    }

    public int size() {
        return this.mapList.size();
    }

    public K getKey(){
        Map.Entry<K, List<V>> entry = mapList.entrySet().iterator().next();
        return entry.getKey();
    }

    public List<V> getValuesByIndex(int index) {
        Object firstKey = mapList.keySet().toArray()[index];
        return mapList.get(firstKey);
    }

    public List<K> getKeys() {
        return new ArrayList<>(mapList.keySet());
    }

}
