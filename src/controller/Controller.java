package controller;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data.structures.Queue;
import model.data.structures.RedBlackBST;
import model.vo.VOMovingViolation;
import view.MovingViolationsManagerView;

@SuppressWarnings("unused")
public class Controller
{
	private RedBlackBST<String, VOMovingViolation> arbol;

	private MovingViolationsManagerView view ;

	// TODO Definir las estructuras de datos para cargar las infracciones del periodo definido
	private Queue<VOMovingViolation> colaInfracciones ;

	// Muestra obtenida de los datos cargados
	Comparable<VOMovingViolation> [ ] muestra ;

	// Copia de la muestra de datos a ordenar
	Comparable<VOMovingViolation> [ ] muestraCopia ;


	private String[] listaMes;

	public Controller() {
		view = new MovingViolationsManagerView();
		
		arbol = new RedBlackBST<String, VOMovingViolation>();

		listaMes = new String[]{"January" , "February", "March", "April", "May", "June"};
		colaInfracciones  =  new Queue<VOMovingViolation>() ;
	}


	/**
	 * Leer los datos de las infracciones de los archivos. Cada infraccion debe ser Comparable para ser usada en los ordenamientos.
	 * Todas infracciones (MovingViolation) deben almacenarse en una Estructura de Datos (en el mismo orden como estan los archivos)
	 * A partir de estos datos se obtendran muestras para evaluar los algoritmos de ordenamiento
	 * @return numero de infracciones leidas
	 */
	/**
	 * Leer los datos de las infracciones de los archivos. Cada infraccion debe ser Comparable para ser usada en los ordenamientos.
	 * Todas infracciones (MovingViolation) deben almacenarse en una Estructura de Datos (en el mismo o archivos)
	 * A partir de estos datos se obtendran muestras para evaluar los algoritmos de ordenamiento
	 * @return numero de infracciones leidas rden como estan los
	 */

	public int loadMovingViolations()
	{
		Gson gson = new Gson();
		JsonReader reader = null;
		try {        
			VOMovingViolation[] reviews = null;
			for( int i = 0 ; i < 5 ; i++){
				reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_"+ listaMes[i] + "_2018.json"));
				reviews = gson.fromJson(reader, VOMovingViolation[].class);
				view.printMensage("Se cargaron " + reviews.length + " registros del mes de " + listaMes[i]);
				for(int j = 0; j < reviews.length; j++)
				{
					arbol.put(reviews[j].getObjectid(), reviews[j]);
				}
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return arbol.size();
	}

	public VOMovingViolation darPorObjectId(String id){
		return arbol.get(id);
	}
	
	public Queue<VOMovingViolation> darPorObjectIdRango(String idInicial, String idFinal){
		Queue<VOMovingViolation> violations = new Queue<VOMovingViolation>();
		for (String key : arbol.keys(idInicial, idFinal)){
			violations.enqueue(arbol.get(key));
		}
		return violations;
	}


	public void run()
	{
		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 1:
				// Cargar infracciones
				int suma = 0;
				int nDatos = this.loadMovingViolations();

				view.printMensage("Numero infracciones cargadas:" + nDatos);
				break;

			case 2:
				Scanner sc1 = new Scanner(System.in);
				view.printMensage("ObjectID: ");
				String id = sc1.nextLine();
				VOMovingViolation object = this.darPorObjectId(id);
				view.printDatosMuestra(object.getLocation(), object.getADDRESS_ID(), object.getSTREETSEGID(), object.getXCOORD(), object.getYCOORD(), object.getTicketIssueDate());
				break;

			case 3:
				Scanner sc2 = new Scanner(System.in);
				view.printMensage("ObjectID menor: ");
				String idInicial = sc2.nextLine();
				
				view.printMensage("ObjectID mayor: ");
				String idFinal = sc2.nextLine();
				
				Queue<VOMovingViolation> violations = this.darPorObjectIdRango(idInicial, idFinal);
				
				for (VOMovingViolation violation : violations){
					view.printDatosMuestra(violation.getLocation(), violation.getADDRESS_ID(), violation.getSTREETSEGID(), violation.getXCOORD(), violation.getYCOORD(), violation.getTicketIssueDate());
				}
				
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				break;

			case 8:
				break;

			case 9:
				break;

			case 10:
				fin=true;
				sc.close();
				break;
			}
		}
	}

}