package Question3;
import java.util.*;

class Student {
    String name;
    int chances;

    public Student(String name, int chances) {
        this.name = name;
        this.chances = chances;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        System.out.println("Insert Array Length : ");
        int n = sc.nextInt();
        Queue<Student> queue = new LinkedList<>();

        System.out.println("Insert Names : ");
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.println("Insert chances : ");
        for (int i = 0; i < n; i++) {
            int chances = sc.nextInt();
            queue.add(new Student(names[i], chances));
        }

        while (!queue.isEmpty()) {
            Student current = queue.poll();
            current.chances--; 
            
            String status;
            boolean backInQueue = false;

            if (current.chances > 0) {
                status = "Try Again";
                backInQueue = true;
            } else {
                status = "Get Out";
            }

            System.out.println(current.name + "|" + status + "|" + current.chances);

            if (backInQueue) {
                queue.add(current);
            }
        }
        sc.close();
    }
}