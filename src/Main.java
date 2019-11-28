import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Student{
        String name;
        int grade;
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String s=in.nextLine();
            //学生个数
            int n=Integer.parseInt(s);
            String s2=in.nextLine();
            //排序方式
            int p=Integer.parseInt(s2);
            String[] strings=new String[n];
            Student[] students=new Student[n];
            //学生对象数组
            for(int i=0;i<n;i++){
                strings[i]=in.nextLine();
                String[] spl=strings[i].split(" ");
                int grade=Integer.parseInt(spl[1]);
                students[i]=new Student(spl[0],grade);
            }
            if(p!=0){
                //升序输出  x[0]最小
                int[] x=new int[n];
                for(int i=0;i<n;i++){
                    x[i]=students[i].grade;
                }
                Arrays.sort(x);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(x[i]==students[j].grade){
                            System.out.println(students[j].name+" "+students[j].grade);
                            students[j].grade=-1;
                        }
                    }
                }
            }else{
                //降序输出
                int[] x=new int[n];
                for(int i=0;i<n;i++){
                    x[i]=students[i].grade;
                }
                Arrays.sort(x);
                for(int i=n-1;i>=0;i--){
                    for(int j=0;j<n;j++){
                        if(x[i]==students[j].grade){
                            System.out.println(students[j].name+" "+students[j].grade);
                            students[j].grade=-1;
                        }
                    }
                }
            }
        }
    }
}