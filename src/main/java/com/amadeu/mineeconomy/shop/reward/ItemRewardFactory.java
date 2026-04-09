package com.amadeu.mineeconomy.shop.reward;

import com.amadeu.mineeconomy.shop.ShopEntry;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public final class ItemRewardFactory {

    private ItemRewardFactory() {
    }

    public static ItemStack createFromEntry(ServerPlayer player, ShopEntry entry) {
        return switch (entry.itemType()) {
            case "enchanted_book" -> createEnchantedBook(player, entry);
            case "golden_apple" -> new ItemStack(Items.GOLDEN_APPLE, entry.count());
            case "golden_carrot" -> new ItemStack(Items.GOLDEN_CARROT, entry.count());
            default -> throw new IllegalArgumentException("Tipo de item não suportado: " + entry.itemType());
        };
    }

    private static ItemStack createEnchantedBook(ServerPlayer player, ShopEntry entry) {
        ItemStack stack = new ItemStack(Items.ENCHANTED_BOOK);

        stack.set(DataComponents.CUSTOM_NAME, Component.literal(entry.displayName()));

        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);

        RegistryAccess registryAccess = player.registryAccess();

        for (ShopEntry.EnchantEntry enchantEntry : entry.enchantments()) {
            ResourceKey<Enchantment> key = mapEnchantKey(enchantEntry.id());

            Holder<Enchantment> holder = registryAccess
                    .lookupOrThrow(Registries.ENCHANTMENT)
                    .getOrThrow(key);

            mutable.set(holder, enchantEntry.level());
        }

        stack.set(DataComponents.STORED_ENCHANTMENTS, mutable.toImmutable());

        return stack;
    }

    private static ResourceKey<Enchantment> mapEnchantKey(String enchantId) {
        return switch (enchantId) {
            case "unbreaking" -> Enchantments.UNBREAKING;
            case "mending" -> Enchantments.MENDING;

            case "sharpness" -> Enchantments.SHARPNESS;
            case "looting" -> Enchantments.LOOTING;
            case "fire_aspect" -> Enchantments.FIRE_ASPECT;
            case "knockback" -> Enchantments.KNOCKBACK;

            case "power" -> Enchantments.POWER;
            case "infinity" -> Enchantments.INFINITY;
            case "flame" -> Enchantments.FLAME;
            case "punch" -> Enchantments.PUNCH;

            case "efficiency" -> Enchantments.EFFICIENCY;
            case "fortune" -> Enchantments.FORTUNE;
            case "silk_touch" -> Enchantments.SILK_TOUCH;

            case "protection" -> Enchantments.PROTECTION;
            case "respiration" -> Enchantments.RESPIRATION;
            case "aqua_affinity" -> Enchantments.AQUA_AFFINITY;
            case "feather_falling" -> Enchantments.FEATHER_FALLING;
            case "depth_strider" -> Enchantments.DEPTH_STRIDER;

            case "luck_of_the_sea" -> Enchantments.LUCK_OF_THE_SEA;
            case "lure" -> Enchantments.LURE;

            default -> throw new IllegalArgumentException("Encantamento não mapeado: " + enchantId);
        };
    }
}
