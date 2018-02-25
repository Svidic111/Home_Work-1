package Task7_1;

public class Trian extends Vehicle{
    @Override
    protected void chekFreeSeats() {
        if (getPasangerCapacity() > getTicketsSold()) {
            System.out.printf("В вагоне поезда есталось %d свободных мест. %n", getPasangerCapacity() - getTicketsSold());
        } else {
            System.out.println("Свобдных мест не осталось.");
        }
    }
}
