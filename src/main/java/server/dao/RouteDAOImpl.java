package server.dao;

import java.util.ArrayList;
import java.util.List;
import server.entities.Route;

public class RouteDAOImpl implements RouteDAO {

	private static ArrayList<Route> routes;

	@Override
	public List<Route> getAllRoutes() {
		routes = new ArrayList<Route>();
		routes.add(new Route(3, 2, "3", "Kyiv", "Lviv"));
		return routes;
	}
}
