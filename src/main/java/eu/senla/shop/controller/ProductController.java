package eu.senla.shop.controller;

import eu.senla.shop.api.services.IProductService;
import eu.senla.shop.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        log.info("REQUEST POST: /shops/products/{}", productDTO);
        ProductDTO productsDTOs = productService.save(productDTO);
        return new ResponseEntity<>(productsDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        log.info("REQUEST GET: /shops/products/{}", id);
        ProductDTO productsDTOs = productService.findById(id);
        return new ResponseEntity<>(productsDTOs, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDTO> findByName(@PathVariable String name) {
        log.info("REQUEST GET: /shops/products/name/{}", name);
        ProductDTO productsDTOs = productService.findByName(name);
        return new ResponseEntity<>(productsDTOs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        log.info("REQUEST GET: /shops/products");
        List<ProductDTO> productsDTOs = productService.findAll();
        return new ResponseEntity<>(productsDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        log.info("REQUEST DELETE: /shops/products/{}", name);
        productService.deleteByName(name);
        return new ResponseEntity<>("PRODUCT DELETED OF NAME: " + name, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll() {
        log.info("REQUEST DELETE ALL: /shop/products/all");
        productService.deleteAll();
        return new ResponseEntity<>("PRODUCTS DELETED ALL", HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> findAllByCategoryId(@PathVariable Long id) {
        log.info("Begin request: /shops/products/category/{}", id);
        List<ProductDTO> productDTOs = productService.findAllByProductId(id);
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("/category/name/{name}")
    public ResponseEntity<List<ProductDTO>> findAllByCategoryName(@PathVariable String name) {
        log.info("Begin request: /shops/products/category/name/{}", name);
        List<ProductDTO> productDTOs = productService.findAllByProductName(name);
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<String> getFile() {
        log.info("PRODUCT IMPORT FROM FILE");
        productService.loadProductWithFile();
        return new ResponseEntity<>("PRODUCT IMPORT FROM FILE", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("REQUEST DELETE BY ID: /shop/products/{}", id);
        productService.deleteById(id);
        return new ResponseEntity<>("PRODUCT DELETED WITH ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody ProductDTO productDTO) {
        log.info("REQUEST DELETE: /shop/products/{}", productDTO);
        productService.delete(productDTO);
        return new ResponseEntity<>("Product DELETED", HttpStatus.OK);
    }
}