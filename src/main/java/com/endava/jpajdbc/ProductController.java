package com.endava.jpajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;


    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @RequestMapping( value = "/products", method = RequestMethod.POST )
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public Optional<Product> findById(@PathVariable(value="id") Long id){
        return productRepository.findById(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") Long id){
        productRepository.deleteById(id);
    }
}
