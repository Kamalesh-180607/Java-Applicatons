import java.util.*;
class product
{
    static String cus[][]=new String[100][];
    static int id[]=new int[100];
    static String price[][]={{"Milk(code '001')","40"},{"Butter(code '002')","30"},{"Bread(code '003')","50"},{"Buiscuit(code '004')","100"},{"Cake(code '005')","80"}};
    static int total[]=new int[100];
    //Arrays.fill(total,0);
       
    void setid(int ii,int idd)
    {
        id[ii]=idd;
    }
    static void showproduct()
    {
        System.out.println("Products\t\t\tPrice");
        for(int i=0;i<price.length;i++)
        {
            for(int j=0;j<price[i].length;j++)
            {
                System.out.print(price[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
    void purchase(int arr[],int i)
    {
        int k=0;
        for(int j=0;j<arr.length;j++)
        {
            int temp=arr[j];
            switch(temp)
            {
                case 001:
                    cus[i][k++]="Milk";
                    total[i]+=40;
                    break;
                case 002:
                    cus[i][k++]="Butter";
                    total[i]+=30;
                    break;
                case 003:
                    cus[i][k++]="Bread";
                    total[i]+=50;
                    break;
                 case 004:
                    cus[i][k++]="Buiscuit";
                    total[i]+=100;
                    break;
                 case 005:
                    cus[i][k++]="Cake";
                    total[i]+=80;
                    break;
            }
        }
    }
    static void display(int num)
    {
       int res = -1;
      for (int i = 0; i < id.length; i++) 
      {
           if (id[i] == num)
            {
           res = i;
           break;
            }
     }
        if(res<0)
        {
            System.out.println("Custumer id is not found!!");
            return;
        }
        System.out.println("\nCustemer id is: "+num);
        System.out.println("Purchased products");
        for(int i=0;i<cus[res].length;i++)
        {
            System.out.println(cus[res][i]);
        }
        System.out.println("Total amount: "+total[res]);
        
    }
    static void putdata(int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.println("\nCustemer id: "+id[i]);
            System.out.println("Purchased products");
            for(int j=0;j<cus[i].length;j++)
            {
                System.out.println(cus[i][j]);
            }
            System.out.println("Total amount: "+total[i]);
        }

    }
                    
}
public class Store
{
    public static void main(String args[])
    {
        int n;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of custemer: ");
        n=scan.nextInt();
        product obj[] = new product[n];
        for(int i=0;i<n;i++)
        {
            int id;
            System.out.println("Enter custemer id: ");
            id=scan.nextInt();
            obj[i]=new product();
            obj[i].setid(i,id);
            System.out.println("Products and price menu");
            product.showproduct();
            int ch;
            System.out.println("\nHow many products do you want");
            ch=scan.nextInt();
            int arr[]=new int[ch];
            System.out.println("Enter product code as per menu");
            for(int ii=0;ii<ch;ii++)
            {
                int temp2=scan.nextInt();
                Arrays.sort(arr);
                while(Arrays.binarySearch(arr,temp2)>=0)
                {
                    System.out.println("You can purchase one quantity for one product!!choose another product");
                    temp2=scan.nextInt(); 
                }
                arr[ii]=temp2;
            }
            product.cus[i] = new String[arr.length];
            obj[i].purchase(arr,i);
        }
        System.out.println("\nEnter specific custemer id for display");
        int cuid=scan.nextInt();
        product.display(cuid);
        System.out.println("\nTotal Custemers details");
        product.putdata(n);

    }
}