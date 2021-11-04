public class List<T> {
    private T[] list;
    private int numberOfElements;

    public List() {
        list = (T[]) new Object[10];
        numberOfElements = 0;
    }

    public void add(T newValue) {
        if (numberOfElements == list.length) {
            increaseLength();
        }
        list[numberOfElements] = newValue;
        numberOfElements++;
    }

    private void increaseLength() {
        T[] newList = (T[]) new Object[list.length * 3 / 2];
        System.arraycopy(list, 0, newList, 0, numberOfElements);
        list = newList;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public void remove(T valueToRemove) {
        int indexOfValue = indexOf(valueToRemove);
        if (indexOfValue < 0) return;

        shiftLeft(indexOfValue);
        numberOfElements--;
    }

    public int indexOf(T valueToFind) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(valueToFind)) {
                return i;
            }
        }
        return -1;
    }

    private void shiftLeft(int fromIndex) {
        for (int i = fromIndex; i < numberOfElements - 1; i++) {
            list[i] = list[i + 1];
        }
    }

    public T get(int index) {
        if (index < 0 || index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int size() {
        return numberOfElements;
    }
}
