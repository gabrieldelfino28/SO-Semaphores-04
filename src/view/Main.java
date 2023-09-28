package view;

import controller.CorridaFormula;
import controller.Sorting;
import model.FormulaOne;

import java.util.concurrent.Semaphore;

public class Main {

    static Semaphore[] escudeira = new Semaphore[7];
    public static FormulaOne[] formula1 = new FormulaOne[14];

    public static void main(String[] args) {

        Thread[] carros = new CorridaFormula[14];
        for (int j = 0; j < 14; j++) {
            formula1[j] = new FormulaOne();
        }

        int id = 0;
        for (int i = 0; i < 7; i++) {
            escudeira[i] = new Semaphore(1);
            for (int j = 0; j < 2; j++) {
                formula1[id].carID = id;
                carros[id] = new CorridaFormula(id, escudeira[i], formula1[id]);
                carros[id].start();
                id++;
            }
        }
        for (Thread car : carros) {
            try {
                car.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Sorting sort = new Sorting();
        System.out.println("\n\nGrid da Corrida: \n");
        formula1 = sort.CarSort(formula1);
        int Colocacoes = 1;
        for (FormulaOne car : formula1) {
            System.out.println(Colocacoes + "o Lugar : " + car + " ");
            Colocacoes++;
        }

    }
}
