package Question1;
import java.util.*;

class Letter {
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

public static void main(String[] args){
    int duration;
    int priority;
    int remainingTime;
    int finishTime;
    int arrivalOrder;

    Scanner sc = new Scanner(System.in);
    int userInput = sc.nextInt();
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
        // Credit to gemini for Array Storage
    while (!processingQueue.isEmpty()) {
            currentTime++;
            List<Letter> tempStorage = new ArrayList<>();
            boolean changed = false;
            for (Letter l : tempStorage) {
                if (l.remainingTime <= 0) {
                    l.status = "Sent";
                    sentSQueue.add(l);
                    changed = true;
                } else {
                    processingQueue.add(l);
                }
            }

        
    }
}
}

