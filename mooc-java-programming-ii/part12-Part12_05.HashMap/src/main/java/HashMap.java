import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {
    private List<Pair<K, V>>[] arrayOfLists;
    private int numberOfPairs;

    public HashMap() {
        arrayOfLists = new List[32];
        numberOfPairs = 0;
    }

    private int createHashValue(K key) {
        return Math.abs(key.hashCode() % arrayOfLists.length);
    }

    public V get(K key) {
        int hashValue = createHashValue(key);
        if (arrayOfLists[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> pairList = arrayOfLists[hashValue];

        for (Pair<K, V> pair : pairList) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> listOfPairs = getListContainingKey(key);
        int index = indexOfKeyInList(listOfPairs, key);

        if (index < 0) {
            listOfPairs.add(new Pair<>(key, value));
            numberOfPairs++;
        } else {
            listOfPairs.get(index).setValue(value);
        }

        if (1.0 * numberOfPairs / arrayOfLists.length > 0.75) {
            increaseSize();
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> pairList = getListContainingKey(key);
        if (pairList.size() == 0) return null;

        int index = indexOfKeyInList(pairList, key);
        if (index < 0) return null;

        Pair<K, V> pair = pairList.get(index);
        pairList.remove(pair);
        return pair.getValue();
    }

    private List<Pair<K, V>> getListContainingKey(K key) {
        int hashValue = createHashValue(key);
        if (arrayOfLists[hashValue] == null) {
            arrayOfLists[hashValue] = new ArrayList<>();
        }
        return arrayOfLists[hashValue];
    }

    private int indexOfKeyInList(List<Pair<K, V>> pairList, K key) {
        for (int i = 0; i < pairList.size(); i++) {
            if (pairList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseSize() {
        List<Pair<K, V>>[] newArray = new List[arrayOfLists.length * 2];
        for (int i = 0; i < arrayOfLists.length; i++) {
            copyPairsFromList(newArray, i);
        }
        arrayOfLists = newArray;
    }

    private void copyPairsFromList(List<Pair<K, V>>[] newArray, int indexInCurrentArray) {
        for (Pair<K, V> pair : arrayOfLists[indexInCurrentArray]) {
            int hashValue = Math.abs(pair.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }
            newArray[hashValue].add(pair);
        }
    }
}
