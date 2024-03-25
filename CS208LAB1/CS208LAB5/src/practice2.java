import java.util.*;

class Lecture {
    String name;
    int startTime;
    int endTime;

    public Lecture(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class practice2 {
    public static List<List<Lecture>> scheduleLectures(List<Lecture> lectures) {
        // 按照开始时间对讲座进行排序
        Collections.sort(lectures, Comparator.comparingInt(lecture -> lecture.startTime));

        List<List<Lecture>> classrooms = new ArrayList<>();
        for (Lecture lecture : lectures) {
            boolean scheduled = false;
            for (List<Lecture> classroom : classrooms) {
                if (classroom.isEmpty() || classroom.get(classroom.size() - 1).endTime <= lecture.startTime) {
                    classroom.add(lecture);
                    scheduled = true;
                    break;
                }
            }
            if (!scheduled) {
                List<Lecture> newClassroom = new ArrayList<>();
                newClassroom.add(lecture);
                classrooms.add(newClassroom);
            }
        }

        return classrooms;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Lecture> lectures = new ArrayList<>();



        // 从标准输入读取讲座信息
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("end")) {
                break;
            }

            String name = input;
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            lectures.add(new Lecture(name, startTime, endTime));
        }

        List<List<Lecture> > scheduledLectures = scheduleLectures(lectures);
        for (List<Lecture> classroom : scheduledLectures) {
            for (Lecture lecture : classroom) {
                System.out.print(lecture.name + " ");
            }
            System.out.println();
        }
    }
}
