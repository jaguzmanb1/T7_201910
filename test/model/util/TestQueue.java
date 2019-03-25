package model.util;

import model.data.structures.Queue;
import static org.junit.Assert.fail;
import java.util.Iterator;
import junit.framework.TestCase;



public class TestQueue extends TestCase{
	
	private Queue<Integer> colaPrueba;
	
	public void setup1() {
		try{
			colaPrueba = new Queue<Integer>();
			
			colaPrueba.enqueue(1);
			colaPrueba.enqueue(2);
			colaPrueba.enqueue(3);
			colaPrueba.enqueue(4);
			colaPrueba.enqueue(5);

		}
		catch (Exception e) { 
			fail("No se pudieron inicializar las colas");
		}

	}
	
	public void testIsEmpty() {
		setup1();

		assertFalse("La cola no está vacia, debería ser falso", colaPrueba.isEmpty());

		colaPrueba.dequeue();
		colaPrueba.dequeue();
		colaPrueba.dequeue();
		colaPrueba.dequeue();
		colaPrueba.dequeue();

		assertTrue("La cola está vacía, debería ser verdadero", colaPrueba.isEmpty());
	}
	
	public void testEnqueue(){
		setup1();

		colaPrueba.enqueue(9);

		boolean encontro = false;
		for(int numero : colaPrueba){
			if(numero == 9)
				encontro = true;
		}
		assertTrue("Deberia haber encontrado el elemento", encontro);
	}
	
	public void testDequeue()
	{
		setup1();

		int numeroPrueba = colaPrueba.dequeue();

		assertEquals("Deberia haber retornado el primer numero de la cola", 1, numeroPrueba);

		boolean encontro = false;
		for(int numero : colaPrueba){
			if(numero == 9)
				encontro = true;
		}

		assertFalse("No deberia haberlo encontrado ", encontro);
	}

	
	public void testSize(){
		setup1();

		assertTrue("Este no es el tamaño inicial de la cola", colaPrueba.size() == 5);

		colaPrueba.dequeue();

		assertTrue("Después de eliminar un dato, este no es el tamaño de la cola", colaPrueba.size() == 4);
		
		colaPrueba.enqueue(6);
		colaPrueba.enqueue(7);
		
		assertTrue("Se agregaron dos datos, este no es el tamaño de la cola", colaPrueba.size() == 6);

	}

	
	public void testIterator() {
		setup1();

		int primerNumero = colaPrueba.iterator().next();

		assertEquals("El numero debería ser 1 ", 1, primerNumero);
	}
	
	
}
