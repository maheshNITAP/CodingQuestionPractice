package LLD.AdapterDesignPattern.Client;

import LLD.AdapterDesignPattern.Adaptee.WeightMachine;
import LLD.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import LLD.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import LLD.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Client {
    public  static void main(String[] args) {
        // Create an instance of the adapter
        WeightMachine weightMachineForBabies =  new WeightMachineForBabies();
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(weightMachineForBabies);
        System.out.println("Weight in kg: " + weightMachineAdapter.getWeightInKg());
    }
}
