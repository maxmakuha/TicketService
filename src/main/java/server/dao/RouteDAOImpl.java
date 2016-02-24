package server.dao;

import java.util.ArrayList;
import java.util.List;
import server.entities.Route;

public class RouteDAOImpl implements RouteDAO {

	private static ArrayList<Route> routes;

	@Override
	public List<Route> getAllRoutes() {
		routes = new ArrayList<Route>();
		routes.add(new Route(1, 1, "150 km", "Kyiv", "Lviv"));
		routes.add(new Route(2, 2, "100 km", "Ternopil", "Odesa"));
		routes.add(new Route(3, 3, "300 km", "Kyiv", "Odesa"));
		routes.add(new Route(4, 4, "200 km", "Chernihiv", "Lviv"));
		routes.add(new Route(5, 5, "140 km", "Kharkiv", "Odesa"));
		return routes;
	}
}
