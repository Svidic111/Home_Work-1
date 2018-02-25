package Task7_2;

import Task7_1.Car;
import Task7_1.Vehicle;

public class Application2 {
    public static void main(String[] args) {
        Vehicle sprinter2 = new Car();
        sprinter2.setAvarageSpeed(100);
        sprinter2.setCost(8);
        System.out.println("Стоимость билета составляет " + sprinter2.getCost() + " грн.");
        sprinter2.setPasangerCapacity(18);
        sprinter2.setTicketsSold(16);
        // sprinter2.profitability();    // метод недоступен, т.к. он defaul package
        sprinter2.raceTime(300);
        // sprinter2.chekFreeSeats();    // не понятно, чему должен наследоватьть данный класс, что бы получить доступ к protected методу chekFreeSeats()???
    }
}
