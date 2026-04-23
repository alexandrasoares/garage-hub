package alexandrazinha.App.service;

import alexandrazinha.App.domain.Cliente;
import alexandrazinha.App.domain.ClienteDTO;
import alexandrazinha.App.exceptions.ClienteNaoEncontradoException;
import alexandrazinha.App.repository.ClienteRepository;
import org.antlr.v4.runtime.atn.PrecedencePredicateTransition;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ModelMapper mapper;

    public ClienteDTO pegarById(Long id){

        Cliente cliente = repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException("não tem essa cara aqui"));
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO salvarCliente(ClienteDTO dto){
        repository.save(mapper.map(dto, Cliente.class));
        return dto;
    }

}
