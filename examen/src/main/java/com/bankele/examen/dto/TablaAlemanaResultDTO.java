package com.bankele.examen.dto;

import java.math.BigDecimal;

public class TablaAlemanaResultDTO {

    private BigDecimal cuota;
    private BigDecimal interes;
    private BigDecimal capitalAmortizado;
    private BigDecimal capitalVivo;

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getCapitalAmortizado() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(BigDecimal capitalAmortizado) {
        this.capitalAmortizado = capitalAmortizado;
    }

    public BigDecimal getCapitalVivo() {
        return capitalVivo;
    }

    public void setCapitalVivo(BigDecimal capitalVivo) {
        this.capitalVivo = capitalVivo;
    }
}
