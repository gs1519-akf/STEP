import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        int highest = sectionA[0];
        String section = "A";
        int index = 0;

        // Calculate total of Section A and find highest item
        for (int i = 0; i < sectionA.length; i++) {

            totalA += sectionA[i];

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "A";
                index = i;
            }
        }

        // Calculate total of Section B and find highest item
        for (int i = 0; i < sectionB.length; i++) {

            totalB += sectionB[i];

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "B";
                index = i;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        System.out.println("Highest Quantity: " + highest);
        System.out.println("Found in Section " + section
                + " at Item " + (index + 1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");

        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter quantities for Section B:");

        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}