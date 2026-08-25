package service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import model.Cliente;
import repository.ClienteRepository;

@Service //Estereotipo
@AllArgsConstructor
@RequiredArgsConstructor
public class ClienteService {
    //@Autowired
    private final ClienteRepository repo;
    private  String texto;
    private Integer number1;
    // Inyeccion de dependencias por constructor
    /*public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }*/git

    public Cliente validAndSave(Integer idCliente, String firstName)
    {
        if(idCliente != null || firstName !=null)
        {
            //repo = new ClienteRepository();
            return repo.searchCliente(idCliente, firstName);
        }
        else
        {
            return new Cliente( 0, "DEFAULT");
        }
    }
}
