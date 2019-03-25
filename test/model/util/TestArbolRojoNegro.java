package model.util;

import java.util.Iterator;
import org.junit.runner.RunWith;
import junit.framework.TestCase;
import model.data.structures.ArbolRojoNegro;
import model.data.structures.ElementoExisteException;
import model.data.structures.ElementoNoExisteException;


public class TestArbolRojoNegro extends TestCase{

	private ArbolRojoNegro<Integer> ArbolPrueba;
	
	public void setup(){
		ArbolPrueba = new ArbolRojoNegro<Integer>();
	}
	
	public void setup1() throws ElementoExisteException{
		setup();
		
		ArbolPrueba.insertar(1);
		ArbolPrueba.insertar(2);
		ArbolPrueba.insertar(3);
		ArbolPrueba.insertar(4);
		ArbolPrueba.insertar(5);
	}
	
	public void setup2() throws ElementoExisteException{
		setup();
		
		ArbolPrueba.insertar(5);
		ArbolPrueba.insertar(4);
		ArbolPrueba.insertar(3);
		ArbolPrueba.insertar(2);
		ArbolPrueba.insertar(1);
	}

	public void testAgregar(){
		setup();
		try {
			ArbolPrueba.insertar(42);
		} catch (ElementoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals("No se agrego correctamente", ArbolPrueba.darAltura(), 1);
		
	}
	
	public void testGet(){
		try {
			setup1();
			ArbolPrueba.insertar(94);
		} catch (ElementoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Deberia ser true", ArbolPrueba.existe(94), true);
	}
	
	public void testEliminar(){
		setup();
		try {
			setup1();
			ArbolPrueba.insertar(94);
			ArbolPrueba.eliminar(94);
		} catch (ElementoExisteException | ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("Deberia ser falso",ArbolPrueba.existe(94) ,false);
	}
	
}
