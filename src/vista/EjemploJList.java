package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploJList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public EjemploJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panelEste = new JPanel();
		panelEste.setBorder(new EmptyBorder(10, 10, 0, 10));
		contentPane.add(panelEste, BorderLayout.WEST);
		panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.X_AXIS));
		
		String[] varArrayLista= {"Cristina", "Cristian", "Maria", "Ramiro"};
		JList list = new JList(varArrayLista);	
		panelEste.add(list);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.EAST);
		panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
		
		List<String> varLista= Arrays.asList(varArrayLista);		
		JList list_1 = new JList(varLista.toArray());
		
		panelOeste.add(list_1);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBorder(new EmptyBorder(0, 50, 0, 50));
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.X_AXIS));
		
		DefaultListModel<String> modelo= new DefaultListModel();
		modelo.addAll(varLista);
		modelo.addElement("Ana");
		JList listaConModelo= new JList(modelo);
		listaConModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll= new JScrollPane(listaConModelo);
		panelCentro.add(scroll);
		
		
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		textField = new JTextField();
		panelBotones.add(textField);
		textField.setColumns(10);		
		
		
		JButton btnNewButton_1 = new JButton("ELIMINAR UNO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.remove(listaConModelo.getSelectedIndex());
				
				
			}
		});
		panelBotones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ELIMINAR TODOS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeAllElements();
				
				
			}
		});
		panelBotones.add(btnNewButton_2);
		
		
		JButton btnNewButton3 = new JButton("VER ELEMENTO SELECCIONADO");
		panelBotones.add(btnNewButton3);
		btnNewButton3.addActionListener(e->{
			JOptionPane.showMessageDialog(null, listaConModelo.getSelectedValue());
			
		});
		
		
		//Trabajando con selecciones múltiples		
		JButton btnNewButton4 = new JButton("CAMBIAR TIPO SELECCIÓN");
		panelBotones.add(btnNewButton4);
		btnNewButton4.addActionListener(e->{
			listaConModelo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);			
		});
		
		JButton btnNewButton5 = new JButton("VER SELECCIONADOS");
		panelBotones.add(btnNewButton5);
		btnNewButton5.addActionListener(e->{
			JOptionPane.showMessageDialog(null, listaConModelo.getSelectedValuesList());
			for (Object s : listaConModelo.getSelectedValuesList()) {
				System.out.println((String)s);
			}
		});
		
		JButton btnNewButton6 = new JButton("BORRAR SELECCIONADOS");
		panelBotones.add(btnNewButton6);
		btnNewButton6.addActionListener(e -> {
			int cont = 0;
			for (Integer y : listaConModelo.getSelectedIndices()) {
				modelo.remove(y - cont++);
			}
				
			
		});
		
		
	}

}
