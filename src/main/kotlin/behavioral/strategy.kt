package behavioral

data class Route(
    // some route representation
    var data: String? = null
)

interface RouteStrategy {
    fun getRoute(x: Long, y: Long): Route
}

class CarRouteStrategy : RouteStrategy {
    override fun getRoute(x: Long, y: Long): Route {
        // some algorithm
        return Route(data = "car route")
    }
}

class PedestrianRouteStrategy : RouteStrategy {
    override fun getRoute(x: Long, y: Long): Route {
        // another algorithm
        return Route(data = "pedestrian route")
    }
}

class Navigator(
    private val strategy: RouteStrategy
) {
    fun calculateRoute(x: Long, y: Long): Route = strategy.getRoute(x, y)
}
