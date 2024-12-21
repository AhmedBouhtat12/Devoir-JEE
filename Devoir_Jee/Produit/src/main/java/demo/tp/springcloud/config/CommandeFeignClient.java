package demo.tp.springcloud.config;

import demo.tp.springcloud.model.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "OPENFIEGN", url = "http://localhost:9103")
public interface CommandeFeignClient {

    @GetMapping("/api/commande/{id}")
    Commande getCommandeById(@PathVariable("id") Long id);
}
