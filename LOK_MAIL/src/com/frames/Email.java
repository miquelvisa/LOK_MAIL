package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Email extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Email() {
		setTitle("Correo electr\u00F3nico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] excludedPaths = {"Seguridad","Alexander Smith","John Moore","Finanzas","Sarah Miller","Personal"};
		
		
		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				boolean isExcluded = false;
				String[] p =new String[1];
				p[0] = e.getPath().getLastPathComponent().toString();
				for(String s:excludedPaths){
					if(s==p[0]){
						isExcluded = true;
					}
				}
				if(!isExcluded){
					CurrentMail.main(p);;
				}
			}
		});
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Correos\t") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Seguridad");
						node_2 = new DefaultMutableTreeNode("Alexander Smith");
							node_2.add(new DefaultMutableTreeNode("Credenciales restablecidos"));
							node_2.add(new DefaultMutableTreeNode("Regalo para Sarah"));
							node_2.add(new DefaultMutableTreeNode("Problemas de conexi\u00F3n"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("John Moore");
							node_2.add(new DefaultMutableTreeNode("Shutdown del sistema"));
							node_2.add(new DefaultMutableTreeNode("Celdas 4 y 5"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Finanzas");
						node_2 = new DefaultMutableTreeNode("Sarah Miller");
							node_2.add(new DefaultMutableTreeNode("Resumen ultimo trimestre"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Personal");
						node_1.add(new DefaultMutableTreeNode("Bankus: Estado de su cuenta"));
						node_1.add(new DefaultMutableTreeNode("Bankus: Transferencia #2124"));
						node_1.add(new DefaultMutableTreeNode("Bankus: Transferencia #2123"));
						node_1.add(new DefaultMutableTreeNode("Meeting"));
						node_1.add(new DefaultMutableTreeNode("Precauci\u00F3n"));
					add(node_1);
				}
			}
		));
		tree.setBounds(10, 11, 349, 403);
		contentPane.add(tree);
	}
}
