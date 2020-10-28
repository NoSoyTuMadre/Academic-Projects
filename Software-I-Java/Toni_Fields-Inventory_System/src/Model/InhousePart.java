package Model;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class InhousePart extends Part {

    //declare fields
    private int machineId;

    //declare methods
    public InhousePart(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.setMachineId(machineId);
    }
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    public int getMachineId() {
        return machineId;
    }
}
