package main.java.com.examly.entity;

public class Vehicle {
    private int vehicleId;
    private String brand;
    private String model;
    private double price;
    private String type;
    private String status;

     public Vehicle() {
    }

    public Vehicle(int vehicleId, String brand, String model, double price, String type, String status) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.type = type;
        this.status = status;
    }
    public Vehicle( String brand, String model, double price, String type, String status) {
       
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.type = type;
        this.status = status;
    }
    
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", brand=" + brand + ", model=" + model + ", price=" + price
                + ", type=" + type + ", status=" + status + "]";
    }
     
    
    
}
