package com.software.no_appearance_back.controller;


import com.software.no_appearance_back.bl.CategoriaBl;
import com.software.no_appearance_back.bl.ClienteBl;
import com.software.no_appearance_back.domain.CategoriaEntity;
import com.software.no_appearance_back.domain.ClienteEntity;
import com.software.no_appearance_back.domain.ClienteSubcategoriaEntity;
import com.software.no_appearance_back.domain.SubcategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    CategoriaBl categoriaBl;

    @Autowired
    public CategoriaController(CategoriaBl categoriaBl) {
        this.categoriaBl = categoriaBl;
    }


    @RequestMapping(value = "/listarcategorias", method = RequestMethod.GET)
    public ResponseEntity listarcategorias(){
        List<CategoriaEntity> categoriaEntityList= categoriaBl.listarcategorias();
        return new ResponseEntity(categoriaEntityList, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/listarsubcategorias/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity listarsubcategorias(@PathVariable(value = "idCategoria")int idCategoria) {
        List<SubcategoriaEntity> subcategoriaEntityList= categoriaBl.listarSubcategoriasPorIdCategoria(idCategoria);
        return new ResponseEntity(subcategoriaEntityList, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/clientesubcategoria/guardar", method = RequestMethod.POST)
    public ResponseEntity clientesubcategoriaGuardar(@RequestBody ClienteSubcategoriaEntity clienteSubcategoriaEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        categoriaBl.clientesubcategoriaGuardar(clienteSubcategoriaEntity);
        return new ResponseEntity("Creado", HttpStatus.CREATED);
    }

}
