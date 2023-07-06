package swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Botonera extends JPanel{
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton boton0;
	private JButton botonIgual;
	private JButton botonMas;
	private JButton botonMenos;
	private JButton botonPor;
	private JButton botonDiv;
	private JButton botonClear;
	private static boolean flag;
	private Contexto context = new Contexto();
	
	public Botonera() {
		
		this.setBackground(Color.black);
		GridLayout grid = new GridLayout(4,5);
		this.setLayout(grid);
		configurarBotones();
		insertarBotones();
		
	}

	public boolean isFlag() {
		return flag;
	}

	private void insertarBotones() {
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(botonMas);
		//2do Row
		this.add(boton4);
		this.add(boton5);
		this.add(boton6);
		this.add(botonMenos);
		//3er Row
		this.add(boton7);
		this.add(boton8);
		this.add(boton9);
		this.add(botonPor);
		//4to Row
		this.add(botonDiv);
		this.add(boton0);
		this.add(botonIgual);
		this.add(botonClear);
	}

	private void configurarBotones() {
		ListenerNumero listenerNuemero = new ListenerNumero();
		ListenerOperador listenerOperador  = new ListenerOperador();
		ListenerClear listenerClear  = new ListenerClear();
		boton1 = new JButton("1");
		boton1.setActionCommand("1");
		boton1.addActionListener(listenerNuemero);
		boton2 = new JButton("2");
		boton2.setActionCommand("2");
		boton2.addActionListener(listenerNuemero);
		boton3 = new JButton("3");
		boton3.setActionCommand("3");
		boton3.addActionListener(listenerNuemero);
		boton4 = new JButton("4");
		boton4.addActionListener(listenerNuemero);
		boton4.setActionCommand("4");
		boton5 = new JButton("5");
		boton5.setActionCommand("5");
		boton5.addActionListener(listenerNuemero);
		boton6 = new JButton("6");
		boton6.setActionCommand("6");
		boton6.addActionListener(listenerNuemero);
		boton7 = new JButton("7");
		boton7.setActionCommand("7");
		boton7.addActionListener(listenerNuemero);
		boton8 = new JButton("8");
		boton8.setActionCommand("8");
		boton8.addActionListener(listenerNuemero);
		boton9 = new JButton("9");
		boton9.setActionCommand("9");
		boton9.addActionListener(listenerNuemero);
		boton0 = new JButton("0");
		boton0.setActionCommand("0");
		boton0.addActionListener(listenerNuemero);
		botonIgual = new JButton("=");
		botonIgual.setActionCommand("igual");
		botonIgual.addActionListener(new ListenerIgual());
		botonMas = new JButton("+");
		botonMas.setActionCommand("+");
		botonMas.addActionListener(listenerOperador);
		botonMenos = new JButton("-");
		botonMenos.addActionListener(listenerOperador);
		botonMenos.setActionCommand("-");
		botonPor = new JButton("X");
		botonPor.addActionListener(listenerOperador);
		botonPor.setActionCommand("*");
		botonDiv = new JButton("/");
		botonDiv.addActionListener(listenerOperador);
		botonDiv.setActionCommand("/");
		botonClear = new JButton("C");
		botonClear.addActionListener(listenerClear);
	}

	
	
	private class ListenerNumero implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Botonera.flag) {
				Ventana.getPantalla1().setText("");
				Ventana.getPantalla2().setText("");
				Botonera.flag = false;
			}
			String texto = Ventana.getPantalla1().getText();
			Ventana.getPantalla1().setText(texto + e.getActionCommand());
		}
	}
	
	private class ListenerOperador implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e){
			if (Ventana.getPantalla1().getText().isBlank()) {
				Ventana.getPantalla2().setText("Ingrese un numero primero");
			}
			else {
				String val1 = Ventana.getPantalla1().getText();
				if (Ventana.getNum1() > -9999) {
					if (!Ventana.getPantalla2().getText().isBlank()) {
						Ventana.getPantalla2().setText(Ventana.getNum2()+e.getActionCommand());;
					}
					else
						Ventana.getPantalla2().setText(Ventana.getPantalla2().getText()+val1);
					Integer resultado = context.getStrategy().operar(Ventana.getNum1(), Integer.valueOf(val1));
					Ventana.getPantalla1().setText(resultado.toString());
					Ventana.setNum2(resultado);
				}
				else {
					String operacion = e.getActionCommand();
					if(operacion == "+")
						context.setStrategy(new Suma());
					else
						if (operacion == "*")
							context.setStrategy(new Multiplicar());
						else
							if (operacion == "-")
								context.setStrategy(new Resta());
							else
								if (operacion =="/")
									context.setStrategy(new Dividir());
					Ventana.setNum1(Integer.valueOf(val1));
					Ventana.getPantalla2().setText(val1+operacion);
					Ventana.getPantalla1().setText("");
				}	
			}
		}
	}
	
	private class ListenerClear implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Ventana.getPantalla1().setText("");
			Ventana.getPantalla2().setText("");
			Ventana.setNum1(-9999);
		}
		
	}
	private class ListenerIgual implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Botonera.flag = true;
			if (Ventana.getPantalla1().getText().isBlank()) {
				Ventana.getPantalla2().setText("Ingrese un numero primero");
			}
			else {
				String val1 = Ventana.getPantalla1().getText();
				if (Ventana.getNum1() > -9999) {
					if (!Ventana.getPantalla2().getText().isBlank()) {
						Ventana.getPantalla2().setText(Ventana.getPantalla2().getText()+val1);
					}
					else
						Ventana.getPantalla2().setText(Ventana.getPantalla2().getText()+val1);
					Integer resultado = context.getStrategy().operar(Ventana.getNum1(), Integer.valueOf(val1));
					Ventana.getPantalla1().setText(resultado.toString());
				}
			}
		}
		
	}
	
}
