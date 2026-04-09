package com.amadeu.mineeconomy.shop;

import com.amadeu.mineeconomy.shop.reward.ItemRewardFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class EmeraldShopOffers {

    private static final int MAX_SINGLE_STACK_COST = 64;
    private static final int MAX_TOTAL_COST = 128;

    private EmeraldShopOffers() {
    }

    public static List<TradeOffer> createOffers(ServerPlayerEntity player) {
        List<TradeOffer> offers = new ArrayList<>();

        // ===== ENCANTAMENTOS =====
        offers.add(createOffer(35, ItemRewardFactory.createBasicPreservationBook(player)));
        offers.add(createOffer(35, ItemRewardFactory.createFishingRodBook(player)));
        offers.add(createOffer(120, ItemRewardFactory.createSwordBook(player)));
        offers.add(createOffer(128, ItemRewardFactory.createBowBook(player)));
        offers.add(createOffer(100, ItemRewardFactory.createPickaxeBook(player)));
        offers.add(createOffer(80, ItemRewardFactory.createShovelBook(player)));
        offers.add(createOffer(70, ItemRewardFactory.createHoeBook(player)));
        offers.add(createOffer(110, ItemRewardFactory.createHelmetBook(player)));
        offers.add(createOffer(120, ItemRewardFactory.createChestplateBook(player)));
        offers.add(createOffer(110, ItemRewardFactory.createLeggingsBook(player)));
        offers.add(createOffer(120, ItemRewardFactory.createBootsBook(player)));

        // ===== UTILIDADES =====
        offers.add(createOffer(18, ItemRewardFactory.createGoldenApple()));
        offers.add(createOffer(6, ItemRewardFactory.createGoldenCarrots()));
        

        return offers;
    }

    private static TradeOffer createOffer(int emeraldCost, ItemStack result) {
        if (emeraldCost <= 0) {
            throw new IllegalArgumentException("O custo da trade deve ser maior que zero.");
        }

        if (emeraldCost > MAX_TOTAL_COST) {
            throw new IllegalArgumentException(
                    "O custo " + emeraldCost + " excede o limite do merchant vanilla (" + MAX_TOTAL_COST + ")."
            );
        }

        TradeOffer offer;

        if (emeraldCost <= MAX_SINGLE_STACK_COST) {
            offer = new TradeOffer(
                    new TradedItem(Items.EMERALD, emeraldCost),
                    Optional.empty(),
                    result,
                    999999,
                    0,
                    0.05F
            );
        } else {
            int firstStack = MAX_SINGLE_STACK_COST;
            int secondStack = emeraldCost - MAX_SINGLE_STACK_COST;

            offer = new TradeOffer(
                    new TradedItem(Items.EMERALD, firstStack),
                    Optional.of(new TradedItem(Items.EMERALD, secondStack)),
                    result,
                    999999,
                    0,
                    0.05F
            );
        }

        offer.setSpecialPrice(0);
        return offer;
    }
}
