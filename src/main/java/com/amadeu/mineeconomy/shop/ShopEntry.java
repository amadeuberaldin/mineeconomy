package com.amadeu.mineeconomy.shop;

import java.util.List;

public record ShopEntry(
        String id,
        String displayName,
        int emeraldCost,
        String itemType,
        int count,
        List<EnchantEntry> enchantments
) {
    public record EnchantEntry(String id, int level) {
    }
}
