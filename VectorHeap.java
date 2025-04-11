import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    protected static int left(int i) {
        return 2 * i + 1;
    }

    protected static int right(int i) {
        return 2 * i + 2;
    }
//organiza el heap hacia arriba after adding someone new 
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }
//organiza para abajo after removing a patient
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                    (data.get(childpos + 1).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    @Override
  //deletes and returns mayor prioridad
    public E remove() {
        if (isEmpty()) return null;
        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, lastVal);
            pushDownRoot(0);
        }
        return minVal;
    }
    
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

}
