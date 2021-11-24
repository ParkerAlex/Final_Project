package eu.senla.shop.controller;

import eu.senla.shop.api.services.IPriceService;
import eu.senla.shop.dto.ComparatorTwoShopDTO;
import eu.senla.shop.dto.PriceDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/prices")
public class PriceController {

    private IPriceService priceService;

    @PostMapping
    public ResponseEntity<PriceDTO> save(@RequestBody PriceDTO priceDTO) {
        log.info("REQUEST POST: /shops/prices/{}", priceDTO);
        PriceDTO priceDTOs = priceService.save(priceDTO);
        return new ResponseEntity<>(priceDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceDTO> findById(@PathVariable Long id) {
        log.info("REQUEST GET: /shops/prices/{}", id);
        PriceDTO priceDTOs = priceService.findById(id);
        return new ResponseEntity<>(priceDTOs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PriceDTO>> findAll() {
        log.info("REQUEST GET: /shops/price");
        List<PriceDTO> priceDTOs = priceService.findAll();
        return new ResponseEntity<>(priceDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll() {
        log.info("REQUEST DELETE ALL: /shops/prices/all");
        priceService.deleteAll();
        return new ResponseEntity<>("PRICE DELETED ALL", HttpStatus.OK);
    }

    @GetMapping("/diagram/{productId}/{shopId}")
    public ResponseEntity<Map<Integer, LocalDate>> getDiagram(
            @PathVariable("productId") Long productId,
            @PathVariable("shopId") Long shopId) {
        log.info("REQUEST GET: /shops/prices/diagram/{}/{}", productId, shopId);
        Map<Integer, LocalDate> diagram = priceService.getDiagram(productId, shopId);
        return new ResponseEntity<>(diagram, HttpStatus.OK);
    }

    @GetMapping("/{productId}/{shopId}")
    public ResponseEntity<List<PriceDTO>> getConsignmentGoodsIdAndStoreId(
            @PathVariable("productId") Long productId,
            @PathVariable("shopId") Long shopId) {
        log.info("Received request GET: /shops/prices/{}/{}", productId, shopId);
        List<PriceDTO> priceDTOs = priceService.getAllProductIdAndShopId(productId, shopId);
        return new ResponseEntity<>(priceDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("REQUEST DELETE BY ID: /shops/prices/{id}");
        priceService.deleteById(id);
        return new ResponseEntity<>("PRICE DELETED WITH ID", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody PriceDTO priceDTO) {
        log.info("REQUEST DELETE: /shops/prices/{}", priceDTO);
        priceService.delete(priceDTO);
        return new ResponseEntity<>("PRICE DELETED", HttpStatus.OK);
    }

    @GetMapping("/comparator/{productName}/{firstNameShop}/{secondNameShop}")
    public ResponseEntity<ComparatorTwoShopDTO> comparatorTwoShops(
            @PathVariable("productName") String productName,
            @PathVariable("firstNameShop") String firstNameShop,
            @PathVariable("secondNameShop") String secondNameShop
    ) {
        log.info("GET REQUEST: /shops/prices/comparator/{}/{}/{}",
                productName, firstNameShop, secondNameShop);
        ComparatorTwoShopDTO comparatorTwoShopDTO = priceService.comparatorTwoShops(
                productName, firstNameShop, secondNameShop);
        return new ResponseEntity<>(comparatorTwoShopDTO, HttpStatus.OK);
    }

    @GetMapping("/names/{productName}/{shopName}")
    public ResponseEntity<List<PriceDTO>> findAllByShopNameAndProductName(
            @PathVariable("productName") String productName,
            @PathVariable("shopName") String shopName) {
        log.info("REQUEST GET: /shops/prices/names/{}/{}", productName, shopName);
        List<PriceDTO> priceDTOs = priceService.findAllByShopNameAndProductName(productName, shopName);
        return new ResponseEntity<>(priceDTOs, HttpStatus.OK);
    }
}
