package Task7_1;

public class Car extends Vehicle {

    @Override
    double  profitability() {
        double fillingCapacity = getTicketsSold() / getPasangerCapacity();  // вычисляем наполняемость рейса
        double profitability;
        if(fillingCapacity <= 0.75) {                             // вычисляем рентабельность рейса
            profitability = (getTicketsSold() - getPasangerCapacity() * 0.75) / (getPasangerCapacity() * 0.75);
            System.out.println("Рентабельность составляет " + profitability + " %");
        }
        else {
            profitability = (getTicketsSold() - getPasangerCapacity() * 0.75) / (getPasangerCapacity() * 0.75);
            System.out.println("Рентабельность составляет " + profitability + " %");
        }
        return profitability;
    }

    @Override
    protected void chekFreeSeats() {
        if (getPasangerCapacity() > getTicketsSold()) {
            System.out.printf("В машине осталось %d свободных мест. %n", getPasangerCapacity() - getTicketsSold());
        } else {
            System.out.println("Свобдных мест не осталось.");
        }
    }
}
