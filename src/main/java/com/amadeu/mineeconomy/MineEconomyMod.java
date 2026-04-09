package com.amadeu.mineeconomy;

import com.amadeu.mineeconomy.command.MerchantShopCommands;
import net.fabricmc.api.ModInitializer;

public class MineEconomyMod implements ModInitializer {

    public static final String MOD_ID = "mineeconomy";

    @Override
    public void onInitialize() {
        MerchantShopCommands.register();
    }
}
