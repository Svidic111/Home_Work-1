package Task7_1;

public class Application {
    public static void main(String[] args) {
        Vehicle an2 = new AirJet();
        an2.setAvarageSpeed(180);
        an2.setCost(30);
        System.out.println("Стоимость билета составляет " + an2.getCost() + " грн.");
        an2.setPasangerCapacity(20);
        an2.setTicketsSold(15);
        an2.profitability();
        an2.raceTime(580);

        Vehicle sprinter1 = new Car();
        sprinter1.setAvarageSpeed(90);
        sprinter1.setCost(8);
        System.out.println("Стоимость билета составляет " + sprinter1.getCost() + " грн.");
        sprinter1.setPasangerCapacity(18);
        sprinter1.setTicketsSold(8);
        sprinter1.profitability();
        sprinter1.raceTime(450);

        Vehicle express1 = new Trian();
        express1.setAvarageSpeed(90);
        express1.setCost(5);
        System.out.println("Стоимость билета составляет " + express1.getCost() + " грн.");
        express1.setPasangerCapacity(48);
        express1.setTicketsSold(36);
        express1.profitability();
        express1.raceTime(580);

        Vehicle[] vehicles1 = new Vehicle[] {an2, sprinter1, express1};
        for (Vehicle vehicleArr : vehicles1) {
            vehicleArr.chekFreeSeats();
        }

    }
}
