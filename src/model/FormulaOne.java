package model;

import java.util.Arrays;

public class FormulaOne {
    public int carID;
    public float bestTime;
    public float[] eachLap = new float[3];


    public FormulaOne() {
        super();
    }

    public FormulaOne(int carID, float bestTime, float[] eachLap) {
        this.carID = carID;
        this.bestTime = bestTime;
        this.eachLap = eachLap;
    }

    @Override
    public String toString() {
        String[] eachLapFormat = new String[3];
        int i = 0;

        for(float item : eachLap) {
            String value = String.format("%.2f", item);
            eachLapFormat[i] = value;
            i++;
        }

        return "Formula1 -> {" +
                "carID = " + carID +
                ", bestTime = " + String.format("%.2f", bestTime) + " seconds" +
                ", eachLap = " + Arrays.toString(eachLapFormat) + " seconds" +
                '}';
    }
}
