package heaplab;

/**
 *
 * @author Walker VanHouten
 */
public class HeapLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap h = new Heap();
        int[] toAdd = {15, 5, 8, 4, 9, 22, 17, 6, 14};
        h.add(toAdd);
        h.print();
    }
    
}
