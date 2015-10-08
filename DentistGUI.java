package dentistguidb;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 08/04/15
 */
public class DentistGUI 
{
    private JFrame frame;
    private PatientGUI pGUI; private ProcedureGUI procGUI; 
    private AdminMenuGUI adminMenuGUI; private ReportsGUI reportGUI;
    private JTabbedPane tp, dentistAdminTP, patientTP, procedureTP, reportsTP;
    private JPanel addPat, listPat, addProc, listProc, adddeleteProcToPat, 
                        addPayToPat, showPatDetails, reportPanel;
    private JMenuBar menubar;
    private JMenu fileMenu;
    private JMenuItem saveItem, quitItem;
    private MyController controller = new MyController();
    
    public DentistGUI () throws FileNotFoundException {
            
        this.createMainDisplay();
        frame.setSize(800, 600);
        frame.setLocation(25, 25);
    }
    
    public void createMainDisplay(){
        frame = new JFrame ("Dentist Administration System");
        frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
                {
                    int choice = JOptionPane.showConfirmDialog(null, "Save and Quit Program?");
                    if(choice == JOptionPane.YES_OPTION)
                        {

                                JOptionPane.showMessageDialog(null, "All program files saved");
                                frame.dispose();
                        }
                        else if(choice == JOptionPane.NO_OPTION)
                            {
                                JOptionPane.showMessageDialog(null, "Goodbye");
                                frame.dispose();
                            }
                            else {  } //Do nothing and continue the application
                }
        });
        
        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
            fileMenu = new JMenu("File");
            menubar.add(fileMenu);
                saveItem = new JMenuItem("Save");
                fileMenu.add(saveItem);
                saveItem.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e){
                        }
                    }
                );
                quitItem = new JMenuItem("Quit");
                fileMenu.add(quitItem);
                quitItem.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Goodbye");
                            frame.dispose();
                        }
                    }
                );  
        
        tp = new JTabbedPane();
        
        patientTP = new JTabbedPane();
        tp.addTab("Patient", patientTP);
            addPat = new JPanel(); 
            addPat.setLayout(new BorderLayout());
            patientTP.addTab("Add/Delete Patient", addPat);
            listPat = new JPanel();
            listPat.setLayout(new BorderLayout());
            patientTP.addTab("List Patients", listPat);
            
            pGUI = new PatientGUI(addPat, listPat, controller);
        
        procedureTP = new JTabbedPane();
        tp.addTab("Procedure", procedureTP);
            addProc = new JPanel(); 
            listProc = new JPanel();
            addProc.setLayout(new BorderLayout());
            procedureTP.addTab("Add/Delete Procedure", addProc);
            listProc.setLayout(new BorderLayout());
            procedureTP.addTab("List Procedures", listProc);
            
            procGUI = new ProcedureGUI(addProc, listProc, controller);
            
        dentistAdminTP = new JTabbedPane();
        tp.addTab("Admin Menu", dentistAdminTP);
            adddeleteProcToPat = new JPanel(); 
            adddeleteProcToPat.setLayout(new BorderLayout());
            dentistAdminTP.addTab("Add/Delete Procedure for patient", adddeleteProcToPat);
            addPayToPat = new JPanel(); 
            addPayToPat.setLayout(new BorderLayout());
            dentistAdminTP.addTab("Add Payment for patient", addPayToPat);
            showPatDetails = new JPanel(); showPatDetails.setLayout(new BorderLayout()); 
            dentistAdminTP.addTab("Display Patient Details", showPatDetails);
            
            adminMenuGUI = new AdminMenuGUI(adddeleteProcToPat, addPayToPat, showPatDetails, controller);
        
        reportsTP = new JTabbedPane();
        tp.addTab("Reports Menu", reportsTP);
            reportPanel = new JPanel();
            reportsTP.add(reportPanel);
            
            reportGUI = new ReportsGUI(reportPanel, controller); 
            
        frame.add(tp);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

