package main.java.com.examly.service;

import java.util.*;
import main.java.com.examly.entity.*;
public interface VehicleService {
    boolean addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int vehicleId);
    List<Vehicle> getAllVehicles();
    boolean updateVehicleStatus(int vehicleId,String status);
    boolean deleteVehicle(int vehicleId);
    List<Vehicle> searchVehicleByBrand(String brand);
    List<Vehicle> filterVehiclesByPriceRange(int mini,int maxi);
    List<Vehicle> sortVehiclesByPrice();

}
