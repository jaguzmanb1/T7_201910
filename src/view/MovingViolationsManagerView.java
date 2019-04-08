package view;

public class MovingViolationsManagerView 
{
	public MovingViolationsManagerView() {
		
	}
	
	public void printMenu() {
		System.out.println("------------- Estructuras de datos-----------------");
		System.out.println("---------------------Taller 6----------------------");
		System.out.println("1. Cargar datos de infracciones");
		System.out.println("2. Infraccion por OBJECT_ID");
		System.out.println("3. Infracciones por rango de OBJECT_ID");
		System.out.println("10. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	public void printDatosMuestra(String location, String address, String streeSeg, String xCord, String yCord, String date)
	{
		System.out.println(location + " - " + address + " - " + streeSeg + " - " + xCord + " - " + yCord + " - " + date);
	}
	
	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}
}
