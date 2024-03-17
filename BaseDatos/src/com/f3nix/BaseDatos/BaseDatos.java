package com.f3nix.BaseDatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos extends JFrame {

	private JPanel contentPane;
	private JTextField introducirDescripcion;
	private JTextField introducirPrecio;
	private JTextField ingresarCodigo;
	private JLabel resultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseDatos frame = new BaseDatos();
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
	public BaseDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel descripcion = new JLabel("Descipci\u00F3n:");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		descripcion.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		descripcion.setBounds(35, 35, 71, 14);
		contentPane.add(descripcion);
		
		JLabel precio = new JLabel("Precio:");
		precio.setHorizontalAlignment(SwingConstants.CENTER);
		precio.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		precio.setBounds(35, 75, 46, 14);
		contentPane.add(precio);
		
		introducirDescripcion = new JTextField();
		introducirDescripcion.setBounds(150, 33, 250, 20);
		contentPane.add(introducirDescripcion);
		introducirDescripcion.setColumns(10);
		
		introducirPrecio = new JTextField();
		introducirPrecio.setBounds(150, 73, 100, 20);
		contentPane.add(introducirPrecio);
		introducirPrecio.setColumns(10);
		
		JButton botonAlta = new JButton("Alta");
		botonAlta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argumento){
				resultado.setText("");
				try{
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba2","root","");
					Statement comando = conexion.createStatement();
					comando.executeUpdate("insert into articulos(descripcion,precio) values('"+introducirDescripcion.getText()+"',"+introducirPrecio.getText()+")");
					conexion.close();
					resultado.setText("Registro completo");
					introducirDescripcion.setText("");
					introducirPrecio.setText("");
				}catch(SQLException excepcion){
					setTitle(excepcion.toString());
				}
			}
		});
		botonAlta.setFont(new Font("Adobe Hebrew", Font.BOLD | Font.ITALIC, 14));
		botonAlta.setBounds(150, 120, 89, 23);
		contentPane.add(botonAlta);
		
		resultado = new JLabel("Resultado");
		resultado.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(275, 123, 78, 14);
		contentPane.add(resultado);
		
		JLabel ingresar = new JLabel("Ingrese c\u00F3digo para consultar articulo:");
		ingresar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		ingresar.setHorizontalAlignment(SwingConstants.CENTER);
		ingresar.setBounds(35, 180, 215, 14);
		contentPane.add(ingresar);
		
		ingresarCodigo = new JTextField();
		ingresarCodigo.setBounds(267, 178, 133, 20);
		contentPane.add(ingresarCodigo);
		ingresarCodigo.setColumns(10);
		driver();
		
		JButton cosultarCodigo = new JButton("Cosulta por c\u00F3digo");
		cosultarCodigo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argumento){
				resultado.setText("");
				introducirDescripcion.setText("");
				introducirPrecio.setText("");
				try{
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba2","root","");
					Statement comando = conexion.createStatement();
					ResultSet registro = comando.executeQuery("select descripcion,precio from articulos where codigo = "+ingresarCodigo.getText());
					if(registro.next() == true){
						introducirDescripcion.setText(registro.getString("descripcion"));
						introducirPrecio.setText(registro.getString("precio"));
					}else{
						resultado.setText("Articulo no encontrado");
					}
					conexion.close();
				}catch(SQLException excepcion){
					setTitle(excepcion.toString());
				}
			}
		});
		cosultarCodigo.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		cosultarCodigo.setBounds(35, 215, 158, 23);
		contentPane.add(cosultarCodigo);
		
		JButton borrar = new JButton("Borrar");
		borrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argumento) {
				resultado.setText("");
				try{
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba2","root","");
					Statement comando = conexion.createStatement();
					int cantidad = comando.executeUpdate("DELETE FROM articulos WHERE codigo = " + ingresarCodigo.getText());
					if(cantidad == 1){
						introducirDescripcion.setText("");
						introducirPrecio.setText("");
						resultado.setText("Articulo eliminado correctamente");
					}else{
						resultado.setText("Articulo no encontrado");
					}
				}catch(SQLException excepcion){
					setTitle(excepcion.toString());
				}
			}
		});
		borrar.setBounds(311, 215, 89, 23);
		contentPane.add(borrar);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argumento) {
				resultado.setText("");
				try{
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba2","root","");
					Statement comando = conexion.createStatement();
					int cantidad = comando.executeUpdate("UPDATE articulos SET descripcion = '" + introducirDescripcion.getText() + "' , precio = " + introducirPrecio.getText() + " WHERE codigo = " + ingresarCodigo.getText());
					if(cantidad == 1){
						resultado.setText("Modificado");
					}else{
						resultado.setText("Articulo no encontrado");
					}
					conexion.close();
				}catch(SQLException excepcion){
					setTitle(excepcion.toString());
				}
			}
		});
		modificar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		modificar.setBounds(203, 215, 89, 23);
		contentPane.add(modificar);
		
	}
	private void driver(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception excepcion){
			setTitle(excepcion.toString());
		}
	}
}
