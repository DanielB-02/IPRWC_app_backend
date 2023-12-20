package com.example.iprwc_app_backend.testdata;

import com.example.iprwc_app_backend.model.Role;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.model.User;
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


    @PostConstruct
    private void saveTestData() {
        createUser("Sebastiaan", "Landers", "admin@spine.com", "12345", Role.ADMIN);
        createUser("Shivane", "Frauenfelder", "ficter@spine.com", "12345", Role.FICTER);
        createUser("Floris", "Admiraal", "readonly@spine.com", "12345", Role.READONLY);

        createShopItem("Fender Stratocaster", "Classic electric guitar", 1200, "path/to/image1.jpg");
        createShopItem("Gibson Les Paul", "Iconic rock guitar", 1800, "path/to/image1.jpg");
        createShopItem("Martin D-28", "Acoustic dreadnought guitar", 2500, "path/to/image1.jpg");
        createShopItem("Ibanez RG550", "Versatile electric guitar", 900, "path/to/image1.jpg");
        createShopItem("Taylor 814ce", "Premium acoustic-electric guitar", 3000, "path/to/image1.jpg");
        createShopItem("PRS Custom 24", "High-end electric guitar", 2200, "path/to/image1.jpg");
        createShopItem("Epiphone Casino", "Vintage-style hollow body guitar", 800, "path/to/image1.jpg");
        createShopItem("Gretsch White Falcon", "Big-bodied electric guitar", 3500, "path/to/image1.jpg");
        createShopItem("Yamaha Pacifica 112V", "Affordable and versatile", 300, "path/to/image1.jpg");
        createShopItem("D'Angelico Excel SS", "Semi-hollow electric guitar", 1600, "path/to/image1.jpg");
        createShopItem("Jackson Soloist", "Metal shredder's choice", 1500, "path/to/image1.jpg");
        createShopItem("Seagull S6", "Quality acoustic guitar", 500, "path/to/image1.jpg");
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
