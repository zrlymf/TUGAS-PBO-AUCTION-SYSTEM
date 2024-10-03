import java.util.ArrayList;

public class Auction {
    private ArrayList<Lot> lots = new ArrayList<>();
    private boolean open = true;

    public void addLot(Lot lot) {
        lots.add(lot);
    }

    public void closeAuction() {
        open = false;
        for (Lot lot : lots) {
            if (lot.isSold()) {
                System.out.println("Lot " + lot.getLotNumber() + " (" + lot.getDescription() + ") sold to " + 
                    lot.getHighestBid().getBidder().getName() + " for $" + lot.getHighestBid().getAmount());
            } else {
                System.out.println("Lot " + lot.getLotNumber() + " (" + lot.getDescription() + ") remains unsold.");
            }
        }
    }

    public boolean isOpen() {
        return open;
    }

    public Lot getLotByNumber(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getLotNumber() == lotNumber) {
                return lot;
            }
        }
        return null;
    }
}
