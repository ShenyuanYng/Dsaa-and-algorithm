import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;
public class ShortestTimeForTasks {
    public static int getShortestTime(int[] durations, List<List<Integer>> prerequisites) {
        int numTasks = durations.length;

        int[] earliestStartTime = new int[numTasks];
        Stack<Integer> stack = new Stack<>();
        int[] indegree = new int[numTasks];

        // 计算入度
        for (List<Integer> prerequisiteTasks : prerequisites) {
            for (int prerequisiteTask : prerequisiteTasks) {
                indegree[prerequisiteTask]++;
            }
        }

        // 找到没有前提任务的起点任务
        for (int i = 0; i < numTasks; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
                earliestStartTime[i] = 0;
            }
        }

        // 迭代计算最早开始时间
        while (!stack.isEmpty()) {
            int task = stack.pop();

            for (int dependentTask : prerequisites.get(task)) {
                indegree[dependentTask]--;
                earliestStartTime[dependentTask] = Math.max(earliestStartTime[dependentTask],
                        earliestStartTime[task] + durations[task]);

                if (indegree[dependentTask] == 0) {
                    stack.push(dependentTask);
                }
            }
        }

        // 找到最晚结束时间
        int latestEndTime = 0;
        for (int i = 0; i < numTasks; i++) {
            int endTime = earliestStartTime[i] + durations[i];
            latestEndTime = Math.max(latestEndTime, endTime);
        }

        return latestEndTime;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] count = new int[number];
        int[] durations = new int[number];
        List<List<Integer>> prerequisites = new ArrayList<>();
        int[] zero = new int[number];


        for (int i = 0; i < number; i++) {
            count[i] = input.nextInt();
            durations[i] = input.nextInt();
            List<Integer> prerequisiteTasks = new ArrayList<>();
            if (i == 0) {
                prerequisites.add(prerequisiteTasks); // 任务1没有前提任务
                //   System.out.println(666);
                zero[i] = input.nextInt();
            } else {
                int x = input.nextInt();
            //    System.out.println(x);
                while (x != 0) {
                    prerequisiteTasks.add(x-1);
                    x = input.nextInt();

                }
          //      System.out.print(prerequisiteTasks);
                prerequisites.add(prerequisiteTasks);
                //  System.out.println(durations[i]);
            }
        }

      //  System.out.println(prerequisites);


        int shortestTime = getShortestTime(durations, prerequisites);
        System.out.println( shortestTime);
    }
}
