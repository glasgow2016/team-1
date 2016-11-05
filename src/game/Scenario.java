package game;

public interface Scenario {
	
	/* Creates the background*/	
	public void createBackground();
	
	/*Creates all the players*/	
	public void createPlayers();
	
	/*Creates the traffic lights(Green,Yellow,Red)*/
	public void createTrafficLight();
	
	/*Sets the quiz questions after the simulation is over*/
	public void setQuiz();
	
	

}
