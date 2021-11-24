package eu.senla.shop.controller;

import eu.senla.shop.api.services.IIntermediateService;
import eu.senla.shop.dto.IntermediateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/intermediates")
public class IntermediateController {

    private IIntermediateService intermediateService;

    @PostMapping
    public ResponseEntity<IntermediateDTO> save(@RequestBody IntermediateDTO intermediateDTO) {
        log.info("REQUEST POST: /shops/intermediates/{}", intermediateDTO);
        IntermediateDTO intermediatesDTOs = intermediateService.save(intermediateDTO);
        return new ResponseEntity<>(intermediatesDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntermediateDTO> findById(@PathVariable Long id) {
        log.info("REQUEST GET BY ID: /shops/intermediates/{}", id);
        IntermediateDTO intermediateDTOs = intermediateService.findById(id);
        return new ResponseEntity<>(intermediateDTOs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<IntermediateDTO>> findAll() {
        log.info("REQUEST GET ALL: /shops/intermediates");
        List<IntermediateDTO> intermediatesDTOs = intermediateService.findAll();
        return new ResponseEntity<>(intermediatesDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll() {
        log.info("REQUEST DELETE ALL: /shops/intermediates/all");
        intermediateService.deleteAll();
        return new ResponseEntity<>("INTERMEDIATES DELETED ALL", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("REQUEST DELETE BY ID: /shops/intermediates/{}", id);
        intermediateService.deleteById(id);
        return new ResponseEntity<>("INTERMEDIATES DELETED WITH ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody IntermediateDTO intermediateDTO) {
        log.info("REQUEST DELETE: /shops/intermediates/{}", intermediateDTO);
        intermediateService.delete(intermediateDTO);
        return new ResponseEntity<>("INTERMEDIATES DELETED " + intermediateDTO, HttpStatus.OK);
    }
}
