package com.amadeu.mineeconomy.command;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public final class MerchantShopCommands {

    private MerchantShopCommands() {
    }

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(
                        Commands.literal("shop")
                                .executes(MerchantShopCommands::executeShopCommand)
                )
        );
    }

    private static int executeShopCommand(CommandContext<CommandSourceStack> context) {
        context.getSource().sendSuccess(
                () -> Component.literal("Loja em desenvolvimento (1.26)"),
                false
        );
        return 1;
    }
}
