package com.amadeu.mineeconomy.shop;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.village.Merchant;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;

public class SimpleMerchant implements Merchant {

    private final TradeOfferList offers;
    private PlayerEntity customer;

    public SimpleMerchant(TradeOfferList offers) {
        this.offers = offers;
    }

    @Override
    public void setCustomer(PlayerEntity customer) {
        this.customer = customer;
    }

    @Override
    public PlayerEntity getCustomer() {
        return this.customer;
    }

    @Override
    public TradeOfferList getOffers() {
        return this.offers;
    }

    @Override
    public void setOffersFromServer(TradeOfferList offers) {
        this.offers.clear();
        this.offers.addAll(offers);
    }

    @Override
    public void trade(TradeOffer offer) {
        offer.use();
    }

    @Override
    public void onSellingItem(net.minecraft.item.ItemStack stack) {
    }

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public void setExperienceFromServer(int experience) {
    }

    @Override
    public boolean isLeveledMerchant() {
        return false;
    }

    @Override
    public SoundEvent getYesSound() {
        return null;
    }

    @Override
    public boolean canInteract(PlayerEntity player) {
        return true;
    }

    @Override
    public boolean isClient() {
        return false;
    }
}
