package Question1;
class Letter {
    String name;
    int duration;
    int priority;
    int remainingTime;
    String status; // "pending", "queued", "sent"

    public Letter(String name, int duration, int priority) {
        this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.remainingTime = duration;
        this.status = "pending";
    }
}
public class Main {

    
}
