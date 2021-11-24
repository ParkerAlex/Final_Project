package eu.senla.shop.controller;

import eu.senla.shop.api.services.ICategoryService;
import eu.senla.shop.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        log.info("REQUEST POST: /shops/categories/{}", categoryDTO);
        CategoryDTO categoryDTOs = categoryService.save(categoryDTO);
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        log.info("REQUEST GET: /shops/categories/{}", id);
        CategoryDTO categoryDTOs = categoryService.findById(id);
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryDTO> findByName(@PathVariable String name) {
        log.info("REQUEST GET: /shops/categories/{}", name);
        CategoryDTO categoryDTOs = categoryService.findByName(name);
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        log.info("REQUEST GET: /shops/categories");
        List<CategoryDTO> categoryDTOs = categoryService.findAll();
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        log.info("REQUEST DELETE: /shops/categories/{}", name);
        categoryService.deleteByName(name);
        return new ResponseEntity<>("CATEGORY DELETED OF NAME: " + name, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll() {
        log.info("REQUEST DELETE ALL: /shops/categories/all");
        categoryService.deleteAll();
        return new ResponseEntity<>("CATEGORIES ALL DELETED", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("REQUEST DELETE BY ID: /shops/categories/{}", id);
        categoryService.deleteById(id);
        return new ResponseEntity<>("CATEGORY DELETED WITH ID " + id, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody CategoryDTO categoryDTO) {
        log.info("REQUEST DELETE: /shops/categories/{}", categoryDTO);
        categoryService.delete(categoryDTO);
        return new ResponseEntity<>("CATEGORY DELETED " + categoryDTO, HttpStatus.OK);
    }
}
