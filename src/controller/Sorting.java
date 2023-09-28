package controller;

import model.FormulaOne;

public class Sorting {
    public Sorting() {
        super();
    }

    public FormulaOne[] CarSort(FormulaOne[] formOne) {
        for (int i = 0; i < formOne.length; i++) {
            for (int j = 0; j < formOne.length - 1; j++) {
                if (formOne[j].bestTime > formOne[j + 1].bestTime) {
                    FormulaOne aux;
                    aux = formOne[j];
                    formOne[j] = formOne[j + 1];
                    formOne[j + 1] = aux;
                }
            }
        }
        return formOne;
    }
}
