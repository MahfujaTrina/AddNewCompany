package Kalpika;

public class CustomerIntegrity {
    private int year;
    private double percentage;
    private int numberOfFlights;

    public CustomerIntegrity(int year, double percentage, int numberOfFlights) {
        this.year = year;
        this.percentage = percentage;
        this.numberOfFlights = numberOfFlights;
    }

    // Getters and Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }
}
