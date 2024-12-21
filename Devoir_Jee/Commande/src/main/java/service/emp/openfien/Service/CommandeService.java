package service.emp.openfien.Service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import service.emp.openfien.Entity.Commande;
import service.emp.openfien.Entity.Product;
import service.emp.openfien.Repesitory.CommandeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Save a new Commande
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Autowired
    private InventoryProductService productFeignClient;
    public Commande createCommandeWithProduct(Long productId, Commande commande) {
        Product product = productFeignClient.getProductById(productId);
        BigDecimal price = BigDecimal.valueOf(product.getPrice());
        BigDecimal totalAmount = price.multiply(BigDecimal.valueOf(commande.getQuantity()));  // Multiply by quantity

        // Set the product information in the commande
        commande.setId_product(productId);  // Set the product ID
        commande.setDescription("Order for " + product.getName());  // Example: "Order for Product X"
        commande.setMontant(totalAmount);  // Calculate total price
        commande.setDate(LocalDate.now());
        commande.setQuantity(commande.getQuantity() + 1);
        // Save the commande to the database
        return commandeRepository.save(commande);
    }

    // Get all Commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Get a Commande by ID
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    // Update an existing Commande
//    public Optional<Commands> updateCommande(Long id, Commands updatedCommande) {
//        Optional<Commands> cmd1 = commandeRepository.findById(id);
//        if(cmd1.isEmpty()){
//
//        }
//        return commandeRepository.findById(id).map(existingCommande -> {
//            existingCommande.setQuantity(updatedCommande.getQuantity());
//            existingCommande.setDate(updatedCommande.getDate());
//            existingCommande.setMontant(updatedCommande.getMontant());
//            return commandeRepository.save(existingCommande);
//        });
//    }

    // Delete a Commande by ID
    public boolean deleteCommande(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
