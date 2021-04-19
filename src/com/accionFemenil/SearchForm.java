package com.accionFemenil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchForm extends JFrame{

	
	private String matricula;

	public SearchForm() {
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		initComponents();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbSearchM = new JLabel();
		lbSearchM.setText("Matrícula: ");
		lbSearchM.setBounds(50, 150, 100, 30);
		panel.add(lbSearchM);
		
		JTextField txSearchM = new JTextField();
		txSearchM.setBounds(150, 150, 199, 30);
		panel.add(txSearchM);
		
		JButton btnSearchM = new JButton();
		btnSearchM.setText("Buscar");
		btnSearchM.setBounds(50, 230, 150, 40);
		panel.add(btnSearchM);
		
		ActionListener al = new ActionListener() {

		

			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					matricula = txSearchM.getText();
					searchWorker(matricula);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		};
		btnSearchM.addActionListener(al);
	}
	
	public void searchWorker(String matricula) {
		this.matricula = matricula;
		
		String SQL = "SELECT * FROM regTrabajador WHERE matricula = ?";
		
		try {
			if(matricula.isEmpty()) {
				System.out.println("Proporciona la matrícula");
				System.exit(1);
			}else{
				try {
					MysqlConnectionConfig con = new MysqlConnectionConfig();
					Connection cx = con.MysqlConnection();
					//System.out.println(cx);
					
					
					PreparedStatement pstmt = cx.prepareStatement(SQL);
					pstmt.setString(1, matricula);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						String name = rs.getString("name");
						String category = rs.getString("category");
						String adscription = rs.getString("adscription");
						String sexo = rs.getString("sexo");
						String age = rs.getString("age");
						String phone = rs.getString("phone");
						String email = rs.getString("email");
						System.out.println(name+category+adscription+sexo+age+phone+email);
					}
					
					
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
