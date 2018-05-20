package application;

import javafx.scene.control.Button;

/**
 * This class extends the Button class. It adds the behavior in which a button
 * is <br>
 * turned On or Off.
 * 
 * @author Roger Cruz <br>
 *         Date 5/2018
 */
public class SeatButton extends Button
{

	/**
	 * Method that represents the behavior of turning a button on.
	 */
	public void turnOn()
	{
		buttonOn = true;
	}

	/**
	 * Method that represents the behavior of turning a button off.
	 */
	public void turnOff()
	{
		buttonOn = false;
	}

	/**
	 * Method that returns the state in which the button is. Whether it is On or
	 * Off.
	 * 
	 * @return boolean
	 */
	public boolean isTurnedOn()
	{
		return buttonOn;
	}

	// PRIVATE DATA MEMBERS
	private boolean buttonOn = false;
}
