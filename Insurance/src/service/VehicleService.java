package service;

import model.Accident;
import model.ColorTypeEnum;
import model.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VehicleService {
    public Vehicle createVehicle(String brand, String model, String plate, String chassisNumber, int modelYear, ColorTypeEnum color){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setPlate(plate);
        vehicle.setChassisNumber(chassisNumber);
        vehicle.setModelYear(modelYear);
        vehicle.setColor(color);
        return vehicle;
    }

    public void addAccidentToVehicle(Vehicle vehicle, Accident accident){
        if(vehicle.getAccidentList() != null){
            vehicle.getAccidentList().add(accident);
        } else {
            ArrayList<Accident> accidents = new ArrayList<>();
            accidents.add(accident);
            vehicle.setAccidentList(accidents);
        }

    }

    public BigDecimal totalOfAccidentDamagePrice(Vehicle vehicle){
        BigDecimal total = BigDecimal.ZERO;
        if (vehicle.getAccidentList() != null){
            for (Accident accident: vehicle.getAccidentList()){
                total = total.add(accident.getDamagePrice());
            }
            return total;
        } else {
            System.out.println("Araçta kaza bulunmamaktadır");
            return total;
        }


    }
}
