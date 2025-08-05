package com.ggstore.service;

import com.ggstore.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{
    private static final List<Product> products = new ArrayList<>();

    static{
        products.add(new Product(
            "caneca001",
            "Caneca Gamer",
            "Canecas",
            "assets/images/canecaGamer.png",
            "Caneca de Doom exclusivo para gamers",
            4999
        ));
        products.add(new Product(
            "camisa001",
            "Camisa Valorant Champions",
            "Camisas",
            "assets/images/camisaValorantChampions.png",
            "camisa da chapion de valorant",
            7999
        ));
        products.add(new Product(
            "figure001",
            "Hollow Knight figure",
            "Figures",
            "assets/images/figureHollowKinigt.png",
            "Uma Figure de hollow knight",
            19999
        ));
        products.add(new Product(
            "quadro001",
            "Quadro Minecraft Creeper",
            "Quadros",
            "assets/images/quadroCreeper.jpeg",
            "Um quadro do Creeper do minecraft",
            5999
        ));
        products.add(new Product(
            "mochila001",
            "Mochila Grande Multifuncional",
            "Mochilas",
            "assets/images/mochilaGrandeMultifuncional.png",
            "Uma mochila multifuncional, que vira mala, bolsa de viagem",
            13599
        ));
        products.add(new Product(
            "bone001",
            "Bone Nat 20",
            "Bones",
            "assets/images/bone.png",
            "Um Bone para fans de RPG de mesa, com um D20",
            2999
        ));
    }

    public List<Product> getProducts() {
        return products;
    }
    public Optional<Product> getProductById(String id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}