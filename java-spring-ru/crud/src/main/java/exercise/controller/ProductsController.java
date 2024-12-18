package exercise.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ProductDTO>> index() {
        var products = productRepository.findAll()
                .stream()
                .map(productMapper::map)
                .toList();


        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(products.size()))
                .body(products);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var productDTO = productMapper.map(product);
        return productDTO;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDTO create(@Valid @RequestBody ProductCreateDTO productData) {
        var category = categoryRepository.findById(productData.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        var product = productMapper.map(productData);
        //product.setCategory(category);
        productRepository.save(product);
        //category.getProducts().add(product);
        var productDTO = productMapper.map(product);
        return productDTO;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO update(@RequestBody @Valid ProductUpdateDTO productData, @PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        productMapper.update(productData, product);
//        if (productData.getCategoryId().isPresent()) {
//            var category = categoryRepository.findById(productData.getCategoryId().get())
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
//            product.setCategory(category);
//            category.getProducts().add(product);
//        }
        productRepository.save(product);
        var productDTO = productMapper.map(product);
        return productDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        productRepository.deleteById(id);
    }


    // END
}
