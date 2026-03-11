package Question1;
import java.util.*;

class Letter {
    public String name;
    public int duration;
    public int priority;
    public int remainingTime;
    public String status; 

    public Letter(String name, int duration, int priority) {
        this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.remainingTime = duration;
        this.status = "Pending";
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

}}

