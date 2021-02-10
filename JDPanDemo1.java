
import java.awt.BorderLayout;  
import java.awt.Container;  
//import javax.swing.JDesktopPane;  
//import javax.swing.JFrame;  
//import javax.swing.JInternalFrame;  
//import javax.swing.JLabel;  
//import javax.swing.JPanel;
//import javax.swing.JButton;  
//import javax.swing.ImageIcon;
//import javax.swing.JTextArea;  
//import javax.swing.JTabbedPane;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import javax.swing.undo.*;
import javax.swing.event.*;
public class JDPanDemo1 extends JFrame implements ActionListener
{ 
	CustomDesktopPane1 desktopPane;
	UndoManager manager = new UndoManager();
	JTextPane jta;
	static int count=1;
	String S; 
	JButton j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13; 
	static JTabbedPane jtp;

  public JDPanDemo1()   
  {  
    desktopPane = new CustomDesktopPane1();  
    Container contentPane = getContentPane();  

	jtp=new JTabbedPane();
	JPanel jpn=new JPanel();
	JPanel jpc=new JPanel();
	JPanel jpe=new JPanel();
	JPanel jpw=new JPanel();
	JPanel jps=new JPanel();

	int policy=jtp.getTabLayoutPolicy();
	jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	jtp.setBounds(5,5,1350,680);
	jtp.setPreferredSize(new Dimension(1350,680));
	jpn.setBackground(Color.GRAY);
	jpc.setPreferredSize(new Dimension(1350,680));
	jpc.setOpaque(true);

	
		j1=new JButton(new ImageIcon("new.png"));
		j1.addActionListener(this);
		j1.setToolTipText("new");
		j1.setPreferredSize(new Dimension(25,30));

		j2=new JButton(new ImageIcon("open.png"));
		j2.addActionListener(this);
		j2.setToolTipText("open");
		j2.setPreferredSize(new Dimension(25,30));

		j3=new JButton(new ImageIcon("save.png"));
		j3.addActionListener(this);
		j3.setToolTipText("save as");
		j3.setPreferredSize(new Dimension(25,30));
		
		j4=new JButton(new ImageIcon("undo.png"));
		j4.addActionListener(this);
		j4.setToolTipText("undo");
		j4.setPreferredSize(new Dimension(25,30));
		
		j5=new JButton(new ImageIcon("redo.png"));
		j5.addActionListener(this);
		j5.setToolTipText("redo");
		j5.setPreferredSize(new Dimension(25,30));


		j6=new JButton(new ImageIcon("print.png"));
		j6.addActionListener(this);
		j6.setToolTipText("print");
		j6.setPreferredSize(new Dimension(25,30));
		
		j7=new JButton(new ImageIcon("close.png"));
		j7.addActionListener(this);
		j7.setToolTipText("close");
		j7.setPreferredSize(new Dimension(25,30));
		
		j8=new JButton(new ImageIcon("cut.png"));
		j8.addActionListener(this);
		j8.setToolTipText("cut");
		j8.setPreferredSize(new Dimension(25,30));
		
		j9=new JButton(new ImageIcon("copy.png"));
		j9.addActionListener(this);
		j9.setToolTipText("copy");
		j9.setPreferredSize(new Dimension(25,30));
		
		j10=new JButton(new ImageIcon("paste.png"));
		j10.addActionListener(this);
		j10.setToolTipText("paste");
		j10.setPreferredSize(new Dimension(25,30));
		
		j11=new JButton(new ImageIcon("closetab.png"));
		j11.addActionListener(this);
		j11.setToolTipText("closetab");
		j11.setPreferredSize(new Dimension(25,30));

		j12=new JButton(new ImageIcon("closealltab.png"));
		j12.addActionListener(this);
		j12.setToolTipText("close all tab");
		j12.setPreferredSize(new Dimension(25,30));


		j13=new JButton(new ImageIcon("command.png"));
		j13.addActionListener(this);
		j13.setToolTipText("Command Prompt");
		j13.setPreferredSize(new Dimension(25,30));
		
	
	jpn.add(j1);
	jpn.add(j2);
	jpn.add(j3);
	jpn.add(j4);
	jpn.add(j5);
	jpn.add(j6);
	jpn.add(j7);
	jpn.add(j8);
	jpn.add(j9);
	jpn.add(j10);
	jpn.add(j11);
	jpn.add(j12);
	jpn.add(j13);
	jpc.add(jtp);

    contentPane.add(desktopPane, BorderLayout.CENTER);  
    contentPane.add("North",jpn);
    contentPane.add("West",jpw);
    contentPane.add("Center",jpc);
    contentPane.add("East",jpe);
    contentPane.add("South",jps);

    	
    desktopPane.display(desktopPane,count,jtp);  
  
    setTitle("EDIORA");  
    setSize(500,500);  
    setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
  }  

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==j1)
		{
			if(jtp.getSelectedIndex()==-1)
			{
				count=0;
			}
			count++;
			desktopPane.display(desktopPane,count,jtp);
		}
		//open
		else if (e.getSource()==j2) { 
            // Create an object of JFileChooser class 
            JFileChooser j = new JFileChooser("F:"); 
            // Invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null); 
            // If the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) { 
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
				S=fi.getName();
				count++;
				desktopPane.display(desktopPane,count,jtp);
				jtp.setTitleAt(jtp.getTabCount()-1,S);
                try { 
                    // String 
                    String s1 = "", sl = ""; 
                    // File reader 
                    FileReader fr = new FileReader(fi); 
                    // Buffered reader 
                    BufferedReader br = new BufferedReader(fr); 
                    // Initilize sl 
                    sl = br.readLine(); 
                    // Take the input from the file 
                    while ((s1 = br.readLine()) != null) { 
                        sl = sl + "\n" + s1; 
                    } 
                    // Set the text 
                    jta.setText(sl); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(this,"! Can't Open"); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(this, "Operation cancelled"); 
			}



		//save as
		else if (e.getSource()==j3) { 
            // Create an object of JFileChooser class 
            JFileChooser j = new JFileChooser("F"); 
            // Invoke the showsSaveDialog function to show the save dialog 
            j.setSelectedFile(new File("untitled"+(jtp.getSelectedIndex()+1)+".txt"));
            int r = j.showSaveDialog(null); 
            if (r == JFileChooser.APPROVE_OPTION) { 
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
                System.out.println(j.getSelectedFile().getAbsolutePath());
				S=fi.getName();
				
					jtp.setTitleAt(jtp.getSelectedIndex(),S);
                	try { 
                    	// Create a file writer 
                    	FileWriter wr = new FileWriter(fi, false); 
                    	// Create buffered writer to write 
                    	BufferedWriter w = new BufferedWriter(wr); 
                    	// Write 
                    	w.write(jta.getText()); 
                    	w.flush(); 
                	    w.close(); 

                	} 
                	catch (Exception evt) { 
                    	JOptionPane.showMessageDialog(this,"! Can't Save"); 
                	} 
				
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(this, "! Operation cancelled"); 
        }
		
		else if(e.getSource()==j4)
		{
			try {
					manager.undo();
				} 
			catch (Exception ex) {
				}
		}
		else if(e.getSource()==j5)
		{
			try {
					manager.redo();
				} 
			catch (Exception ex) {
				}
		}
			
			//print
			else if (e.getSource()==j6) { 
            try { 
                // print the file 
                jta.print(); 
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(this, evt.getMessage()); 
            } 
        }
		else if(e.getSource()==j7)
		{
			int x=JOptionPane.showConfirmDialog(this,"Close EDIORA ?");
			if(x==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}

		else if(e.getSource()==j8)
		{
			jta.cut();
		}
		else if(e.getSource()==j9)
		{
			jta.copy();
		}
		else if(e.getSource()==j10)
		{
			jta.paste();
		}
		else if(e.getSource()==j11)
		{
			int x=jtp.getSelectedIndex();
			if(x==-1)
			{
				JOptionPane.showMessageDialog(this,"! No more tabs remained, create one to deal with, work wisely.");

			}
			else
			{
			jtp.remove(x);
			}
		}
		else if(e.getSource()==j12)
		{
			int x=JOptionPane.showConfirmDialog(this,"Close all tabs?");
			if(x==JOptionPane.YES_OPTION)
			{
			jtp.removeAll();
			}
		}
		else if(e.getSource()==j13)
		{
			try
        	{ 
            // /K : Carries out command specified by string 
		    //      Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"}); 
 	     		Runtime.getRuntime().exec("cmd /c start cmd.exe /k"+"python "+S);
  
        	} 
        	catch (Exception ce) 
        	{ 
           		JOptionPane.showMessageDialog(this,"! Something went wrong."); 
        	} 
		}

	}

	public static void  main(String args[])  
  	{  
    		new JDPanDemo1();  
  	} 


  class CustomDesktopPane1 extends JDesktopPane  implements KeyListener
{  
  	public void display(CustomDesktopPane1 dp,int count,JTabbedPane jtp)   
  	{    
 		String t="untitled";
		jta=new JTextPane();
		Font fon=new Font("Consolas",Font.ITALIC,17);
		jta.setFont(fon);
		jta.setContentType("charset=UTF-8");
		jta.setBounds(0,0,1350,680);
//		jta.setBackground(Color.DARK_GRAY);
//		jta.setForeground(Color.PINK);
		jta.setPreferredSize(new Dimension(1350,680));
		JScrollPane sc=new JScrollPane(jta);
		jtp.add(t+""+count,sc);
//		jtp.setBackgroundAt(count-1,Color.PINK);
		jta.addKeyListener(this);
		jta.getDocument().addUndoableEditListener(new UndoableEditListener() {
		public void undoableEditHappened(UndoableEditEvent e) {
		manager.addEdit(e.getEdit());
		}
		});
  	} 
  	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			
		}
	}
	public void keyPressed(KeyEvent ke)
	{
		if(ke.isControlDown() && (ke.getKeyCode()==KeyEvent.VK_N))
		{
			count++;
			desktopPane.display(desktopPane,count,jtp);
		}
		else if(ke.isControlDown() && (ke.getKeyCode()==KeyEvent.VK_Z))
		{
			try {
					manager.undo();
			} 
			catch (Exception ex) {
			}
		}
		else if(ke.isControlDown() && (ke.getKeyCode()==KeyEvent.VK_Y))
		{
			try {
					manager.redo();
			} 
			catch (Exception ex) {
			}
		}
		else if(ke.isControlDown() && (ke.getKeyCode()==KeyEvent.VK_S))
		{
/*			try{
			JFileChooser j=new JFileChooser("F");
			File fi = new File("C:\\Users\\ash\\Desktop\\untitled"+(jtp.getSelectedIndex()+1)+".txt"); 
			j.setSelectedFile(fi);
			if (0 == JFileChooser.APPROVE_OPTION){
				FileWriter wr = new FileWriter(fi, false); 
                // Create buffered writer to write 
                BufferedWriter w = new BufferedWriter(wr); 
                // Write 
                w.write(jta.getText()); 
                w.flush(); 
                w.close(); 
			 
			}
			}  
			catch(Exception ioe)
			{}
*/				
        } 
			
	}
	public void keyTyped(KeyEvent ke)
	{
		
	} 
	}  
}


