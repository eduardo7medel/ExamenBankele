package com.bankele.examen.controller;

import com.bankele.examen.dto.TablaAlemanaRequestDTO;
import com.bankele.examen.dto.TablaAlemanaResultDTO;
import com.bankele.examen.service.TableAlemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class TablaAlemanaController {

    @Autowired
    TableAlemanaService tableAlemanaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/getTableAlemana")
    public @ResponseBody Collection<TablaAlemanaResultDTO> getTableAlemana(@RequestBody TablaAlemanaRequestDTO request){
        return tableAlemanaService.getTableAlemana(request);
    }

}
