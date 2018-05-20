package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import application.SeatButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;

/**
 * This class is the controller for the main flight attendant screen.
 * 
 * @author Roger Cruz <br>
 *         Date 5/2018
 */

public class SeatController
{
	/**
	 * Method that receives an ActionEvent from the View when a call button is
	 * clicked.
	 * 
	 * @param ActionEvent
	 */
	@FXML
	private void callFlightAttendant(ActionEvent event)
	{

		SeatButton seat = (SeatButton) event.getSource();

		seat.setOnMouseClicked(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event)
			{

				if (seat.isTurnedOn() == false)
				{
					seat.turnOn();
					seat.setStyle("-fx-background-color: #336699;" + "-fx-text-fill: #ffffff;");
					Glow glow = new Glow();
					glow.setLevel(0.9);
					seat.setEffect(glow);
					addButtonToList(seat.getText());
					callButtonArrayTracker.add(seat);

				}
				else if (seat.isTurnedOn() == true)
				{
					seat.turnOff();
					seat.setEffect(null);
					seat.setStyle("");
					callButtonArrayTracker.remove(seat);
					remove(seat.getText());

				}
			}
		});
	}

	/**
	 * Method that receives an ActionEvent from the View when the Delete Selected
	 * button is clicked.
	 * 
	 * @param ActionEvent
	 */
	@FXML
	private void removeCallFromList(ActionEvent event)
	{

		if (callingListView.getSelectionModel().getSelectedItem() == null)
		{
			// DO NOTHING
		}
		else
		{
			String seat = callingListView.getSelectionModel().getSelectedItem();
			remove(seat);
			depressCallButton(callButtonArrayTracker.get(iterateThroughList(seat)));
			callButtonArrayTracker.remove(iterateThroughList(seat));
		}

	}

	/**
	 * Method that receives an ActionEvent from the View when the Delete All button
	 * is clicked.
	 * 
	 * @param ActionEvent
	 */
	@FXML
	private void removeAllCallsFromList(ActionEvent event)
	{
		if (list.isEmpty() == true)
		{
			// Do NOTHING
		}
		else
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Removing All Call Attendance Alerts");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to clear the Alert List?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
			{
				Iterator<SeatButton> iterator = callButtonArrayTracker.iterator();

				while (iterator.hasNext())
				{
					depressCallButton(iterator.next());
				}
				callButtonArrayTracker.clear();
				list.clear();
			}
			else
			{
				alert.close();
			}
		}

	}

	/**
	 * Helper method for class. It turns off the call flight Attendant button at the
	 * seat location.
	 * 
	 * @param SeatButton
	 */
	private void depressCallButton(SeatButton seat)
	{
		seat.turnOff();
		seat.setEffect(null);
		seat.setStyle("");
	}

	/**
	 * Helper method for class. It iterates through the list in which each button is
	 * <br>
	 * stored if the button is turned on. If button is found, it returns the index
	 * of the button.
	 * 
	 * @param String
	 * @return int
	 */
	private int iterateThroughList(String seatName)
	{
		Iterator<SeatButton> iterator = callButtonArrayTracker.iterator();

		int counter = 0;
		boolean foundSeat = false;

		while (iterator.hasNext() && foundSeat == false)
		{

			if (iterator.next().getText().equals(seatName))
			{
				foundSeat = true;
			}
			else
			{
				counter++;
			}

		}
		return counter;

	}

	/**
	 * Helper method for class. It adds the the button to the Flight attendant
	 * observable array list <br>
	 * 
	 * @param String
	 */
	private void addButtonToList(String seat)
	{
		if (list.contains(seat))
		{
			// DO NOTHING
		}
		else
		{
			list = callingListView.getItems();
			list.add(seat);
		}

	}

	/**
	 * Helper method to remove the button from the ListView
	 */
	private void remove(String seat)
	{
		callingListView.getItems().remove(seat);
	}

	// PRIVATE DATA MEMBERS
	private ObservableList<String> list = FXCollections.observableArrayList();
	private ArrayList<SeatButton> callButtonArrayTracker = new ArrayList<>();

	// FXML DATA MEMBERS
	@FXML
	private ListView<String> callingListView;
	@FXML
	private SeatButton seat1;
	@FXML
	private SeatButton seat2;
	@FXML
	private SeatButton seat3;
	@FXML
	private SeatButton seat4;
	@FXML
	private SeatButton seat5;
}
