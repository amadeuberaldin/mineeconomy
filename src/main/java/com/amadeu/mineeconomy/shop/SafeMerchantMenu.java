package com.amadeu.mineeconomy.shop;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;

/*
 * Menu seguro da loja virtual.
 *
 * Usado no /shop para impedir o Shift + Clique dentro do MerchantMenu.
 *
 * Motivo:
 * O MerchantMenu vanilla chama quickMoveStack() quando o jogador usa Shift + Clique.
 * Nesse caminho, ele tenta tocar som de trade tratando o Merchant como Entity.
 * Como nosso VirtualMerchant é ClientSideMerchant, e não Entity, isso gera ClassCastException
 * e pode causar rollback/exploit de item infinito.
 */
public class SafeMerchantMenu extends MerchantMenu {

    public SafeMerchantMenu(int containerId, Inventory playerInventory, Merchant merchant) {
        super(containerId, playerInventory, merchant);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return ItemStack.EMPTY;
    }
}
