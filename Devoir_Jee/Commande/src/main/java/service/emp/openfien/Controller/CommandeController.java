package service.emp.openfien.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.emp.openfien.Entity.Commande;
import service.emp.openfien.Entity.Product;
import service.emp.openfien.Service.CommandeService;
import service.emp.openfien.Service.InventoryProductService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;
    private final InventoryProductService inventoryProductService;

    @Autowired
    public CommandeController(CommandeService commandeService, InventoryProductService inventoryProductService) {
        this.commandeService = commandeService;
        this.inventoryProductService = inventoryProductService;
    }

    @PostMapping("/add/{productId}")
    public Commande createCommandeWithProduct(@PathVariable Long productId, @RequestBody Commande commande) {
        return commandeService.createCommandeWithProduct(productId, commande);
    }


    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        return ResponseEntity.ok(commandes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Optional<Commande> commande = commandeService.getCommandeById(id);
        return commande.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        Optional<Commande> existingCommande = commandeService.getCommandeById(id);
        if (existingCommande.isPresent()) {
            commandeService.deleteCommande(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
