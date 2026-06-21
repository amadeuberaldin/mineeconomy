package com.amadeu.mineeconomy.shop;

import java.util.List;

public record ShopEntry(
        String id,
        String displayName,
        int emeraldCost,
        boolean requiresBook,
        String itemType,
        int count,
        List<EnchantEntry> enchantments
) {
    public record EnchantEntry(String id, int level) {
    }
}