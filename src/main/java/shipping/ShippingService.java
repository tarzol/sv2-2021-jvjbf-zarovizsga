package shipping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable newPackage) {
        packages.add(newPackage);
    }

    //List<Transportable> result = shippingService.collectItemsByBreakableAndWeight(true,21
    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable,int weight) {
        List<Transportable> result = new ArrayList<>();
        for ( Transportable actualPackage : packages) {
            if (actualPackage.getWeight() > weight ) {
                result.add(actualPackage);
            }
        }
        return result;
    }


    public Map<String, Integer> collectTransportableByCountry() {
        String destination = null;
        Map<String , Integer> result = new TreeMap<>();
        for ( Transportable actualPackage : packages ) {
//            if ( actualPackage instanceof NationalPackage) {
//                destination = "Hungary";
//            }
//            if ( actualPackage instanceof InternationalPackage ) {
//                destination = (InternationalPackage)actualPackage.getDestinationCountry();
//            }
            if ( !result.containsKey(actualPackage.getDestinationCountry())) {
                result.put(actualPackage.getDestinationCountry(), 1);
            }
            result.put(actualPackage.getDestinationCountry(), result.get(actualPackage.getDestinationCountry()+1));
        }
        return result;
    }

//    public sortInternationalPackagesByDistance() {
//
//    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
