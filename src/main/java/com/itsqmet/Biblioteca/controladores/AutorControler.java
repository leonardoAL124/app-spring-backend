package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AutorControler {

    @Autowired
    AutorRepository autorRepository;

    // READ
    @GetMapping("/autores")
    public String autor(Model model){

        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);

        return "autor/autor";
    }


    //Eliminar
    @GetMapping("/autor/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        autorRepository.deleteById(id);

        return "redirect:/autores";

    }

}
