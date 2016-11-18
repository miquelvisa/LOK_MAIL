package com.frames;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CurrentMail extends JFrame {

	private JPanel contentPane;
	private JTextField textField_de;
	private JTextField textField_asunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentMail frame = new CurrentMail(args[0]);
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
	public CurrentMail(String asunto) {
		String[] msg = getInfo(asunto);
		setTitle("Mensaje de: "+msg[1]);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_de = new JTextField();
		textField_de.setEditable(false);
		textField_de.setBounds(67, 11, 406, 20);
		textField_de.setText(msg[1]);
		contentPane.add(textField_de);
		textField_de.setColumns(10);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBounds(10, 14, 46, 14);
		contentPane.add(lblDe);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsunto.setBounds(10, 39, 46, 14);
		contentPane.add(lblAsunto);
		
		textField_asunto = new JTextField();
		textField_asunto.setEditable(false);
		textField_asunto.setColumns(10);
		textField_asunto.setBounds(67, 36, 406, 20);
		textField_asunto.setText(msg[0]);
		contentPane.add(textField_asunto);
		
		JEditorPane mensaje = new JEditorPane();
		mensaje.setContentType("text/html");
		mensaje.setBounds(10, 64, 463, 434);
		mensaje.setText(msg[2]);
		contentPane.add(mensaje);
	}
	
	public static String[] getInfo(String asunto){
		ArrayList<String[]> mensajes = new ArrayList<String[]>();
		String[] msg1 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(1)};
		String[] msg2 = {"Regalo para Sarah","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(2)};
		String[] msg3 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(3)};
		String[] msg4 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(4)};
		String[] msg5 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(5)};
		String[] msg6 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(6)};
		String[] msg7 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(7)};
		String[] msg8 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(8)};
		String[] msg9 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(9)};
		String[] msg10 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(10)};
		String[] msg11 = {"Credenciales restablecidos","Alexander Smith <alexandersmith@codebrain.com>",readHTMLFile(11)};
		
		mensajes.add(msg1);
		mensajes.add(msg2);
		mensajes.add(msg3);
		mensajes.add(msg4);
		mensajes.add(msg5);
		mensajes.add(msg6);
		mensajes.add(msg7);
		mensajes.add(msg8);
		mensajes.add(msg9);
		mensajes.add(msg10);
		mensajes.add(msg11);
		
		
		
		
		for(String[] c:mensajes){
			if(c[0]==asunto){
				return c;
			}
		}
		return null;
	}
	
	public static String readHTMLFile(int n){
		String content = "";
	    try {
	        BufferedReader in = new BufferedReader(new FileReader("msg/msg"+n+".html"));
	        String str;
	        while ((str = in.readLine()) != null) {
	            content +=str;
	        }
	        in.close();
	    } catch (IOException e) {
	    	System.err.println(e);
	    }
	    return content;
	}
}
