import java.util.ArrayList;

class Vehicle {
  private String plate;
  private String model;
  private int year;
  private static int totalVehicles;

  public Vehicle(String plate, String model, int year) {
    this.plate = plate;
    this.model = model;
    this.year = year;
    totalVehicles++;
  }

  public String getPlate() {
    return plate;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public static void getTotalVehicles() {
    System.out.println("Total vehicles: " + totalVehicles);
  }

  public double calculateDaily(int days) {
    return days;
  }

  public void showDetails() {
    System.out.println("Vehicle details: ");
    System.out.println("Plate: " + getPlate());
    System.out.println("Model: " + getModel());
    System.out.println("Year: " + getYear());
  }
}

class Car extends Vehicle {
  private int doors;

  public Car(String plate, String model, int year, int doors) {
    super(plate, model, year);
    this.doors = doors;
  }

  public int getDoors() {
    return doors;
  }

  @Override
  public double calculateDaily(int days) {
    return (days * 100) + (20 * doors);
  }

  @Override
  public void showDetails() {
    System.out.println("Car details: ");
    System.out.println("Plate: " + getPlate());
    System.out.println("Model: " + getModel());
    System.out.println("Year: " + getYear());
    System.out.println("Doors: " + getDoors());
  }
}

class Motorcycle extends Vehicle {
  private int cylinders;

  public Motorcycle(String plate, String model, int year, int cylinders) {
    super(plate, model, year);
    this.cylinders = cylinders;
  }

  public int getCylinders() {
    return cylinders;
  }

  @Override
  public double calculateDaily(int days) {
    return (days * 50) + (0.10 * cylinders);
  }

  @Override
  public void showDetails() {
    System.out.println("Motorcycle details: ");
    System.out.println("Plate: " + getPlate());
    System.out.println("Model: " + getModel());
    System.out.println("Year: " + getYear());
    System.out.println("Cylinders: " + getCylinders());
  }
}

class rentCompany {
  private String name;
  private ArrayList<Vehicle> cars;

  public rentCompany(String name) {
    this.name = name;
    cars = new ArrayList<Vehicle>();
  }

  public void addVehicle(Vehicle v) {
    cars.add(v);
  }

  public void listVehicles() {
    System.out.println("Vehicles List: ");
    for (Vehicle v : cars) {
      System.out.println(v.getPlate());
      System.out.println(v.getModel());
    }
  }

  public double calculateTotalValue(String plate, int days) {
    for (Vehicle v : cars) {
      if (v.getPlate().equals(plate)) {
        return v.calculateDaily(days);
      }
    }

    System.out.println("The plate selected was not found!");
    return -1;

  }

}

public class Main {
  public static void main(String[] args) {
    System.out.println("Starting Project...");

    Vehicle.getTotalVehicles();

    Car car1 = new Car("ABC-1313", "Fiat", 2006, 2);
    car1.showDetails();
    Vehicle.getTotalVehicles();

    Motorcycle motorcycle = new Motorcycle("CBA-1313", "Honda", 2025, 120);
    motorcycle.showDetails();
    Vehicle.getTotalVehicles();

    rentCompany company = new rentCompany("Company");
    company.addVehicle(car1);
    company.addVehicle(motorcycle);
    company.listVehicles();

    System.out.println("\n\nPlate: CBA-1313 \nTotal Value = " + company.calculateTotalValue("CBA-1313", 5));

  }
}