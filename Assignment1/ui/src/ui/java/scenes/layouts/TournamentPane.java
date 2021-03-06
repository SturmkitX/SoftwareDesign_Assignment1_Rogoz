package scenes.layouts;

import java.util.ArrayList;
import java.util.List;

import database.TournamentAccess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import models.Match;
import models.Tournament;
import session.UserSession;
import starter.MainScreen;

public class TournamentPane extends GridPane {
	
	// the tournaments select should be automatically done
	// insert should be present on an empty spot
	// update and delete after selecting a tournament
	// all of these are possible only if the logged in used is an admin
	
	private List<Tournament> tournaments;
	private Button addTournamentBtn;
	private List<Text> tournamentTexts;
	private int rows, cols;
	private Button prevPage, nextPage;
	
	public TournamentPane() {
		super();
		setAlignment(Pos.CENTER);
		setHgap(20);
		setVgap(20);
		
		setPadding(new Insets(25, 25, 25, 25));
		
		MainScreen.getStage().setTitle("Tournament list");
		
		// show at most 3 tournaments per row
		setUpTournamentView();
		TournamentListHandler tlh = new TournamentListHandler();
		
		addTournamentBtn.setOnAction(new ActionHandler());
		for(Text t : tournamentTexts) {
			t.setOnMousePressed(tlh);
		}
		
		
	}
	
	private void setUpTournamentView() {
		tournaments = TournamentAccess.getAllTournaments();
		tournamentTexts = new ArrayList<Text>();
		rows = cols = 0;
		
		for(Tournament t : tournaments) {
			Text tf = new Text(t.getName());
			tournamentTexts.add(tf);
			
			add(tf, cols, rows);
			cols++;
			if(cols == 3) {
				rows++;
				cols = 0;
			}
		}
		
		addTournamentBtn = new Button("Add Tournament");
		if(UserSession.getLoggedInUser().getIsAdmin()) {
			add(addTournamentBtn, cols, rows);
		}
		
		prevPage = new Button("Previous page");
		nextPage = new Button("Next page");
		
		TournamentPageHandler tph = new TournamentPageHandler();
		
		prevPage.setOnAction(tph);
		nextPage.setOnAction(tph);
		
		if(UserSession.getTournamentOffset() > 0) {
			add(prevPage, 1, rows + 2);
		}
		
		if(tournaments.size() == UserSession.getTournamentLimit()) {
			add(nextPage, 2, rows + 2);
		}
		
	}
	
	private class TournamentListHandler implements EventHandler<MouseEvent> {
		
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Text t = (Text) arg0.getSource();
			Tournament tournament = TournamentAccess.getTournamentByName(t.getText());
			
			UserSession.setActiveTournament(tournament);
			
			MainScreen.setScene(new Scene(new TournamentMatchPane(), 1024, 768));
		}
	}
	
	private class ActionHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent arg0) {
			TournamentAccess.insertTournament(new Tournament(0, "New Tournament", new ArrayList<Match>()));
			MainScreen.setScene(new Scene(new TournamentPane(), 1024, 768));
		}
	}
	
	private class TournamentPageHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {
			if(arg0.getSource() == prevPage) {
				UserSession.decrementTournamentOffset();
			} else if(arg0.getSource() == nextPage) {
				UserSession.incrementTournamentOffset();
			}
			
			MainScreen.setScene(new Scene(new TournamentPane(), 1024, 768));
			
		}
		
	}
	
}
