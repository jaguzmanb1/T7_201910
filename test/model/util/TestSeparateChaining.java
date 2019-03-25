package model.util;


import java.util.Iterator;

import org.junit.Before;
import junit.framework.TestCase;
import model.data.structures.SeparateChainingHash;

public class TestSeparateChaining extends TestCase
{
	private int tamañoInicial;

	private SeparateChainingHash<Integer,String> pruebaHash;
	
	public void setup() throws Exception{
		tamañoInicial = 500;
		pruebaHash = new SeparateChainingHash<Integer,String>(500);
	}

	public void testPut(){
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0 ; i < 500 ; i++) 
		{
			pruebaHash.put(i ,"a" + Integer.toString(i));
		}
		assertEquals("No fueron insertadas todas las llaves ", 500, pruebaHash.size());

	}

	public void testRehash(){
		try {
			setup();
			testPut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = pruebaHash.size() ; i < 500; i++) 
		{
			pruebaHash.put(i ,"a" + i);
		}
		assertEquals("El tamaño debería haberse modificado", 1000, pruebaHash.size());
	}

	public void testGet(){
		try {
			setup();
			testPut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String prueba = pruebaHash.get(0);

		assertEquals("Deberia haber retornado el string correcto", "a0", prueba);
	}

	public void testKeys(){
		int cantidad = 0;
		try {
			setup();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (pruebaHash.keys().hasNext()){
			pruebaHash.keys().next();
			cantidad++;
		}
		assertEquals("Debería estar la totalidad de las llaves", cantidad, pruebaHash.size());
	}


}
