package ec.edu.insteclrg.controller.v1;


import ec.edu.insteclrg.domain.Username;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.UsernameDTO;
import ec.edu.insteclrg.service.crud.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/usuario/")
public class UsernameController {


    @Autowired
    UsernameService service;

    @PostMapping
    public ResponseEntity<Object> guardar(@RequestBody UsernameDTO dto) {
        service.save(dto);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> actualizar(@RequestBody UsernameDTO dtoBody, @PathVariable Long id) {
        UsernameDTO dto = new UsernameDTO();
        dto.setId(id);
        Optional<Username> domain = service.find(dto);
        UsernameDTO dtoUpdate = service.mapToDto(domain.get());
        dtoUpdate.setUsername(dtoBody.getUsername());
        service.update(dtoUpdate);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        List<UsernameDTO> list = this.service.findAll(new UsernameDTO());
        if (!list.isEmpty()) {
            ApiResponseDTO<List<UsernameDTO>> response = new ApiResponseDTO<>(true, list);
            return (new ResponseEntity<Object>(response, HttpStatus.OK));
        } else {
            return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        UsernameDTO dto = new UsernameDTO();
        dto.setId(id);
        Optional<Username> domain = service.find(dto);
        if (!domain.isEmpty()) {
            dto = service.mapToDto(domain.get());
            return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> eliminar(@RequestBody UsernameDTO dto) {
        Optional<Username> domain = service.find(dto);
        UsernameDTO dtoUpdate = service.mapToDto(domain.get());
        service.delete(dtoUpdate);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

}

