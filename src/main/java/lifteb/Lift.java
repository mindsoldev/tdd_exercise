package lifteb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lift {
    private final String id;
    private int floor;
    private HashSet<Integer> requests;
    private boolean doorsOpen;

    public Lift(String id, int floor, List<Integer> requests, boolean doorsOpen) {

        this.id = id;
        this.floor = floor;
        this.requests = new HashSet<>(requests);
        this.doorsOpen = doorsOpen;
    }

    public Lift(String id, int floor) {
        this(id, floor, new ArrayList<Integer>(), false);
    }

    public Lift(String id, int floor, List<Integer> requests) {
        this(id, floor, requests, false);
    }

    public Lift(String id, int floor, boolean doorsOpen) {
        this(id, floor, new ArrayList<Integer>(), doorsOpen);
    }

    public String getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasRequestForFloor(int floor) {
        return this.requests.contains(floor);
    }

    public boolean areDoorsOpen() {
        return doorsOpen;
    }

	public void tick() {
		if (requests.contains(this.floor)) {
			this.doorsOpen = true;
			this.requests.remove(this.floor);
		}
		else if (!requests.isEmpty()) {
			this.floor = getClosestFloor();
		}
	}

	private int getClosestFloor() {
		
		int closestFloor = Integer.MAX_VALUE;

		HashMap<Integer, Integer> map = (HashMap<Integer, Integer>)requests.stream()
				.collect(Collectors.toMap(x -> Math.abs(this.floor - x), x -> x));
		// ez kihasználja, hogy a HashMap a kulcsok (távolság) hash kódja szerint rendezett.
//		Entry<Integer, Integer> entry = map.entrySet().iterator().next();
//		closestFloor = entry.getValue();
		// ez megjeresi a legkissebb távolságot.
		closestFloor = Collections.min(map.entrySet(), Map.Entry.comparingByKey()).getValue();
		
//		for (Integer request : requests) {
//			if (Math.abs(this.floor - request) < Math.abs(this.floor - closestFloor)) {
//				closestFloor = request;
//			}
//		}
		return closestFloor;
	}
}
