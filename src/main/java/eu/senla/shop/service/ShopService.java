package eu.senla.shop.service;

import eu.senla.shop.api.services.IShopService;
import eu.senla.shop.dto.ShopDTO;
import eu.senla.shop.api.mapper.IShopMapper;
import eu.senla.shop.model.Shop;
import eu.senla.shop.api.repository.IShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Setter
@Service
@RequiredArgsConstructor
public class ShopService implements IShopService {

    //    @Autowired
    private IShopRepository shopRepository;
    //        @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShopDTO save(ShopDTO shopDTO) {
        Shop shops = shopRepository.save(modelMapper.map(shopDTO, Shop.class));
        return modelMapper.map(shops, ShopDTO.class);
    }

    @Override
    public ShopDTO findById(Long shopId) {
        log.info("BEGINNING METHOD findById({})", shopId);
        Shop shop = shopRepository.getById(shopId);
        return IShopMapper.INSTANCE.toDTO(shop);
    }

    @Override
    public ShopDTO findByName(String name) {
        log.info("BEGINNING METHOD findByName({})", name);
        Shop shops = shopRepository.findByName(name);
        return IShopMapper.INSTANCE.toDTO(shops);
    }

    @Override
    public List<ShopDTO> findAll() {
        log.info("BEGINNING METHOD findAll()");
        return shopRepository.findAll().stream().map(IShopMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long shopId) {
        log.info("BEGINNING METHOD deleteById({})", shopId);
        shopRepository.deleteById(shopId);
    }

    @Override
    public void deleteAll() {
        log.info("BEGINNING METHOD deleteAll()");
        shopRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        log.info("BEGINNING METHOD deleteByName({})", name);
        shopRepository.deleteByName(name);
    }

    @Override
    public void delete(ShopDTO shopDTO) {
        log.info("BEGINNING METHOD delete({})", shopDTO.toString());
        shopRepository.delete(IShopMapper.INSTANCE.toShop(shopDTO));
    }
}
