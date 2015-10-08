package dentistguidb;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.*;
import javax.swing.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 08/04/15
 */
public class ReportsGUI {
    
    private JTextArea j1, j2;
    private JButton patientReport, paymentReport;
    
    public ReportsGUI() {}
    
    public ReportsGUI( JPanel reportPanel, MyController controller)
    {
        this.createReportsPage(reportPanel, controller);
    }
    
    public void createReportsPage(JPanel reportPanel, final MyController controller)
    {
        reportPanel.setLayout(new GridLayout(0,1));
        
            //This section shows text and button to generate the patient report that
            //that is sorted by name
            JPanel topPanel = new JPanel();
            topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Report on all patients"));
            reportPanel.add(topPanel);
            
                j1 = new JTextArea(12,30);
                patientReport = new JButton("Generate Patient Report");
                topPanel.add(j1);
                topPanel.add(Box.createHorizontalStrut(80));
                topPanel.add(patientReport);
                
                    j1.append("\n\n\n                The following report will generate a list of"
                                     + "\n                 patients sorted by name and showing all  "
                                     + "\n                   details in relation to procedures and"
                                     + "\n                                          payments.");
            
            //This sections shows text and button to generate the patient report that
            //contains account details on patients who haven't paid in the last 6 months
            JPanel bottomPanel = new JPanel();
            bottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Report on patient payments"));
            reportPanel.add(bottomPanel);
            
                j2 = new JTextArea(12,30);
                paymentReport = new JButton("Generate Payment Report");
                bottomPanel.add(j2);
                bottomPanel.add(Box.createHorizontalStrut(80));
                bottomPanel.add(paymentReport);
                
                    j2.append("\n\n\n                  The following report will generate a list of"
                                     + "\n               patients sorted by the amount of money they"
                                     + "\n                         owe and if they have not made a "
                                     + "\n                                  payment in 6 months");
            
        patientReport.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    try{ 
                        controller.generatePatientReport();
                        }
                    catch ( IOException ex) { System.out.println("Input/Output Error !!!"); }
                    catch ( Exception ex) { }
                }
            }
        );
        
        paymentReport.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    try{ 
                        controller.generatePaymentReport();
                        }
                    catch ( IOException ex) { System.out.println("Input/Output Error !!!"); }
                    catch ( Exception ex) {}
                }
            }
        );
    }
    
}
