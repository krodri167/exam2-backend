package ec.edu.insteclrg.controller.v1;

import ec.edu.insteclrg.domain.Service;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.service.crud.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/servicio/")
public class ServiceController {

    @Autowired
    ServiceService service;

    @PostMapping
    public ResponseEntity<Object> guardar(@RequestBody ServicioDTO dto) {
        service.save(dto);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> actualizar(@RequestBody ServicioDTO dtoBody, @PathVariable Long id) {
        ServicioDTO dto = new ServicioDTO();
        dto.setId(id);
        Optional<Service> domain = service.find(dto);
        ServicioDTO dtoUpdate = service.mapToDto(domain.get());
        dtoUpdate.setDescription(dtoBody.getDescription());
        service.update(dtoUpdate);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        List<ServicioDTO> list = this.service.findAll(new ServicioDTO());
        if (!list.isEmpty()) {
            ApiResponseDTO<List<ServicioDTO>> response = new ApiResponseDTO<>(true, list);
            return (new ResponseEntity<Object>(response, HttpStatus.OK));
        } else {
            return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        ServicioDTO dto = new ServicioDTO();
        dto.setId(id);
        Optional<Service> domain = service.find(dto);
        if (!domain.isEmpty()) {
            dto = service.mapToDto(domain.get());
            return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> eliminar(@RequestBody ServicioDTO dto) {
        Optional<Service> domain = service.find(dto);
        ServicioDTO dtoUpdate = service.mapToDto(domain.get());
        service.delete(dtoUpdate);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
    }

}