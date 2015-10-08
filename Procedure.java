package dentistguidb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Student Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: Thomas.OHalloran@mycit.ie
 * Subject : OOP2
 * Date Completed 13/02/15
 */

public class Procedure implements Cloneable, Serializable {
   
    private static int procLogNumberList = 1000000;
    private int procedureNumber;
    private String procedureName;
    private double procedureCost;
    
    public Procedure () {}
    
    public Procedure (String procName, double procCost) 
    {
        procedureName = procName;
        procedureCost = procCost;
        procedureNumber = procLogNumberList++;
    }
    
    public void setProcNumber()
    {
        procedureNumber = procLogNumberList++;
    }
    
    public void setProcNumber(int number)
    {
        procedureNumber = number;
    }
    
    public int getProcNumber()
    {
        return procedureNumber;
    }
    
    public void setProcName(String procName)
    {
        procedureName = procName;
    }
    
    public String getProcName()
    {
        return procedureName;
    }
    
    public void setProcCost(double procCost)
    {
        procedureCost = procCost;
    }
    
    public double getProcCost()
    {
        return procedureCost;
    }
    
    public String toString()
    {
        return "\nProcedure Number : "+procedureNumber
              +"\nProcedure Name   : "+procedureName
              +"\nProcedure Cost   : "+procedureCost+"\n";
    }

    public void print()
    {
        System.out.println(toString());
    }
    
    public Object clone(){
        try
            {
                return super.clone();
            }
            catch(CloneNotSupportedException e)
                {
                    System.out.println("Cloning not allowed.");
                    return this;
                }
    }
}
