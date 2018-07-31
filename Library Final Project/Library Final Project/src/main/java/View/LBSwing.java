package View;
import library.*;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class LBSwing extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu mFile,mAboutBook,mMember,mThesis,mList ,mHelp;
	//For Menu FIle
	JMenuItem mItemNew, mItemSave, mItemExit;
	//FOr Menu About Book
	JMenuItem mAddBook,mBorrowBook,mReturnBook;
	//For Menu Member
	JMenuItem mMembers;
	//For Menu Thesis
	JMenuItem mThesises;
	//For Menu List 
	JMenuItem lstMember,lstCatetory,lstBorrow;
	// For Menu Help
	JMenuItem mItemWelcome, mItemHelpContents, mItemCheckUpdate, mItemAbout;
	
	//JTree for Library
	JTree jTreeLb;
	JTabbedPane JTab;
	
	// Search Area
	JComboBox cboField;
	JTextField txtSearch;
	
	//List Book
	JTable tbBook;
	DefaultTableModel tbmodelBook;
	
	//List Thesis
	JTable tbThesis;
	DefaultTableModel tbmodelThesis;
	
	//List Member
	JTable tbMember;
	DefaultTableModel tbmodelMember;
	
	//List Borrow Book
	JTable tbBorrow;
	DefaultTableModel tbmodelBorrow;

	//For add Book
	JTextField txtId,txtTitle,txtPublisher,txtPublisherYear,txtStatus,txtISBN,txtPrice,txtAuthor,txtEdition;
	JButton btnAddBook,btnCancelBook;

	//For Add Member
	JTextField txtMemberID,txtMemberName,txtMemberAddress,txtMemberDOM,txtMemberTOM;
	JButton btnAddMember,btnCancelMember;

	//For Borrow and Book
	JTextField txtBorrowBookID,txtBorrowMemberID,txtDOI,txtDOD;
	JButton btnReturn,btnBorrow,btnCancel;

	//Return Book
	JTextField txtReturnBookID;
	
	//For Add Thesis
	JTextField txtThesisIID, txtThesisTitle,txtThesisPublisher,txtThesisPublisherYear,txtThesisWriter,txtThesisTOT;
	JButton btnAddThesis,btCancel;
	

	public LBSwing()
	{
		   
		       // Create object MenuItem of file
				mItemNew = new JMenuItem("New");
				mItemSave= new JMenuItem("Save");
				mItemExit = new JMenuItem("Exit");
				
				// Create object Menu File and add its items
				mFile = new JMenu("File");
				mFile.add(mItemNew);
				mFile.add(mItemSave);
				mFile.add(new JSeparator());
				mFile.add(mItemExit);	
				//=============== END OF FILE ===============
				
				
				// Create Object of Menu About Book
				mAddBook = new JMenuItem("Add New Book");
				mAddBook.addActionListener(this);
				mBorrowBook = new JMenuItem("Borrow Book");
				mBorrowBook.addActionListener(this);
				mReturnBook = new JMenuItem("Return Book");
				mReturnBook.addActionListener(this);
				// Create Object Menu About Book and Add its Items
				mAboutBook = new JMenu("About Book");
				mAboutBook.add(mAddBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mBorrowBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mReturnBook);
			   //================== END OF About BOOk===============
				
				//Create Object of Menu Member
				mMembers = new JMenuItem("Add Member");
				mMembers.addActionListener(this);
				//Create object Menu Report and Add its Item
				mMember = new JMenu("Members");
			    mMember.add(mMembers);
				//==================== END OF MEMBER ================
				
			    
			    //Create Object of Menu Thesis
			    mThesises = new JMenuItem("Add Thesis");
			    mThesises.addActionListener(this);
			    //Create Object of Menu Thesis And add Its Item
			    mThesis = new JMenu("Thesis");
			    mThesis.add(mThesises);
			    //================= End of Thesis===================
			    
			    
				//Create Object of Menu List
				lstMember = new JMenuItem("List Members");
				lstMember.addActionListener(this);
				lstCatetory = new JMenuItem("List Book By Catetory");
				lstCatetory.addActionListener(this);
				lstBorrow = new JMenuItem("List Of Borrowed Book");
				lstBorrow.addActionListener(this);
				//Create Object of Menu List and add Its Item
				mList  = new JMenu("List");
				mList.add(lstMember);
				mList.add(lstCatetory);
				mList.add(lstBorrow);
				//===================== End OF List===============================
				
				//create object menu item of help
				mItemWelcome = new JMenuItem( "Welcome");
				mItemHelpContents = new  JMenuItem( "Help Contents");
				mItemCheckUpdate = new JMenuItem( "Check Update");
				mItemAbout = new JMenuItem( "About Employee Mgt");
				
				//Create object menu bar and its menus
				mHelp = new JMenu( "Help");
				mHelp.add(mItemWelcome);
				mHelp.add(mItemHelpContents);
				mHelp.add(new JSeparator());
				mHelp.add(mItemCheckUpdate);
				mHelp.add(mItemAbout);
				//==================END OF HELP=============================
				
				
				// create object menu bar and add its menus
				menuBar = new JMenuBar();
				menuBar.add(mFile);
				menuBar.add(mAboutBook);
				menuBar.add(mMember);
				menuBar.add(mThesis);
				menuBar.add(mList);
				menuBar.add(mHelp);
				
				// ======================END MENU BAR===================
				 JTree leftJTree = createJTree();
				 JTab = new JTabbedPane();
				 
				 JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftJTree,JTab);
					jsp.setDividerLocation(180);
					// Add Menu bar to Frame
					add(menuBar);
					add(jsp);
					setTitle("Library Project 0.0.0.0.1");
					setJMenuBar(menuBar);
					setExtendedState(MAXIMIZED_BOTH);
					setVisible(true);
				
				
				
				
	}
	private void performAddBook()
	{
		JPanel BlockAddBook = new JPanel(new GridLayout(8,2,10,10));
		BlockAddBook.add(new JLabel("ID :"));
		BlockAddBook.add(txtId = new JTextField());
		BlockAddBook.add(new JLabel("Title :"));
		BlockAddBook.add(txtTitle = new JTextField());
		BlockAddBook.add(new JLabel("Publisher :"));
		BlockAddBook.add(txtPublisher = new JTextField());
		BlockAddBook.add(new JLabel("Publisher Year :"));
		BlockAddBook.add(txtPublisherYear = new JTextField());
		BlockAddBook.add(new JLabel("ISBN :"));
		BlockAddBook.add(txtISBN = new JTextField());
		BlockAddBook.add(new JLabel("Price :"));
		BlockAddBook.add(txtPrice = new JTextField());
		BlockAddBook.add(new JLabel("Author :"));
		BlockAddBook.add(txtAuthor = new JTextField());
		BlockAddBook.add(new JLabel("Edition :"));
		BlockAddBook.add(txtEdition = new JTextField());
		

		JPanel actionbtn = new JPanel(new FlowLayout());
		actionbtn.add(btnAddBook = new JButton("Add"));
		btnAddBook.addActionListener(this);
		actionbtn.add(btnCancelBook = new JButton("Cancel"));
		
		
		JPanel BookP = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Adding New Book");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		
		JPanel BlockAddBookFinal = new JPanel(new BorderLayout(10,10));
		BlockAddBookFinal.setBorder(titleBorder);
		BlockAddBookFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddBookFinal.add(BlockAddBook,BorderLayout.CENTER);
		BlockAddBookFinal.add(actionbtn,BorderLayout.SOUTH);
		
		BookP.add(BlockAddBookFinal,BorderLayout.CENTER,SwingConstants.CENTER);
		
		JTab.addTab("Adding New Book",BookP);
		JTab.setSelectedComponent(BookP);
	}
	
	private void performMember()
	{
		
        JPanel BlockAddMember = new JPanel(new GridLayout(5,2,10,10));
		BlockAddMember.add(new JLabel("Member ID :"));
		BlockAddMember.add(txtMemberID= new JTextField());
		BlockAddMember.add(new JLabel("Member Name :"));
		BlockAddMember.add(txtMemberName = new JTextField());
		BlockAddMember.add(new JLabel("Address :"));
		BlockAddMember.add(txtMemberAddress = new JTextField());
		BlockAddMember.add(new JLabel("Date Of Member :"));
		BlockAddMember.add(txtMemberDOM = new JTextField());
		BlockAddMember.add(new JLabel("Type Of member :"));
		BlockAddMember.add(txtMemberTOM = new JTextField());
		
		
		JPanel actionbutton = new JPanel(new FlowLayout());
		actionbutton.add(btnAddMember = new JButton("Add"));
		btnAddMember.addActionListener(this);
		actionbutton.add(btnCancelMember = new JButton("Cancel"));
		
		JPanel BlockAddMemberFinal = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder2 = BorderFactory.createTitledBorder("Adding New Member");
		titleBorder2.setTitleJustification(TitledBorder.CENTER);
		
		
		BlockAddMemberFinal.setBorder(titleBorder2);
		BlockAddMemberFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddMemberFinal.add(BlockAddMember,BorderLayout.CENTER);
		BlockAddMemberFinal.add(actionbutton,BorderLayout.SOUTH);
		
		
		JPanel MemberP = new JPanel();
		MemberP.add(BlockAddMemberFinal,BorderLayout.CENTER);
		
		JTab.addTab("Adding New Member",MemberP);
		JTab.setSelectedComponent(MemberP);
		
	}
	
	private void performAddThesis()
	{
		JPanel BlockAddThesis = new JPanel(new GridLayout(6,2,10,10));
		BlockAddThesis.add(new JLabel("Thesis ID :"));
		BlockAddThesis.add(txtThesisIID= new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Title :"));
		BlockAddThesis.add(txtThesisTitle = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Publisher :"));
		BlockAddThesis.add(txtThesisPublisher = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Publisher Year :"));
		BlockAddThesis.add(txtThesisPublisherYear = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Writer :"));
		BlockAddThesis.add(txtThesisWriter = new JTextField());
		BlockAddThesis.add(new JLabel("Type of Thesis:"));
		BlockAddThesis.add(txtThesisTOT= new JTextField());
		
		JPanel actionbt = new JPanel(new FlowLayout());
		actionbt.add(btnAddThesis = new JButton("Add"));
		btnAddThesis.addActionListener(this);
		actionbt.add(btCancel = new JButton("Cancel"));
		
		JPanel BlockAddThesisFinal = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder2 = BorderFactory.createTitledBorder("Adding New Thesis");
		titleBorder2.setTitleJustification(TitledBorder.CENTER);
		BlockAddThesisFinal.setBorder(titleBorder2);
		BlockAddThesisFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddThesisFinal.add(BlockAddThesis,BorderLayout.CENTER);
		BlockAddThesisFinal.add(actionbt,BorderLayout.SOUTH);

		
		JTab.addTab("Add Thesis", BlockAddThesisFinal);
		JTab.setSelectedComponent(BlockAddThesisFinal);
		
	}
	
	
	private void performOpenBook_Borrow()
	{
		JPanel blockBorrow = new JPanel (new GridLayout(4,2,10,10));
		blockBorrow.add(new JLabel("Book ID: "));
		blockBorrow.add(txtBorrowBookID = new JTextField());
		blockBorrow.add(new JLabel("Member ID: "));
		blockBorrow.add(txtBorrowMemberID = new JTextField());
		blockBorrow.add(new JLabel("Date of Issue :"));
		blockBorrow.add(txtDOI = new JTextField());
		blockBorrow.add(new JLabel("Date of Due: "));
		blockBorrow.add(txtDOD = new JTextField());

		JPanel actionBtnPanel = new JPanel(new FlowLayout());
		actionBtnPanel.add(btnBorrow = new JButton("Borrow"));
		btnBorrow.addActionListener(this);
		actionBtnPanel.add(btnCancel = new JButton("Cancel"));
		
		JPanel blockBorrow_Final = new JPanel(new BorderLayout(10,10));
		blockBorrow_Final.add(new JLabel( "Please Complete Information below:"),BorderLayout.NORTH);
		//blockBookInfo_Final.add(new JSeparator(),BorderLayout.CENTER);
		blockBorrow_Final.add(blockBorrow,BorderLayout.CENTER);
		blockBorrow_Final.add(actionBtnPanel,BorderLayout.SOUTH);
		
		JPanel bookPanel = new JPanel(new BorderLayout(10,10));
		JPanel borrow = new JPanel();
		//Create Group Box new Employee
		TitledBorder tBorderAddBook = BorderFactory.createTitledBorder("BORROW BOOK");
		tBorderAddBook.setTitleJustification(TitledBorder.CENTER);
		borrow.setBorder(tBorderAddBook);
		
		borrow.add(blockBorrow_Final,BorderLayout.NORTH);	
		//bookPanel.add(new JScrollPane(empList), BorderLayout.CENTER);
		bookPanel.add(new JScrollPane(borrow), BorderLayout.EAST);
		JTab.addTab("Borrow Book:", borrow);
		JTab.setSelectedComponent(borrow);
	}
	private void performOpenBook_Return()
	{
		JPanel blockReturn = new JPanel (new GridLayout(4,2,10,10));
		blockReturn.add(new JLabel("Book ID: "));
		blockReturn.add(txtReturnBookID = new JTextField());
		blockReturn.add(new JLabel("Member ID: "));
		blockReturn.add(txtBorrowMemberID = new JTextField());
		blockReturn.add(new JLabel("Date of Issue :"));
		blockReturn.add(txtDOI = new JTextField());
		blockReturn.add(new JLabel("Date of Due: "));
		blockReturn.add(txtDOD = new JTextField());

		//Create Block Book info Final
		JPanel actionBtnPanel = new JPanel(new FlowLayout());
		actionBtnPanel.add(btnReturn = new JButton("Return"));
		btnReturn.addActionListener(this);
		actionBtnPanel.add(btnCancel = new JButton("Cancel"));
		
		JPanel blockReturnInfo_Final = new JPanel(new BorderLayout(10,10));
		blockReturnInfo_Final.add(new JLabel( "Please Complete Information below:"),BorderLayout.NORTH);
		//blockBookInfo_Final.add(new JSeparator(),BorderLayout.CENTER);
		blockReturnInfo_Final.add(blockReturn,BorderLayout.CENTER);
		blockReturnInfo_Final.add(actionBtnPanel,BorderLayout.SOUTH);
		
		JPanel bookPanel = new JPanel(new BorderLayout(10,10));
		JPanel Return = new JPanel();
		//Create Group Box new Employee
		TitledBorder tBorderAddBook = BorderFactory.createTitledBorder("RETURN BOOK");
		tBorderAddBook.setTitleJustification(TitledBorder.CENTER);
		Return.setBorder(tBorderAddBook);
		
		Return.add(blockReturnInfo_Final,BorderLayout.NORTH);	
		//bookPanel.add(new JScrollPane(empList), BorderLayout.CENTER);
		bookPanel.add(new JScrollPane(Return), BorderLayout.EAST);
		JTab.addTab("Return Book:", Return);
		JTab.setSelectedComponent(Return);
	}

	private JPanel performOpenMember_ListMember(JPanel MemberList)
	{
		TitledBorder tBorderListMember = BorderFactory.createTitledBorder("List OF Member");
		tBorderListMember.setTitleJustification(TitledBorder.CENTER);
		MemberList.setBorder(tBorderListMember);
		
		tbmodelMember = new DefaultTableModel();
		tbmodelMember.addColumn("ID");
		tbmodelMember.addColumn("Name");
		tbmodelMember.addColumn("Address");
		tbmodelMember.addColumn("Date of Member");
		tbmodelMember.addColumn("Type of Member");
		
		tbMember = new JTable(tbmodelMember);
		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(MemberEntity.class)
						.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				try {
					// start a transaction
					session.beginTransaction();
					String data[];
					// you select data from MemberEntity but you declare List of member to get it

					List<MemberEntity> memberlist= session.createQuery("from MemberEntity").getResultList();
					for(MemberEntity ml: memberlist) {
						data = ml.toStringData();
						tbmodelMember.addRow(data);
					}
					// commit transaction
					session.getTransaction().commit();
				}finally {
					factory.close();
				}
		JPanel searchandlistpanel1 = new JPanel(new BorderLayout(10,10));
		searchandlistpanel1.add(new JScrollPane(tbMember),BorderLayout.CENTER);
		
		
		JPanel blockBookList_Final = new JPanel(new BorderLayout(10,10));
		blockBookList_Final.add(new JLabel("List Of Your Member "), BorderLayout.NORTH);
	    blockBookList_Final.add(new JSeparator(),BorderLayout.CENTER);
	    blockBookList_Final.add(searchandlistpanel1, BorderLayout.CENTER);
	    
	   	return blockBookList_Final;
		
	}
	
	
	private JPanel performOpenBook_ListBook(JPanel BookList)
	{
		TitledBorder tBorderListBook = BorderFactory.createTitledBorder("List OF Book");
		tBorderListBook.setTitleJustification(TitledBorder.CENTER);
		BookList.setBorder(tBorderListBook);
		
		// Create Search Area and Count Book
		JPanel SearchandCountPanel = new JPanel(new GridLayout (1,2,10,10));
		//Add Search Area
		JPanel SearchPanel = new JPanel(new FlowLayout());
		SearchPanel.add(new JLabel("Field:"));
		String[] Search = {"ID","Title","Publisher","Publisher Year","ISBN","Price"};
		SearchPanel.add(cboField = new JComboBox(Search));
		SearchPanel.add(new JLabel("Search"));
		SearchPanel.add(txtSearch = new JTextField(12));
		//Add Search Area
		SearchandCountPanel.add(SearchPanel);
		
		tbmodelBook = new DefaultTableModel();
		tbmodelBook.addColumn("ID");
		tbmodelBook.addColumn("Title");
		tbmodelBook.addColumn("Publisher");
		tbmodelBook.addColumn("Publisher Year");
		tbmodelBook.addColumn("Status");
		tbmodelBook.addColumn("ISBN");
		tbmodelBook.addColumn("Price");
		tbmodelBook.addColumn("Author");
		tbmodelBook.addColumn("Edition");
	
		tbBook = new JTable(tbmodelBook);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BookEntity.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			String data[];
			List<BookEntity> booklist = session.createQuery("from BookEntity").getResultList();				
			for(BookEntity bl: booklist) {
				data = bl.toStringData();
				tbmodelBook.addRow(data);
			}
			// commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		
		JPanel searchandlistpanel = new JPanel(new BorderLayout(10,10));
		searchandlistpanel.add(SearchandCountPanel,BorderLayout.NORTH);
		searchandlistpanel.add(new JScrollPane(tbBook),BorderLayout.CENTER);
		
		
		JPanel blockBookList_Final = new JPanel(new BorderLayout(10,10));
		blockBookList_Final.add(new JSeparator(),BorderLayout.CENTER);
	    blockBookList_Final.add(searchandlistpanel, BorderLayout.CENTER);
	    
	    
		return blockBookList_Final;
		
	}

	

	private JPanel performOpenBook_ListTheis(JPanel ThesisList)
	{
		TitledBorder tBorderListThesis = BorderFactory.createTitledBorder("List OF Thesis");
		tBorderListThesis.setTitleJustification(TitledBorder.CENTER);
		ThesisList.setBorder(tBorderListThesis);
		
		tbmodelThesis = new DefaultTableModel();
		tbmodelThesis.addColumn("ID");
		tbmodelThesis.addColumn("Title");
		tbmodelThesis.addColumn("Publisher");
		tbmodelThesis.addColumn("Publisher Year");
		tbmodelThesis.addColumn("Writer");
		tbmodelThesis.addColumn("Type Of Thesis");

		tbThesis = new JTable(tbmodelThesis);

	   SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ThesisEntity.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			String data[];
			List<ThesisEntity> Thesis = session.createQuery("from ThesisEntity").getResultList();				
			for(ThesisEntity tl: Thesis) {
				data = tl.toStringData();
				tbmodelThesis.addRow(data);
			}
			// commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		
		JPanel tbPanel = new JPanel(new BorderLayout(10,10));
		tbPanel.add(new JScrollPane(tbThesis),BorderLayout.CENTER);
		
		
		JPanel blockThesisList_Final = new JPanel(new BorderLayout(10,10));
		blockThesisList_Final.add(new JSeparator(),BorderLayout.CENTER);
	    blockThesisList_Final.add(tbPanel, BorderLayout.CENTER);
	    
	    
		return blockThesisList_Final;
		
	}

     private JPanel performOpenList_ListBorrow(JPanel BorrowList)
	{
		TitledBorder tBorderListBorrow = BorderFactory.createTitledBorder("List of Borrow Book");
		tBorderListBorrow.setTitleJustification(TitledBorder.CENTER);
		BorrowList.setBorder(tBorderListBorrow);
		
		tbmodelBorrow = new DefaultTableModel();
		tbmodelBorrow.addColumn("ID");
		tbmodelBorrow.addColumn("Title");
		tbmodelBorrow.addColumn("Publisher");
		tbmodelBorrow.addColumn("Publisher Year");
		tbmodelBorrow.addColumn("Status");
		tbmodelBorrow.addColumn("ISBN");
		tbmodelBorrow.addColumn("Price");
		tbmodelBorrow.addColumn("Author");
		tbmodelBorrow.addColumn("Edition");
		
		tbBorrow = new JTable(tbmodelBorrow);
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BookEntity.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();
			String data[];
			// you select data from MemberEntity but you declare List of member to get it
			//List<BorrowEntity> borrowlist = session.createQuery("from BorrowEntity").getResultList();
			List<BookEntity> booklist = session.createQuery("from BookEntity b where b.status=false").getResultList();
			for(BookEntity bl : booklist) {
				data = bl.toStringData();
				tbmodelBorrow.addRow(data);
			}
			// commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		
		JPanel listpanel = new JPanel(new BorderLayout(10,10));
		listpanel.add(new JScrollPane(tbBorrow),BorderLayout.CENTER);
		
		
		JPanel blockBorrowList_Final = new JPanel(new BorderLayout(10,10));
	    blockBorrowList_Final.add(listpanel, BorderLayout.CENTER);
	    
	   	return blockBorrowList_Final;
	}
	
	private void performShowlstBook()
	{
		JPanel BookPanel = new JPanel(new BorderLayout(10,10));
		JPanel BookList= new JPanel(new BorderLayout(10,10));
		JPanel ThesisList= new JPanel(new BorderLayout(10,10));
		
		//TitledBorder titleBorder = BorderFactory.createTitledBorder("Show List");
		//titleBorder.setTitleJustification(TitledBorder.CENTER);
		//BookAdd.setBorder(titleBorder);
		BookList.add(performOpenBook_ListBook(BookList),BorderLayout.NORTH);
	    ThesisList.add(performOpenBook_ListTheis(ThesisList));
	    
		BookPanel.add(new JScrollPane(BookList),BorderLayout.CENTER);
		//BookPanel.add(new JSeparator(),BorderLayout.CENTER);
		BookPanel.add(new JScrollPane(ThesisList),BorderLayout.EAST);
		 JSplitPane js = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,BookList,ThesisList);
		 BookPanel.add(js);
		
		
		JTab.addTab("List Book By Category :", BookPanel);
		JTab.setSelectedComponent(BookPanel);
		
	}
	
	private void performShowlstMember()
	{
		JPanel MemberPanel = new JPanel(new BorderLayout(10,10));
		JPanel MemberList= new JPanel(new BorderLayout(10,10));
		JPanel MemberAdd= new JPanel(new BorderLayout(10,10));
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Show List");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		MemberAdd.setBorder(titleBorder);
		
		MemberList.add(performOpenMember_ListMember(MemberList),BorderLayout.NORTH);
		MemberPanel.add(MemberList,BorderLayout.CENTER);
		
		
		JTab.addTab("List Of Member :", MemberPanel);
		JTab.setSelectedComponent(MemberPanel);
		
	}
	private void performShowlstBorrow()
	{
		JPanel BorrowPanel = new JPanel(new BorderLayout(10,10));
		JPanel BorrowList= new JPanel(new BorderLayout(10,10));
		JPanel Borrow = new JPanel(new BorderLayout(10,10));
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Show List");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		Borrow.setBorder(titleBorder);
		
		BorrowList.add(performOpenList_ListBorrow(BorrowList),BorderLayout.NORTH);
		BorrowPanel.add(BorrowList,BorderLayout.CENTER);
		
		
		JTab.addTab("List Of Borrow Book : ", BorrowPanel);
		JTab.setSelectedComponent(BorrowPanel);
		
	}
	private JTree createJTree()
	{

		// Create Tree Node Of Library
		DefaultMutableTreeNode nodeBook = new DefaultMutableTreeNode("Books");
		DefaultMutableTreeNode nodeAddBook = new DefaultMutableTreeNode("Add New Book");
		DefaultMutableTreeNode nodeBoroBook = new DefaultMutableTreeNode("Borrow Book");
		DefaultMutableTreeNode nodeReturnBook = new DefaultMutableTreeNode("Return Book");
		nodeBook.add(nodeAddBook);
		nodeBook.add(nodeBoroBook);
		nodeBook.add(nodeReturnBook);
		//=====================End tree node of Books===================
		
		DefaultMutableTreeNode nodeMember = new DefaultMutableTreeNode("Member");
		DefaultMutableTreeNode nodeMembers = new DefaultMutableTreeNode("Add Member");
		nodeMember.add(nodeMembers);
		//=====================End tree node of Member==========================
		
		DefaultMutableTreeNode nodeThesis = new DefaultMutableTreeNode("Thesis");
		DefaultMutableTreeNode nodeThesises = new DefaultMutableTreeNode("Add Thesis");
		nodeThesis.add(nodeThesises);
		//=====================End tree node of Thesis==========================
		
		//create tree node List
		DefaultMutableTreeNode nodeList = new DefaultMutableTreeNode("List");
		DefaultMutableTreeNode nodelistMember = new DefaultMutableTreeNode( "List of Member");
		DefaultMutableTreeNode nodelistCategory = new DefaultMutableTreeNode( "List Book By Category");
		DefaultMutableTreeNode nodelistBorrow = new DefaultMutableTreeNode( "List Of Borrowed Book");
		nodeList.add(nodelistMember);
		nodeList.add(nodelistCategory);
		nodeList.add(nodelistBorrow);
		//================== ENd of Node of List================
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		rootNode.add(nodeBook);
		rootNode.add(nodeMember);
		rootNode.add(nodeThesis);
		rootNode.add(nodeList);
		
		
		//create object of jTree Library
		jTreeLb = new JTree(rootNode);
		jTreeLb.setRowHeight(25);
		jTreeLb.setRootVisible(false);
		jTreeLb.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//Expand all tree nodes
		jTreeLb.addMouseListener(new MouseAdapter()
				{
			public void mousePressed(MouseEvent e)
			{
				// Find Selected Node of Tree
				int selectedNode = jTreeLb.getRowForLocation(e.getX(), e.getY());
				// COndition when mouse pressed on a Specific node
				if(selectedNode != -1)
					//When mouse Pressed is Double click
					if(e.getClickCount() == 2)
					{   
						//Get for Tree whole tree path
						TreePath treepath = jTreeLb.getPathForLocation(e.getX(), e.getY());
						//Get Last Selected Path
						String lastselectedpath = treepath.getLastPathComponent().toString();
						if(lastselectedpath.equals("Add New Book"))
						{
							  performAddBook();
						}
						else if(lastselectedpath.equals("Borrow Book"))
						{
						      performOpenBook_Borrow();
						}
						else if(lastselectedpath.equals("Return Book"))
						{
							 performOpenBook_Return();
						}
						else if(lastselectedpath.equals("Add Member"))
						{
						     performMember();
						} 
						else if(lastselectedpath.equals("Add Thesis"))
						{
						      performAddThesis();
						
						}
						else if(lastselectedpath.equals("List of Member"))
						{
						   performShowlstMember();
						
						}
						else if(lastselectedpath.equals("List Book By Category"))
						{
						   performShowlstBook();
						
						}
						else if(lastselectedpath.equals("List Of Borrowed Book"))
						{
						   performShowlstBorrow();
						
						}
					}
				
			}
			});
		for(int i =0; i<=jTreeLb.getRowCount(); i++)
		jTreeLb.expandRow(i);
		//Add tree to panel
		//leftPanel.add(jTreeEmp);
		
		return jTreeLb;
		
	}
	
	    
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == mAddBook)
		{
			performAddBook();
		}
		else if (e.getSource() == mBorrowBook) 
		{
			performOpenBook_Borrow();
		}
		else if (e.getSource() == mReturnBook)
		{
			performOpenBook_Return();
		}
		else if(e.getSource() == mMembers)
		{
			performMember();
		}
		else if(e.getSource() == mThesises)
		{
			performAddThesis();
		}
		if(e.getSource() == lstMember)
		{
			performShowlstMember();
		}
		else if (e.getSource() == lstCatetory) 
		{
		    performShowlstBook();
		}
		else if (e.getSource() == lstBorrow)
		{
			performShowlstBorrow();
		}
		
		
		close:
		if(e.getSource()==btnBorrow) {
			boolean borrow=false;
			String bookName=null;
			String memberName=null;
			String bookId = txtBorrowBookID.getText();
			String memberId = txtBorrowMemberID.getText();
			String issue = txtDOI.getText();
			String doe = txtDOD.getText();

			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(MemberEntity.class)
					.addAnnotatedClass(BookEntity.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();

			try {

				session.beginTransaction();
				List<BookEntity> myBookList = session.createQuery("from BookEntity b where b.status=true").getResultList();
				List<MemberEntity> memberList= session.createQuery("from MemberEntity").getResultList();

				for(int i=0;i<memberList.size();i++) {
					if(memberId.equalsIgnoreCase(memberList.get(i).getId()) ){

						for (int j=0;j<myBookList.size();j++){

							if (bookId.equalsIgnoreCase(myBookList.get(j).getId())){
								// Add borrow info to database
								bookName=myBookList.get(j).getTitle();
								memberName=memberList.get(i).getName();
								borrow=true;
								// Update status of book
								String id=myBookList.get(j).getId();

								BookEntity myBookEntity = session.get(BookEntity.class,id);
								myBookEntity.setStatus(false);
								session.getTransaction().commit();
								JOptionPane.showMessageDialog(null, "Successfully!", "Borrow Book", JOptionPane.PLAIN_MESSAGE);

								break close;
							}
						}
						JOptionPane.showMessageDialog(null, "ID book was not found, Pls input agian!", "Borrow Book", JOptionPane.PLAIN_MESSAGE);

						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Member ID was not found, Pls register", "Member Information", JOptionPane.PLAIN_MESSAGE);


			}

			finally {
				System.out.println("close connection");
				factory.close();
				if(borrow=true){
					saveBorrowInfo(memberName,bookName,issue,doe);
				}
			}



		}

	
			
	if(e.getSource() == btnAddMember)
		{
			String id= txtMemberID.getText();
			String name = txtMemberName.getText();
			String address = txtMemberAddress.getText();
			String dom = txtMemberDOM.getText();
			String tom = txtMemberTOM.getText();
	
			MemberEntity memberEntity = new MemberEntity(id, name,address, dom,tom);
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(MemberEntity.class)
					.buildSessionFactory();
			Session sessionObj = factory.getCurrentSession();
			try {
			
			sessionObj.beginTransaction();
			sessionObj.save(memberEntity);
			sessionObj.getTransaction().commit();

			JOptionPane.showMessageDialog(null, "Add Successfully", "Member Information", JOptionPane.PLAIN_MESSAGE);


			}

			finally {
			factory.close();
			}


		}	
	
	        if(e.getSource() == btnAddThesis)
		{
			String id= txtThesisIID.getText();
			String title = txtThesisTitle.getText();
			String publisher = txtThesisPublisher.getText();
			String yearPublished = txtThesisPublisherYear.getText();
			String writer = txtThesisWriter.getText();
			String type = txtThesisTOT.getText();
	
			ThesisEntity thesisEntity = new ThesisEntity (id,title,publisher,yearPublished,writer,type);
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(ThesisEntity.class)
					.buildSessionFactory();
			Session sessionObj = factory.getCurrentSession();
			try {
			
			sessionObj.beginTransaction();
			sessionObj.save(thesisEntity);
			sessionObj.getTransaction().commit();

			JOptionPane.showMessageDialog(null, "Add Successfully", "Thesis Information", JOptionPane.PLAIN_MESSAGE);


			}

			finally {
			factory.close();
			}


		}

		if(e.getSource()==btnReturn){

			String memberId = txtBorrowMemberID.getText();
			String bookId=txtReturnBookID.getText();
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(BookEntity.class)
					.addAnnotatedClass(MemberEntity.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				session.beginTransaction();
				List<BookEntity> myBookList = session.createQuery("from BookEntity b where b.status=false").getResultList();
				List<MemberEntity> memberList= session.createQuery("from MemberEntity").getResultList();

				for(int i=0;i<memberList.size();i++) {
					if(memberId.equalsIgnoreCase(memberList.get(i).getId()) ){

						for (int j=0;j<myBookList.size();j++){
							System.out.println(myBookList.get(j).getId());
							System.out.println(bookId);
							if (bookId.equalsIgnoreCase(myBookList.get(j).getId())){
								String id=myBookList.get(j).getId();
								BookEntity myBookEntity = session.get(BookEntity.class,id);
								myBookEntity.setStatus(true);
								session.getTransaction().commit();
								JOptionPane.showMessageDialog(null, "Successfully!", "Borrow Book", JOptionPane.PLAIN_MESSAGE);

								return;
							}
						}
						JOptionPane.showMessageDialog(null, "ID book was not in borrow list!", "Borrow Book", JOptionPane.PLAIN_MESSAGE);

						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Member ID was not found, Pls register", "Member Information", JOptionPane.PLAIN_MESSAGE);


			}
			finally {
				factory.close();
			}



		}



		if(e.getSource() == btnAddBook)
		{
			//Create Object of Books
			
			String id= txtId.getText();
			String title = txtTitle.getText();
			String publisher = txtPublisher.getText();
			String yearPublished = txtPublisherYear.getText();
			boolean status = true;
			//boolean status = txtStatus.toString() == "Valaible" ? true : false;
			String ISBN = txtISBN.getText();
			double price = Double.parseDouble(txtPrice.getText());
			String author = txtAuthor.getText();
			int edition = Integer.parseInt(txtEdition.getText());
		
			BookEntity bookEntity = new BookEntity(id,title,publisher, yearPublished,status,ISBN,price,author,edition);
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(BookEntity.class)
					.buildSessionFactory();

			Session sessionObj = factory.getCurrentSession();
			try {
			
			System.out.println("Creating new Book object...");
			
			sessionObj.beginTransaction();
			System.out.println("Saving the Book...");
			sessionObj.save(bookEntity);
			sessionObj.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Add Successfully", "Book Information", JOptionPane.PLAIN_MESSAGE);

			}

			finally {
			factory.close();
			}


		}
	}
	
	public void saveBorrowInfo(String member ,String book,String issue,String due){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(BorrowEntity.class)
				.buildSessionFactory();
		Session sessionObj = factory.getCurrentSession();
		try {

			sessionObj.beginTransaction();

			BorrowEntity borrowEntity = new BorrowEntity (member,book,issue,due);

			sessionObj.save(borrowEntity);

			sessionObj.getTransaction().commit();

		}

		finally {
			factory.close();
		}
	}
	public static void main(String[] arg)
	{
		new LBSwing();
	}
}
