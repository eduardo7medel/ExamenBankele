package com.bankele.examen.service;

import com.bankele.examen.dto.TablaAlemanaRequestDTO;
import com.bankele.examen.dto.TablaAlemanaResultDTO;

import java.util.Collection;

public interface TableAlemanaService {

    Collection<TablaAlemanaResultDTO> getTableAlemana(TablaAlemanaRequestDTO requestDTO);

}
