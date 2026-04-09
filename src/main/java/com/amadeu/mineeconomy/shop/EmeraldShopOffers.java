package com.amadeu.mineeconomy.shop;

import java.util.List;

public final class EmeraldShopOffers {

    private EmeraldShopOffers() {
    }

    public static List<ShopEntry> createOffers() {
        return List.of(
                // ===== ENCANTAMENTOS =====
                new ShopEntry(
                        "basic_preservation_book",
                        "Livro Basico de Preservacao",
                        35,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1),
                                new ShopEntry.EnchantEntry("vanishing_curse", 1)
                        )
                ),
                new ShopEntry(
                        "fishing_rod_book",
                        "Livro da Vara",
                        35,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("luck_of_the_sea", 3),
                                new ShopEntry.EnchantEntry("lure", 3),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "sword_book",
                        "Livro da Espada",
                        120,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("sharpness", 5),
                                new ShopEntry.EnchantEntry("looting", 3),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1),
                                new ShopEntry.EnchantEntry("fire_aspect", 2),
                                new ShopEntry.EnchantEntry("knockback", 2)
                        )
                ),
                new ShopEntry(
                        "bow_book",
                        "Livro do Arco",
                        128,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("power", 5),
                                new ShopEntry.EnchantEntry("infinity", 1),
                                new ShopEntry.EnchantEntry("flame", 1),
                                new ShopEntry.EnchantEntry("punch", 2),
                                new ShopEntry.EnchantEntry("unbreaking", 3)
                        )
                ),
                new ShopEntry(
                        "pickaxe_book",
                        "Livro da Picareta",
                        100,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("efficiency", 5),
                                new ShopEntry.EnchantEntry("fortune", 3),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "shovel_book",
                        "Livro da Pa",
                        80,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("efficiency", 5),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1),
                                new ShopEntry.EnchantEntry("silk_touch", 1)
                        )
                ),
                new ShopEntry(
                        "hoe_book",
                        "Livro da Enxada",
                        70,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("efficiency", 5),
                                new ShopEntry.EnchantEntry("fortune", 3),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "helmet_book",
                        "Livro do Capacete",
                        110,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("protection", 4),
                                new ShopEntry.EnchantEntry("respiration", 3),
                                new ShopEntry.EnchantEntry("aqua_affinity", 1),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "chestplate_book",
                        "Livro do Peitoral",
                        120,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("protection", 4),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "leggings_book",
                        "Livro da Calca",
                        110,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("protection", 4),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),
                new ShopEntry(
                        "boots_book",
                        "Livro da Bota",
                        120,
                        "enchanted_book",
                        1,
                        List.of(
                                new ShopEntry.EnchantEntry("protection", 4),
                                new ShopEntry.EnchantEntry("feather_falling", 4),
                                new ShopEntry.EnchantEntry("depth_strider", 3),
                                new ShopEntry.EnchantEntry("unbreaking", 3),
                                new ShopEntry.EnchantEntry("mending", 1)
                        )
                ),

                // ===== UTILIDADES =====
                new ShopEntry(
                        "golden_apple",
                        "Maca Dourada",
                        18,
                        "golden_apple",
                        1,
                        List.of()
                ),
                new ShopEntry(
                        "golden_carrot",
                        "Cenoura Dourada",
                        6,
                        "golden_carrot",
                        4,
                        List.of()
                )
        );
    }
}
