package com.amadeu.mineeconomy.command;

import com.amadeu.mineeconomy.shop.EmeraldShopOffers;
import com.amadeu.mineeconomy.shop.SimpleMerchant;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;

import java.util.List;
import java.util.OptionalInt;

public final class MerchantShopCommands {

    private MerchantShopCommands() {
    }

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(
                        CommandManager.literal("shop")
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    openShop(player);
                                    return 1;
                                })
                )
        );
    }

    private static void openShop(ServerPlayerEntity player) {
        List<TradeOffer> rawOffers = EmeraldShopOffers.createOffers(player);
        TradeOfferList offerList = new TradeOfferList();
        offerList.addAll(rawOffers);

        SimpleMerchant merchant = new SimpleMerchant(offerList);
        merchant.setCustomer(player);

        OptionalInt optionalSyncId = player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, p) -> new MerchantScreenHandler(syncId, inventory, merchant),
                Text.literal("Loja")
        ));

        if (optionalSyncId.isPresent()) {
            player.sendTradeOffers(
                    optionalSyncId.getAsInt(),
                    offerList,
                    0,
                    0,
                    false,
                    false
            );
        }
    }
}
