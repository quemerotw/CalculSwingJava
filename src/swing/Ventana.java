package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Ventana {
	private static Ventana ventana;
	private JFrame frame;
	private Botonera botonera;
	private static JTextField pantalla1;
	private static JTextField pantalla2;
	private static Integer num1 = -9999;
	private static Integer num2;

	private Ventana() {
		inicializarVentana();
		inicializarPantalla();
		this.botonera = new Botonera();
		this.frame.add(botonera);
		this.frame.setVisible(true);
	}
	
	public static Ventana getVentana() {
		if (ventana == null) {
			return new Ventana();
		}
		else {
			return ventana;
		}
	}
	private void inicializarVentana() {
		this.frame = new JFrame("Calculadora By --->Quemero<---");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} 
		this.frame.setSize(500,500);
		GridLayout grid = new GridLayout(2,1);
		this.frame.setLayout(grid);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void inicializarPantalla(){
		JPanel x = new JPanel();
		pantalla1 = new JTextField();
		pantalla2 = new JTextField();
		pantalla1.setBorder(BorderFactory.createLoweredBevelBorder());
		pantalla2.setBorder(BorderFactory.createLoweredBevelBorder());
		pantalla1.setSize(200, 100);
		Font font = new Font("SansSerif",Font.PLAIN,25);
		pantalla1.setFont(font);
		pantalla1.setEditable(false);
		x.add(pantalla2);
		pantalla2.setFont(new Font("SansSerif",Font.ITALIC,20));
		pantalla2.setEditable(false);
		x.add(pantalla1);
		x.setLayout(new GridLayout(2,1));
		this.frame.add(x);
	}

	public static JTextField getPantalla1() {
		return pantalla1;
	}
	
	

	public static JTextField getPantalla2() {
		return pantalla2;
	}

	public static int getNum1() {
		return num1;
	}

	public static int getNum2() {
		return num2;
	}

	public static void setNum1(int num1) {
		Ventana.num1 = num1;
	}

	public static void setNum2(int num2) {
		Ventana.num2 = num2;
	}
	
	
	
	
	
}
