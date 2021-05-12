package control;

import java.awt.EventQueue;

import vista.EjemploJList;
import vista.EjemploJList2;
import vista.EjemploJList3;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJList3 frame = new EjemploJList3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
