import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.stream.Collectors;
import java.util.*;
import models.ClassificationLevel;
// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(p -> p instanceof  ExperimentalPlane).map(p -> (ExperimentalPlane)p).collect(Collectors.toList());
    }
    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        return planes.stream().filter(p -> p instanceof ExperimentalPlane).map(p -> (ExperimentalPlane)p)
                .filter(p -> p.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED).collect(Collectors.toList());
    }
    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof  MilitaryPlane).map(p -> (MilitaryPlane)p).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof MilitaryPlane).map(p -> (MilitaryPlane)p)
                .filter(p->p.getType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof MilitaryPlane).map(p -> (MilitaryPlane)p)
                .filter(p -> p.getType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }
    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(p -> p instanceof PassengerPlane).map(p -> (PassengerPlane)p).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return planes.stream().map(p -> (PassengerPlane)p).max(new Comparator<PassengerPlane>() {
            public int compare(PassengerPlane o1, PassengerPlane o2) {
                return o1.getPassengersCapacity() - o2.getPassengersCapacity();
            }
        }).get();
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void printPlanes(Collection<? extends Plane> collection) {
        planes.stream().forEachOrdered(p -> System.out.println(p.toString()));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }



}
