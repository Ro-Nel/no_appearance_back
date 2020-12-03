package com.software.no_appearance_back.controller;


import com.software.no_appearance_back.bl.CategoriaBl;
import com.software.no_appearance_back.bl.MatchBl;
import com.software.no_appearance_back.domain.CategoriaEntity;
import com.software.no_appearance_back.domain.ClienteSubcategoriaEntity;
import com.software.no_appearance_back.domain.MatchEntity;
import com.software.no_appearance_back.domain.SubcategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
        List<MatchEntity> matchEntityList= matchBl.listarMatchesPorIdCliente(idCliente);
        return new ResponseEntity(matchEntityList, HttpStatus.ACCEPTED);
    }

}
