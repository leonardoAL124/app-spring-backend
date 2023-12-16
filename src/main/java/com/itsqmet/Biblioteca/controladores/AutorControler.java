package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.entidades.Libro;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorControler {

    @Autowired
    AutorRepository autorRepository;

    // READ
    @GetMapping("/autores")
    public String autor(Model model){

        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);

        return "/autor/autor";
    }

    // CREAR
    @GetMapping("/autor/form")
    public String formulario(Model model){
        model.addAttribute("autor", new Autor());

        return "/autor/formulario";
    }

    @PostMapping("/autor/form")
    public String crear( Autor autor){
       autorRepository.save(autor);
        return "redirect:/autores";
    }

    /////ACTUALIZAR
    @GetMapping("/autor/editar/{id}")
    public String actualizar(@PathVariable int id, Model model){

        Optional<Autor> autor = autorRepository.findById(id);
        model.addAttribute("autor", autor);

        return "autor/formulario";
    }


    //Eliminar
    @GetMapping("/autor/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        autorRepository.deleteById(id);

        return "redirect:/autores";

    }

}
