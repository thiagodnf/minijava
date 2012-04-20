package org.minijava.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.minijava.tests.ScannerTest;

public class MiniJavaGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private String version 			   = "1.0";
	private JTabbedPane tabPaneCode    = null;
	private JTabbedPane tabPaneConsole = null;
	private JTextArea textAreaConsole  = null;
	
	public MiniJavaGUI(File file) {
		setSize(800, 600);
		setTitle("MiniJava Compiler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		
		createMenuBar();
		
		createToolBar();
		
		createCodeArea();
		createConsoleArea();
		
		if(file != null)
			openFile(file);
		else
			addNewTab("untitled");
		
		this.textAreaConsole.append("Welcome\n");
	}

	public void run() {
		setVisible(true);		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuCode = new JMenu("Code");
		JMenu menuSobre = new JMenu("About");
		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemNew = new JMenuItem("New");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		JMenuItem menuItemClose = new JMenuItem("Close");
		JMenuItem menuItemSobre = new JMenuItem("About");
		JMenuItem menuItemCompile = new JMenuItem("Compile");
		
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.event.InputEvent.CTRL_MASK));
		menuItemClose.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q,java.awt.event.InputEvent.CTRL_MASK));
		menuItemCompile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,java.awt.event.InputEvent.CTRL_MASK));
		
		menuItemOpen.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				open();
			}
		});
		menuItemNew.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addNewTab("");				
			}
		});
		menuItemClose.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		menuItemExit.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		menuItemCompile.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				compile();
			}
		});
		menuItemSobre.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				about();
			}
		});
		
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.addSeparator();
		menuFile.add(menuItemClose);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		
		menuCode.add(menuItemCompile);
		menuSobre.add(menuItemSobre);
		
		menuBar.add(menuFile);
		menuBar.add(menuCode);
		menuBar.add(menuSobre);
		setJMenuBar(menuBar);
	}

	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Menu");

		JButton buttonCompile = new JButton("Compile");
		buttonCompile.setToolTipText("Compile the current code");
		buttonCompile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/minijava/resources/image-compile-20.png")));
		buttonCompile .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				compile();			
			}
		});
		
		toolBar.add(buttonCompile );
		add(toolBar, BorderLayout.PAGE_START);
	}
	
	private JTextArea addNewTab(String name){
		if(name.isEmpty())
			name = JOptionPane.showInputDialog(this, "Filename:");
		if(name == null)
			return null;
		
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setTabSize(4);
		textArea.setFont(new Font("Arial",0, 14));
		textArea.setSize(10,100);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		if(tabPaneCode != null){
			tabPaneCode.addTab(name+".java", scrollPane);
			tabPaneCode.setSelectedIndex(tabPaneCode.getComponentCount()-1);
			textArea.requestFocusInWindow();
			tabPaneCode.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {				
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					if(arg0.getButton() == 3){
						JPopupMenu pop = new JPopupMenu();
						JMenuItem menuItemRemove = new JMenuItem("Remove");				
						menuItemRemove.addActionListener(new ActionListener() {						
							@Override
							public void actionPerformed(ActionEvent arg1) {
								close();								
							}
						});
						
						pop.add(menuItemRemove);
						pop.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {				
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {				
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});			
		}
		return textArea;
	}
	
	private void createConsoleArea(){
		tabPaneConsole = new JTabbedPane();
		Container container = this.getContentPane();		
		container.add(tabPaneConsole, BorderLayout.LINE_END);
		textAreaConsole = new JTextArea(5,20);
		textAreaConsole.setEditable(false);
		textAreaConsole.setTabSize(4);		
		textAreaConsole.setFont(new Font("Arial",0, 14));
		textAreaConsole.setSize(100,100);
		JScrollPane scrollPane = new JScrollPane(textAreaConsole);
		tabPaneConsole.addTab("Console", scrollPane);
		
		textAreaConsole.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getButton() == 3){
					JPopupMenu pop = new JPopupMenu();
					JMenuItem menuItemClear = new JMenuItem("Clear");					
					menuItemClear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							textAreaConsole.setText("");		
						}
					});
					
					pop.add(menuItemClear);					
					pop.show(arg0.getComponent(),arg0.getX(),arg0.getY());
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
	}
	
	private void createCodeArea() {
		tabPaneCode = new JTabbedPane();	
		Container container = this.getContentPane();		
		container.add(tabPaneCode, BorderLayout.CENTER);					
	}
	
	private void compile(){
		if(getSelectedTab() != null){
			ScannerTest scanner = new ScannerTest(getSelectedTab().getText());
			scanner.setConsole(textAreaConsole);
			scanner.run();
		}else{
			JOptionPane.showMessageDialog(this,"No code selected.");
		}
	}
	
	private void close(){
		int index = tabPaneCode.getSelectedIndex();
		String nameTab = tabPaneCode.getTitleAt(index);
		if(index != -1){
			int more = JOptionPane.showConfirmDialog(this, "Would you like to close '"+nameTab+"'?", "Close File",JOptionPane.YES_NO_OPTION);
			if(more == JOptionPane.OK_OPTION)
				tabPaneCode.remove(index);
		}
	}
	
	private void open(){
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileFilter(new FileNameExtensionFilter("MiniJava Files", "java"));	    
	    chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle("Open file");
	    
	    if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {	    	
			openFile(chooser.getSelectedFile());				       
	    }
	}
	
	private void openFile(File file){
		try {
			JTextArea textArea = addNewTab(file.getName());
			FileReader reader = new FileReader(file);
	        BufferedReader bufRdr = new BufferedReader(reader);
	        
	        String line = null;
	        while ((line = bufRdr.readLine()) != null)
	        	textArea.append(line+"\n");
	        bufRdr.close();
	        reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void about(){
		String authors = "Autores:\n  Débora Martins\n  Thiago Nascimento";
		String version = "Version:\n  "+this.version;
		JOptionPane.showMessageDialog(this,"MiniJava Compiler\n\n"+authors+"\n\n"+version);
	}
	
	private JTextArea getSelectedTab(){
		if(tabPaneCode != null){
			int index = tabPaneCode.getSelectedIndex();
			if(index != -1){
				JScrollPane scrollPane = (JScrollPane) tabPaneCode.getComponentAt(index);
				JViewport viewport = scrollPane.getViewport(); 
				return (JTextArea)viewport.getView();
			}
		}
		return null;
	}
	
	private void init(){
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				JTextArea textArea = getSelectedTab();
				if(textArea != null)
					textArea.requestFocusInWindow();
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
	}
}
