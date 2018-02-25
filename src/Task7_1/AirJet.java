package Task7_1;

public class AirJet extends Vehicle {

    @Override
    public void raceTime(int disance) {
        double raceTime = 1.5 + disance / getAvarageSpeed();
        System.out.println("Расчетное время в пути " + raceTime + " часов.");
    }

    @Override
    protected void chekFreeSeats() {
        if (getPasangerCapacity() > getTicketsSold()) {
            System.out.printf("В самолете осталось %d свободных мест. %n", getPasangerCapacity() - getTicketsSold());
        } else {
            System.out.println("Свобдных мест не осталось.");
        }
    }
}
