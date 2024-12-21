package demo.tp.springcloud.controller;

import demo.tp.springcloud.Repository.ProductRepository;
import demo.tp.springcloud.config.ApplicationPropertiesConfiguration;
import demo.tp.springcloud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController implements HealthIndicator {

    @Autowired
    ProductRepository productDao;

    @Autowired
    ApplicationPropertiesConfiguration applicationPropertiesConfig;

    @GetMapping
    public List<Product> productList(){
        List<Product> productList = productDao.findAll();
        //if(productList.isEmpty())
        //throw new ProductNotFoundException("aucun produit n'est disponible");

        List<Product> Listlimit = productList.subList(0,applicationPropertiesConfig.getLimitDeProduits());
        return Listlimit;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productDao.save(product);
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productDao.findById(id);
    }

    @Override
    public Health health() {
        return null;
    }
}
