import java.util.Scanner;
public class Main {
    public int QuickPass(student S[], int low, int high)
    {
        student k=new student("",0);
        k=S[low];
        int x = S[low].getGrade();
        while (low < high)
        {
            while (low < high && S[high].getGrade() <= x)
                high--;
            if (low == high)
                break;
            S[low] = S[high];
            low++;
            while (low < high && S[low].getGrade() > x)
                low++;
            if (low == high)
                break;
            S[high] = S[low];
            high--;
        }
        S[low] = k;
        return low;
    }
    public void QuickSort(student[] S, int low, int high)
    {
        int m;
        if (low >= high)
            return;
        m = new Main ().QuickPass(S, low, high);
        new Main ().QuickSort(S, low, m - 1);
        new Main ().QuickSort(S, m + 1, high);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i,j;
        String name;
        int grade;
        student k=new student("",0);
        int max=0;//
        int same=0;//
        int number=sc.nextInt();
        student S[]=new student[number];
        for(i=0;i<number;i++)
        {
            name=sc.next();
            grade=sc.nextInt();
            S[i]=new student(name,grade);
        }
        new Main ().QuickSort(S,0,number-1);
        for(i=0;i<number;i++)
        {
            if(i==0)
                S[i].setRank(i+1);
            else
            {
                if(S[i].getGrade()==S[i-1].getGrade())
                {
                    S[i].setRank(S[i - 1].getRank());
                    same=i+1-S[i].getRank()+1;
                    max=i;
                    for(j=i-same+1;j<i;j++)
                    {
                        if(S[i].getName().compareTo(S[j].getName())<=0)
                        {
                            max=j;
                            break;
                        }
                    }
                    k=S[i];
                    for(j=i;j>max;j--)
                    {
                        S[j]=S[j-1];
                    }
                    S[max]=k;
                }
                else
                    S[i].setRank(i+1);
            }
        }
        for(i=0;i<number;i++)
            System.out.println(S[i].getName()+" "+S[i].getGrade()+" "+S[i].getRank());
    }

}
class student{
    private String name;
    private int grade;
    private int rank;

    public student (String name,int grade)
    {
        this.name=name;
        this.grade=grade;
        this.rank=0;
    }

    public String getName(){return name;}
    public int getGrade(){return grade;}
    public int getRank(){return rank;}

    public void setName(String name){
        this.name=name;
    }
    public void setGrade(int grade) {
        this.grade=grade;
    }
    public void setRank(int rank){
        this.rank=rank;
    }
}
