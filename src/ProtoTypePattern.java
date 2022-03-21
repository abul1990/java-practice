import java.util.ArrayList;
import java.util.List;

public class ProtoTypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        VehiclePT a = new VehiclePT();
        a.addVehicles();
        VehiclePT b = a.clone();

        System.out.println("a >> " + a.getVehicleList());
        System.out.println("b >> " + b.getVehicleList());
        b.getVehicleList().add("new Apache");
        System.out.println("b add >> " + b.getVehicleList());
        b.getVehicleList().remove("Honda");
        System.out.println("b remove >> " + b.getVehicleList());
        System.out.println("still a >> " + a.getVehicleList());

    }
}

class VehiclePT implements Cloneable {

    private List<String> vehicleList;

    public VehiclePT() {
        this.vehicleList = new ArrayList<>();
    }

    public VehiclePT(List<String> list) {
        this.vehicleList = list;
    }

    public void addVehicles() {
        vehicleList.add("Honda");
        vehicleList.add("FZ");
        vehicleList.add("Alto");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    protected VehiclePT clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s : vehicleList) {
            temp.add(s);
        }
        return new VehiclePT(temp);
    }

}
