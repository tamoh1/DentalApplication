package dentistguidb;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 08/04/15
 */
public class AdminMenuGUI {
    
    private JTextField patNameText1, patNumberText1, patNameText2, patNumberText2,
                                patNameText3, patNumberText3, payAmountText, patNameText4, patNumberText4;
    private JButton patientFindBtn1, patientFindBtn2, patientFindResetBtn1, patientFindResetBtn2, 
                           deleteProcedureBtn, deleteProcedureCancelBtn, addProcedureBtn, addProcedureCancelBtn,
                            patientFindBtn3, patientFindResetBtn3, enterPayAmountBtn, payAmountResetBtn,
                            patientFindBtn4, patientFindResetBtn4;
    private JTextArea displayTopArea, displayBottomArea, accountDisplay, accountDisplay1, listPatProcedures, listPatPayments;
    private static JComboBox addProcList;
    private static JComboBox deleteProcList;
    
    private DecimalFormat df = new DecimalFormat("#0.00");
    
    public AdminMenuGUI(){}
    
    public AdminMenuGUI(JPanel adddeleteProcToPat, JPanel addPayToPat, JPanel showPatDetails, MyController controller){
        
        this.addDeleteProcToPatientDisplay(adddeleteProcToPat, controller);
        this.addPaymentToPatientDisplay(addPayToPat, controller);
        this.displayPatientDetails(showPatDetails, controller);
        
    }
    
    //This method creates the GUI display for adding and deleting a procedure for a patient
    public void addDeleteProcToPatientDisplay(JPanel adddeleteProcToPat, final MyController controller)
    {
        JPanel pCenter = new JPanel();
        adddeleteProcToPat.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        
            //This section is for adding a procedure to a patient
            JPanel pCenterTop = new JPanel();
            pCenterTop.setLayout(new BoxLayout(pCenterTop, BoxLayout.X_AXIS));
            pCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add procedure to patient"));
            pCenter.add(pCenterTop);
                
                JPanel pCT1 = new JPanel();
                pCT1.setLayout(new BoxLayout(pCT1, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT1);
                    pCT1.add(Box.createVerticalStrut(20));
                    JPanel pCT1Name = new JPanel();
                    pCT1.add(pCT1Name);
                        JLabel patientNameLabelTop = new JLabel("Patient Name: ");
                        pCT1Name.add(patientNameLabelTop);
                        patNameText1 = new JTextField(12);
                        pCT1Name.add(patNameText1);
                    JPanel pCT1Number = new JPanel();
                    pCT1.add(pCT1Number);
                        JLabel patientNumberLabelTop = new JLabel("Patient Number: ");
                        pCT1Number.add(patientNumberLabelTop);
                        patNumberText1 = new JTextField(10);
                        pCT1Number.add(patNumberText1);
                    JPanel pCT1Buttons = new JPanel();
                    pCT1.add(pCT1Buttons);
                        patientFindBtn1 = new JButton("Find Patient");
                        pCT1Buttons.add(patientFindBtn1);
                        pCT1Buttons.add(Box.createHorizontalStrut(15));
                        patientFindResetBtn1 = new JButton("Reset Details");
                        pCT1Buttons.add(patientFindResetBtn1);
                        
                JPanel pCT2 = new JPanel();
                pCenterTop.add(pCT2);
                    displayTopArea = new JTextArea(12, 22);
                    displayTopArea.setEditable(false);
                    displayTopArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCT2.add(displayTopArea);
                
                JPanel pCT3 = new JPanel();
                pCT3.setLayout(new BoxLayout(pCT3, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT3);
                    JPanel pCT3Top = new JPanel();
                    pCT3Top.setLayout(new BoxLayout(pCT3Top, BoxLayout.Y_AXIS));
                    pCT3.add(pCT3Top);
                        pCT3Top.add(Box.createVerticalStrut(30));
                        JPanel pCT3Top1 = new JPanel();
                        pCT3Top.add(pCT3Top1);
                            JLabel addProcLabel = new JLabel("Choose a procedure from the drop down list");
                            pCT3Top1.add(addProcLabel);
                        JPanel pCT3Top2 = new JPanel();
                        pCT3Top.add(pCT3Top2);
                            addProcList = new JComboBox();
                            addProcList = (JComboBox) controller.populateProcedureSelectionList();
                            addProcList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXX");
                            pCT3Top2.add(addProcList);
                    JPanel pCT3Bottom = new JPanel();
                    pCT3.add(pCT3Bottom);
                        addProcedureBtn = new JButton("Add Procedure");
                        pCT3Bottom.add(addProcedureBtn);
                        addProcedureCancelBtn = new JButton("Cancel");
                        pCT3Bottom.add(addProcedureCancelBtn);
            
            //This section is for deleting a procedure from a patient
            JPanel pCenterBottom = new JPanel();
            pCenterBottom.setLayout(new BoxLayout(pCenterBottom, BoxLayout.X_AXIS));
            pCenterBottom.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Delete procedure from patient"));
            pCenter.add(pCenterBottom);
                
                JPanel pCB1 = new JPanel();
                pCB1.setLayout(new BoxLayout(pCB1, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB1);
                    pCB1.add(Box.createVerticalStrut(20));
                    JPanel pCB1Name = new JPanel();
                    pCB1.add(pCB1Name);
                        JLabel patientNameLabelBottom = new JLabel("Patient Name: ");
                        pCB1Name.add(patientNameLabelBottom);
                        patNameText2 = new JTextField(12);
                        pCB1Name.add(patNameText2);
                    JPanel pCB1Number = new JPanel();
                    pCB1.add(pCB1Number);
                        JLabel patientNumberLabelBottom = new JLabel("Patient Number: ");
                        pCB1Number.add(patientNumberLabelBottom);
                        patNumberText2 = new JTextField(10);
                        pCB1Number.add(patNumberText2);
                    JPanel pCB1Buttons = new JPanel();
                    pCB1.add(pCB1Buttons);
                        patientFindBtn2 = new JButton("Find Patient");
                        pCB1Buttons.add(patientFindBtn2);
                        pCB1Buttons.add(Box.createHorizontalStrut(15));
                        patientFindResetBtn2 = new JButton("Reset Details");
                        pCB1Buttons.add(patientFindResetBtn2);
                        
                JPanel pCB2 = new JPanel();
                pCenterBottom.add(pCB2);
                    displayBottomArea = new JTextArea(12, 22);
                    displayBottomArea.setEditable(false);
                    displayBottomArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCB2.add(displayBottomArea);
                
                JPanel pCB3 = new JPanel();
                pCB3.setLayout(new BoxLayout(pCB3, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB3);
                    JPanel pCB3Top = new JPanel();
                    pCB3Top.setLayout(new BoxLayout(pCB3Top, BoxLayout.Y_AXIS));
                    pCB3.add(pCB3Top);
                        pCB3Top.add(Box.createVerticalStrut(30));
                        JPanel pCB3Top1 = new JPanel();
                        pCB3Top.add(pCB3Top1);
                            JLabel deleteProcLabel = new JLabel("Choose a procedure from the drop down list");
                            pCB3Top1.add(deleteProcLabel);
                        JPanel pCB3Top2 = new JPanel();
                        pCB3Top.add(pCB3Top2);
                            deleteProcList = new JComboBox();
                            deleteProcList = (JComboBox) controller.populateProcedureSelectionList();
                            deleteProcList.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXX");
                            pCB3Top2.add(deleteProcList);
                    JPanel pCB3Bottom = new JPanel();
                    pCB3.add(pCB3Bottom);
                        deleteProcedureBtn = new JButton("Delete Procedure");
                        pCB3Bottom.add(deleteProcedureBtn);
                        deleteProcedureCancelBtn = new JButton("Cancel");
                        pCB3Bottom.add(deleteProcedureCancelBtn);
        
        patientFindBtn1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){ 
                    String name = patNameText1.getText();
                    String num = patNumberText1.getText();
                    displayTopArea.setText("");
                    
                    if( controller.getPatient(name, num) != null )
                        {
                            displayTopArea.append(controller.displayPatient(name, num));
                        }
                        else
                            {
                                displayTopArea.append("\n  No patient found with those details!!");
                            }
                }
            }
        );
        
        patientFindResetBtn1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){ 
                    patNameText1.setText(""); patNumberText1.setText("");
                    displayTopArea.setText(""); addProcList.setSelectedIndex(0);
                }
            }
        );
                        
        addProcedureBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = patNameText1.getText();
                    String number = patNumberText1.getText();
                    String procName = (String) addProcList.getSelectedItem();
                    controller.addProcToPatient(name, number, procName);
                    addProcList.setSelectedIndex(0);
                }
            }
        );
                    
        addProcedureCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    patNameText1.setText(""); patNumberText1.setText("");
                    displayTopArea.setText("");
                    addProcList.setSelectedIndex(0);
                }
            }
        );
        
        patientFindBtn2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = patNameText2.getText();
                    String num = patNumberText2.getText();
                    displayBottomArea.setText("");
                    displayBottomArea.append(controller.displayPatient(name, num));
                }
            }
        );
        
        patientFindResetBtn2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){ 
                    patNameText2.setText(""); patNumberText2.setText("");
                    displayBottomArea.setText(""); deleteProcList.setSelectedIndex(0);
                }
            }
        );
        
        deleteProcedureBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = patNameText2.getText();
                    String number = patNumberText2.getText();
                    String procName = (String) deleteProcList.getSelectedItem();
                    controller.deleteProcToPatient(name, number, procName);
                    deleteProcList.setSelectedIndex(0);
                }
            }
        );
        
        deleteProcedureCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    patNameText2.setText(""); patNumberText2.setText("");
                    displayBottomArea.setText(""); deleteProcList.setSelectedIndex(0);
                }
            }
        );   
    }
    
    //This method creates the display for adding a payment for a patient
    public void addPaymentToPatientDisplay(JPanel addPayToPat, final MyController controller)
    {
        JPanel pCenter = new JPanel();
        addPayToPat.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
            
            pCenter.add(Box.createVerticalStrut(100));
            
            JPanel pCMain = new JPanel();
            pCMain.setLayout(new BoxLayout(pCMain, BoxLayout.X_AXIS));
            pCMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add payment for patient"));
            pCenter.add(pCMain);
                
                JPanel pCMLeft = new JPanel();
                pCMLeft.setLayout(new BoxLayout(pCMLeft, BoxLayout.Y_AXIS));
                pCMain.add(pCMLeft);
                    pCMLeft.add(Box.createVerticalStrut(50));
                    JPanel pCML1 = new JPanel();
                    pCMLeft.add(pCML1);
                        JLabel patNameLabel = new JLabel("Patient Name: ");
                        patNameText3 = new JTextField(12);
                        pCML1.add(patNameLabel);
                        pCML1.add(patNameText3);
                    JPanel pCML2 = new JPanel();
                    pCMLeft.add(pCML2);
                        JLabel patNumberLabel = new JLabel("Patient Number: ");
                        patNumberText3 = new JTextField(12);
                        pCML2.add(patNumberLabel);
                        pCML2.add(patNumberText3);
                    JPanel pCML3 = new JPanel();
                    pCMLeft.add(pCML3);
                        patientFindBtn3 = new JButton("Find Patient");
                        pCML3.add(patientFindBtn3);
                        pCML3.add(Box.createHorizontalStrut(15));
                        patientFindResetBtn3 = new JButton("Reset Details");
                        pCML3.add(patientFindResetBtn3);
                    pCMLeft.add(Box.createVerticalStrut(100));
                    
                JPanel pCMMid = new JPanel();
                pCMain.add(pCMMid);
                    accountDisplay = new JTextArea(15, 22);
                    accountDisplay.setEditable(false);
                    accountDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCMMid.add(accountDisplay);
                
                JPanel pCMRight = new JPanel();
                pCMRight.setLayout(new BoxLayout(pCMRight, BoxLayout.Y_AXIS));
                pCMain.add(pCMRight);
                    pCMRight.add(Box.createVerticalStrut(20));
                    JPanel pCMR1 = new JPanel();
                    pCMRight.add(pCMR1);
                        JLabel enterPayDetails = new JLabel("Enter the payment details below");
                        pCMR1.add(enterPayDetails);
                    JPanel pCMR2 = new JPanel();
                    pCMRight.add(pCMR2);
                        JLabel payLabel = new JLabel("Payment Amount: €");
                        payAmountText = new JTextField(12);
                        pCMR2.add(payLabel);
                        pCMR2.add(payAmountText);
                    JPanel pCMR3 = new JPanel();
                    pCMRight.add(pCMR3);
                        enterPayAmountBtn = new JButton("Submit Payment");
                        pCMR3.add(enterPayAmountBtn);
                        pCMR3.add(Box.createHorizontalStrut(10));
                        payAmountResetBtn = new JButton("Reset Details");
                        pCMR3.add(payAmountResetBtn);
                    pCMRight.add(Box.createVerticalStrut(50));
                    
            pCenter.add(Box.createVerticalStrut(100));
        
        patientFindBtn3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    Patient p = new Patient();
                    String name = patNameText3.getText();
                    String num = patNumberText3.getText();
                    accountDisplay.setText("");
                    
                    if( name.equals("") || num.equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Please ensure all fields are completed!!!" );
                            patNameText3.setText(""); patNumberText3.setText("");
                        }
                        else if( controller.getPatient(name, num) != null)
                            {
                                p = controller.getPatient(name, num);
                                accountDisplay.append("          Patient Account Details\n"
                                                            + "\n  "+p.getPatName()
                                                            + "\n  "+p.getPatAddr()
                                                            + "\n  "+p.getPatPhone()+"\n"
                                                            + "\n Total cost of procedures: €"+df.format(p.getProcTotalAmount())
                                                            + "\n Amount paid to date:         €"+df.format(p.getPayTotalAmount())
                                                            + "\n Account Balance:               €"+df.format(p.getTotal()));
                            }
                            else
                                {
                                    accountDisplay.append("\nNo patient found with those details!!");
                                }
                }
            }
        );
        
        patientFindResetBtn3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    patNameText3.setText(""); patNumberText3.setText(""); payAmountText.setText("");
                    accountDisplay.setText("");
                }
            }
        );
            
        enterPayAmountBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    
                    Patient p = new Patient();
                    String name = patNameText3.getText();
                    String num  = patNumberText3.getText();
                    String payment = payAmountText.getText();
                    
                    if( !payment.replaceFirst("\\.", "").matches("[0-9]+"))
                        {
                            JOptionPane.showMessageDialog(null, "Please ensure only numbers are entered!!!" );
                        }
                        else
                            {
                                p = controller.getPatient(name, num);
                                
                                if(Double.parseDouble(payment) > p.getTotal())
                                    {
                                        JOptionPane.showMessageDialog(null, "Amount entered €"+payment+" is more than the\n"
                                                                                           + "remaining patient balance: € "+p.getTotal());
                                        payAmountText.setText("");
                                    }
                                    else
                                        {
                                            controller.addPayment(name, num, payment);
                                            accountDisplay.setText("");
                                            accountDisplay.append("  Patient details have been updated\n\n"
                                                        +"          Patient Account Details\n"
                                                        + "\n  "+p.getPatName()
                                                        + "\n  "+p.getPatAddr()
                                                        + "\n  "+p.getPatPhone()+"\n"
                                                        + "\n Total cost of procedures: €"+df.format(p.getProcTotalAmount())
                                                        + "\n Most recent payment:      €"+payment
                                                        + "\n Amount paid to date:        €"+df.format(p.getPayTotalAmount())
                                                        + "\n Account Balance:              €"+df.format(p.getTotal()));
                                        }    
                            }
                }
            }
        );
                    
        payAmountResetBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    payAmountText.setText("");
                }
            }
        );
    }
    
    //This method creates the display that shows all of the patients details. It shows their contact
    //details along with their account details plus their procedure and payment lists.
    public void displayPatientDetails(JPanel showPatDetails, final MyController controller)
    {
        JPanel pCenter = new JPanel();
        showPatDetails.add(pCenter);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        
            JPanel pCTop = new JPanel();
            pCTop.setLayout(new BoxLayout(pCTop, BoxLayout.X_AXIS));
            pCenter.add(pCTop);
                
                JPanel pCT1 = new JPanel();
                pCT1.setLayout(new BoxLayout(pCT1, BoxLayout.Y_AXIS));
                pCTop.add(pCT1);
                    pCT1.add(Box.createVerticalStrut(20));
                    JPanel pCT1Top = new JPanel();
                    pCT1.add(pCT1Top);
                        JLabel patNameLabel = new JLabel("Patient Name: ");
                        patNameText4 = new JTextField(12);
                        pCT1Top.add(patNameLabel);
                        pCT1Top.add(patNameText4);
                    JPanel pCT1Mid = new JPanel();
                    pCT1.add(pCT1Mid);
                        JLabel patNumberLabel = new JLabel("Patient Number: ");
                        patNumberText4 = new JTextField(12);
                        pCT1Mid.add(patNumberLabel);
                        pCT1Mid.add(patNumberText4);
                    JPanel pCT1Bottom = new JPanel();
                    pCT1.add(pCT1Bottom);
                        patientFindBtn4 = new JButton("Find Patient");
                        pCT1Bottom.add(patientFindBtn4);
                        pCT1Bottom.add(Box.createHorizontalStrut(15));
                        patientFindResetBtn4 = new JButton("Reset Details");
                        pCT1Bottom.add(patientFindResetBtn4);
                
                JPanel pCT2 = new JPanel();
                pCTop.add(pCT2);
                    accountDisplay1 = new JTextArea(15,35);
                    accountDisplay1.setEditable(false);
                    accountDisplay1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCT2.add(accountDisplay1);
                    
            JPanel pCBottom = new JPanel();
            pCBottom.setLayout(new BoxLayout(pCBottom, BoxLayout.X_AXIS));
            pCenter.add(pCBottom);
            
                JPanel pCB1 = new JPanel();
                pCB1.setLayout(new BorderLayout());
                pCBottom.add(pCB1);
                    listPatProcedures = new JTextArea();
                    JScrollPane js = new JScrollPane(listPatProcedures);
                    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    listPatProcedures.setEditable(false);
                    pCB1.add(js, BorderLayout.CENTER);
                
                JPanel pCB2 = new JPanel();
                pCB2.setLayout(new BorderLayout());
                pCBottom.add(pCB2);
                    listPatPayments = new JTextArea();
                    JScrollPane js2 = new JScrollPane(listPatPayments);
                    js2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    listPatPayments.setEditable(false);
                    pCB2.add(js2, BorderLayout.CENTER);
                    
        patientFindBtn4.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    Patient p = new Patient();
                    String name = patNameText4.getText();
                    String num = patNumberText4.getText();
                    accountDisplay1.setText("");
                    
                    if( name.equals("") || num.equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Please ensure all fields are completed!!!" );
                            patNameText4.setText(""); patNumberText4.setText("");
                        }
                        else if( controller.getPatient(name, num) != null)
                            {
                                p = controller.getPatient(name, num);
                                accountDisplay1.append("          Patient Account Details\n"
                                                            + "\n  "+p.getPatName()
                                                            + "\n  "+p.getPatAddr()
                                                            + "\n  "+p.getPatPhone()+"\n"
                                                            + "\n Total cost of procedures: €"+df.format(p.getProcTotalAmount())
                                                            + "\n Amount paid to date:         €"+df.format(p.getPayTotalAmount())
                                                            + "\n Account Balance:               €"+df.format(p.getTotal()));
                                listPatProcedures.setText("");
                                listPatProcedures.append("   List of patient procedures\n\n"+controller.displayPatProcedures(name, num));
                                listPatPayments.setText("");
                                listPatPayments.append("   List of patient payments\n\n"+controller.displayPayments(name, num));
                            }
                            else
                                {
                                    accountDisplay1.append("\n No patient found with those details!!");
                                }
                }
            }
        );
        
        patientFindResetBtn4.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    patNameText4.setText("");
                    patNumberText4.setText("");
                    accountDisplay1.setText("");
                    listPatProcedures.setText("");
                    listPatPayments.setText("");
                }
            }
        );
    }
    
    /*
    * The following methods are used to pass details of the dentists current
    * procedures available and populates the drop down selection box for
    * the patient
    */
    public void addProcToList(String procName)
    {
        addProcList.addItem(procName);
        deleteProcList.addItem(procName);
    }
    
    public void deleteProcToList(String procName)
    {
        addProcList.removeItem(procName);
        deleteProcList.removeItem(procName);
    }
}
