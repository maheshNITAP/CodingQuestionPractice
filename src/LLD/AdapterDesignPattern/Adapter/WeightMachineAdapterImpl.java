package LLD.AdapterDesignPattern.Adapter;

import LLD.AdapterDesignPattern.Adaptee.WeightMachine;
import LLD.AdapterDesignPattern.Adaptee.WeightMachineForBabies;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;
    public WeightMachineAdapterImpl (WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPounds = weightMachine.getWeightInPounds();
        double weightInKg = weightInPounds * 0.453592; // Convert pounds to kg
        return weightInKg;
    }
}
