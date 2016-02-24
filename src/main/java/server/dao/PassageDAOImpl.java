package server.dao;

import java.util.ArrayList;
import java.util.List;

import server.entities.Passage;

public class PassageDAOImpl implements PassageDAO {

	private static ArrayList<Passage> passages;
	
	@Override
	public List<Passage> getAllPassages() {
		passages = new ArrayList<Passage>();
		passages.add(new Passage(1, 3, "2016.02.02", "2016.02.03", 3, 3));
		passages.add(new Passage(2, 3, "2016.02.03", "2016.02.04", 10, 5));
		passages.add(new Passage(3, 3, "2016.02.05", "2016.02.06", 8, 1));
		passages.add(new Passage(4, 3, "2016.02.07", "2016.02.08", 2, 5));
		passages.add(new Passage(5, 3, "2016.02.09", "2016.02.10", 15, 6));
		return passages;
	}
}
