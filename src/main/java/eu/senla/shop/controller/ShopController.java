package eu.senla.shop.controller;

import eu.senla.shop.api.services.IShopService;
import eu.senla.shop.dto.ShopDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @PostMapping
    public ResponseEntity<ShopDTO> save(@RequestBody ShopDTO shopDTO) {
        log.info("REQUEST POST: /shops/shops/{}", shopDTO);
        ShopDTO shopDTOs = shopService.save(shopDTO);
        return new ResponseEntity<>(shopDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> findById(@PathVariable Long id) {
        log.info("REQUEST GET: /shops/shops/{}", id);
        ShopDTO shopDTOs = shopService.findById(id);
        return new ResponseEntity<>(shopDTOs, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ShopDTO> findByName(@PathVariable String name) {
        log.info("REQUEST GET: /shops/shops/name/{}", name);
        ShopDTO shopDTOs = shopService.findByName(name);
        return new ResponseEntity<>(shopDTOs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShopDTO>> findAll() {
        log.info("REQUEST GET: /shops/shops");
        List<ShopDTO> shopDTOs = shopService.findAll();
        return new ResponseEntity<>(shopDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        log.info("REQUEST DELETE BY NAME: /shops/shops/{}", name);
        shopService.deleteByName(name);
        return new ResponseEntity<>("SHOP DELETED BY NAME: " + name, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll() {
        log.info("REQUEST DELETE ALL: /shops/shops/all");
        shopService.deleteAll();
        return new ResponseEntity<>("SHOPS DELETED ALL", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("REQUEST DELETE BY ID: /shops/shops/{}", id);
        shopService.deleteById(id);
        return new ResponseEntity<>("SHOP DELETED WITH ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody ShopDTO shopDTO) {
        log.info("REQUEST DELETE: /shops/shops/{}", shopDTO);
        shopService.delete(shopDTO);
        return new ResponseEntity<>("SHOP DELETED", HttpStatus.OK);
    }
}
