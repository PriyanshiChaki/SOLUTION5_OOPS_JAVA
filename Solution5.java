import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Solution5 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc= new Scanner(System.in);
        Inventory invent[]= new Inventory[4];
        for(int i=0;i<invent.length;i++)
        {
            invent[i]=new Inventory(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
            int limit=sc.nextInt();
            sc.close();
            Inventory arr[]=replenish(invent,limit);
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i].getThreshold()>75)
                System.out.println(arr[i].getInventoryId() + " Critical Filling");
                else if(arr[i].getThreshold()>50 && arr[i].getThreshold()<75)
                System.out.println(arr[i].getInventoryId()+ " Moderate Filling");
                else 
                System.out.println(arr[i].getInventoryId()+ " Non-Critical Filling");
            }
        }
    

    public static Inventory[] replenish(Inventory[] invent, int limit) {
        Inventory newarr[]=new Inventory[0];
        for(int i=0;i<invent.length;i++)
        {
            if(invent[i].getThreshold()<=limit)
            {
                newarr=Arrays.copyOf(newarr, newarr.length+1);
                newarr[newarr.length-1]=invent[i];
            }
        }

        return newarr;
    }

    
}
class Inventory{
    String inventoryId;
    int maximumQuantity; 
    int currentQuantity;
    int threshold; 

    public String getInventoryId()
    {
        return inventoryId;
    }
    public int getMaximumQuantity()
    {
        return maximumQuantity;
    }
    public int getCurrentQuantity()
    {
        return currentQuantity;
    }
    public int getThreshold()
    {
        return threshold;
    }
    public void setInventoryId(String inventoryId)
    {
        this.inventoryId=inventoryId;
    }
    public void setMaximumQuantity(int maximumQuantity)
    {
        this.maximumQuantity=maximumQuantity;
    }
    public void setCurrentQuantity(int currentQuantity)
    {
        this.currentQuantity=currentQuantity;
    }
    public void setThreshold(int threshold)
    {
        this.threshold=threshold;
    }
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold)
    {
        this.inventoryId=inventoryId;
        this.maximumQuantity=maximumQuantity;
        this.currentQuantity=currentQuantity;
        this.threshold=threshold;
    }
}