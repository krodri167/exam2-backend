package ec.edu.insteclrg.service.crud;


import ec.edu.insteclrg.domain.Service;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.persistence.ServiceRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service

public class ServiceService extends GenericCrudServiceImpl<Service, ServicioDTO> {

    @Autowired
    private ServiceRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Service> find(ServicioDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public ServicioDTO mapToDto(Service domain) {
        return modelMapper.map(domain, ServicioDTO.class);
    }

    @Override
    public Service mapToDomain(ServicioDTO dto) {
        return modelMapper.map(dto, Service.class);
    }

}