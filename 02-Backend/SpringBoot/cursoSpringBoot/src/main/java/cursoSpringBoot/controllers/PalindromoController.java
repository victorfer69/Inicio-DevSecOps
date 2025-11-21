package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para valdiar palindromo
 */
@RestController
public class PalindromoController {

    /**
     * Endpoint para verificar si una palabra es palindromo o no.
     * @param palabra para verificar
     * @return mensaje indicando si la palabra es o no palindromo.
     */
    @GetMapping(path = "/validar-palindromo/{palabra}")
    public String esPalindromo(@PathVariable String palabra){
        for(int i = 0; i < palabra.length()/2; i++){
            if(palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)){
                return ("La palabra " + palabra + " NO es palindromo");
            }
        }
        return ("La palabra " + palabra + " SI es palindromo");
    }

}
