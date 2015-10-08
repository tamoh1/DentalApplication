package dentistguidb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 08/04/15
 */
public class PatientGUI {
    
    private JTextField nameText, addrText, phoneText, deleteNameText, deleteNumberText;
    private JButton addPatientBtn, addPatientCancelBtn, deletePatientFindBtn, deletePatientResetBtn, deletePatientBtn, deletePatientCancelBtn;
    private JTextArea addPatientDisplayArea, deletePatientDisplayArea;
    private JTextField namePatientText, numberPatientText, addrPatientText, tf1, tf2;
    private JTextArea displayPatArea, displayPatientArea, displayPatientArea1, displayPatientArea2, displayPatientArea3;
    private JButton savePatientAddBtn, cancelPatientAddBtn;
    private JButton listDisplayPatientBtn, listAllPatientsBtn;
    
    public PatientGUI(JPanel addPat, JPanel listPat, MyController controller)
    {    
            this.createAddPatientDisplay(addPat, controller);
            this.createListPatientDisplay(listPat, controller);
    }
    
    //This method creates the display for adding and deleting a patient from the dentist's practice
    public void createAddPatientDisplay(JPanel addPat, final MyController controller)
    {
        JPanel pCenter = new JPanel();
        addPat.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        
            //This section is for adding a patient
            JPanel pCenterTop = new JPanel();
            pCenterTop.setLayout(new BoxLayout(pCenterTop, BoxLayout.X_AXIS));
            pCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add patient to practice"));
            pCenter.add(pCenterTop);
                
                JPanel pCT1 = new JPanel();
                pCT1.setLayout(new BoxLayout(pCT1, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT1);
                    pCT1.add(Box.createVerticalStrut(20));
                    JPanel pCT1Name = new JPanel();
                    pCT1.add(pCT1Name);
                        JLabel nameLabel = new JLabel("Name: ");
                        pCT1Name.add(nameLabel);
                        nameText = new JTextField(12);
                        pCT1Name.add(nameText);
                    JPanel pCT1Address = new JPanel();
                    pCT1.add(pCT1Address);
                        JLabel addressLabel = new JLabel("Address: ");
                        pCT1Address.add(addressLabel);
                        addrText = new JTextField(15);
                        pCT1Address.add(addrText);
                    JPanel pCT1Phone = new JPanel();
                    pCT1.add(pCT1Phone);
                        JLabel phoneLabel = new JLabel("Phone: ");
                        pCT1Phone.add(phoneLabel);
                        phoneText = new JTextField(10);
                        pCT1Phone.add(phoneText);
                
                JPanel pCT2 = new JPanel();
                pCT2.setLayout(new BoxLayout(pCT2, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT2);
                    pCT2.add(Box.createVerticalStrut(45));
                    JPanel pCT2Top = new JPanel();
                    pCT2.add(pCT2Top);
                        addPatientBtn = new JButton("Add Patient");
                        pCT2Top.add(addPatientBtn);
                    JPanel pCT2Bottom = new JPanel();
                    pCT2.add(pCT2Bottom);
                        addPatientCancelBtn = new JButton("Cancel");
                        pCT2Bottom.add(addPatientCancelBtn);
                    
                JPanel pCT3 = new JPanel();
                pCenterTop.add(pCT3);
                pCT3.setBounds(5, 5, 5, 5);
                    addPatientDisplayArea = new JTextArea(12, 27);
                    addPatientDisplayArea.setEditable(false);
                    addPatientDisplayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCT3.add(addPatientDisplayArea);
            
            //This section is for deleting a patient
            JPanel pCenterBottom = new JPanel();
            pCenterBottom.setLayout(new BoxLayout(pCenterBottom, BoxLayout.X_AXIS));
            pCenterBottom.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Delete patient from practice"));
            pCenter.add(pCenterBottom);
                
                JPanel pCB1 = new JPanel();
                pCB1.setLayout(new BoxLayout(pCB1, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB1);
                    pCB1.add(Box.createVerticalStrut(20));
                    JPanel pCB1Name = new JPanel();
                    pCB1.add(pCB1Name);
                        JLabel deleteNameLabel = new JLabel("Patient Name: ");
                        pCB1Name.add(deleteNameLabel);
                        deleteNameText = new JTextField(12);
                        pCB1Name.add(deleteNameText);
                    JPanel pCB1Address = new JPanel();
                    pCB1.add(pCB1Address);
                        JLabel deleteAddressLabel = new JLabel("Patient Number: ");
                        pCB1Address.add(deleteAddressLabel);
                        deleteNumberText = new JTextField(10);
                        pCB1Address.add(deleteNumberText);
                    JPanel pCB1Buttons = new JPanel();
                    pCB1.add(pCB1Buttons);
                        deletePatientFindBtn = new JButton("Find Patient");
                        pCB1Buttons.add(deletePatientFindBtn);
                        pCB1Buttons.add(Box.createHorizontalStrut(15));
                        deletePatientResetBtn = new JButton("Reset Details");
                        pCB1Buttons.add(deletePatientResetBtn);
                        
                JPanel pCB2 = new JPanel();
                pCenterBottom.add(pCB2);
                    deletePatientDisplayArea = new JTextArea(12, 27);
                    deletePatientDisplayArea.setEditable(false);
                    deletePatientDisplayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCB2.add(deletePatientDisplayArea);
                
                JPanel pCB3 = new JPanel();
                pCB3.setLayout(new BoxLayout(pCB3, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB3);
                    pCB3.add(Box.createVerticalStrut(45));
                    JPanel pCB3Top = new JPanel();
                    pCB3.add(pCB3Top);
                        deletePatientBtn = new JButton("Delete Patient");
                        pCB3Top.add(deletePatientBtn);
                    JPanel pCB3Bottom = new JPanel();
                    pCB3.add(pCB3Bottom);
                        deletePatientCancelBtn = new JButton("Cancel");
                        pCB3Bottom.add(deletePatientCancelBtn);
                        
        addPatientBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){                        
                    String name = nameText.getText();
                    String address = addrText.getText();
                    String phone = phoneText.getText();
                    
                    if(name.equals("") || address.equals("") || phone.equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Please ensure all fields are completed!!" );
                            nameText.setText(""); addrText.setText(""); phoneText.setText("");
                        }
                        else if ( !name.replaceAll("\\s", "").matches("[a-zA-Z]+"))
                            {
                                JOptionPane.showMessageDialog(null, "Name must have letters only!!" );
                                nameText.setText(""); addrText.setText(""); phoneText.setText("");
                            }
                            else if ( !phone.replaceAll("\\s", "").matches("[0-9]+"))
                                {
                                    JOptionPane.showMessageDialog(null, "Phone number can only have numbers!!\n i.e 01 444333" );
                                    nameText.setText(""); addrText.setText(""); phoneText.setText("");
                                }
                                else
                                    {
                                        controller.addPatient(name, address, phone);
                                        addPatientDisplayArea.setText("");
                                        addPatientDisplayArea.append("The following patient has \nbeen added:\n"
                                                                        +"\n Patient Name : "+name
                                                                        +"\n Address: "+address
                                                                        +"\n Phone Number: "+phone);
                                        nameText.setText(""); addrText.setText(""); phoneText.setText("");
                                    }
                }
            }
        );
                    
        addPatientCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    nameText.setText(""); addrText.setText(""); phoneText.setText("");
                    addPatientDisplayArea.setText("");
                }
            }
        );
        
        deletePatientFindBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = deleteNameText.getText();
                    String num = deleteNumberText.getText();
                    deletePatientDisplayArea.setText("");
                    
                    if( name.equals("") || num.equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Please ensure all fields are completed!!" );
                            deleteNameText.setText(""); deleteNumberText.setText("");
                            deletePatientDisplayArea.setText("");
                        }
                        else if( controller.getPatient(name, num) == null )
                            {
                                deletePatientDisplayArea.setText("");
                                deletePatientDisplayArea.append("\n No patient found!!");
                            }
                            else
                                {
                                    deletePatientDisplayArea.append(controller.displayPatient(name, num));
                                }
                }
            }
        );
        
        deletePatientResetBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    deleteNameText.setText(""); deleteNumberText.setText(""); 
                    deletePatientDisplayArea.setText("");
                }
            }
        );
        
        deletePatientBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = deleteNameText.getText();
                    String num = deleteNumberText.getText();
                    if( controller.getPatient(name, num) != null )
                        {
                            deletePatientDisplayArea.setText("");
                            deletePatientDisplayArea.setText("  Patient successfully deleted:\n"
                                                                                +controller.displayPatient(name, num));
                            controller.removePatient(name, num);
                            deleteNameText.setText("");
                            deleteNumberText.setText("");
                        }
                        else
                            { 
                                deletePatientDisplayArea.setText(" No patient found to delete!!");
                            }
                }
            }
        );
        
        deletePatientCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    deleteNameText.setText(""); deleteNumberText.setText("");
                    deletePatientDisplayArea.setText("");
                }
            }
        );           
    }
     
    //This method creates the display for listing out all patients
    public void createListPatientDisplay(JPanel listPat, final MyController controller)
    {
            
        JPanel patCenter = new JPanel();
        patCenter.setLayout(new GridLayout(0,2));
        listPat.add(patCenter, BorderLayout.CENTER);
        
            JPanel patEast = new JPanel();
            patEast.setLayout(new BorderLayout());
            patCenter.add(patEast);
                JPanel patEastNorth = new JPanel();
                patEast.add(patEastNorth, BorderLayout.NORTH);
                    JPanel pEN1 = new JPanel();
                    patEastNorth.add(pEN1);
                        listAllPatientsBtn = new JButton("Display All Patients");
                        pEN1.add(listAllPatientsBtn);
                JPanel patEastCenter = new JPanel();
                patEastCenter.setLayout(new BorderLayout());
                patEast.add(patEastCenter, BorderLayout.CENTER);
                    displayPatArea = new JTextArea();
                    JScrollPane js = new JScrollPane(displayPatArea);
                    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    displayPatArea.setEditable(false);
                    patEastCenter.add(js);
        
            JPanel patWest = new JPanel();
            patCenter.add(patWest);
            patWest.setLayout(new BoxLayout(patWest, BoxLayout.Y_AXIS));
                    
                JPanel patWestTop = new JPanel();
                patWestTop.setLayout(new GridLayout(0,1));
                patWest.add(patWestTop);
                    JPanel pWT1 = new JPanel();
                    patWestTop.add(pWT1);
                        JLabel l1 = new JLabel("Show Patient Details");
                        pWT1.add(l1);
                    JPanel pWT2 = new JPanel();
                    patWestTop.add(pWT2);
                        JLabel l2 = new JLabel("Name :");
                        pWT2.add(l2);
                        tf1 = new JTextField(15);
                        pWT2.add(tf1);
                    JPanel pWT3 = new JPanel();
                    patWestTop.add(pWT3);
                        JLabel l3 = new JLabel("Patient No :");
                        pWT3.add(l3);
                        tf2 = new JTextField(15);
                        pWT3.add(tf2);
                    JPanel pWT4 = new JPanel();
                    patWestTop.add(pWT4);
                        listDisplayPatientBtn = new JButton("Display Patient");
                        pWT4.add(listDisplayPatientBtn);
                JPanel patWestBottom = new JPanel();
                patWestBottom.setLayout(new BorderLayout());
                patWest.add(patWestBottom);
                    displayPatientArea1 = new JTextArea();
                    JScrollPane js1 = new JScrollPane(displayPatientArea1);
                    js1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    displayPatientArea1.setEditable(false);
                    patWestBottom.add(js1);
                    
        listDisplayPatientBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = tf1.getText();
                    String num = tf2.getText();
                    displayPatientArea1.setText("");
                    displayPatientArea1.append(controller.displayPatient(name, num));
                    displayPatientArea1.append(controller.displayPatProcedures(name, num));
                    tf1.setText("");
                    tf2.setText("");
                }
            }
        );
                    
        listAllPatientsBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    displayPatArea.setText("");
                    displayPatArea.append(controller.displayAllPatients());
                }
            }            
        );       
    }
}