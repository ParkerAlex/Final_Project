package eu.senla.shop.service;

import eu.senla.shop.api.importcsv.IProductsImportCSV;
import eu.senla.shop.api.services.IProductService;
import eu.senla.shop.dto.ProductDTO;
import eu.senla.shop.api.mapper.IProductMapper;
import eu.senla.shop.model.Product;
import eu.senla.shop.api.repository.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private IProductRepository productRepository;
    private IProductsImportCSV productsImportCSV;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        log.info("BEGINNING METHOD save({})", productDTO);
        Product products = productRepository.save(IProductMapper.INSTANCE.toProduct(productDTO));
        return IProductMapper.INSTANCE.toDTO(products);
    }

    @Override
    public ProductDTO findById(Long productId) {
        log.info("BEGINNING METHOD findById({})", productId);
        return IProductMapper.INSTANCE.toDTO(productRepository.findById(productId)
                .orElseThrow(() -> new ProviderNotFoundException("PRODUCT ID NOT FOUND")));
    }

    @Override
    public ProductDTO findByName(String name) {
        log.info("BEGINNING METHOD findByName({})", name);
        Product products = productRepository.findByName(name);
        return IProductMapper.INSTANCE.toDTO(products);
    }

    @Override
    public List<ProductDTO> findAll() {
        log.info("BEGINNING METHOD findAll()");
        return productRepository.findAll().stream().map(IProductMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long productId) {
        log.info("BEGINNING METHOD deleteById({})", productId);
        productRepository.deleteById(productId);
    }

    @Override
    public void deleteAll() {
        log.info("BEGINNING METHOD deleteAll()");
        productRepository.deleteAll();
    }

    @Override
    public List<ProductDTO> findAllByProductId(Long categoryId) {
        log.info("BEGINNING METHOD findAllByProductId({})", categoryId);
        return productRepository.findAllByCategoryId(categoryId).stream()
                .map(IProductMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByProductName(String name) {
        log.info("BEGINNING METHOD findAllByProductName({})", name);
        return productRepository.findAllByCategoryName(name).stream()
                .map(IProductMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void loadProductWithFile() {
        log.info("BEGINNING METHOD loadProductWithFile");
        productRepository.saveAll(productsImportCSV.productList());
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        log.info("BEGINNING METHOD deleteByName({})", name);
        productRepository.deleteByName(name);
    }

    @Override
    public void delete(ProductDTO productDTO) {
        log.info("BEGINNING METHOD delete({})", productDTO.toString());
        productRepository.delete(IProductMapper.INSTANCE.toProduct(productDTO));
    }
}
