package main.java.com.examly.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import main.java.com.examly.entity.Vehicle;
import main.java.com.examly.util.DBConnectionUtil;

public class VehicleServiceImpl implements VehicleService {
    @Override
    public boolean addVehicle(Vehicle vehicle){

        if(vehicle.getBrand()==null || vehicle.getBrand().trim().isEmpty()){
            return false;
        }
        if(vehicle.getPrice()<0){
            return false;
        }

        String sql="INSERT INTO vehicles(brand,model,price,type,status) VALUES(?,?,?,?,?)";

        try(Connection con=DBConnectionUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,vehicle.getBrand());
            ps.setString(2, vehicle.getModel());
            ps.setDouble(3, vehicle.getPrice());
            ps.setString(4, vehicle.getType());
            ps.setString(4, vehicle.getStatus());
            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;

    }
    @Override 
    public Vehicle getVehicleById(int vehicleId){

        String sql="SELECT * FROM vehicles WHERE vehicleId=?";

        try(Connection con=DBConnectionUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,vehicleId);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                return new Vehicle(
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getDouble("price"),
                    rs.getString("type"),
                    rs.getString("status")
                );

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> li=new ArrayList<>();
        String sql="SELECT * FROM vehicles";

        try(Connection con=DBConnectionUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vehicle v=new Vehicle(
                    rs.getInt("vehicleId"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getDouble("price"),
                    rs.getString("type"),
                    rs.getString("status")
                );
                li.add(v);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return li;

    }
    @Override
    public boolean updateVehicleStatus(int vehicleId,String status){
        String sql="UPDATE vehicles SET status=? WHERE vehicleId=?";

        try(Connection con=DBConnectionUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,status);
            ps.setInt(2, vehicleId);
            return ps.executeUpdate()>0;
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;

    }
    @Override
    public boolean deleteVehicle(int vehicleId){
        String sql="DELETE FROM vehicles WHERE vehicleId=?";

        try(Connection con=DBConnectionUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1, vehicleId);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Vehicle> searchVehicleByBrand(String brand){
        List<Vehicle> li=new ArrayList<>();
        for(Vehicle v: this.getAllVehicles()){
            if(v.getBrand().toLowerCase().contains(brand.toLowerCase())){
                li.add(v);
            }
        }
        return li;
    }

    @Override
    public List<Vehicle> filterVehiclesByPriceRange(int mini,int maxi){
        List<Vehicle> li=new ArrayList<>();
        for(Vehicle v: this.getAllVehicles()){
            if(v.getPrice()>mini && v.getPrice()<maxi){
                li.add(v);
            }
        }
        return li;
    }
    
    @Override
    public List<Vehicle> sortVehiclesByPrice(){
        List<Vehicle> all=this.getAllVehicles();
        all.sort(Comparator.comparingDouble(Vehicle::getPrice));
        return all;
    }
     
}
