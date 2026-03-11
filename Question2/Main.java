package Question2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Masukkan jumlah operasi:");
            if (!sc.hasNextInt()) break;
            int n = sc.nextInt();
            
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();

            boolean isStack = true, isQueue = true, isMaxPQ = true, isMinPQ = true;

            System.out.println("Masukkan " + n + " operasi (Tipe : 1 = Add, 2=  Take Out | Contoh: 1 45):");
            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                int val = sc.nextInt();

                if (type == 1) {
                    // Operasi Add
                    if (isStack) stack.push(val);
                    if (isQueue) queue.add(val);
                    if (isMaxPQ) maxPQ.add(val);
                    if (isMinPQ) minPQ.add(val);
                } else {
                    // Operasi Take Out (Validasi LIFO/FIFO/Priority)
                    if (isStack) {
                        if (stack.isEmpty() || !stack.pop().equals(val)) isStack = false;
                    }
                    if (isQueue) {
                        if (queue.isEmpty() || !queue.poll().equals(val)) isQueue = false;
                    }
                    if (isMaxPQ) {
                        if (maxPQ.isEmpty() || !maxPQ.poll().equals(val)) isMaxPQ = false;
                    }
                    if (isMinPQ) {
                        if (minPQ.isEmpty() || !minPQ.poll().equals(val)) isMinPQ = false;
                    }
                }
            }

            // Penentuan Kategori
            boolean isPQ = isMaxPQ || isMinPQ;
            int count = (isStack ? 1 : 0) + (isQueue ? 1 : 0) + (isPQ ? 1 : 0);

            System.out.print("Hasil Analisis: ");
            if (count == 0) System.out.println("tidak ada");
            else if (count > 1) System.out.println("tidak yakin");
            else if (isStack) System.out.println("stack");
            else if (isQueue) System.out.println("queue");
            else System.out.println("priority queue");
            
            System.out.println("---");
        }
        sc.close();
    }
}