package ec.edu.insteclrg.service.crud;

import ec.edu.insteclrg.domain.Service;
import ec.edu.insteclrg.domain.Username;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.dto.UsernameDTO;
import ec.edu.insteclrg.persistence.ServiceRepository;
import ec.edu.insteclrg.persistence.UsernameRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service

public class UsernameService extends GenericCrudServiceImpl<Username, UsernameDTO>

    {

        @Autowired
        private UsernameRepository repository;

        private ModelMapper modelMapper = new ModelMapper();

        @Override
        public Optional<Username> find(UsernameDTO dto) {
        return repository.findById(dto.getId());
    }

        @Override
        public UsernameDTO mapToDto(Username domain) {
        return modelMapper.map(domain, UsernameDTO.class);
    }

        @Override
        public Username mapToDomain(UsernameDTO dto) {
        return modelMapper.map(dto, Username.class);
    }

    }

