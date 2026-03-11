package Question1;
import java.util.*;

public class Main {
    static class Letter implements Comparable<Letter> {
        public String name;
        public int duration;
        public int priority;
        public int remainingTime;
        public String status; 
        public int arrivalOrder;

        public Letter(String name, int duration, int priority, int arrivalOrder) {
            this.name = name;
            this.duration = duration;
            this.priority = priority;
            this.remainingTime = duration;
            this.status = "Pending";
            this.arrivalOrder = arrivalOrder;
        }

        @Override 
        public int compareTo(Letter other) {
            if (this.priority != other.priority) return Integer.compare(this.priority, other.priority);
            return Integer.compare(this.arrivalOrder, other.arrivalOrder);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter How Many Letters : ");
        if (!sc.hasNextInt())
            return;
 
        int userInput = sc.nextInt();

        System.out.println("Enter name, duration, and priorty of the letters : ");

        Queue<Letter> pendingQueue = new PriorityQueue<>();
        Queue<Letter> processingQueue = new PriorityQueue<>();
        Queue<Letter> sentSQueue = new PriorityQueue<>();

        for (int i = 0; i < userInput; i++) {
            pendingQueue.add(new Letter(sc.next(), sc.nextInt(), sc.nextInt(), i));
        }

        int currentTime = 0;
        
        while (!pendingQueue.isEmpty()) {
            Letter l = pendingQueue.poll();
            l.status = "Queued";
            processingQueue.add(l);
        }

        printStatus(currentTime, pendingQueue, processingQueue, sentSQueue);

        while (!processingQueue.isEmpty()) {
            currentTime++;
            List<Letter> tempStorage = new ArrayList<>();
            boolean changed = false;

            while (!processingQueue.isEmpty()) {
                tempStorage.add(processingQueue.poll());
            }

            for (Letter l : tempStorage) {
                l.remainingTime = l.remainingTime - 1;
                if (l.remainingTime <= 0) {
                    l.status = "Sent";
                    sentSQueue.add(l);
                    changed = true;
                } else {
                    processingQueue.add(l);
                }
            }

            if (changed || processingQueue.isEmpty()) {
                printStatus(currentTime, pendingQueue, processingQueue, sentSQueue);
            }
        }
        sc.close();
        sc.close();
    }

    private static void printStatus(int time, Queue<Letter> p, Queue<Letter> pr, Queue<Letter> s) {
        System.out.printf("%d %s | %s | %s\n", time, format(p), format(pr), format(s));
    }

    private static String format(Queue<Letter> q) {
        if (q.isEmpty()) return "";
        PriorityQueue<Letter> copy = new PriorityQueue<>(q);
        List<String> names = new ArrayList<>();
        while (!copy.isEmpty()) names.add(copy.poll().name);
        return String.join(", ", names);
    }
}