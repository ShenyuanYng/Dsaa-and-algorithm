import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Job {
    String name;
    int startTime;
    int endTime;

    public Job(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class practice1 {
    public static List<Job> findCompatibleJobs(List<Job> jobs) {
        // 按照结束时间对作业进行排序
        Collections.sort(jobs, Comparator.comparingInt(job -> job.endTime));
        List<Job> compatibleJobs = new ArrayList<>();
        Job previousJob = null;

        for (Job job : jobs) {
            if (previousJob == null || job.startTime >= previousJob.endTime) {
                compatibleJobs.add(job);
                previousJob = job;
            }
        }

        return compatibleJobs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Job> jobs = new ArrayList<>();



        // 从标准输入读取作业信息
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("end")) {
                break;
            }

            String name = input;
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            jobs.add(new Job(name, startTime, endTime));
        }

        List<Job> compatibleJobs = findCompatibleJobs(jobs);

        for (Job job : compatibleJobs) {
            System.out.print(job.name+" ");
        }
    }
}
