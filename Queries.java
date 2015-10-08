package dentistguidb;
import java.sql.*;
import java.util.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 14/05/15
 */
public class Queries 
{
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/Dentist";
    
    private Connection connection = null;
    private PreparedStatement addPatient = null;  
    private PreparedStatement removePatient = null;     
    private PreparedStatement getPatient = null;
    private PreparedStatement addProcToPatient = null;    
    private PreparedStatement deleteProcToPatient = null;   
    private PreparedStatement displayPatProcedures = null;
    private PreparedStatement displayPatPayments = null;
    private PreparedStatement getAllPatients = null; 
    private PreparedStatement addProcedure = null;   
    private PreparedStatement removeProcedure = null;   
    private PreparedStatement getProcedure = null;   
    private PreparedStatement getProcedure2 = null;   
    private PreparedStatement displayProcPatients = null;  
    private PreparedStatement getAllProcedures = null; 
    private PreparedStatement addPayment = null;
    
    public Queries () 
    {
        try
        {   
            connection = DriverManager.getConnection (DATABASE_URL);
            
            //All SQL statements relating to patients
            addPatient = connection.prepareStatement ( "INSERT INTO Patients " 
                                                        + "(pNumber, pName, pAdd, pPhone) " 
                                                        + "VALUES (?, ?, ?, ?)");
            removePatient = connection.prepareStatement ("DELETE FROM Patients "
                                                        + "WHERE pNumber=? AND pName = ?");
            getPatient = connection.prepareStatement ( "SELECT * "
                                                                + "FROM Patients "
                                                                + "WHERE pNumber=? AND pName = ?");
            addProcToPatient = connection.prepareStatement ( "INSERT INTO ListProcedures "
                                                                + "(pNumber, procNumber, procName, procCost) "
                                                                + "VALUES (?, ?, ?, ?)");
            deleteProcToPatient = connection.prepareStatement ( "DELETE FROM ListProcedures "
                                                                     + "WHERE pNumber=? AND procName=?");
            displayPatProcedures = connection.prepareStatement("SELECT procNumber, procName, procCost"
                                                                +"From Patients p, ListProcedures l"
                                                                +"WHERE p.pNumber = l.pNumber"
                                                                +"AND pNumber=? AND pName=?");
            displayPatPayments = connection.prepareStatement("SELECT payNumber, payAmount, payDate"
                                                                +"From Patients p, Payments pay"
                                                                +"WHERE p.pNumber = pay.pNumber"
                                                                +"AND pNumber=? AND pName=?");
            getAllPatients = connection.prepareStatement( "SELECT * "
                                                              + "FROM Patients");
            
            //All SQL statements relating to procedures
            addProcedure = connection.prepareStatement ( "INSERT INTO Procedures " 
                                                        + "(procNumber, procName, procCost) " 
                                                        + "VALUES (?, ?, ?)");
            removeProcedure = connection.prepareStatement ("DELETE FROM Procedures "
                                                        + "WHERE procNumber=? AND procName=?");
            getProcedure = connection.prepareStatement ( "SELECT * "
                                                                + "FROM Procedures "
                                                                + "WHERE procName = ?");
            getProcedure2 = connection.prepareStatement ( "SELECT * "
                                                                + "FROM Procedures "
                                                                + "WHERE procNumber=? AND procName=?");
            getAllProcedures = connection.prepareStatement("SELECT * "
                                                              + "FROM Procedures");
            displayProcPatients = connection.prepareStatement("Select pNumber, pName, pAdd, pPhone"
                                                             +"From Patients p, ListProcedures l"
                                                             +"WHERE p.pNumber = l.pNumber"
                                                             +"AND procNumber=? AND procName=?");
            
            //All SQL statements relating to payments
            addPayment = connection.prepareStatement ( "INSERT INTO Payments "
                                                              + "(pNumber, payNumber, payAmount, payDate) "
                                                              + "VALUES (?, ?, ?, ?)" );
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    /*
    *
    * The following section holds all methods related to a patient
    *
    */
    //Adds a patient to the dentist's list
    public void addPatient(int number, String name, String address, String phone)
    {
        try
        {
            addPatient.setInt (1, number);
            addPatient.setString (2, name);
            addPatient.setString (3, address);
            addPatient.setString (4, phone);
                     
            addPatient.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close ();
        }
    }
    
    //Removes a patient from the dentist's list
    public void removePatient(int number, String name)
    {
        try
        {
            removePatient.setInt (1, number);
            removePatient.setString (2, name);
            
            removePatient.executeUpdate();
        }
        
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }
    }
    
    //Returns a patient object for a particular patient
    public Patient getPatient(int number, String name)
    {
        ResultSet resultSet = null;
        Patient p = new Patient();
        try
        {
            getPatient.setInt(1, number);
            getPatient.setString(2, name);
            resultSet = getPatient.executeQuery();
            
            while (resultSet.next ())
            {
                    p.setPatNumber(resultSet.getInt ("pNumber"));
                    p.setPatName(resultSet.getString("pName"));
                    p.setPatAddr(resultSet.getString ("pAdd"));
                    p.setPatPhone(resultSet.getString ("pPhone"));
            }
            return p;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        
        return null;
    }
    
    //Adds a procedure to a patient
    public void addProcToPatient(String name, int number, String procName)
    {
        Patient p = this.getPatient(number, name);
        Procedure proc = this.getProcedure(name);
        try
        {
            addProcToPatient.setInt(1, p.getPatNumber());
            addProcToPatient.setInt (2, proc.getProcNumber());
            addProcToPatient.setString (3, proc.getProcName());
            addProcToPatient.setDouble (4, proc.getProcCost());
                     
            addProcToPatient.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
            close ();
        }
    }
    
    //Deletes a procedure from a patient
    public void deleteProcToPatient(String name, int number, String procName)
    {
        Patient p = this.getPatient(number, name);
        
        try
        {
            deleteProcToPatient.setInt(1, number);
            deleteProcToPatient.setString(2, procName);
            
            deleteProcToPatient.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
            close ();
        }
    }
    
    //This returns the list of patients in the dentist's list
    public ArrayList <Patient> getPatientArrayList ()
    {
        ArrayList <Patient> results = null;
        ResultSet resultSet = null;
        try
        {
            resultSet = getAllPatients.executeQuery ();
            results = new ArrayList <Patient> ();
            Patient p = new Patient();
            while (resultSet.next ())
            {
                p.setPatNumber(resultSet.getInt ("pNumber"));
                p.setPatName(resultSet.getString("pName"));
                p.setPatAddr(resultSet.getString ("pAdd"));
                p.setPatAddr(resultSet.getString ("pPhone"));
                
                results.add(p);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        
        return results;
    }
    
    //This returns an array list of procedures for a particular patient
    public ArrayList<Procedure> displayPatProcedures(int number, String name)
    {
        ArrayList <Procedure> results = null;
        ResultSet resultSet = null;
        try
        {
            displayPatProcedures.setInt(1, number);
            displayPatProcedures.setString(1, name);
            resultSet = displayPatProcedures.executeQuery ();
            results = new ArrayList <Procedure> ();
            Procedure p = new Procedure();
            while (resultSet.next ())
            {
                p.setProcNumber(resultSet.getInt ("procNumber"));
                p.setProcName(resultSet.getString("procName"));
                p.setProcCost(resultSet.getDouble("procCost"));
                
                results.add(p);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        return results;
    }
    
    //Returns an arraylist of payments for a particular patient
    public ArrayList<Payment> displayPatPayments(int number, String name)
    {
        ArrayList <Payment> results = null;
        ResultSet resultSet = null;
        try
        {
            displayPatPayments.setInt(1, number);
            displayPatPayments.setString(1, name);
            resultSet = displayPatPayments.executeQuery ();
            results = new ArrayList <Payment> ();
            Payment p = new Payment();
            while (resultSet.next ())
            {
                p.setPayNumber(resultSet.getInt ("payNumber"));
                p.setPayAmount(resultSet.getDouble("payAmount"));
                p.setPayDate(resultSet.getString("payDate"));
                
                results.add(p);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        return results;
    }
    
    /*
    *
    * The following section holds all methods related to a procedure
    *
    */
    
    //This adds a procedure to the dentist's list of procedures
    public void addProcedure (int procNumber, String procName, double procCost)
    {
        try
        {
            addProcedure.setInt (1, procNumber);
            addProcedure.setString (2, procName);
            addProcedure.setDouble(3, procCost);
                     
            addProcedure.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
            close ();
        }
    }
    
    //This removes a procedure from the dentist's list of procedures
    public void removeProcedure (int procNumber, String name)
    {
        try
        {
            removeProcedure.setInt (1, procNumber);
            removeProcedure.setString(2, name);
            
            removeProcedure.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
            close ();
        }
    }
    
    //This gets a procedure from the dentist's list
    public Procedure getProcedure(String name)
    {
        ResultSet resultSet = null;
        Procedure p = new Procedure();
        try
        {
            getProcedure.setString(1, name);
            resultSet = getProcedure.executeQuery ();
            
            while (resultSet.next ())
            {
                    p.setProcNumber(resultSet.getInt ("procNumber"));
                    p.setProcName(resultSet.getString("procName"));
                    p.setProcCost(resultSet.getDouble("procCost"));
            }
            return p;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        return null;
    }
    
    //This returns a procedure for a particular patient
    public Procedure getProcedure2(int number, String name)
    {
        ResultSet resultSet = null;
        Procedure p = new Procedure();
        try
        {
            getProcedure2.setInt(1, number);
            getProcedure2.setString(2, name);
            resultSet = getProcedure2.executeQuery ();
            
            while (resultSet.next ())
            {
                    p.setProcNumber(resultSet.getInt ("procNumber"));
                    p.setProcName(resultSet.getString("procName"));
                    p.setProcCost(resultSet.getDouble("procCost"));
            }
            return p;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        return null;
    }
    
    //Return the list of the dentist's available procedures
    public ArrayList <Procedure> getProcedureArrayList ()
    {
        ArrayList <Procedure> results = null;
        ResultSet resultSet = null;
        try
        {
            resultSet = getAllProcedures.executeQuery ();
            results = new ArrayList <Procedure> ();
            Procedure p = new Procedure();
            while (resultSet.next ())
            {
                p.setProcNumber(resultSet.getInt ("procNumber"));
                p.setProcName(resultSet.getString("procName"));
                p.setProcCost(resultSet.getDouble ("procCost"));
                
                results.add(p);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        
        return results;
    }
    
    //this returns an arraylist of patients for a particular procdure
    public ArrayList<Patient> displayProcPatients(int number, String name)
    {
        ArrayList <Patient> results = null;
        ResultSet resultSet = null;
        try
        {
            displayProcPatients.setInt(1, number);
            displayProcPatients.setString(2, name);
            resultSet = displayProcPatients.executeQuery ();
            results = new ArrayList <Patient>();
            Patient p = new Patient();
            while (resultSet.next ())
            {
                p.setPatNumber(resultSet.getInt ("pNumber"));
                p.setPatName(resultSet.getString("pName"));
                p.setPatAddr(resultSet.getString ("pAdd"));
                p.setPatAddr(resultSet.getString ("pPhone"));
                
                results.add(p);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
            sqlException.printStackTrace ();
            close ();
            }
        }
        
        return results;
    }
    
    /*
    *
    * The following section holds all methods related to payments
    *
    */
    //This adds a payment to a patient
    public void addPayment(int pnumber, int payNum, double payAmount, String date)
    {
        try
        {
            addPayment.setInt (1, pnumber);
            addPayment.setInt (2, payNum);
            addPayment.setDouble(3, payAmount);
            addPayment.setString(4, date);
                     
            addPayment.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
            close ();
        }
    }
    
    //This method is used to close the DB connection
    public void close ()
    {
        try
        {
            connection.close();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace ();
        }
    }
}
