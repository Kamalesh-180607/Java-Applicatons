import java.util.*;
public class LIBRARY
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        fine obj[]=new fine[100];
        int n=-1,c=-1;
        do
        {
            System.out.println("1. Fine calculation");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            c=sc.nextInt();
            switch(c)
            {
                case 1:
                    obj[++n]=new fine();
                    obj[n].getdata(sc);
                    obj[n].calculateFine();
                    break;
                case 2:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Enter valid choice: ");
            }
        }while(c!=2);
        System.out.println("Do you want display all details  type '111' ");
        int t=sc.nextInt();
        if(t==111)
        {
            for(int i=0;i<=n;i++)
            {
                obj[i].display();
            }
        }
    }
}

class library
{
    String bookName;
    int id;
    int borrowDays;
    String catagory="";
    int fineAmount=0;

    int calculateFine(int day,int fine)
    {
        return day*fine;
    }
}
class fine extends library
{
    void getdata(Scanner sc)
    {
        sc.nextLine();
        System.out.println("Enter Book name: ");
        bookName=sc.nextLine();
        System.out.println("Enter Catagory(UG students(code:'C01'),PG students or Scholars(code: 'C02'),Faculty(code:'C03'))");
        catagory=sc.nextLine();
        System.out.println("Id number: ");
        id=sc.nextInt();
        System.out.println("Enter Borrowdays: ");
        borrowDays=sc.nextInt();
    }
    int calculateFine(int day,int fine)
    {
        return super.calculateFine(day,fine);
    }
    void calculateFine()
    {
        if(catagory.equals("C01"))
        {
            int temp=borrowDays-15;
            if(temp<=0)
            fineAmount=0;
            else 
            {
                if(temp<=10)
                fineAmount=temp*5;
                else
                {
                    temp-=10;
                    fineAmount=calculateFine(temp,10)+50;
                }
            }
        }
        if(catagory.equals("C02"))
        {
            int temp=borrowDays-30;
            if(temp<=0)
            fineAmount=0;
            else 
            {
                if(temp<=10)
                fineAmount=temp*5;
                else
                {
                    temp-=10;
                    fineAmount=calculateFine(temp,10)+50;
                }

            }
        
        }
        if(catagory.equals("C03"))
        {
            int temp=borrowDays-90;
            if(temp<=0)
            fineAmount=0;
            else 
            {
                fineAmount=calculateFine(temp,10);
            }
        }

    }
    void display()
    {
        System.out.println("Book name: "+bookName);
        System.out.println("Id number: "+id);
        System.out.println("Catagory: "+catagory);
        System.out.println("Barrow Days: "+borrowDays);
        System.out.println("Fine Amount: "+fineAmount);
    }
}

