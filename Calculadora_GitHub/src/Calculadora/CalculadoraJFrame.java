package Calculadora;

import javax.swing.JFrame;

public class CalculadoraJFrame extends JFrame {

	public CalculadoraJFrame() {

		CalculadoraJPanel LaminaCalculadora = new CalculadoraJPanel();

		add(LaminaCalculadora);
		
		setTitle("Calculadora");

		setBounds(500, 300, 450, 300);
		
		pack();
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}
}