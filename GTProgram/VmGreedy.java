import java.util.Scanner;

public class VmGreedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ente number of Vms : ");
        int vmCount = scanner.nextInt();
        System.out.println("Enter number of tasks : ");
        int task = scanner.nextInt();

        int[] vmCPU = new int[vmCount];
        int[] vmMem = new int[vmCount];

        System.out.println("Enter CPU and memory for each VM : ");
        for (int i = 0; i < vmCount; i++) {
            System.out.println("VM " + i + "CPU");
            vmCPU[i] = scanner.nextInt();
            System.out.println("VM " + i + "Memory");
            vmMem[i] = scanner.nextInt();
        }
        System.out.println("Vm : ");
        for (int i = 0; i < vmCount; i++) {
            System.out.println("VM" + i + "CPU=" + vmCPU[i] + ", Mem=" + vmMem[i]);

        }
        int[] taskCPU = new int[task];
        int[] taskMem = new int[task];

        System.out.println("Enter CPU and memory for each task : ");
        for (int i = 0; i < task; i++) {
            System.out.println("Task " + i + "CPU");
            taskCPU[i] = scanner.nextInt();
            System.out.println("Task " + i + "Memory");
            taskMem[i] = scanner.nextInt();
        }

        System.out.println("\nTasks:");
        for (int i = 0; i < task; i++) {
            System.out.println("Task" + i + " CPU=" + taskCPU[i] + ", Mem=" + taskMem[i]);
        }
        int[][] cost = new int[vmCount][task];
        System.out.println("Enter cost matrix : ");
        for (int i = 0; i < vmCount; i++) {
            for (int j = 0; j < task; j++) {
                System.out.println("Cost of vm" + i + "Task" + j + ":");
                cost[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nCost Matrix:");
        for (int i = 0; i < vmCount; i++) {
            for (int j = 0; j < task; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < task; i++) {
            
        }
    }
}
