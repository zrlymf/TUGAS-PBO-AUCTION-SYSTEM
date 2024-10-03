public class Lot {
    private int lotNumber;
    private String description;
    private Bid highestBid;

    public Lot(int lotNumber, String description) {
        this.lotNumber = lotNumber;
        this.description = description;
        this.highestBid = null;  // No bid initially
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public boolean placeBid(Bid newBid) {
        if (highestBid == null || newBid.getAmount() > highestBid.getAmount()) {
            highestBid = newBid;
            return true;
        }
        return false;
    }

    public boolean isSold() {
        return highestBid != null;
    }
}
