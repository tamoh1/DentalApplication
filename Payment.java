package dentistguidb;
/**
 * Student Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: Thomas.OHalloran@mycit.ie
 * Subject : OOP2
 */
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment implements Serializable{
    
    private static int payNumberLog = 100;
    private int payNumber;
    private double payAmount;
    private String payDate;
    DecimalFormat df = new DecimalFormat("#0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date today = new Date();
    
    public Payment () {}
    
    public Payment (double paymentAmount) 
    {
        payAmount = paymentAmount;
        payDate = sdf.format(today);
        payNumber = payNumberLog++;
    }
    
    public void setPayNumber()
    {
        payNumber = payNumberLog++;
    }
    
    public void setPayNumber(int number)
    {
        payNumber = number;
    }
    
    public int getPayNumber()
    {
        return payNumber;
    }
    
    public void setPayAmount(double payAmt)
    {
        payAmount = payAmt;
    }
    
    public double getPayAmount()
    {
        return payAmount;
    }
    
    public void setPayDate()
    {
        payDate = sdf.format(today);
    }
    
    //This method is used when taking in the date from a text file
    public void setPayDate(String date)
    {
        payDate = date;
    }
    
    public String getPayDate()
    {
        return payDate;
    }
    
    public String toString()
    {
        return "\n Pay ID : "+payNumber+", €"+df.format(payAmount)+", "+payDate;
    }

    public void print()
    {
        System.out.println(toString());
    }
}

