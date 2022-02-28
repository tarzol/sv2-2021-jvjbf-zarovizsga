package shipping;

public interface Transportable {
    int getWeight();
    boolean isBreakable();
    int calculateShippingPrice();

    String getDestinationCountry();
}
