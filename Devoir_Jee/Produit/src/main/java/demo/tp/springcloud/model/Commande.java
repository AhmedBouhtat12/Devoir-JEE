package demo.tp.springcloud.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Commande {
    private Long Id;

    private String description;

    private int quantity;

    private LocalDate date;

    private Double montant;

    private Long id_product;
}
