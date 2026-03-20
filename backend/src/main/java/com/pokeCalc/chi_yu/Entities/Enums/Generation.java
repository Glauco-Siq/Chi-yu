package com.pokeCalc.chi_yu.Entities.Enums;

public enum Generation {
    GEN_1(1),
    GEN_2(2),
    GEN_3(3),
    GEN_4(4),
    GEN_5(5),
    GEN_6(6),
    GEN_7(7),
    GEN_8(8),
    GEN_9(9),
    GEN_10(10);
    //Add aqui nova geracao

    private final int number;

    Generation(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
