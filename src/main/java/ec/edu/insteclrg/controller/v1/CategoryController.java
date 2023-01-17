package ec.edu.insteclrg.controller.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.insteclrg.domain.Category;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.CategoriaDTO;
import ec.edu.insteclrg.service.crud.CategoryService;

@RestController
@RequestMapping("/api/v1.0/categoria/")
public class CategoryController {

	@Autowired
	CategoryService service;

	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody CategoriaDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "{id}")
	public ResponseEntity<Object> actualizar(@RequestBody CategoriaDTO dtoBody, @PathVariable Long id) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setId(id);
		Optional<Category> domain = service.find(dto);
		CategoriaDTO dtoUpdate = service.mapToDto(domain.get());
		dtoUpdate.setName(dtoBody.getName());
		service.update(dtoUpdate);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		List<CategoriaDTO> list = this.service.findAll(new CategoriaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<CategoriaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setId(id);
		Optional<Category> domain = service.find(dto);
		if (!domain.isEmpty()) {
			dto = service.mapToDto(domain.get());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping
	public ResponseEntity<Object> eliminar(@RequestBody CategoriaDTO dto) {
		Optional<Category> domain = service.find(dto);
		CategoriaDTO dtoUpdate = service.mapToDto(domain.get());
		service.delete(dtoUpdate);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

}
