package View;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BIG extends JFrame implements ActionListener
{
 
JMenuBar menubar;
//For ButtonClick
JMenu mAllbook,mReturnbook,mCreate,mMember,mHelp;
//FOr button in the front page
JButton btnEnter,btnQuit;

JTextField txtType;
JButton btnSearch;


	public BIG()
{ 
		//Create Caption
		JPanel p = new JPanel(new FlowLayout());
		p.add(new JLabel("Create By "));
		p.add(new JLabel(" Mr Tenfi "));

		JPanel p1 = new JPanel(new BorderLayout(10,10));
		JLabel lbl1 = (new JLabel("Welcome To Library",SwingConstants.CENTER));
		lbl1.setFont(new Font("Cuties Caps",Font.BOLD,24));
		p1.add(lbl1,BorderLayout.NORTH);
		p1.add(p,BorderLayout.CENTER);	
	
	//block Image
	JLabel im1 = new JLabel("");
	ImageIcon icon1 = new ImageIcon("Images/Image12.jpg");
	JLabel im2 = new JLabel("");
	ImageIcon icon2 = new ImageIcon("Images/Image2.jpg");
	im2.setIcon(icon2);
	im1.setIcon(icon1);
	
	JPanel PanelIcon = new JPanel(new FlowLayout());
	PanelIcon.add(im1);
	PanelIcon.add(im2);
	
	//create object of button
	JPanel actonmBtnPanel = new JPanel(new FlowLayout());
	actonmBtnPanel.add(btnEnter= new JButton("Enter to the Libray"));
	btnEnter.setPreferredSize(new Dimension(200, 100));
	btnEnter.addActionListener(this);
	actonmBtnPanel.add(btnQuit = new JButton ("Quit This Progream"));
	btnQuit.setPreferredSize(new Dimension(200, 100));
	btnQuit.addActionListener(this);
	
	//All blocks of first page
	JPanel Final = new JPanel(new BorderLayout(10,10));
	Final.add(p1,BorderLayout.NORTH);
	Final.add(PanelIcon,BorderLayout.CENTER);
	Final.add(actonmBtnPanel,BorderLayout.SOUTH);

	add(Final);
	setTitle("Library Project");
	setExtendedState(MAXIMIZED_BOTH);
	setVisible(true);
}	
	//when we select Enter Button
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == btnEnter)
		{
		  performbtnEnter();
		}
			if(e.getSource() == mAllbook)
			{
				JPanel Head = new JPanel (new GridLayout(1,1,10,10));
				Head.add(new JLabel("Title,Id or Type of Book"),SwingConstants.CENTER);
				Head.add(txtType = new JTextField());
				
				
			}
			else if (e.getSource() == mReturnbook)
			{
				
			}
			else if (e.getSource() == mCreate)
			{
				
			}
			else if(e.getSource() == mMember)
			{
				
			}
			else
			{
				
			}
				
		
			
	if(e.getSource() == btnQuit)	
	{
		System.exit(0);	
		
	}
	};
	private JPanel performbtnEnter() 
	{
		JPanel BlockMenu = new JPanel(new FlowLayout());
		mAllbook = new JMenu("All Book");
		mAllbook.addActionListener(this);
		mReturnbook = new JMenu("Return Book");
		mReturnbook.addActionListener(this);
		mCreate = new JMenu("Create An Account");
		mCreate.addActionListener(this);
		mMember = new JMenu("Become Member");
		mMember.addActionListener(this);
		mHelp  = new JMenu("Help");
		mHelp.addActionListener(this);
		
		menubar.add(mAllbook);
		menubar.add(mReturnbook);
		menubar.add(mCreate);
		menubar.add(mMember);
		menubar.add(mHelp);
		BlockMenu.add(menubar);
		return BlockMenu;
	}
public static void main(String[] args)
{
	new BIG();
}
}
