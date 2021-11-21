package eu.senla.shop.util.csv;

import eu.senla.shop.api.importcsv.IProductsImportCSV;
import eu.senla.shop.model.Category;
import eu.senla.shop.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProductsImportCSV implements IProductsImportCSV {

    public List<Product> productList() {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/main/java/eu/senla/shop/util/csv/product.csv"))) {
            String file = bufferedReader.readLine();
            while (file != null) {
                String[] attributes = file.split(",");
                Product product = getOneProduct(attributes);
                productList.add(product);
                file = bufferedReader.readLine();
                log.info("LOAD in BUFFER is OK");

            }
        } catch (FileNotFoundException e) {
            log.warn("FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            log.warn("Error!!!");
            e.printStackTrace();
        }
        return productList;
    }

    private Product getOneProduct(String[] attributes) {
        String name = attributes[0];
        Category category = new Category();
        category.setId(Long.parseLong(attributes[1]));
        return new Product(name, category);
    }
}







