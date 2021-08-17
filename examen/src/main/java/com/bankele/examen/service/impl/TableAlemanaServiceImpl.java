package com.bankele.examen.service.impl;

import com.bankele.examen.dto.TablaAlemanaRequestDTO;
import com.bankele.examen.dto.TablaAlemanaResultDTO;
import com.bankele.examen.service.TableAlemanaService;
import com.bankele.examen.util.TasasEfectivas;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class TableAlemanaServiceImpl implements TableAlemanaService {
    private static BigDecimal TNA=new BigDecimal(5);

    @Override
    public Collection<TablaAlemanaResultDTO> getTableAlemana(TablaAlemanaRequestDTO requestDTO) {
        Collection<TablaAlemanaResultDTO> resultDTOS = new ArrayList<TablaAlemanaResultDTO>();

        TasasEfectivas tasaEfectiva = TasasEfectivas.getTasaEfectiva(requestDTO.getPeriodicidad()).get();

        BigDecimal interesEquivalente = tasaEfectiva.valor.multiply(TNA);

        BigDecimal capitalAmortizado = requestDTO.getMontoSolicitado().divide(new BigDecimal(tasaEfectiva.numMensualidades),1);;

        BigDecimal capitalVivo = requestDTO.getMontoSolicitado();

        TablaAlemanaResultDTO resultDTO;
        for(int x = tasaEfectiva.numMensualidades ; x>0 ; x--){
            resultDTO = new TablaAlemanaResultDTO();

            resultDTO.setCapitalAmortizado(capitalAmortizado);
            resultDTO.setInteres(capitalVivo.multiply(interesEquivalente).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_UP));
            resultDTO.setCuota(resultDTO.getCapitalAmortizado().add(resultDTO.getInteres()).setScale(2, BigDecimal.ROUND_UP));

            capitalVivo = capitalVivo.add(capitalAmortizado.negate());
            resultDTO.setCapitalVivo(capitalVivo);

            resultDTOS.add(resultDTO);
        }

        return resultDTOS;
    }
}
