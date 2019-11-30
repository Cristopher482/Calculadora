package Calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraJPanel extends JPanel  {

	private JPanel Milamina2 = new JPanel();

	private JPanel Milamina3 = new JPanel();

	private JTextField PantallaNumero1,PantallaNumero2,PantallaResultado;

	private double Numero1,Numero2,Resultado;
	
	private String UltimaOperacion;
	
	private boolean FocoPantalla1,FocoPantalla2;

	public CalculadoraJPanel() {

		setLayout(new BorderLayout());

		PantallaNumero1 = new JTextField(10);

		PantallaNumero2 = new JTextField(10);

		PantallaResultado = new JTextField(13);

		Milamina3.add(PantallaNumero1);

		Milamina3.add(PantallaNumero2);

		Milamina3.add(PantallaResultado);
		
		PantallaResultado.setEnabled(false);

		Milamina2.setLayout(new GridLayout(4, 4));

		Milamina3.setLayout(new GridLayout(3, 1));
		
		add(Milamina2, BorderLayout.CENTER);

		add(Milamina3, BorderLayout.NORTH);

		ActionListener IntroducirNumero = new InsertarNumero();

		ActionListener IntroducirOperacion = new InsertarOperacion();

		ponerBoton("7", IntroducirNumero);
		ponerBoton("8", IntroducirNumero);
		ponerBoton("9", IntroducirNumero);
		ponerBoton("/", IntroducirOperacion);

		ponerBoton("4", IntroducirNumero);
		ponerBoton("5", IntroducirNumero);
		ponerBoton("6", IntroducirNumero);
		ponerBoton("*", IntroducirOperacion);

		ponerBoton("1", IntroducirNumero);
		ponerBoton("2", IntroducirNumero);
		ponerBoton("3", IntroducirNumero);
		ponerBoton("-", IntroducirOperacion);

		ponerBoton("0", IntroducirNumero);
		ponerBoton(".", IntroducirNumero);
		ponerBoton("AC", new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				PantallaNumero1.setText("");
				PantallaNumero2.setText("");
				PantallaResultado.setText("");
			}

		});
		
		ponerBoton("+", IntroducirOperacion);

		PantallaNumero1.addFocusListener(new Foco());

		PantallaNumero2.addFocusListener(new Foco());
	}

	public void ponerBoton(String NombreBoton, ActionListener Evento) {

		JButton boton = new JButton(NombreBoton);
		
		boton.addActionListener(Evento);

		Milamina2.add(boton);
	}

	private class Foco extends FocusAdapter {

		public void focusGained(FocusEvent e) {

			if (e.getSource() == PantallaNumero1) {
				FocoPantalla1 = true;
				FocoPantalla2 = false;
				//System.out.println("estoy en pantalla1");
			} else if (e.getSource() == PantallaNumero2) {
				FocoPantalla1 = false;
				FocoPantalla2 = true;
				//System.out.println("estoy en pantalla2");
			}
		}

	}

	private class InsertarNumero implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String entrada = e.getActionCommand();

			if (FocoPantalla1) {
				PantallaNumero1.setText(PantallaNumero1.getText() + entrada);
			} else if (FocoPantalla2) {
				PantallaNumero2.setText(PantallaNumero2.getText() + entrada);
			}
		}

	}

	private class InsertarOperacion implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String operacion = e.getActionCommand();

			UltimaOperacion = operacion;

			Numero1 = Double.parseDouble(PantallaNumero1.getText());

			Numero2 = Double.parseDouble(PantallaNumero2.getText());

			calcular(Numero1, Numero2);

		}

		public void calcular(double Numero1, double Numero2) {

			switch (UltimaOperacion) {

			case "+":

				Resultado = Numero1 + Numero2;

				break;

			case "-":

				Resultado = Numero1 - Numero2;

				break;

			case "*":

				Resultado = Numero1 * Numero2;

				break;

			case "/":

				Resultado = Numero1 / Numero2;

				break;

			default:

				PantallaNumero1.setText("operacion incorrecta");
			}
			
			PantallaResultado.setText("" + Resultado);
		}

	}

}