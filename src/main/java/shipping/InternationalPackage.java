package shipping;

public class InternationalPackage implements Transportable{
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int calculateShippingPrice() {
        if (isBreakable()) {
            return 2400+10*distance;
        }
        return 1200+10*distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getShippingPrice() {
        if (isBreakable()) {
            return 2400+10*distance;
        }
        return 1200+10*distance;
    }
}


// Transportable internationalPackage = new InternationalPackage(15, false,"Germany",1300);
//assertEquals(15, internationalPackage.getWeight());
//        assertEquals("Germany", internationalPackage.getDestinationCountry());
//        assertFalse(internationalPackage.isBreakable());
//        assertEquals(14200, internationalPackage.calculateShippingPrice());