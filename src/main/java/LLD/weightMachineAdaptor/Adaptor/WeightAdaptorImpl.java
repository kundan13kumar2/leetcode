package LLD.weightMachineAdaptor.Adaptor;

import LLD.weightMachineAdaptor.babyWeightmachine.WeightMachine;

public class WeightAdaptorImpl implements WeightAdaptor {

    WeightMachine weightMachine;

    public WeightAdaptorImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        return weightMachine.getWeightInPound() * .45;
    }
}
