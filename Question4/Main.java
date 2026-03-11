package Question4;
import java.util.*;

class Visitor implements Comparable<Visitor> {
    String name;
    int money;
    public Visitor(String name, int money) {
        this.name = name;
        this.money = money;
    }
    @Override
    public int compareTo(Visitor other) {
        return Integer.compare(other.money, this.money);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of visitors:");
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        System.out.println("Enter all visitor names:");
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.println("Enter money for each visitor:");
        PriorityQueue<Visitor> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) break;
            int currentMoney = sc.nextInt();
            
            if (names[i].equalsIgnoreCase("Jeff")) {
                System.out.println("System: Sending " + names[i] + " (" + currentMoney + ") to failure management.");
                continue;
            }
            pq.add(new Visitor(names[i], currentMoney));
        }
        System.out.print("[");
        while (!pq.isEmpty()) {
            Visitor richest = pq.poll();
            System.out.print(richest.name);
            if (!pq.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}