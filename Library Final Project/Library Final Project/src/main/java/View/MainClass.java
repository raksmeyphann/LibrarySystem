package View;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainClass extends JFrame implements ActionListener
{
	
	JMenuBar menubar;
	JMenu mFile,mBooks,mReport,mHelp;
	//For Menu File
	JMenuItem mItemNew,mSave,mExit;
	//For Menu Book
	JMenuItem mBook,mThesis,mMember;
	//For Menu Report
	JMenuItem mBorrowReport,mReturnReport;
	
	
	//For Menu Help
	JMenuItem mItemWelcome, mItemHelpContents, mItemCheckUpdate, mItemAbout;
	
	
	
	//JTree for Library
	JTree jTreeLib;
	JTabbedPane jTab;

	public MainClass()
	{
		mItemNew = new JMenuItem("New");
		mSave = new JMenuItem("Save");
		mExit = new JMenuItem("Exit");
		
		//Create Menu File and Add it Item
		mFile = new JMenu("File");
		mFile.add(mItemNew);
		mFile.add(mSave);
		mFile.add(new JSeparator());
		mFile.add(mExit);
		//=================End OF Menu FIle==================
		
		//CreateObject Menu Item  and Add Library Item
		mBook = new JMenuItem("Add Book");
		mBook.addActionListener(this);
		mThesis = new JMenuItem("Add Thesis");
		mThesis.addActionListener(this);
		mMember = new JMenuItem("Add Member");
		mMember.addActionListener(this);
		//Create Object Menu Books and Add it item
		mBooks = new JMenu("About Book");
		mBooks.add(mBook);
		mBooks.add(mThesis);
		mBooks.add(mMember);	
		//=========== End Of Books ================
		
		
		//Create Object of Report
		mBorrowReport = new JMenuItem("Borrow Report");
		mBorrowReport.addActionListener(this);
		mReturnReport = new JMenuItem("Return Report");
		mReturnReport.addActionListener(this);
		//Create Object of report and Add it Item
		mReport = new JMenu("Report");
		mReport.add(mBorrowReport);
		mReport.add(mReturnReport);
		//=============== ENd Of Report ==================
		
		
		//create object menu item of help
		mItemWelcome = new JMenuItem( "Welcome");
		mItemHelpContents = new  JMenuItem( "Help Contents");
		mItemCheckUpdate = new JMenuItem( "Check Update");
		mItemAbout = new JMenuItem( "About Library");
		
		//Create object menu bar and its menus	
		mHelp = new JMenu( "Help");
	    mHelp.add(mItemWelcome);
		mHelp.add(mItemHelpContents);
		mHelp.add(new JSeparator());
		mHelp.add(mItemCheckUpdate);
		mHelp.add(mItemAbout);
		//============= END of Menu Help ================
		
		// create object menu bar and add its menus
		menubar = new JMenuBar();
		menubar.add(mFile);
		menubar.add(mBooks);
		menubar.add(mReport);
		menubar.add(mHelp);

		//================== End of Menu Bar ==============
		
		//JTree leftjtree = new JTree();
		//jTab = new JTabbedPane();
		//JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftjtree,jTab);
		//jsp.setDividerLocation(180);
		
		
		
		//End OF menu Bar for Frame
		add(menubar);
		
		
		//add(jsp);
		setTitle("Library Project");
		setJMenuBar(menubar);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	
	}
	private void performHeader()
	{
		
		JLabel lbl1 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("Images/Image1.png");
		lbl1.setIcon(icon1);

        JPanel jPanelICon = new JPanel(new BorderLayout(10,10));
		jPanelICon.add(lbl1, BorderLayout.CENTER);
		jTab.addTab( "Add Book", new JScrollPane(jPanelICon));
		
		
	}
	/*private  JTree CreateJTree()
	{
		//Create Tree Node Library Books
		DefaultMutableTreeNode nodeAbouttBook = new DefaultMutableTreeNode("About Books");
		DefaultMutableTreeNode nodeAddBook = new DefaultMutableTreeNode("Add Book");
		DefaultMutableTreeNode nodeAddThesis = new DefaultMutableTreeNode("Add Thesis");
		DefaultMutableTreeNode nodeAddMember = new DefaultMutableTreeNode("Add Member");
		nodeAbouttBook.add(nodeAddBook);
		nodeAbouttBook.add(nodeAddThesis);
		nodeAbouttBook.add(nodeAddMember);
		//===================== End Of Tree Node Books=======================
		
		
		//Create Tree Node Report
		DefaultMutableTreeNode nodeReport = new DefaultMutableTreeNode("Report");
		DefaultMutableTreeNode nodeBorrowBook= new DefaultMutableTreeNode("Borrow Book");
		DefaultMutableTreeNode nodeReturnBook = new DefaultMutableTreeNode("Return Book");
		nodeReport.add(nodeBorrowBook);
		nodeReport.add(nodeReturnBook);
		//====================== End Of report==========================
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
	    rootNode.add(nodeAbouttBook);
	    rootNode.add(nodeReport);
	    
	    jTreeLib = new JTree(rootNode);
		jTreeLib.setRowHeight(25);
		jTreeLib.setRootVisible(false);
		jTreeLib.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//Expand all tree nodes
		jTreeLib.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
		// Find Selected Node of Tree
				int selectedNode = jTreeLib.getRowForLocation(e.getX(), e.getY());
		// COndition when mouse pressed on a Specific node
				if(selectedNode != -1)
			//When mouse Pressed is Double click
					if(e.getClickCount() == 2)
					{   
				//Get for Tree whole tree path
						TreePath treepath = jTreeLib.getPathForLocation(e.getX(), e.getY());
				//Get Last Selected Path
						String lastselectedpath = treepath.getLastPathComponent().toString();
						if(lastselectedpath.equals("Add Book"))
				{
					//  performOpenEmployee();
				}
						else if(lastselectedpath.equals("Add Thesis"))
				{
				     // performOpenEmployee();
				}
						else if(lastselectedpath.equals("Add Member"))
				{
					//  performOpenTaxReport();
				}
						else if(lastselectedpath.equals("Borrow Book"))
				{
					// performOpenTaxRule2018();
				}
						else if(lastselectedpath.equals("Return Book"))
				{
				   //  performOpenTaxCalculator();
				
				}
				
			}
		
	}
	});
			
		for(int i =0; i<=jTreeLib.getRowCount(); i++)
			jTreeLib.expandRow(i);
		return jTreeLib;
	}
	*/
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == mBook)
		{ 
			//performOpenEmployee();
		}
		else if (e.getSource() == mThesis)
		{
              //  performOpenEmployee();
		}
		else if (e.getSource() == mMember)
		{
			// performOpenTaxReport();
		}
		else if (e.getSource() == mBorrowReport)
		{
			//performOpenTaxRule2018();
			
		}
		else if (e.getSource() == mReturnReport)
		{
			 // performOpenTaxCalculator();
			 
		}
	}
	
	public static void main(String[] args)
	{
		new MainClass();
	}
}
