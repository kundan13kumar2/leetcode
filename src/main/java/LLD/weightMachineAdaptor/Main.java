package LLD.weightMachineAdaptor;

import LLD.weightMachineAdaptor.Adaptor.WeightAdaptor;
import LLD.weightMachineAdaptor.Adaptor.WeightAdaptorImpl;
import LLD.weightMachineAdaptor.babyWeightmachine.WeightMachineImpl;

public class Main {
    public static void main(String[] args) {

        WeightAdaptor weightAdaptor = new WeightAdaptorImpl(new WeightMachineImpl());
        System.out.println(weightAdaptor.getWeightInKg());
    }
}
