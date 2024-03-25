import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        Queue<Long> queue1 = new LinkedList<>();//存值
        ArrayList<Long> List=new ArrayList<>();
       // Queue<Long> queue2 = new LinkedList<Long>();//存数量
        int shuliang = 0;
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();

            if (n==1){
                long m=input.nextLong();
                long x=input.nextLong();
                List.add(m);
                queue1.add(x);
                shuliang++;
            }
            long count=0;
            if (n==2) {
                long y = input.nextInt();
                    if (y < List.get(0)) {
                        count =count+ y * queue1.element();
                        long zhongjianzhi = List.get(0) - y;
                        List.set(0, zhongjianzhi);
                    }
                    else if (y == List.get(0)) {
                        count = count+y * queue1.element();
                        List.remove(0);
                        queue1.poll();
                        shuliang--;
                    }
                   else if (y > List.get(0)) {
                        while (y > List.get(0) && shuliang >= 0) {
                            y = y - List.get(0);
                            count = count + queue1.element() * List.get(0);
                            List.remove(0);
                            queue1.poll();
                            shuliang--;
                        }
                        if (shuliang > 0) {
                            count = count + y * queue1.element();
                            if (y == List.get(0)) {
                                List.remove(0);
                                queue1.poll();
                                shuliang--;
                            }
                            else {
                                long zhongjianzhi = List.get(0) - y;
                                List.set(0, zhongjianzhi);
                            }
                        }
                    }

                    System.out.println(count);
                }
            }
        }
    }


