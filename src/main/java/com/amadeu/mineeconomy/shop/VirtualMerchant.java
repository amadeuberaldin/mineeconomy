package com.amadeu.mineeconomy.shop;

import com.amadeu.mineeconomy.shop.reward.ItemRewardFactory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;

import java.util.List;
import java.util.Optional;

public class VirtualMerchant extends ClientSideMerchant {

    private static final int MAX_SINGLE_STACK_COST = 64;
    private static final int MAX_TOTAL_COST = 128;

    public VirtualMerchant(ServerPlayer player, List<ShopEntry> entries) {
        super(player);

        MerchantOffers offers = this.getOffers();

        for (ShopEntry entry : entries) {
            int emeraldCost = entry.emeraldCost();

            if (emeraldCost <= 0) {
                throw new IllegalArgumentException("O custo da trade deve ser maior que zero.");
            }

            if (emeraldCost > MAX_TOTAL_COST) {
                throw new IllegalArgumentException(
                        "O custo " + emeraldCost + " excede o limite do merchant vanilla (" + MAX_TOTAL_COST + ")."
                );
            }

            ItemStack result = ItemRewardFactory.createFromEntry(player, entry);

            ItemCost firstCost;
            Optional<ItemCost> secondCost;

            if (emeraldCost <= MAX_SINGLE_STACK_COST) {
                firstCost = new ItemCost(Items.EMERALD, emeraldCost);
                secondCost = Optional.empty();
            } else {
                firstCost = new ItemCost(Items.EMERALD, MAX_SINGLE_STACK_COST);
                secondCost = Optional.of(new ItemCost(Items.EMERALD, emeraldCost - MAX_SINGLE_STACK_COST));
            }

            offers.add(new MerchantOffer(
                    firstCost,
                    secondCost,
                    result,
                    0,        // uses
                    999999,   // maxUses
                    0,        // xp
                    0.05f     // priceMultiplier
            ));
        }
    }
}
