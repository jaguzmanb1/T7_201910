package controller;
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

import model.data.structures.ColaPrioridad;
import model.data.structures.Queue;
import model.vo.VOMovingViolation;
import view.MovingViolationsManagerView;

@SuppressWarnings("unused")
public class Controller
{
	private MovingViolationsManagerView view ;

	// TODO Definir las estructuras de datos para cargar las infracciones del periodo definido
	private Queue<VOMovingViolation> colaInfracciones ;

	// Muestra obtenida de los datos cargados
	Comparable<VOMovingViolation> [ ] muestra ;

	// Copia de la muestra de datos a ordenar
	Comparable<VOMovingViolation> [ ] muestraCopia ;

	ColaPrioridad<String, VOMovingViolation> colaPrioridad;

	private String[] listaMes;

	public Controller() {
		view = new MovingViolationsManagerView();

		listaMes = new String[]{"January" , "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
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

	public int loadMovingViolations(int pSemestre)
	{
		int limSup;
		int limInf;

		if ( pSemestre == 1 ){
			limSup = 6;
			limInf = 0;
		}
		else{
			limSup = 12;
			limInf = 6;
		}
		String dataFile;
		int anterior = 0;
		int totalMes = 0;

		try{
			for(int f = limInf ; f < limSup ; f++){
				dataFile = "." + File.separator + "data" + File.separator + "Moving_Violations_Issued_in_" + listaMes[f] + "_2018.csv";
				FileReader n1 = new FileReader(dataFile);
				CSVReader n2 = new CSVReaderBuilder(n1).withSkipLines(1).build();
				List <String[]> info = n2.readAll();

				for(int j = 0 ; j < info.size() ; j++){
					VOMovingViolation infraccion = new VOMovingViolation(info.get(f)[0], info.get(f)[2], info.get(f)[13],info.get(f)[9], info.get(f)[12], info.get(f)[15]);
					//colaPrioridad.insertar(infraccion.getAccidentIndicator(), infraccion);
					colaInfracciones.enqueue(infraccion);

				}
				n1.close();
				n2.close();

				if (anterior == 0){
					anterior = colaInfracciones.size();
					totalMes = colaInfracciones.size();
				}
				else{
					totalMes = colaInfracciones.size() - anterior;
					anterior = colaInfracciones.size();
				}

				view.printMensage(listaMes[f] + " - " + totalMes);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return colaInfracciones.size();

	}

	public VOMovingViolation darPorObjectId(String id){
		return arbolito.get(id);
	}


	public void run()
	{
		int nDatos = 0;
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
				view.printMensage("Dar semestre: ");
				Scanner semestre = new Scanner(System.in);
				int semestren = semestre.nextInt();
				nDatos = this.loadMovingViolations(semestren);

				view.printMensage("Numero infracciones cargadas:" + nDatos);
				break;

			case 2:
				break;

			case 3:
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