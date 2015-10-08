package dentistguidb;

import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Studnet Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: thomas.ohalloran@mycit.ie
 * Date last modified: 08/04/15
 */
public class ProcedureGUI {
    
    private JTextField procNameText, procNumText, addProcNameText, addProcCostText, deleteProcNameText, deleteProcNumberText;
    private JButton addProcedureBtn, addProcedureCancelBtn, deleteProcedureFindBtn, deleteProcedureResetBtn, 
                            listDisplayProcedureBtn, listAllProceduresBtn, deleteProcedureBtn, deleteProcedureCancelBtn;
    private JTextArea addProcedureDisplayArea, deleteProcedureDisplayArea, displayProcedureArea1, displayProcedureArea2;
    private AdminMenuGUI amGUI = new AdminMenuGUI();
    
    public ProcedureGUI(JPanel addProc, JPanel listProc, MyController controller)
    {    
        this.createAddProcedureDisplay(addProc, controller);
        this.createListProcedureDisplay(listProc, controller);        
    }

    ProcedureGUI() {
    }
    
    //This methods creates the display for adding and deleting procedures to the dentist's practice 
    public void createAddProcedureDisplay(JPanel addProc, final MyController controller)
    {
        JPanel pCenter = new JPanel();
        addProc.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        
            //This section is for adding a procedure
            JPanel pCenterTop = new JPanel();
            pCenterTop.setLayout(new BoxLayout(pCenterTop, BoxLayout.X_AXIS));
            pCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add procedure to practice"));
            pCenter.add(pCenterTop);
                
                JPanel pCT1 = new JPanel();
                pCT1.setLayout(new BoxLayout(pCT1, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT1);
                    pCT1.add(Box.createVerticalStrut(40));
                    JPanel pCT1Name = new JPanel();
                    pCT1.add(pCT1Name);
                        JLabel procNameLabel = new JLabel("Procedure Name: ");
                        pCT1Name.add(procNameLabel);
                        addProcNameText = new JTextField(12);
                        pCT1Name.add(addProcNameText);
                    JPanel pCT1Cost = new JPanel();
                    pCT1.add(pCT1Cost);
                        JLabel procCostLabel = new JLabel("Procedure Cost: €");
                        pCT1Cost.add(procCostLabel);
                        addProcCostText = new JTextField(15);
                        pCT1Cost.add(addProcCostText);
                
                JPanel pCT2 = new JPanel();
                pCT2.setLayout(new BoxLayout(pCT2, BoxLayout.Y_AXIS));
                pCenterTop.add(pCT2);
                    pCT2.add(Box.createVerticalStrut(45));
                    JPanel pCT2Top = new JPanel();
                    pCT2.add(pCT2Top);
                        addProcedureBtn = new JButton("Add Procedure");
                        pCT2Top.add(addProcedureBtn);
                    JPanel pCT2Bottom = new JPanel();
                    pCT2.add(pCT2Bottom);
                        addProcedureCancelBtn = new JButton("Cancel");
                        pCT2Bottom.add(addProcedureCancelBtn);
                    
                JPanel pCT3 = new JPanel();
                pCenterTop.add(pCT3);
                pCT3.setBounds(5, 5, 5, 5);
                    addProcedureDisplayArea = new JTextArea(12, 27);
                    addProcedureDisplayArea.setEditable(false);
                    addProcedureDisplayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCT3.add(addProcedureDisplayArea);
            
            //This section is for deleting a procedure
            JPanel pCenterBottom = new JPanel();
            pCenterBottom.setLayout(new BoxLayout(pCenterBottom, BoxLayout.X_AXIS));
            pCenterBottom.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Delete procedure from practice"));
            pCenter.add(pCenterBottom);
                
                JPanel pCB1 = new JPanel();
                pCB1.setLayout(new BoxLayout(pCB1, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB1);
                    pCB1.add(Box.createVerticalStrut(20));
                    JPanel pCB1Name = new JPanel();
                    pCB1.add(pCB1Name);
                        JLabel deleteNameLabel = new JLabel("Procedure Name: ");
                        pCB1Name.add(deleteNameLabel);
                        deleteProcNameText = new JTextField(12);
                        pCB1Name.add(deleteProcNameText);
                    JPanel pCB1Address = new JPanel();
                    pCB1.add(pCB1Address);
                        JLabel deleteAddressLabel = new JLabel("Procedure Number: ");
                        pCB1Address.add(deleteAddressLabel);
                        deleteProcNumberText = new JTextField(10);
                        pCB1Address.add(deleteProcNumberText);
                    JPanel pCB1Buttons = new JPanel();
                    pCB1.add(pCB1Buttons);
                        deleteProcedureFindBtn = new JButton("Find Procedure");
                        pCB1Buttons.add(deleteProcedureFindBtn);
                        pCB1Buttons.add(Box.createHorizontalStrut(15));
                        deleteProcedureResetBtn = new JButton("Reset Details");
                        pCB1Buttons.add(deleteProcedureResetBtn);
                        
                JPanel pCB2 = new JPanel();
                pCenterBottom.add(pCB2);
                    deleteProcedureDisplayArea = new JTextArea(12, 27);
                    deleteProcedureDisplayArea.setEditable(false);
                    deleteProcedureDisplayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCB2.add(deleteProcedureDisplayArea);
                
                JPanel pCB3 = new JPanel();
                pCB3.setLayout(new BoxLayout(pCB3, BoxLayout.Y_AXIS));
                pCenterBottom.add(pCB3);
                    pCB3.add(Box.createVerticalStrut(45));
                    JPanel pCB3Top = new JPanel();
                    pCB3.add(pCB3Top);
                        deleteProcedureBtn = new JButton("Delete Procedure");
                        pCB3Top.add(deleteProcedureBtn);
                    JPanel pCB3Bottom = new JPanel();
                    pCB3.add(pCB3Bottom);
                        deleteProcedureCancelBtn = new JButton("Cancel");
                        pCB3Bottom.add(deleteProcedureCancelBtn);
                        
        addProcedureBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){                        
                    String name = addProcNameText.getText();
                    String cost = addProcCostText.getText();
                    if(name.equals("") || cost.equals("") )
                        {
                            JOptionPane.showMessageDialog(null, "Please note all fields must be completed!!" );
                        }
                        else if ( !cost.replaceFirst("\\.", "").matches("[0-9]+") )
                            {
                                JOptionPane.showMessageDialog(null, "Procedure cost can only have\nnumbers i.e. €24.67, €44.99, etc!!" );
                                addProcCostText.setText("");
                            }
                            else
                                {
                                    controller.addProcedure(name, cost);
                                    addProcedureDisplayArea.setText("");
                                    addProcedureDisplayArea.append("The following procedure has \nbeen added:\n"
                                                                            +"\n Name : "+name
                                                                            +"\n Cost: €"+cost);
                                    addProcNameText.setText("");
                                    addProcCostText.setText("");
                                    amGUI.addProcToList(name);
                                }
                }
            }
        );
                    
        addProcedureCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    addProcNameText.setText(""); addProcCostText.setText("");
                    addProcedureDisplayArea.setText("");
                }
            }
        );
        
        deleteProcedureFindBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = deleteProcNameText.getText();
                    String num = deleteProcNumberText.getText();
                    deleteProcedureDisplayArea.setText("");
                    if( name.equals("") || num.equals("") )
                        {
                            JOptionPane.showMessageDialog(null, "Please note all fields must be completed!!" );
                            deleteProcNameText.setText(""); deleteProcNumberText.setText("");
                        }
                        else if ( controller.getProcedure(name, num) == null )
                            {
                                deleteProcedureDisplayArea.append("No procedure found!!!");
                                deleteProcNameText.setText(""); deleteProcNumberText.setText("");
                            }
                            else
                                {
                                    deleteProcedureDisplayArea.append(controller.displayProcedure(name, num));
                                }
                }
            }
        );
        
        deleteProcedureResetBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    deleteProcNameText.setText(""); deleteProcNumberText.setText("");
                    deleteProcedureDisplayArea.setText("");
                }
            }
        );
        
        deleteProcedureBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = deleteProcNameText.getText();
                    String num = deleteProcNumberText.getText();
                    if( controller.getProcedure(name, num) == null )
                        {
                            deleteProcedureDisplayArea.setText("");
                            deleteProcedureDisplayArea.append("\nNo procedure found to delete!!" );
                        }
                        else
                            {
                                deleteProcedureDisplayArea.setText("");
                                deleteProcedureDisplayArea.setText("\nProcedure successfully delete:\n"
                                                                                    +controller.displayProcedure(name, num));
                                controller.removeProcedure(name, num);
                                deleteProcNameText.setText("");
                                deleteProcNumberText.setText("");
                                amGUI.deleteProcToList(name);
                            }
                }
            }
        );
        
        deleteProcedureCancelBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    deleteProcNameText.setText(""); deleteProcNumberText.setText("");
                    deleteProcedureDisplayArea.setText("");
                }
            }
        );
    }
    
    //This method creates the display for listing all the procedures in the dentist's practice
    public void createListProcedureDisplay(JPanel listPat, final MyController controller)
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
                        listAllProceduresBtn = new JButton("Display All Procedures");
                        pEN1.add(listAllProceduresBtn);
                JPanel patEastCenter = new JPanel();
                patEastCenter.setLayout(new BorderLayout());
                patEast.add(patEastCenter, BorderLayout.CENTER);
                    displayProcedureArea2 = new JTextArea();
                    JScrollPane js = new JScrollPane(displayProcedureArea2);
                    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    displayProcedureArea2.setEditable(false);
                    patEastCenter.add(js);
        
            JPanel patWest = new JPanel();
            patCenter.add(patWest);
            patWest.setLayout(new BoxLayout(patWest, BoxLayout.Y_AXIS));
                JPanel patWestTop = new JPanel();
                patWestTop.setLayout(new GridLayout(0,1));
                patWest.add(patWestTop);
                    JPanel pWT1 = new JPanel();
                    patWestTop.add(pWT1);
                        JLabel l1 = new JLabel("Show Procedure Details");
                        pWT1.add(l1);
                    JPanel pWT2 = new JPanel();
                    patWestTop.add(pWT2);
                        JLabel l2 = new JLabel("Procedure Name :");
                        pWT2.add(l2);
                        procNameText = new JTextField(15);
                        pWT2.add(procNameText);
                    JPanel pWT3 = new JPanel();
                    patWestTop.add(pWT3);
                        JLabel l3 = new JLabel("Procedure No :");
                        pWT3.add(l3);
                        procNumText = new JTextField(15);
                        pWT3.add(procNumText);
                    JPanel pWT4 = new JPanel();
                    patWestTop.add(pWT4);
                        listDisplayProcedureBtn = new JButton("Display Procedure");
                        pWT4.add(listDisplayProcedureBtn);
                JPanel patWestBottom = new JPanel();
                patWestBottom.setLayout(new BorderLayout());
                patWest.add(patWestBottom);
                    displayProcedureArea1 = new JTextArea();
                    JScrollPane js1 = new JScrollPane(displayProcedureArea1);
                    js1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    displayProcedureArea1.setEditable(false);
                    patWestBottom.add(js1);        
                    
        listDisplayProcedureBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = procNameText.getText();
                    String number = procNumText.getText();
                    displayProcedureArea1.setText("");
                    displayProcedureArea1.append(controller.displayProcedure(name, number));
                    displayProcedureArea1.append(controller.displayProcPatients(name, number));
                    procNameText.setText("");
                    procNumText.setText("");
                }
            }
        );
                        
        listAllProceduresBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    displayProcedureArea2.setText("");
                    displayProcedureArea2.append(controller.displayAllProcedures());
                }
            }            
        );        
    }
}
