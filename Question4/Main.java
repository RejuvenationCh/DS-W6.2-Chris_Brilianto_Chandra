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

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 
        String namesLine = sc.nextLine();
        String[] names = namesLine.split(",\\s*");

        String moneyLine = sc.nextLine();
        String[] moneyValues = moneyLine.split(",\\s*");

        List<Visitor> queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currentName = names[i].trim();
            int currentMoney = Integer.parseInt(moneyValues[i].trim());
            if (currentName.equalsIgnoreCase("Jeff")) {
                continue;
            }

            queue.add(new Visitor(currentName, currentMoney));
        }

        Collections.sort(queue);

        System.out.print("[");
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).name);
            if (i < queue.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}