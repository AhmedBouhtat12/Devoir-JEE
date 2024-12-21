package service.emp.openfien.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.emp.openfien.Entity.Product;


@FeignClient(name = "SPRING-CLOUD" , url = "http://localhost:8082")
public interface InventoryProductService {

    @GetMapping("/products")
    PagedModel<Product> allProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}

