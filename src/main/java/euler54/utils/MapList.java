package euler54.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  @author Fesal.Baxhaku
 */
@Data
public class MapList<K,V> {

    private final Map<K, List<V>> mapList = new HashMap<>();

    public V add(K key, V value) {
        List<V> values = mapList.computeIfAbsent(key, k -> new ArrayList<>());
        values.add(value);

        return value;
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
        return (List<K>) mapList.keySet();
    }
}
