package model.vo;

/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> 
{

	// TODO Definir los atributos de una infraccion


	private String objectId;
	private String location;
	private String ticketIssueDate;
	private String totalPaid;
	private String accidentIndicator;
	private String violationDescription;


	/**
	 * constructor
	 */
	public VOMovingViolation(String pObjectId, String pLocation, String pTicketIssueDate, String pTotalPaid, String pAccidentIndicator,String pViolationDescription){
		objectId = pObjectId;
		location=pLocation;
		ticketIssueDate=pTicketIssueDate;
		totalPaid = pTotalPaid;
		accidentIndicator=pAccidentIndicator;
		violationDescription=pViolationDescription;
	}
	/**
	 * @return id 
	 */
	public String objectId() 
	{
		// TODO Auto-generated method stub
		return objectId;
	}	

	/**
	 * @return location 
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return date 
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketIssueDate;
	}

	/**
	 * @return totalPaid 
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return Integer.parseInt(totalPaid);
	}

	/**
	 * @return accidentIndicator 
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}

	/**
	 * @return description 
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return violationDescription;
	}

	@Override
	public int compareTo(VOMovingViolation o) 
	{
		// TODO implementar la comparacion "natural" de la clase
		int rta=ticketIssueDate.compareTo(o.getTicketIssueDate());
		if(rta==0)
		{
	        rta=objectId.compareTo(o.objectId);
		}
		
		return rta;
	}

	public String toString()
	{
		// TODO Convertir objeto en String (representacion que se muestra en la consola)
		return objectId + " - " + location + " - " + ticketIssueDate + " - " + totalPaid + "- " + violationDescription;
	}
}
