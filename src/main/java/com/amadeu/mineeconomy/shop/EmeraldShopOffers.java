package com.amadeu.mineeconomy.shop;

import java.util.List;

public final class EmeraldShopOffers {

        private EmeraldShopOffers() {
        }

        public static List<ShopEntry> createOffers() {
                return List.of(
                                // ===== MANUAIS =====
                                new ShopEntry(
                                                "safezone_book",
                                                "safezone manual",
                                                1,
                                                false,
                                                "safezone_book",
                                                1,
                                                List.of()),
                                // ===== MINERACAO =====

                                new ShopEntry(
                                                "efficiency_5",
                                                "efficiency V",
                                                41,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("efficiency", 5))),

                                new ShopEntry(
                                                "fortune_3",
                                                "fortune III",
                                                28,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("fortune", 3))),

                                new ShopEntry(
                                                "silk_touch",
                                                "silk touch",
                                                12,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("silk_touch", 1))),

                                new ShopEntry(
                                                "unbreaking_3",
                                                "unbreaking III",
                                                41,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("unbreaking", 3))),

                                new ShopEntry(
                                                "mending",
                                                "mending",
                                                12,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("mending", 1))),

                                // ===== COMBATE =====

                                new ShopEntry(
                                                "sharpness_5",
                                                "sharpness V",
                                                41,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("sharpness", 5))),

                                new ShopEntry(
                                                "smite_5",
                                                "smite V",
                                                41,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("smite", 5))),

                                new ShopEntry(
                                                "bane_of_arthropods_5",
                                                "bane of arthropods V",
                                                41,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("bane_of_arthropods", 5))),

                                new ShopEntry(
                                                "looting_3",
                                                "looting III",
                                                28,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("looting", 3))),

                                new ShopEntry(
                                                "fire_aspect_2",
                                                "fire aspect II",
                                                20,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("fire_aspect", 2))),

                                new ShopEntry(
                                                "knockback_2",
                                                "knockback II",
                                                20,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("knockback", 2))),

                                new ShopEntry(
                                                "sweeping_edge_3",
                                                "sweeping edge III",
                                                28,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("sweeping_edge", 3))),

                                // ===== ARMADURA =====

                                new ShopEntry(
                                                "protection_4",
                                                "protection IV",
                                                36, true,
                                                "enchanted_book", 1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("protection", 4))),

                                new ShopEntry(
                                                "fire_protection_4",
                                                "fire protection IV",
                                                36,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(
                                                                new ShopEntry.EnchantEntry("fire_protection", 4))),

                                new ShopEntry(
                                                "blast_protection_4",
                                                "blast protection IV",
                                                36,
                                                true,
                                                "enchanted_book",
                                                1,
                                                List.of(new ShopEntry.EnchantEntry("blast_protection", 4))),

                                new ShopEntry("projectile_protection_4", "projectile protection IV", 36, true,
                                                "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("projectile_protection", 4))),

                                new ShopEntry("feather_falling_4", "feather falling IV", 36, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("feather_falling", 4))),

                                new ShopEntry("respiration_3", "respiration III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("respiration", 3))),

                                new ShopEntry("aqua_affinity", "aqua affinity", 12, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("aqua_affinity", 1))),

                                new ShopEntry("thorns_3", "thorns III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("thorns", 3))),

                                new ShopEntry("depth_strider_3", "depth strider III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("depth_strider", 3))),

                                new ShopEntry("frost_walker_2", "frost walker II", 20, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("frost_walker", 2))),

                                // ===== ARCO E BESTA =====

                                new ShopEntry("power_5", "power V", 41, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("power", 5))),

                                new ShopEntry("punch_2", "punch II", 20, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("punch", 2))),

                                new ShopEntry("flame", "flame", 12, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("flame", 1))),

                                new ShopEntry("infinity", "infinity", 12, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("infinity", 1))),

                                new ShopEntry("multishot", "multishot", 12, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("multishot", 1))),

                                new ShopEntry("quick_charge_3", "quick charge III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("quick_charge", 3))),

                                new ShopEntry("piercing_4", "piercing IV", 36, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("piercing", 4))),

                                // ===== PESCA =====

                                new ShopEntry("luck_of_the_sea_3", "luck of the sea III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("luck_of_the_sea", 3))),

                                new ShopEntry("lure_3", "lure III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("lure", 3))),

                                // ===== TRIDENTE =====

                                new ShopEntry("loyalty_3", "loyalty III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("loyalty", 3))),

                                new ShopEntry("impaling_5", "impaling V", 41, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("impaling", 5))),

                                new ShopEntry("riptide_3", "riptide III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("riptide", 3))),

                                new ShopEntry("channeling", "channeling", 12, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("channeling", 1))),

                                // ===== MACE =====

                                new ShopEntry("density_5", "density V", 41, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("density", 5))),

                                new ShopEntry("breach_4", "breach IV", 36, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("breach", 4))),

                                new ShopEntry("lunge_3", "lunge III", 28, true, "enchanted_book", 1,
                                                List.of(new ShopEntry.EnchantEntry("lunge", 3))),

                                // ===== UTILIDADES =====
                                new ShopEntry(
                                                "golden_apple",
                                                "golden apple",
                                                18,
                                                false,
                                                "golden_apple",
                                                1,
                                                List.of()),
                                new ShopEntry(
                                                "golden_carrot",
                                                "golden carrots",
                                                6,
                                                false,
                                                "golden_carrot",
                                                6,
                                                List.of()),

                                // ===== DISCOS (COSMÉTICOS) =====
                                new ShopEntry(
                                                "music_13",
                                                "disc 13",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_cat",
                                                "disc cat",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_blocks",
                                                "disc blocks",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_chirp",
                                                "disc chirp",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_far",
                                                "disc far",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_mall",
                                                "disc mall",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_mellohi",
                                                "disc mellohi",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_stal",
                                                "disc stal",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_strad",
                                                "disc strad",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_ward",
                                                "disc ward",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_11",
                                                "disc 11",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_wait",
                                                "disc wait",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_pigstep",
                                                "disc pigstep",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_otherside",
                                                "disc otherside",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_5",
                                                "disc 5",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_creator",
                                                "disc creator",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_creator_music_box",
                                                "disc creator music box",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_precipice",
                                                "disc precipice",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_tears",
                                                "disc tears",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_lava_chicken",
                                                "disc lava chicken",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()),
                                new ShopEntry(
                                                "music_relic",
                                                "disc relic",
                                                1,
                                                false,
                                                "music_disc",
                                                1, List.of()));
        }
}
