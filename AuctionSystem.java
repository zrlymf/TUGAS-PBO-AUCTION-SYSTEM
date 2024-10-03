import java.util.Scanner;

public class AuctionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auction auction = new Auction();

        // Allow user to add lots
        System.out.println("Enter the number of lots:");
        int numberOfLots = scanner.nextInt();
        scanner.nextLine();  // consume newline

        for (int i = 1; i <= numberOfLots; i++) {
            System.out.println("Enter description for lot " + i + ":");
            String description = scanner.nextLine();
            auction.addLot(new Lot(i, description));
        }

        // Bidding process
        while (auction.isOpen()) {
            System.out.println("Enter bidder's name:");
            String bidderName = scanner.nextLine();
            Person person = new Person(bidderName);

            System.out.println("Enter lot number to bid on:");
            int lotNumber = scanner.nextInt();

            System.out.println("Enter bid amount:");
            double bidAmount = scanner.nextDouble();
            scanner.nextLine();  // consume newline

            Lot lot = auction.getLotByNumber(lotNumber);
            if (lot != null) {
                boolean success = lot.placeBid(new Bid(person, bidAmount));
                if (success) {
                    System.out.println("Bid placed successfully.");
                } else {
                    System.out.println("Bid too low. Try again.");
                }
            } else {
                System.out.println("Lot number not found.");
            }

            System.out.println("Do you want to continue bidding? (yes/no)");
            String continueBidding = scanner.nextLine();
            if (continueBidding.equalsIgnoreCase("no")) {
                auction.closeAuction();
            }
        }

        scanner.close();
    }
}
