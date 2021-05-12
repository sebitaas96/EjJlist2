package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;





public class ModeloPropio extends AbstractListModel{
	List<Ciudad> listaC= new ArrayList<Ciudad>();
	@Override 
	public int getSize() {
		return listaC.size();
	}

	@Override
	public Object getElementAt(int index) {
		Ciudad c = listaC.get(index);
		return c.getNombreCiudad();
	}
	
	public void addCiudad(Ciudad c){
		  listaC.add(c);
		  //avisa al JList de que se ha creado un nuevo elemento
		  this.fireIntervalAdded(this, getSize(), getSize()+1);
		 }

	public void addAll(List<Ciudad> listaCiudades) {
		this.listaC=listaCiudades;
		this.fireIntervalAdded(this, 0, getSize());
		
	}
	
	public void eliminarCiudad(int index){
		   listaC.remove(index);
		 
		   this.fireIntervalRemoved(index, getSize(), (getSize()-1)<0?0:getSize()-1);
		 }
	public void eliminarAllCiudad(){

			listaC.removeAll(listaC);
		 
		   this.fireIntervalRemoved(0,0,0);
		 }

}
