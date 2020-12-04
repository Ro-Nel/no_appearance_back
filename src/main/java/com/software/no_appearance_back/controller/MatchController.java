package com.software.no_appearance_back.controller;


import com.software.no_appearance_back.bl.MatchBl;
import com.software.no_appearance_back.domain.MatchSubcategoriaEntity;
import com.software.no_appearance_back.domain.MatchiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    MatchBl matchBl;

    @Autowired
    public MatchController(MatchBl matchBl) {
        this.matchBl = matchBl;
    }



    @RequestMapping(value = "/listarmatches/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity listarMatchesPorIdCliente(@PathVariable(value = "idCliente")int idCliente) {
        List<MatchiEntity> matchEntityList= matchBl.listarMatchesPorIdCliente(idCliente);
        return new ResponseEntity(matchEntityList, HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/matchdetalle/{idCliente1}/{idCliente2}", method = RequestMethod.GET)
    public ResponseEntity matchDetallePorIdClientes(@PathVariable(value = "idCliente1")int idCliente1, @PathVariable(value = "idCliente2")int idCliente2) {
        List<MatchSubcategoriaEntity> matchSubcategoriaEntityList= matchBl.matchDetallePorIdClientes(idCliente1,idCliente2);
        return new ResponseEntity(matchSubcategoriaEntityList, HttpStatus.ACCEPTED);
    }


}
