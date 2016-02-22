package server.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import server.entities.Passage;

public class PassageDAOImpl implements PassageDAO {

	private static ArrayList<Passage> passages;
	
	@Override
	public List<Passage> getAllPassages() {
		passages = new ArrayList<Passage>();
		passages.add(new Passage(3, 3, new Date(1995,2,2), new Date(1995,2,2), 3, 3));
		return passages;
	}
}
