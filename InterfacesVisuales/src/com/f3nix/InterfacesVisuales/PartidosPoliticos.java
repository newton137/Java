package com.f3nix.InterfacesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartidosPoliticos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean bandera = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidosPoliticos frame = new PartidosPoliticos();
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
	public PartidosPoliticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel botonPRI = new JLabel("PRI");
		botonPRI.setHorizontalAlignment(SwingConstants.CENTER);
		botonPRI.setBackground(Color.GREEN);
		botonPRI.setFont(new Font("Source Sans Pro Black", Font.BOLD
				| Font.ITALIC, 12));
		botonPRI.setBounds(37, 30, 46, 14);
		contentPane.add(botonPRI);

		JLabel botonPAN = new JLabel("PAN");
		botonPAN.setHorizontalAlignment(SwingConstants.CENTER);
		botonPAN.setBackground(Color.BLUE);
		botonPAN.setFont(new Font("Source Sans Pro Black", Font.BOLD
				| Font.ITALIC, 12));
		botonPAN.setBounds(37, 80, 46, 14);
		contentPane.add(botonPAN);

		JLabel botonPRD = new JLabel("PRD");
		botonPRD.setHorizontalAlignment(SwingConstants.CENTER);
		botonPRD.setBackground(Color.YELLOW);
		botonPRD.setFont(new Font("Source Sans Pro Black", Font.BOLD
				| Font.ITALIC, 12));
		botonPRD.setBounds(37, 130, 46, 14);
		contentPane.add(botonPRD);

		textField = new JTextField();
		textField.setBounds(130, 30, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 76, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(130, 126, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton graficar = new JButton("GRAFICAR");
		graficar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				13));
		graficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argumento) {
				bandera = true;
				repaint();
			}
		});
		graficar.setBounds(37, 199, 120, 23);
		contentPane.add(graficar);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (bandera == true) {
			String casilla1 = textField.getText();
			String casilla2 = textField_1.getText();
			String casilla3 = textField_2.getText();
			int valor1 = Integer.parseInt(casilla1);
			int valor2 = Integer.parseInt(casilla2);
			int valor3 = Integer.parseInt(casilla3);
			int suma = valor1 + valor2 + valor3;
			int grados1 = valor1 * 360 / suma;
			int grados2 = valor2 * 360 / suma;
			int grados3 = valor3 * 360 / suma;
			g.setColor(new Color(0, 255, 0));
			g.fillArc(50, 250, 200, 200, 0, grados1);
			g.fillRect(370, 250, 20, 20);
			g.drawString("PRI", 400, 270);
			g.setColor(new Color(0, 0, 200));
			g.fillArc(50, 250, 200, 200, grados1, grados2);
			g.fillRect(370, 280, 20, 20);
			g.drawString("PAN", 400, 300);
			g.setColor(new Color(150, 0, 0));
			g.fillArc(50, 250, 200, 200, grados1 + grados2, grados3);
			g.fillRect(370, 310, 20, 20);
			g.drawString("PRD", 400, 330);
		}
	}
}
