import java.util.*;
import java.io.*;

class Student{
    public int name;
    public int recomm_cnt=0;

    public Student(int name){
        this.name=name;
    }
}
public class Main{
    static boolean flag = false;
    static int[] recommend;
    static List<Student> frame = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalcnt = Integer.parseInt(br.readLine());
        recommend = new int[totalcnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<totalcnt; i++){
            recommend[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<totalcnt; i++){
            Student student = new Student(recommend[i]);

            if(frame.isEmpty()){
                student.recomm_cnt+=1;
                frame.add(student);

            }
            else if(frame.size()<=N){
                plusRecommend(i);

                if(!flag&&frame.size()<N){
                    student.recomm_cnt+=1;
                    frame.add(student);
                }
                else if(!flag && frame.size()==N){
                    int idx=0;
                    int min=Integer.MAX_VALUE;

                    for(int j=0; j<frame.size(); j++){
                        if(frame.get(j).recomm_cnt<min){
                            min=frame.get(j).recomm_cnt;
                            idx=j;
                        }
                    }
                    frame.remove(idx);
                    student.recomm_cnt+=1;
                    frame.add(student);
                }
                flag=false;
            }


        }
        List<Integer> out = new ArrayList<>();
        for(Student student : frame){
            out.add(student.name);
        }

        Collections.sort(out);
        for(int i=0; i<out.size(); i++){
            System.out.print(out.get(i)+" ");
        }
        br.close();
    }
    static public void plusRecommend(int i){
        for(int j=0; j<frame.size(); j++){
            if(frame.get(j).name==recommend[i]){
                frame.get(j).recomm_cnt+=1;

                flag=true;
                break;
            }

        }
    }
}