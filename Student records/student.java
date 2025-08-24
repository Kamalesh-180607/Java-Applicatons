import java.util.Scanner;
class sstudent
{
    int roll_no;
    String name;
    double total[]=new double[3];
    int internal[]=new int[3];
    int external[]=new int[3];
    String grade[]=new String[3];
    String subject[]={"DSA","UHV","DSD"};

    void display()
    {
        System.out.println("Roll no. : "+roll_no);
        System.out.println("Name: "+name);
    }
}
class fulltime extends sstudent
{
    fulltime(Scanner sc)
    {
        System.out.println("Enter Roll number: ");
        roll_no=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        name=sc.nextLine();
        System.out.println("Enter three subject's internal and external");
        for(int i=0;i<3;i++)
        {
            System.out.print("Enter subject "+(i+1)+" internal,external :");
            internal[i]=sc.nextInt();
            external[i]=sc.nextInt();
            while(internal[i]<0 || internal[i]>100 || external[i]<0 || external[i]>100)
            {
                System.out.println("Enter valid mark (Mark should be greater than zero and less than 100)");
                internal[i]=sc.nextInt();
                external[i]=sc.nextInt();
            }
        }
    }
    void display()
    {
        super.display();
        System.out.println("Totals and grades for three subjects");
        System.out.println("Subject\t\tTotal\t\tGrade");
        for(int i=0;i<3;i++)
        {
            System.out.println(subject[i]+"\t\t"+total[i]+"\t\t"+grade[i]);
        }
    }
    void totalc()
    {
        for(int i=0;i<3;i++)
        {
            total[i]=(internal[i]*0.4)+(external[i]*0.6);
        }
    }
    void gradec()
    {
        for(int i=0;i<3;i++)
        {
            if(total[i]>90)
            grade[i]="S";
            else if(total[i]>80)
            grade[i]="A+";
            else if(total[i]>70)
            grade[i]="A";
            else if(total[i]>60)
            grade[i]="B+";
            else if(total[i]>50)
            grade[i]="B";
            else
            grade[i]="U";
        }
    }
}
class parttime extends sstudent
{
    parttime(Scanner sc)
    {
        System.out.println("Enter Roll number(Integer): ");
        roll_no=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        name=sc.nextLine();
        System.out.println("Enter three subject's internal and external");
        for(int i=0;i<3;i++)
        {
            System.out.print("Enter subject "+(i+1)+" internal,external :");
            internal[i]=sc.nextInt();
            external[i]=sc.nextInt();
            while(internal[i]<0 || internal[i]>100 || external[i]<0 || internal[i]>100)
            {
                System.out.println("Enter valid mark (Mark should be greater than zero and less than 100)");
                internal[i]=sc.nextInt();
                external[i]=sc.nextInt();
            }
        }
    }
    void display()
    {
        super.display();
        System.out.println("Totals and grades for three subjects");
        System.out.println("Subject\t\tTotal\t\tGrade");
        for(int i=0;i<3;i++)
        {
            System.out.println(subject[i]+"\t\t"+total[i]+"\t\t"+grade[i]);
        }
    }
    void totalc()
    {
        for(int i=0;i<3;i++)
        {
            total[i]=(internal[i]*0.5)+(external[i]*0.5);
        }
    }
    void gradec()
    {
        for(int i=0;i<3;i++)
        {
            if(total[i]>90)
            grade[i]="S";
            else if(total[i]>80)
            grade[i]="A+";
            else if(total[i]>70)
            grade[i]="A";
            else if(total[i]>60)
            grade[i]="B+";
            else if(total[i]>50)
            grade[i]="B";
            else
            grade[i]="U";
        }
    }
}
public class Student{
    public static void main(String args[])
    {
        boolean c1=true,c2=true;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of full time students: ");
        int f=sc.nextInt();
        if(f<0)
        {
            System.out.println("Enter postive number or zero");
            while(f<0)
            f=sc.nextInt();
        }
        System.out.println("Enter number of part time students: ");
        int p=sc.nextInt();
        if(p<0)
        {
            System.out.println("Enter postive number or zero");
            while(p<0)
            p=sc.nextInt();
        }
        fulltime[] o1=new fulltime[f]; 
        parttime[] o2=new parttime[p];
        if(f>0)
        {
        System.out.println("Enter full time students details");
        for(int i=0;i<f;i++)
        {
            System.out.println("Student "+(i+1)+" :");
            o1[i]=new fulltime(sc);
            o1[i].totalc();
            o1[i].gradec();
        }
        }
        if(p>0)
        {
        System.out.println("Enter part time students details");
        for(int i=0;i<p;i++)
        {
            System.out.println("Student "+(i+1)+" :");
            o2[i]=new parttime(sc);
            o2[i].totalc();
            o2[i].gradec();
        }
        }
        if(f>0)
        {
        System.out.println("-----Full time students details-----");
        for(int i=0;i<f;i++)
        {
            o1[i].display();
        }
        }
        if(p>0)
        {
        System.out.println("-----Part time students details-----");
        for(int i=0;i<p;i++)
        {
            o2[i].display();
        }
        }
        if(f==0)
        System.out.println("No full time students record");
        if(p==0)
        System.out.println("No part time students record");
        
    }
}
