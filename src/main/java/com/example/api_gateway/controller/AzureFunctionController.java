package com.example.api_gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("azure")
public class AzureFunctionController {


    private final RestTemplate restTemplate;

    public AzureFunctionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("users/{id}")
    public String obtenerUsuario( @PathVariable int id ) {
        String url = "https://vet-func.azurewebsites.net/func/usuario/" + id + "?code=S6hZLwDrKcsekZ0Hph264P3p_gqPuWlecc4XmIXY6F43AzFuqDyR0Q==";
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("users")
    public String guardarUsuario(@RequestBody String user) {
        String url = "https://vet-func.azurewebsites.net/func/usuario?code=FxtddeDbuYFNKB9Bbb6z_dXKcQhJWvpqOc3Apci7ymqfAzFu7vli0g==";
        return restTemplate.postForObject(url, user, String.class);

    }

    @PutMapping("users/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String usuario) {
        String url = "https://vet-func.azurewebsites.net/func/usuario/"+id+"?code=qIeUjwspRBZpZXNUwhkT2Ic_4hDVkioUOPdfB4AFuPvaAzFu144OjQ==";
        restTemplate.put(url, usuario );
        return "Libro actualizado con ID: " + id;
    }

    @DeleteMapping("users/{id}")
    public String deleteLibro(@PathVariable int id) {
        String url = "https://vet-func.azurewebsites.net/func/usuario/"+id+"?code=D3wze9BUfctRSdpInCYnR8Bey60djytxHNFF0Dpw5MSHAzFu7F-ExQ==";
        restTemplate.delete(url);
        return "Libro eliminado con ID: " + id;
    }

    @PostMapping("email")
    public String postMethodName(@RequestBody String payload) {
       
        String url = "https://vet-func.azurewebsites.net/func/SendEmail";
        return restTemplate.postForObject(url, payload, String.class);        
    }
}
