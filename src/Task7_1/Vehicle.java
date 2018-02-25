package Task7_1;

public class Vehicle {

    private int pasangerCapacity;
    private int avarageSpeed;
    private int ticketsSold;
    private double cost;

    public void setCost(double costKoef) {
        this.cost = costKoef * Ticket.getCost();
    }

    public void setPasangerCapacity(int pasangerCapacity) {
        this.pasangerCapacity = pasangerCapacity;
    }

    public void setAvarageSpeed(int avarageSpeed) {
        this.avarageSpeed = avarageSpeed;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public int getPasangerCapacity() {
        return pasangerCapacity;
    }

    public int getAvarageSpeed() {
        return avarageSpeed;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public double getCost() {
        return cost;
    }

    public void raceTime(int disance) {
        double raceTime = disance / getAvarageSpeed();
        System.out.println("Расчетное время в пути " + raceTime + " часов.");
    }

    protected void chekFreeSeats() {
        if (getPasangerCapacity() > getTicketsSold()) {
            System.out.printf("Осталось %d свободных мест. %n", getPasangerCapacity() - getTicketsSold());
        } else {
            System.out.println("Свобдных мест не осталось.");
        }
    }

    double profitability() {
        double fillingCapacity = getTicketsSold() / getPasangerCapacity();  // вычисляем наполняемость рейса
        double profitability = 0;
        if (fillingCapacity <= 0.65) {                             // вычисляем рентабельность рейса
            profitability = (getTicketsSold() - getPasangerCapacity() * 0.65) / (getPasangerCapacity() * 0.65);
            System.out.println("Рентабельность составляет " + profitability + " %");
        }
        else if(fillingCapacity > 0.65){
            profitability = 1 + (getTicketsSold() - getPasangerCapacity() * 0.65) / (getPasangerCapacity() * 0.65);
            System.out.println("Рентабельность составляет " + profitability + " %");
        }
        return profitability;
    }
}
