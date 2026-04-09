package com.amadeu.mineeconomy.shop.reward;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public final class ItemRewardFactory {

    private ItemRewardFactory() {
    }

    public static ItemStack createBasicPreservationBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro Basico de Preservacao");
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        addEnchantment(stack, player, Enchantments.VANISHING_CURSE, 1);
        return stack;
    }

    public static ItemStack createSwordBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Espada");
        addEnchantment(stack, player, Enchantments.SHARPNESS, 5);
        addEnchantment(stack, player, Enchantments.LOOTING, 3);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        addEnchantment(stack, player, Enchantments.FIRE_ASPECT, 2);
        addEnchantment(stack, player, Enchantments.KNOCKBACK, 2);
        return stack;
    }

    public static ItemStack createBowBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro do Arco");
        addEnchantment(stack, player, Enchantments.POWER, 5);
        addEnchantment(stack, player, Enchantments.INFINITY, 1);
        addEnchantment(stack, player, Enchantments.FLAME, 1);
        addEnchantment(stack, player, Enchantments.PUNCH, 2);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        return stack;
    }

    public static ItemStack createPickaxeBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Picareta");
        addEnchantment(stack, player, Enchantments.EFFICIENCY, 5);
        addEnchantment(stack, player, Enchantments.FORTUNE, 3);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createShovelBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Pa");
        addEnchantment(stack, player, Enchantments.EFFICIENCY, 5);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        addEnchantment(stack, player, Enchantments.SILK_TOUCH, 1);
        return stack;
    }

    public static ItemStack createHoeBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Enxada");
        addEnchantment(stack, player, Enchantments.EFFICIENCY, 5);
        addEnchantment(stack, player, Enchantments.FORTUNE, 3);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createHelmetBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro do Capacete");
        addEnchantment(stack, player, Enchantments.PROTECTION, 4);
        addEnchantment(stack, player, Enchantments.RESPIRATION, 3);
        addEnchantment(stack, player, Enchantments.AQUA_AFFINITY, 1);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createChestplateBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro do Peitoral");
        addEnchantment(stack, player, Enchantments.PROTECTION, 4);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createLeggingsBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Calca");
        addEnchantment(stack, player, Enchantments.PROTECTION, 4);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createBootsBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Bota");
        addEnchantment(stack, player, Enchantments.PROTECTION, 4);
        addEnchantment(stack, player, Enchantments.FEATHER_FALLING, 4);
        addEnchantment(stack, player, Enchantments.DEPTH_STRIDER, 3);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);
        return stack;
    }

    public static ItemStack createGoldenApple() {
        return new ItemStack(Items.GOLDEN_APPLE, 1);
    }

    public static ItemStack createGoldenCarrots() {
        return new ItemStack(Items.GOLDEN_CARROT, 4);
    }

   public static ItemStack createFishingRodBook(ServerPlayerEntity player) {
        ItemStack stack = createEnchantedBookBase("Livro da Vara");

        addEnchantment(stack, player, Enchantments.LUCK_OF_THE_SEA, 3);
        addEnchantment(stack, player, Enchantments.LURE, 3);
        addEnchantment(stack, player, Enchantments.UNBREAKING, 3);
        addEnchantment(stack, player, Enchantments.MENDING, 1);

        return stack;
    }

    private static ItemStack createEnchantedBookBase(String customName) {
        ItemStack stack = new ItemStack(Items.ENCHANTED_BOOK);
        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(customName));
        return stack;
    }

    private static void addEnchantment(
            ItemStack stack,
            ServerPlayerEntity player,
            net.minecraft.registry.RegistryKey<Enchantment> enchantmentKey,
            int level
    ) {
        RegistryWrapper.Impl<Enchantment> enchantmentLookup =
                player.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);

        ItemEnchantmentsComponent existing = stack.getOrDefault(
                DataComponentTypes.STORED_ENCHANTMENTS,
                ItemEnchantmentsComponent.DEFAULT
        );

        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(existing);

        enchantmentLookup.getOptional(enchantmentKey).ifPresent(entry -> builder.add(entry, level));

        stack.set(DataComponentTypes.STORED_ENCHANTMENTS, builder.build());
    }
}
