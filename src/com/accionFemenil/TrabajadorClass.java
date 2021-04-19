package com.accionFemenil;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class TrabajadorClass extends JFrame{
	private JPanel panel;
	private String matricula;
	private String name;
	private String category;
	private String adscription;
	private String sexo;
	private String age;
	private String phone;
	private String email;
	private JTextField txMatricula;
	private JTextField txName;
	private JTextField txCategory;
	private JTextField txAdscription;
	private JTextField txSexo;
	private JTextField txAge;
	private JTextField txPhone;
	private JTextField txEmail;
	private JButton btnSearchM;
	private JTable table;
	private JScrollPane spanel;
	String[] g = {"Matricula"};
	
	
	//Constructor
	public TrabajadorClass() {
		this.setSize(950, 700);
		
		initComponents();
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel lbMatricula = new JLabel();
		lbMatricula.setText("Matrícula: ");
		lbMatricula.setBorder(BorderFactory.createLineBorder(Color.white));
		lbMatricula.setBackground(Color.white);
		lbMatricula.setOpaque(true);
		lbMatricula.setBounds(119, 94, 81, 20);
		panel.add(lbMatricula);
		
		JLabel lbName = new JLabel();
		lbName.setText("Nombre: ");
		lbName.setBorder(BorderFactory.createLineBorder(Color.white));
		lbName.setBackground(Color.white);
		lbName.setOpaque(true);
		lbName.setBounds(134, 141, 66, 20);
		panel.add(lbName);
		
		JLabel lbCategory = new JLabel();
		lbCategory.setText("Categoría: ");
		lbCategory.setBorder(BorderFactory.createLineBorder(Color.white));
		lbCategory.setBackground(Color.white);
		lbCategory.setOpaque(true);
		lbCategory.setBounds(119, 197, 81, 20);
		panel.add(lbCategory);
		
		JLabel lbAdscription = new JLabel();
		lbAdscription.setText("Unidad de Adscripción: ");
		lbAdscription.setBorder(BorderFactory.createLineBorder(Color.white));
		lbAdscription.setBackground(Color.white);
		lbAdscription.setOpaque(true);
		lbAdscription.setBounds(32, 249, 168, 20);
		panel.add(lbAdscription);
		
		JLabel lbSexo = new JLabel();
		lbSexo.setText("Sexo: ");
		lbSexo.setBorder(BorderFactory.createLineBorder(Color.white));
		lbSexo.setBackground(Color.white);
		lbSexo.setOpaque(true);
		lbSexo.setBounds(153, 300, 47, 20);
		panel.add(lbSexo);
		
		JLabel lbAge = new JLabel();
		lbAge.setText("edad: ");
		lbAge.setBorder(BorderFactory.createLineBorder(Color.white));
		lbAge.setBackground(Color.white);
		lbAge.setOpaque(true);
		lbAge.setBounds(153, 343, 47, 20);
		panel.add(lbAge);
		
		JLabel lbPhone = new JLabel();
		lbPhone.setText("Teléfono: ");
		lbPhone.setBorder(BorderFactory.createLineBorder(Color.white));
		lbPhone.setBackground(Color.white);
		lbPhone.setOpaque(true);
		lbPhone.setBounds(127, 395, 73, 20);
		panel.add(lbPhone);
		
		JLabel lbEmail = new JLabel();
		lbEmail.setText("Correo: ");
		lbEmail.setBorder(BorderFactory.createLineBorder(Color.white));
		lbEmail.setBackground(Color.white);
		lbEmail.setOpaque(true);
		lbEmail.setBounds(141, 443, 59, 20);
		panel.add(lbEmail);
		
		//TextFields
		JTextField txMatricula = new JTextField();
		txMatricula.setBounds(212, 90, 210, 30);
		panel.add(txMatricula);
		
		JTextField txNombre = new JTextField();
		txNombre.setBounds(212, 137, 210, 30);
		panel.add(txNombre);
		
		JTextField txCategory = new JTextField();
		txCategory.setBounds(212, 193, 210, 30);
		panel.add(txCategory);
		
		JTextField txAdscription = new JTextField();
		txAdscription.setBounds(212, 245, 210, 30);
		panel.add(txAdscription);
		
		JTextField txSexo = new JTextField();
		txSexo.setBounds(212, 296, 210, 30);
		panel.add(txSexo);
		
		JTextField txAge = new JTextField();
		txAge.setBounds(212, 339, 210, 30);
		panel.add(txAge);
		
		JTextField txPhone = new JTextField();
		txPhone.setBounds(212, 391, 210, 30);
		panel.add(txPhone);
		
		JTextField txEmail = new JTextField();
		txEmail.setBounds(212, 439, 210, 30);
		panel.add(txEmail);
		
		
		//Buttons
		JButton btnSave = new JButton();
		btnSave.setText("Registrar");
		btnSave.setBounds(212, 540, 120, 40);
		panel.add(btnSave);	
		
		JButton btnSearch1 = new JButton();
		btnSearch1.setText("Buscar");
		btnSearch1.setBounds(412, 540, 120, 40);
		panel.add(btnSearch1);	
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource() == btnSave) {
					matricula = txMatricula.getText();
					name = txNombre.getText();
					category = txCategory.getText();
					adscription = txAdscription.getText();
					sexo = txSexo.getText();
					age = txAge.getText();
					phone = txPhone.getText();
					email = txEmail.getText();
					//System.out.println(matricula+name+category+adscription+sexo+age+ phone+ email);
					try {
						regWorker(matricula,name,category,adscription,sexo,age, phone, email);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}else if(ev.getSource() == btnSearch1) {
					try {
						paintSearchForm();
						
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}	
			}
			
		};
		btnSave.addActionListener(al);
		btnSearch1.addActionListener(al);
	}
	
	
	//Register Worker Data
	//private void regWorker() throws ClassNotFoundException{
	private void regWorker(String matricula, String name, String category, String adscription, String sexo, String age, String phone, String email) throws ClassNotFoundException{
		
		this.matricula = matricula;
		this.name = name;
		this.category = category;
		this.adscription = adscription;
		this.sexo = sexo;
		this.age = age;
		this.phone = phone;
		this.email = email;
		
		String SQL = "INSERT INTO regTrabajador(matricula, name, category, adscription, sexo, age, phone, email)VALUES(?,?,?,?,?,?,?,?)";
				
		try {
			if(matricula.isEmpty() && name.isEmpty() && category.isEmpty() && adscription.isEmpty() && sexo.isEmpty() && age.isEmpty() && phone.isEmpty() && email.isEmpty()) {
				System.out.println("Hay campos vacíos, verifica y llena los campos");
				System.exit(1);
			}else{
				try {
					MysqlConnectionConfig con = new MysqlConnectionConfig();
					Connection cx = con.MysqlConnection();
					System.out.println(cx);
					PreparedStatement pstmt = cx.prepareStatement(SQL);
					pstmt.setString(1, matricula);
					pstmt.setString(2, name);
					pstmt.setString(3, category);
					pstmt.setString(4, adscription);
					pstmt.setString(5, sexo);
					pstmt.setString(6, age);
					pstmt.setString(7, phone);
					pstmt.setString(8, email);
					int rs = pstmt.executeUpdate();
					if(rs == 1) {
						System.out.println("Registro realizado exitosamente");
						
					} else if(rs == 2){
						System.out.println("Registro no se realizo");
					}
					cx.close();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	private void searchWorker(String matricula) {
		this.matricula = matricula;		
		
		Vector<String> vc = new Vector<String>();
		Vector<String> nColumns = new Vector<String>();
		
		String SQL = "SELECT * FROM regTrabajador WHERE matricula = ?";
		
		try {
			if(matricula.isEmpty()) {
				System.out.println("Proporciona la matrícula");
				//System.exit(1);
			}else{
				try {
					MysqlConnectionConfig con = new MysqlConnectionConfig();
					Connection cx = con.MysqlConnection();
					//System.out.println(cx);
					
					
					PreparedStatement pstmt = cx.prepareStatement(SQL);
					pstmt.setString(1, matricula);
					ResultSet rs = pstmt.executeQuery();
					ResultSetMetaData rsm = rs.getMetaData();
					Integer noColmn = rsm.getColumnCount();
					Vector column = new Vector(noColmn);
					System.out.println(column);
					for(int i=1; i<=noColmn;i++) {
						System.out.println(i);
						column.add(rsm.getCatalogName(i));
					}
					System.out.println(rsm.getColumnCount());
					System.out.println(rsm.getColumnName(1));
					
					//int nColumns = rsm.getColumnCount();
					while(rs.next()) {
						
						
						//Object[] obj = new Object[nColumns];
						//System.out.println(obj);
						//String matricula = rs.getString("matricula");
						//List<String> data = new ArrayList<String>();
						//System.out.println(data);
						
						
						//System.out.println(rsm.getColumnCount());
						//System.out.println(rsm);
						//String[] columns = {"Matrícula", "Nombre"};
						//TableModel tModel = new DefaultTableModel(data.toArray(new Object[][] {}), columns);
						//JTable table = new JTable(tModel);
						//System.out.println(table.getTableHeader());
						String name = rs.getString("name");
						String category = rs.getString("category");
						String adscription = rs.getString("adscription");
						String sexo = rs.getString("sexo");
						String age = rs.getString("age");
						String phone = rs.getString("phone");
						String email = rs.getString("email");
						vc.add(matricula);
						vc.add(name);
						vc.add(adscription);
						vc.add(sexo);
						vc.add(age);
						vc.add(phone);
						vc.add(email);
						
						System.out.println(vc);
						JOptionPane.showMessageDialog(null, "Encontrado");
						/*data.add(matricula);
						data.add(name);
						data.add(category);
						data.add(adscription);
						data.add(sexo);
						data.add(age);
						data.add(phone);
						data.add(email);
						for(String p : data) {
							System.out.println(p);
						}*/
						//String l = data.toString();
						//System.out.println(l);
						
						//System.out.println(data.toString());
						
						//System.out.println(matricula+name+category+adscription+sexo+age+phone+email);
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
	
	
	private void paintSearchForm() {
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		//initComponents();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lbSearchM = new JLabel();
		lbSearchM.setText("Matrícula: ");
		lbSearchM.setBounds(50, 150, 100, 30);
		panel.add(lbSearchM);
		
		JTextField txMatricula = new JTextField();
		txMatricula.setBounds(150, 150, 199, 30);
		panel.add(txMatricula);
		
		JButton btnSearchM = new JButton();
		btnSearchM.setText("Buscar");
		btnSearchM.setBounds(50, 230, 150, 40);
		panel.add(btnSearchM);
		
		ActionListener btnS = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				
				if(ev.getSource() == btnSearchM) {
					try {
						String matricula = txMatricula.getText();
						System.out.println(matricula);
						searchWorker(matricula);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		};
		btnSearchM.addActionListener(btnS);
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
	private void PaintResultsTable() {
		
		
		JTable table = new JTable();
		JScrollPane spanel = new JScrollPane();
		spanel.add(table);
		panel.add(spanel);
	}
	
	
	
}
