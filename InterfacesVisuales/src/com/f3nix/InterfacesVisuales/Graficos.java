package com.f3nix.InterfacesVisuales;

import java.awt.BorderLayout;
import java.awt.color.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Graficos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graficos frame = new Graficos();
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
	public Graficos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.blue);
		g.drawLine(0, 70, 100, 70);
		g.drawRect(150,70, 50, 70);
		g.drawRoundRect(250, 70, 50, 70, 6, 6);
		g.drawOval(350, 70, 50, 70);
		int [] vx1 = {500,550,400};
		int [] vy1 = {70,120,120};
		g.drawPolygon(vx1,vy1,3);
		g.setColor(Color.red);
		g.fillRect(151,71, 49, 69);
		g.fillRoundRect(251, 71, 49, 69, 4, 4);
		g.fillOval(350, 70, 50, 70);
		g.fillPolygon(vx1,vy1,3);
		g.drawString("Santi es un niño rata", 20, 100);
	}

}
