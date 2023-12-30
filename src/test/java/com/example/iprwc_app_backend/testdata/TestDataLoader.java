package com.example.iprwc_app_backend.testdata;

import com.example.iprwc_app_backend.model.*;
import com.example.iprwc_app_backend.repository.OrderItemRepository;
import com.example.iprwc_app_backend.repository.ShopItemRepository;
import com.example.iprwc_app_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class TestDataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ShopItemRepository shopItemRepository;
    private final OrderItemRepository orderItemRepository;


    @PostConstruct
    private void saveTestData() {
        createUser("Floris", "Admiraal", "admin@shop.com", "12345", Role.ADMIN);
        createUser("Daniel", "Bor", "user@shop.com", "12345", Role.USER);

        createShopItem("Fender Stratocaster", "Classic electric guitar", 1200, "assets/img/fender-stratocaster.jpg");
        createShopItem("Gibson Les Paul", "Iconic rock guitar", 1800, "assets/img/gibson-les-paul.jpg");
        createShopItem("Martin D-28", "Acoustic dreadnought guitar", 2500, "assets/img/martin-d28.jpg");
        createShopItem("Ibanez RG550", "Versatile electric guitar", 900, "assets/img/ibanez-rg550.jpg");
        createShopItem("Taylor 814ce", "Premium acoustic-electric guitar", 3000, "assets/img/taylor-814ce.jpg");
        createShopItem("PRS Custom 24", "High-end electric guitar", 2200, "assets/img/prs-custom-24.jpg");
        createShopItem("Epiphone Casino", "Vintage-style hollow body guitar", 800, "assets/img/epiphone-casino.jpg");
        createShopItem("Gretsch White Falcon", "Big-bodied electric guitar", 3500, "assets/img/gretsch-white-falcon.jpg");
        createShopItem("Yamaha Pacifica 112V", "Affordable and versatile", 300, "assets/img/yamaha-pacifica-112v.jpg");
        createShopItem("D'Angelico Excel SS", "Semi-hollow electric guitar", 1600, "assets/img/dangelico-excel-ss.jpg");
        createShopItem("Jackson Soloist", "Metal shredder's choice", 1500, "assets/img/jackson-soloist.jpg");
        createShopItem("Seagull S6", "Quality acoustic guitar", 500, "assets/img/seagull-s6.jpg");

//        createOrderItem()
    }

    private void createOrderItem(ShopItem shopItem, Order order) {
        var orderItem = OrderItem.builder()
                    .shopItem(shopItem)
                    .order(order).build();
            orderItemRepository.save(orderItem);
    }


    private void createUser(String firstName, String lastName, String email, String password, Role role) {
        var user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role).build();
            userRepository.save(user);
    }

    private void createShopItem(String name, String description, double price, String imageUrl) {
        var shopItem = ShopItem.builder()
                .name(name)
                .description(description)
                .price(price)
                .imageUrl(imageUrl).build();
        shopItemRepository.save(shopItem);
    }
}
