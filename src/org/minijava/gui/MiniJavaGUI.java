package org.minijava.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import java_cup.runtime.Symbol;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import org.minijava.scanner.Scanner;
import org.minijava.tests.ScannerTest;

import JFlex.sym;

public class MiniJavaGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private String version = "1.0";
	private JTabbedPane tabPaneCode = null;
	private JTabbedPane tabPaneConsole = null;
	private JTextArea textAreaConsole = null;
	
	public MiniJavaGUI() {
		this.setSize(800, 600);
		this.setTitle("MiniJava");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();
		menuBar();
		toolBar();
		codeArea();

		this.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(java.awt.event.ComponentEvent e) {
				// Dimension dimension = jpanel.getSize();
				// scrollPane.setSize(dimension.width-20,dimension.height-200);
				// scrollPaneConsole.setSize(dimension.width-20,dimension.height-50);
				// textArea.setSize(dimension.width-20,dimension.height-100);
				// btnFechar.setLocation(dimension.width-120-10,dimension.height-25-10);
			}
		});
		
		this.textAreaConsole.append("Seja bem vindo\n");
	}

	public void run() {
		setVisible(true);
		//compile();
	}

	private void menuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuCode = new JMenu("Code");
		JMenu menuSobre = new JMenu("Sobre");
		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemNew = new JMenuItem("New");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		JMenuItem menuItemSobre = new JMenuItem("Sobre");
		JMenuItem menuItemCompile = new JMenuItem("Compile");
		
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.event.InputEvent.CTRL_MASK));
		menuItemCompile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,java.awt.event.InputEvent.CTRL_MASK));
		
		menuItemNew.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addNewTab("");				
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
		menuFile.add(menuItemExit);
		menuCode.add(menuItemCompile);
		menuSobre.add(menuItemSobre);
		
		menuBar.add(menuFile);
		menuBar.add(menuCode);
		menuBar.add(menuSobre);
		this.setJMenuBar(menuBar);
	}

	private void toolBar() {
		JToolBar toolBar = new JToolBar("Menu");

		// first button
		JButton button = new JButton("Compile");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compile();			
			}
		});
		button.setToolTipText("Clique aqui para compilar o código corrente");
		button.setIcon(new ImageIcon("lib/images/run-20.png"));
		toolBar.add(button);
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.PAGE_START);
	}
	
	private void addNewTab(String name){
			
		if(name.isEmpty())
			name = JOptionPane.showInputDialog(this, "Filename:");
		if(name == null)
			return;
		
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setTabSize(4);
		textArea.setFont(new Font("Arial",0, 14));
		textArea.setSize(10,100);
		JScrollPane scrollPane = new JScrollPane(textArea);
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
					System.out.println(arg0.getComponent());
					JPopupMenu pop = new JPopupMenu("oi");
					pop.add(new JMenuItem("Remove"));
					pop.show(arg0.getComponent(),arg0.getX(),arg0.getY());
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void codeArea() {
		tabPaneCode = new JTabbedPane();	
		tabPaneConsole = new JTabbedPane();
		addNewTab("code");		
		//this.add(tabPane);
		
		textAreaConsole = new JTextArea(5,20);
		textAreaConsole.setEditable(false);
		textAreaConsole.setTabSize(4);		
		textAreaConsole.setFont(new Font("Arial",0, 14));
		textAreaConsole.setSize(100,100);
		JScrollPane scrollPane = new JScrollPane(textAreaConsole);
		tabPaneConsole.addTab("Console", scrollPane);
				
		Container container = this.getContentPane();		
		container.add(tabPaneCode, BorderLayout.CENTER);
		container.add(tabPaneConsole, BorderLayout.LINE_END);			
	}
	
	private void compile(){
		ScannerTest scanner = new ScannerTest(getSelectedTab().getText());
		scanner.setConsole(textAreaConsole);
		scanner.run();
	}
	
	private void about(){
		String authors = "Autores:\n  Débora Martins\n  Thiago Nascimento";
		String version = "Version:\n  "+this.version;
		JOptionPane.showMessageDialog(this,"MiniJava\n\n"+authors+"\n\n"+version);
	}
	
	private JTextArea getSelectedTab(){
		int index = tabPaneCode.getSelectedIndex();
		JScrollPane scrollPane = (JScrollPane) tabPaneCode.getComponentAt(index);
		JViewport viewport = scrollPane.getViewport(); 
		return (JTextArea)viewport.getView();
	}
	
	private void init(){
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				getSelectedTab().requestFocusInWindow();
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
