package dentistguidb;

import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 15/05/15
 */
public class MyController implements Serializable{
    
    private Queries queries = new Queries();
    private ArrayList<Patient> patList = null;
    private ArrayList<Procedure> procList = null;
    private AdminMenuGUI amGUI = new AdminMenuGUI();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat df = new DecimalFormat("#0.00");
    
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/Dentist";
    
    public static void main(String[] args) throws FileNotFoundException {
       
        new DentistGUI();
    }
    
    /*
    * The following section holds all methods related to patients
    */
    
    //this method adds a patient
    public void addPatient(String name, String address, String phone)      
    {
        Patient p = new Patient();
        p.setPatName(name);
        p.setPatAddr(address);
        p.setPatPhone(phone);
        p.setPatNumber();
        queries.addPatient(p.getPatNumber(), name, address, phone);
    }
    
    //This method removes a patient
    public void removePatient(String name, String number)     
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                queries.removePatient(num, name);
            }
    }
    
    //This returns a patient object
    public Patient getPatient(String name, String number)      
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                return queries.getPatient(num, name);
            }
        
        return null;
    }
    
    //This method adds a procedure to a patient
    public void addProcToPatient(String name, String number, String procName)        
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                queries.addProcToPatient(name, num, procName);
            }
    }

    //This method removes a procedure from a patient
    public void deleteProcToPatient(String name, String number, String procName)       
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                queries.deleteProcToPatient(name, num, procName);
            }
    }
    
    //This returns a string display of a patient
    public String displayPatient(String name, String number)       
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                Patient p = queries.getPatient(num, name);
                return p.toString();
            }
        return "No patient found";
    }
    
    //This returns a string list of all procedures for a particular patient
    public String displayPatProcedures(String name, String number)     
    {
        String temp = "";  
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                ArrayList<Procedure> tempList =  queries.displayPatProcedures(num, name);
                for(int i = 0; i < tempList.size();i++)
                {
                    temp += tempList.get(i).toString();
                }
            }
        return "";
    }
    
    //This returns a string list of all patients
    public String displayAllPatients()      //Done
    {
        String temp = "";  
        patList = queries.getPatientArrayList();
        for(int i = 0; i < patList.size();i++)
        {
            temp += patList.get(i).toString();
        }
        return temp;
    }
    
    /*
    * The following section holds all methods related to procedures
    */
    
    //This method adds a procedure to the dentist's practice
    public void addProcedure(String name, String  cost)    
    {
        double procCost = Double.parseDouble(cost);
        Procedure proc = new Procedure();
        proc.setProcName(name);
        proc.setProcCost(procCost);
        proc.setProcNumber();
        queries.addProcedure(proc.getProcNumber(), name, procCost);
    }
    
    //This method removes a procedure from the dentist's practice
    public void removeProcedure(String name, String num)       
    {
        if(num.matches("[0-9]+"))
            {
                int procNum = Integer.parseInt(num);
                queries.removeProcedure(procNum, name);
            }
    }
    
    //This returns a procedure object
    public Procedure getProcedure(String name, String num)     
    {
        if(num.matches("[0-9]+"))
            {
                int procNum = Integer.parseInt(num);
                return queries.getProcedure2(procNum, name);
            }
        return null;
    }
    
    //This returns a string representation for a particular procedure
    public String displayProcedure(String name, String number)     
    {
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                Procedure p = queries.getProcedure2(num, name);
                return p.toString();
            }
        return "No procedure found";
    }
    
    
    //This returns a string representation of all procedures
    public String displayAllProcedures()       
    {
        String temp = "";   
        procList = queries.getProcedureArrayList();
        for(int i = 0; i < procList.size();i++)
        {
            temp += procList.get(i).toString();
        }
        return temp;
    }
    
    //This returns string representation of all patients that have a particular procedure
    public String displayProcPatients(String name, String number)      
    {
        String temp = "";
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                patList = queries.displayProcPatients(num, name);
                for(int i = 0; i <patList.size();i++)
                {
                    temp += patList.get(i).toString();
                }
            }   
        return temp;
    }
    
    /*
    * The following section holds all methods related to payments
    */
    
    //This method adds a payment for a patient
    public void addPayment(String name, String number, String amount)       
    {
        Payment pay = new Payment();
        if(number.matches("[0-9]+"))
            {
                double payAmount = Double.parseDouble(amount);
                int num = Integer.parseInt(number);
                pay.setPayNumber();
                pay.setPayDate();
                
                queries.addPayment(num, pay.getPayNumber(), payAmount, pay.getPayDate());
            }   
    }
    
    //This returns a string representation of all payments for a particular patient
    public String displayPayments(String name, String number)
    {
        String temp = "";
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                ArrayList<Payment> tempPayList = queries.displayPatPayments(num, name);
                for(int i = 0; i <tempPayList.size();i++)
                {
                    temp += tempPayList.get(i).toString();
                }
            }
        return temp;
    }
    
    //This method returns a string representation of the patients account details
    public String showPatientAccountDetails(String name, String number)
    {
        String result = "";
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                Patient p = queries.getPatient(num, name);
                result += p.getPatName()
                                      +"\n"+p.getPatAddr()
                                      +"\n"+p.getPatPhone()
                                    +"\n  Total Cost of Procedures €"+df.format(p.getProcTotalAmount())
                                    +"\n  Total amount paid to date €"+df.format(p.getPayTotalAmount())
                                    +"\n  Balance remaining to be paid €"+(df.format(p.getTotal()));
            }
        return result;
    }
    
    //This method calculates the amount of money the patient still owes
    public double getTotalAmountOwed(String name, String number)
    {
        double result = 0;
        if(number.matches("[0-9]+"))
            {
                int num = Integer.parseInt(number);
                Patient p = queries.getPatient(num, name);
                result = p.getTotal();
            }
        return result;
    }
    
    /*
    * This method is used to populate the procedure drop down box
    * when the system is started
    */
    public JComboBox populateProcedureSelectionList()
    {
        JComboBox temp = new JComboBox();
        procList = queries.getProcedureArrayList();
        temp.insertItemAt("", 0);
        int count = 1;
        
        for(int i = 0;i<this.procList.size();i++)
        {
            temp.insertItemAt(this.procList.get(i).getProcName(), count);
            count++;
        }
        
        return temp;
    }
    
    /*
    * The following methods are for generating the text file reports
    */
    
    public void generatePatientReport() throws Exception
    {
        FileWriter fw = new FileWriter("PatientTextReport.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        ArrayList<Procedure> tempProcList;
        ArrayList<Payment> tempPayList;
        
        ArrayList<Patient> tempPatList = queries.getPatientArrayList();
        
        Collections.sort(tempPatList);
        
        bw.write("\n---------------------------------------------------------\n");
        bw.write("\n   This report contains a list of patients that have "
                +    "\n    been sorted in alphabetical order by name."
                + "\n---------------------------------------------------------\n");
        
        for(int i = 0; i< tempPatList.size();i++)
        {
            bw.write("\n Patient : "+(i+1));
            bw.write("\n   "+tempPatList.get(i).getPatNumber());
            bw.write("\n   "+tempPatList.get(i).getPatName());
            bw.write("\n   "+tempPatList.get(i).getPatAddr());
            bw.write("\n   "+tempPatList.get(i).getPatPhone());
            
            tempProcList = queries.displayPatProcedures(tempPatList.get(i).getPatNumber(), tempPatList.get(i).getPatName());
            tempPayList = queries.displayPatPayments(tempPatList.get(i).getPatNumber(), tempPatList.get(i).getPatName());
            
            bw.write("\n      Procedures");
            for(int j = 0;j<tempProcList.size();j++)
            {
                bw.write("\n      "+tempProcList.get(j).getProcNumber()+","+tempProcList.get(j).getProcName()+", €"+df.format(tempProcList.get(j).getProcCost()));
            }
            bw.write("\n      Payments");
            for(int k = 0;k<tempPayList.size();k++)
            {
                bw.write("\n      "+tempPayList.get(k).getPayNumber()+", €"+df.format(tempPayList.get(k).getPayAmount())+", "+tempPayList.get(k).getPayDate());
            }
            bw.write("\n----------------------------------------\n");
        }
        bw.close();
    }
    
    public void generatePaymentReport() throws Exception
    {
        FileWriter fw = new FileWriter("ProcedureTextReport.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        ArrayList<Procedure> tempProcList;
        ArrayList<Payment> tempPayList;
        patList = queries.getPatientArrayList();
        ArrayList<Patient> tempPatList = new ArrayList();
        
        bw.write("\n---------------------------------------------------------\n");
        bw.write("\n   This report contains a list of patients that have "
                +    "\n    have not made a payment in the last 6 months."
                +    "\n    It shows the patient contact details with a"
                +    "\n    breakdown of their account details.\n "
                + "\n---------------------------------------------------------\n");
        
        
        for(int i = 0;i<patList.size();i++)
        {
            if( patList.get(i).getTotal() > 0)
                {
                    tempPatList.add(patList.get(i));
                }
        }
        
        for(int j = 0;j<tempPatList.size();j++)
        {
            tempPayList = queries.displayPatPayments(tempPatList.get(j).getPatNumber(), tempPatList.get(j).getPatName());
            for(int k = 0;k<tempPayList.size();k++)
            {
                if(this.compareDates(tempPayList.get(k).getPayDate()) == true)
                    {
                        tempPatList.remove(j);
                        j = 0;
                        k = tempPayList.size();
                    }
            }
        }
        
        Collections.sort(tempPatList, new Comparator<Patient>() {	//anonymous inner class to implement Comparator
                public int compare (Patient p1, Patient p2) {
                        double amount1 = p1.getTotal();            //compares amounts owed by patients in new list and orders them
                        double amount2 = p2.getTotal();
                        return (int) (amount2 - amount1);					
                }
            }
        );
        
        for(int i = 0; i< tempPatList.size();i++)
        {
            bw.write("\n Patient : "+(i+1));
            bw.write("\n   "+tempPatList.get(i).getPatNumber());
            bw.write("\n   "+tempPatList.get(i).getPatName());
            bw.write("\n   "+tempPatList.get(i).getPatAddr());
            bw.write("\n   "+tempPatList.get(i).getPatPhone());
            bw.write("\n\n           Account Details");
            bw.write("\n       Total cost of procedures: €"+df.format(tempPatList.get(i).getProcTotalAmount()));
            bw.write("\n       Amount paid to date:       €"+df.format(tempPatList.get(i).getPayTotalAmount()));
            bw.write("\n       Remaining balance owed: €"+df.format(tempPatList.get(i).getTotal()));
            bw.write("\n---------------------------------------------------------\n");
        }
        bw.close();
    }
    
    //This method checks to see if a payment has been paid in the last 6 months
    public boolean compareDates(String payDate) throws ParseException
    {
        long backDate = System.currentTimeMillis() - ((long)180) *24*60*60*1000;
        Date checkDate = new Date();
        checkDate.setTime(backDate);
        Date paymentDate = new SimpleDateFormat("dd/MM/yyyy").parse(payDate);
        
        if(paymentDate.after(checkDate))
            {
                return true;
            }
            else
                {
                    return false;
                }
    }
}
