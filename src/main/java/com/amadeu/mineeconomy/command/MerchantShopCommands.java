package com.amadeu.mineeconomy.command;

import com.amadeu.mineeconomy.shop.EmeraldShopOffers;
import com.amadeu.mineeconomy.shop.ShopEntry;
import com.amadeu.mineeconomy.shop.VirtualMerchant;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public final class MerchantShopCommands {

    private MerchantShopCommands() {}

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(
                        Commands.literal("shop")
                                .executes(MerchantShopCommands::executeShopCommand)
                )
        );
    }

    private static int executeShopCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();

        List<ShopEntry> entries = EmeraldShopOffers.createOffers();
        VirtualMerchant merchant = new VirtualMerchant(player, entries);

        merchant.openTradingScreen(player, Component.literal("Loja Global"), 0);

        return 1;
    }
}
