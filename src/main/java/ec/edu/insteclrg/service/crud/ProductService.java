package ec.edu.insteclrg.service.crud;

import ec.edu.insteclrg.domain.Product;
import ec.edu.insteclrg.dto.ProductoDTO;
import ec.edu.insteclrg.persistence.ProductRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService extends GenericCrudServiceImpl<Product, ProductoDTO> {

    @Autowired
    private ProductRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Product> find(ProductoDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public ProductoDTO mapToDto(Product domain) {
        return modelMapper.map(domain, ProductoDTO.class);
    }

    @Override
    public Product mapToDomain(ProductoDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

}