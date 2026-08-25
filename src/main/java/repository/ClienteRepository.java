package repository;

import model.Cliente;
import org.springframework.stereotype.Repository;

@Repository //Estereotipo
public class ClienteRepository {
    public Cliente searchCliente(Integer id, String firsName)
    {
        return new Cliente(id,firsName);
    }
}
