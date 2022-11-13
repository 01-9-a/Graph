package cpen221.mp2.spaceship;

import cpen221.mp2.controllers.GathererStage;
import cpen221.mp2.controllers.HunterStage;
import cpen221.mp2.controllers.Spaceship;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.ImGraph;
import cpen221.mp2.models.Link;
import cpen221.mp2.models.Planet;
import cpen221.mp2.models.PlanetStatus;
import cpen221.mp2.util.Heap;

import java.util.*;

/**
 * An instance implements the methods needed to complete the mission.
 */
public class MillenniumFalcon implements Spaceship {
    long startTime = System.nanoTime(); // start time of rescue phase

    /**
     * The spaceship is on the location given by parameter state.
     * Move the spaceship to Kamino and then return.
     * This completes the first phase of the mission.<br><br>
     * <p>
     * If the spaceship continues to move after reaching Kamino, rather than
     * returning, it will not count. A return from this procedure while
     * not on Kamino count as a failure.<br><br>
     * <p>
     * There is no limit to how many steps you can take, but the score is
     * directly related to how long it takes you to find Kamino.<br><br>
     * <p>
     * At every step, you know only the current planet's ID, the IDs of
     * neighboring planets, and the strength of the signal from Kamino
     * at each planet.<br><br>
     * <p>
     * In this stage of the game,<br>
     * (1) In order to get information about the current state, use
     * functions currentID(), neighbors(), and signal().<br><br>
     * <p>
     * (2) Use method onKamino() to know if your ship is on Kamino.<br><br>
     * <p>
     * (3) Use method moveTo(int id) to move to a neighboring planet
     * with the given ID. Doing this will change state to reflect the
     * ship's new position.
     */
    @Override
    public void hunt(HunterStage state) {
        while(!state.onKamino()) {
            //double signal = state.signal();
            PlanetStatus[] status = state.neighbors();
            List<PlanetStatus> statusList = new ArrayList<>(Arrays.stream(status).toList());
            //go to the planet with the strongest signal
            Collections.sort(statusList);
            Collections.reverse(statusList);
            state.moveTo(statusList.get(0).id());
        }
    }

    /**
     * The spaceship is on the location given by state. Get back to Earth
     * without running out of fuel and return while on Earth. Your ship can
     * determine how much fuel it has left via method fuelRemaining(), and how
     * much fuel is needed to travel on a link via link's fuelNeeded().<br><br>
     * <p>
     * Each Planet has some spice. Moving to a Planet automatically
     * collects any spice it carries, which increases your score. your
     * objective is to return to earth with as much spice as possible.<br><br>
     * <p>
     * You now have access to the entire underlying graph, which can be
     * accessed through parameter state. currentNode() and earth() return
     * planets of interest, and planets() returns a collection of
     * all planets in the graph.<br><br>
     * <p>
     * Note: Use moveTo() to move to a destination node adjacent to
     * your ship's current node.
     */
    @Override
    public void gather(GathererStage state) {
        ImGraph<Planet, Link> allPlanets = state.planetGraph();
        while(!state.currentPlanet().equals(state.earth())){
            Map<Planet, Link> map = allPlanets.getNeighbours(state.currentPlanet(), state.fuelRemaining());
            Planet nearestPlanet = map.keySet().stream().toList().get(0);
            int minLength = map.get(nearestPlanet).length();
            for (Planet planet : map.keySet()) {
                if(map.get(planet).fuelNeeded()<minLength) {
                    minLength = map.get(planet).fuelNeeded();
                    nearestPlanet = planet;
                }
            }
            //if pathLength(nearest planet, earth)<=fuelRemaining-length(current, nearest planet), go to the nearest planet
            if(allPlanets.pathLength(allPlanets.shortestPath(nearestPlanet, state.earth()))<=state.fuelRemaining()-minLength){
                state.moveTo(nearestPlanet);
            }
            else{
                List<Planet> pathToEarth = allPlanets.shortestPath(state.currentPlanet(), state.earth());
                for(Planet p: pathToEarth){
                    state.moveTo(p);
                }
            }
        }
    }
}