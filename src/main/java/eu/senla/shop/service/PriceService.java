package eu.senla.shop.service;

import eu.senla.shop.api.comparator.IPriceShopComparator;
import eu.senla.shop.api.diagram.IDiagram;
import eu.senla.shop.api.services.IPriceService;
import eu.senla.shop.dto.ComparatorTwoShopDTO;
import eu.senla.shop.dto.PriceDTO;
import eu.senla.shop.api.mapper.IPriceMapper;
import eu.senla.shop.model.Price;
import eu.senla.shop.api.repository.IPriceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PriceService implements IPriceService {

    private IPriceRepository priceRepository;
    private IPriceShopComparator priceShopComparator;
    private IDiagram diagram;

    @Override
    public PriceDTO save(PriceDTO priceDTO) {
        log.info("BEGINNING METHOD save({})", priceDTO);
        Price prices = priceRepository.save(IPriceMapper.INSTANCE.toPrice(priceDTO));
        return IPriceMapper.INSTANCE.toDTO(prices);
    }

    @Override
    public PriceDTO findById(Long priceId) {
        log.info("BEGINNING METHOD findById({})", priceId);
        Price prices = priceRepository.getById(priceId);
        return IPriceMapper.INSTANCE.toDTO(prices);
    }

    @Override
    public List<PriceDTO> findAll() {
        log.info("BEGINNING METHOD findAll()");
        return priceRepository.findAll().stream().map(IPriceMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long priceId) {
        log.info("BEGINNING METHOD deleteById({})", priceId);
        priceRepository.deleteById(priceId);
    }

    @Override
    public void deleteAll() {
        log.info("BEGINNING METHOD deleteAll()");
        priceRepository.deleteAll();
    }

    @Override
    public void delete(PriceDTO priceDTO) {
        log.info("BEGINNING METHOD delete({})", priceDTO.toString());
        priceRepository.delete(IPriceMapper.INSTANCE.toPrice(priceDTO));
    }

    @Override
    public Map<Integer, LocalDate> getDiagram(Long productId, Long shopId) {
        log.info("BEGINNING METHOD getDiagram({},{})", productId, shopId);
        List<PriceDTO> pricesDTOs = getAllProductIdAndShopId(productId, shopId);
        return diagram.getDiagram(pricesDTOs);
    }

    @Override
    public List<PriceDTO> getAllProductIdAndShopId(Long productId, Long shopId) {
        log.info("BEGINNING METHOD getAllProductIdAndShopId({},{})", productId, shopId);
        return priceRepository.getAllByIntermediateProductIdAndIntermediateShopId(productId, shopId)
                .stream().map(IPriceMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ComparatorTwoShopDTO comparatorTwoShops(
            String productName, String firstNameShop, String secondNameShop) {
        log.info("BEGINNING METHOD comparatorTwoShops({},{},{})",
                productName, firstNameShop, secondNameShop);
        return priceShopComparator.getPriceComparator(
                productName,
                firstNameShop,
                secondNameShop,
                findAllByShopNameAndProductName(productName, firstNameShop),
                findAllByShopNameAndProductName(productName, secondNameShop)
        );
    }

    @Override
    public List<PriceDTO> findAllByShopNameAndProductName(String productName, String shopName) {
        log.info("BEGINNING METHOD findAllByShopNameAndProductName({}, {})", productName, shopName);
        return priceRepository.findAllByIntermediateProductNameAndIntermediateShopName(productName, shopName)
                .stream().map(IPriceMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
