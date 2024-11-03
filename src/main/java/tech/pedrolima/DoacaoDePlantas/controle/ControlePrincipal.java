package tech.pedrolima.DoacaoDePlantas.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlePrincipal {

    @GetMapping("/")
    public String redirectToInicio() {
        return "redirect:/inicio";
    }


    @GetMapping("/inicio")
    public String acessarPrincipal(){
        return "home.html";
    }

}