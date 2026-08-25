package controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClienteService;

// http://localhost:8080/v1/Cliente
// Inyeccion tipos: por metodo, por constructor, por atributo
@RestController //Comportamiento para API
@RequestMapping("/v1/Cliente")
@AllArgsConstructor
@RequiredArgsConstructor
public class ClienteController {
    //@Autowired
    private final ClienteService service;

    // Inyeccion por constructor
    /*public ClienteController(ClienteService service) {
        this.service = service;
    } */

    @GetMapping
    public Cliente serchCliente()
    {
        //service = new ClienteService();
        return service.validAndSave(10, "Gregory");
    }
}
