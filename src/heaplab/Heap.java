package heaplab;

/**
 *
 * @author Walker VanHouten
 */
public class Heap {
    
    public static final int MAX_HEAP_SIZE = 25;
    
    private Node[] heap;
    private boolean sorted;
    private int n;
    
    Heap() {
        heap = new Node[MAX_HEAP_SIZE+1];
        n = 1;
    }
    
    void sort() {
        int x = n/2;
        while(x > 0) {
           if(get(2*x)<get((2*x)+1)) {
            swap(2*x, (2*x)+1);
        }
        if(get(x)<get(2*x)) {
            swap(x, 2*x);
        }
        if(get(2*x)<get((2*x)+1)) {
            swap(2*x, (2*x)+1);
        }
        x--; 
        }
    }
    
    int get(int elementID) {
        if(heap[elementID]==null) {
            return 0;
        } else {
            return heap[elementID].getData();
        }
    }
    
    private void swap(int a, int b) {
        Node store = heap[a];
        heap[a] = null;
        heap[a] = heap[b];
        heap[b] = null;
        heap[b] = store;
    }
    
    void add(int newElement) {
        heap[n] = new Node(newElement);
        n++;
        sort();
    }
    
    void add(int[] newElements) {
        for(int i = 0; i < newElements.length; i++) {
            heap[n+i] = new Node(newElements[i]);
        }
        n += newElements.length;
        sort();
    }
    
    void print() {
        System.out.println("Heap contains: ");
        if(heap[1]!=null) {
                System.out.println("Level 1:\t" + heap[1].getData());
        } else {
            System.out.println("nothing");
            return;
        }
        for(int i = 2; i <= heap.length; i*=2) {
            if (heap[i] != null) {
                System.out.format("Level %d:\t%d", i, heap[i].getData());
            } else {
                System.out.println("");
                return;
            }
            for(int k = i+1; k < i*2; k++) {
                if(heap[k] != null) {
                    System.out.print(", " + heap[k].getData());
                } else {
                    System.out.println("");
                    return;
                }
            }
            System.out.println("");
        }
    }
    
//    int getOpenIndex() {
//        for(int i = 1; i < heap.length; i++) {
//            if(heap[i]==null) {
//                return i;
//            }
//        }
//        System.out.println("Heap full");
//        return heap.length-1;
//    }
}
