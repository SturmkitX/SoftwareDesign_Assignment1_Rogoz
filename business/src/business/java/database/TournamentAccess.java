package database;

import java.util.List;

import implementations.mysql.TournamentDAOImplem;
import interfaces.TournamentDAO;
import models.Tournament;

public final class TournamentAccess {
	
	private static TournamentDAO dao = new TournamentDAOImplem();
	
	private TournamentAccess() {
		
	}
	
	public static List<Tournament> getAllTournaments() {
		return dao.findAll();
	}
	
	public static Tournament getTournamentByName(String name) {
		return dao.findTournamentByName(name);
	}
	
	public static Tournament getTournamentById(int id) {
		return dao.findTournament(id);
	}
	
	public static void updateTournament(Tournament tournament) {
		dao.updateTournament(tournament);
	}
	
	public static void deleteTournament(int id) {
		dao.deleteTournament(id);
	}
}
