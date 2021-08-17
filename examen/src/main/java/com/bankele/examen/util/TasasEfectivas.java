package com.bankele.examen.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum TasasEfectivas {

    A("A",new BigDecimal(1),1,"ANUAL"),
    S("S",new BigDecimal(0.5),2,"SEMESTRAL"),
    C("C",new BigDecimal(0.33333333),3,"CUATRIMESTRAL"),
    T("T",new BigDecimal(0.25),4,"TRIMESTRAL"),
    B("B",new BigDecimal(0.16666667),6,"BIMENSUAL"),
    M("M",new BigDecimal(0.08333333),12,"MENSUAL");

    public String alias;
    public BigDecimal valor;
    public int numMensualidades;
    public String description;

    TasasEfectivas(String alias, BigDecimal valor, int numMensualidades, String description){
        this.alias = alias;
        this.valor = valor;
        this.numMensualidades = numMensualidades;
        this.description = description;
    }


    public static Optional<TasasEfectivas> getTasaEfectiva(String alias){
        return Arrays.stream(TasasEfectivas.values()).filter(tasasEfectivas -> tasasEfectivas.alias.equals(alias)).findFirst();
    }

}
