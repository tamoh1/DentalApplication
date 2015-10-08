package dentistguidb;
/**
 * Student Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: Thomas.OHalloran@mycit.ie
 * Subject : OOP2
 * Date Completed 15/05/15
 */
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Patient implements Serializable, Comparable{
    
    Queries q = new Queries();
    private static int patNumberLog = 10000;
    private int patientNumber;
    private String patientName;
    private String patientAddr;
    private String patientPhone;
    ArrayList<Procedure> procList = null;
    ArrayList<Payment> payList = null;
    
    public Patient () {}
    
    public Patient (String patName, String patAddr, String patPhone) 
    {
        patientName = patName;
        patientAddr = patAddr;
        patientPhone = patPhone;
        patientNumber = patNumberLog++;
    }
    
    public void setPatNumber()
    {
        patientNumber = patNumberLog++;
    }
    
    public void setPatNumber(int number)
    {
        patientNumber = number;
    }
    
    public int getPatNumber()
    {
        return patientNumber;
    }
    
    
    public void setPatName(String patName)
    {
        patientName = patName;
    }
    
    public String getPatName()
    {
        return patientName;
    }
    
    
    public void setPatAddr(String patAddr)
    {
        patientAddr = patAddr;
    }
    
    public String getPatAddr()
    {
        return patientAddr;
    }
    
    
    public void setPatPhone(String patPhone)
    {
        patientPhone = patPhone;
    }
    
    public String getPatPhone()
    {
        return patientPhone;
    }
    
    public boolean findProcedure(String procName)
    {
        boolean found = false;
        for(int i = 0;i<procList.size();i++)
        {
            if(procList.get(i).getProcName().matches(procName))
            {
                found = true;
            }
        }
        return found;
    }
    
    public void addProcedure(Procedure p1)
    {
        procList.add(p1);
    }
    
    public void removeProcedure(String procName)
    {
        for(int i = 0;i<procList.size();i++)
        {
            if(procList.get(i).getProcName().equalsIgnoreCase(procName))
            {
                procList.remove(i);
            }
        }
    }
    
    public boolean findPayment(int payNum)
    {
        boolean found = false;
        for(int i = 0;i<payList.size();i++)
        {
            if(payList.get(i).getPayNumber() == payNum)
            {
                found = true;
            }
        }
        return found;
    }
        
    public void addPayment(Payment p1)
    {
        payList.add(p1);
    }
    
    public void removePayment(int payNum)
    {
        for(int i = 0;i<payList.size();i++)
        {
            if(payList.get(i).getPayNumber() == payNum)
            {
                payList.remove(i);
            }
        }
    }
    
    public String toString()
    {   
        return "\nPatient Number : "+patientNumber
              +"\nPatient Name   : "+patientName
              +"\nPatient Address: "+patientAddr
              +"\nPatient Phone  : "+patientPhone+"\n";
    }

    public void print()
    {
        System.out.println(toString());
    }
    
    public ArrayList<Procedure> getProcArray()
    {
        procList = q.displayPatProcedures(patientNumber, patientName);
        return procList;
    }
    
    public ArrayList<Payment> getPayArray()
    {
        return payList;
    }
    
    public String getProcList()
    {
        String display = "";
        for(int i = 0;i<procList.size();i++)
        {
            display += procList.get(i).toString();
        }
        return display;
    }
    
    public String printPayList()
    {
        String temp = "";
        for(int i = 0;i<payList.size();i++)
        {
            temp += payList.get(i).toString();
        }
        return temp;
    }
    
    public double getProcTotalAmount()
    {
        double result = 0;
        procList = this.getProcArray();
        for(int i = 0;i<procList.size();i++)
        {
            result += procList.get(i).getProcCost();
        }
        return result;
    }
    
    public double getPayTotalAmount()
    {
        double result = 0;
        payList = q.displayPatPayments(patientNumber, patientName);
        for(int i = 0;i<payList.size();i++)
        {
            result += payList.get(i).getPayAmount();
        }
        return result;
    }
    
    public double getTotal()
    {
        return (this.getProcTotalAmount()-this.getPayTotalAmount());
    }
    
    public int compareTo(Object p){
        int cmp = this.patientName.compareTo(((Patient) p).getPatName());
        return cmp;   
    }
}

