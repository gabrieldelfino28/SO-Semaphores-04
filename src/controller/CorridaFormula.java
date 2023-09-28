package controller;

import model.FormulaOne;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CorridaFormula extends Thread {

    private int carID;
    private Semaphore escudeira;
    private static Semaphore circuito = new Semaphore(5);
    private Random random = new Random();
    private FormulaOne formOne;

    public CorridaFormula(int carID, Semaphore escudeira, FormulaOne formOne) {
        this.carID = carID;
        this.escudeira = escudeira;
        this.formOne = formOne;
    }

    @Override
    public void run() {
        try {
            escudeira.acquire();
            circuito.acquire();
            Circuito();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            escudeira.release();
            circuito.release();

        }
    }

    private void Circuito() {

        for (int i = 0; i < 3; i++) {
            float timeInSeconds = random.nextFloat(20F, 90F);
            formOne.eachLap[i] = timeInSeconds;
            System.err.println("Carro #" + carID + " completou a " + (i + 1) + "a volta em "+formOne.eachLap[i] + " segundos!");
        }
            formOne.bestTime = formOne.eachLap[0];
        for (int j = 0; j < 3; j++){
            if (formOne.eachLap[j] < formOne.bestTime) {
                formOne.bestTime = formOne.eachLap[j];
            }
        }
        System.err.println("\nMelhor tempo do Carro #" +carID+ " é de "+ formOne.bestTime+ " segundos");
    }
}
