package model.vo;

/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> 
{

	// TODO Definir los atributos de una infraccion


	private String OBJECTID;
	private String LOCATION;
	private String TICKETISSUEDATE;
	private String XCOORD;
	private String YCOORD;
	private String ADDRESS_ID;
	private String STREETSEGID;
	


	/**
	 * constructor
	 */
	public VOMovingViolation(String pObjectId, String pLocation, String pTicketIssueDate, String pTotalPaid, String pAccidentIndicator,String pViolationDescription,String pXCOORD,String pYCOORD, String pADDRESS_ID, String pSTREETSEGID){
		OBJECTID = pObjectId;
		LOCATION=pLocation;
		TICKETISSUEDATE=pTicketIssueDate;
		XCOORD = pXCOORD;
		YCOORD = pYCOORD;
		ADDRESS_ID = pADDRESS_ID;
		STREETSEGID = pSTREETSEGID;
		
	}
	
	public String getSTREETSEGID() 
	{
		// TODO Auto-generated method stub
		return STREETSEGID;
	}
	
	public String getADDRESS_ID() 
	{
		// TODO Auto-generated method stub
		return ADDRESS_ID;
	}
	
	public String getYCOORD() 
	{
		// TODO Auto-generated method stub
		return YCOORD;
	}
	
	
	public String getXCOORD() 
	{
		// TODO Auto-generated method stub
		return XCOORD;
	}	
	
	/**
	 * @return id 
	 */
	public String getObjectid() 
	{
		// TODO Auto-generated method stub
		return OBJECTID;
	}	

	/**
	 * @return location 
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return LOCATION;
	}

	/**
	 * @return date 
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return TICKETISSUEDATE;
	}


	@Override
	public int compareTo(VOMovingViolation o) 
	{
		// TODO implementar la comparacion "natural" de la clase
		int rta= TICKETISSUEDATE.compareTo(o.getTicketIssueDate());
		if(rta==0)
		{
	        rta=OBJECTID.compareTo(o.OBJECTID);
		}
		
		return rta;
	}

}
