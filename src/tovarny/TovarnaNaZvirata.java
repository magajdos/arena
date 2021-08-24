package tovarny;

import com.google.common.collect.Lists;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TovarnaNaZvirata {
    private final TovarnaNaZbrane tovarnaNaZbrane;
    private final TovarnaNaZbroje tovarnaNaZbroje;

    public TovarnaNaZvirata() {
        tovarnaNaZbrane = new TovarnaNaZbrane();
        tovarnaNaZbroje = new TovarnaNaZbroje();
    }

    public void vyrobVesnicana(World svet, Location location) {
        var trader = (WanderingTrader) svet.spawnEntity(location, EntityType.WANDERING_TRADER);
        trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

        //training

        MerchantRecipe trainingSword = new MerchantRecipe(tovarnaNaZbrane.vyrobTrainingSword(), 999);
        trainingSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

        MerchantRecipe trainingHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingHelmet(), 999);
        trainingHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

        MerchantRecipe trainingChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingChestPlate(), 999);
        trainingChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

        MerchantRecipe trainingLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingLeggins(), 999);
        trainingLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

        MerchantRecipe trainingBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingBoots(), 999);
        trainingBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

        //nomal

        MerchantRecipe normalSword = new MerchantRecipe(tovarnaNaZbrane.vyrobNormalSword(), 999);
        normalSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

        MerchantRecipe chainMaleHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleHelmet(), 999);
        chainMaleHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

        MerchantRecipe chainMaleChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleChestPlate(), 999);
        chainMaleChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

        MerchantRecipe chainMaleLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleLeggins(), 999);
        chainMaleLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

        MerchantRecipe chainMaleBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleBoots(), 999);
        chainMaleBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

        //pro

        MerchantRecipe proSword = new MerchantRecipe(tovarnaNaZbrane.vyrobProSword(), 999);
        proSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

        MerchantRecipe plateHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateHelmet(), 999);
        plateHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

        MerchantRecipe chestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChestPlate(), 999);
        chestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

        MerchantRecipe plateLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateLeggins(), 999);
        plateLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

        MerchantRecipe plateBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingBoots(), 999);
        plateBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

        //Gladiator

        MerchantRecipe gladiatorSword = new MerchantRecipe(tovarnaNaZbrane.vyrobGladiatorSword(), 999);
        gladiatorSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 60));

        MerchantRecipe gladiatorHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorHelmet(), 999);
        gladiatorHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

        MerchantRecipe gladiatorChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorChestplate(), 999);
        gladiatorChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

        MerchantRecipe gladiatorLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorLeggins(), 999);
        gladiatorLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

        MerchantRecipe gladiatorBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorBoots(), 999);
        gladiatorBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));


        //items

        MerchantRecipe stit = new MerchantRecipe(tovarnaNaZbrane.vyrobStit(), 999);
        stit.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

        MerchantRecipe maso = new MerchantRecipe(tovarnaNaZbrane.horaMasa(), 30);
        maso.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

        MerchantRecipe zlateJabko = new MerchantRecipe(tovarnaNaZbrane.vyrobZlateJabko(), 999);
        zlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

        MerchantRecipe ocarovaneZlateJabko = new MerchantRecipe(tovarnaNaZbrane.vyrobOcarovaneZlateJablko(), 999);
        ocarovaneZlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

        trader.setRecipes(
                Lists.newArrayList(trainingSword, trainingHelmet, trainingChestPlate, trainingLeggins, trainingBoots, normalSword,
                        chainMaleHelmet, chainMaleChestPlate, chainMaleLeggins, chainMaleBoots, proSword, plateHelmet, chestPlate,
                        plateLeggins, plateBoots, gladiatorSword, gladiatorHelmet, gladiatorChestPlate, gladiatorLeggins, gladiatorBoots,
                        stit, maso, zlateJabko, ocarovaneZlateJabko));

    }
    public void vyrobObchodnika(World svet, Location location) {
        var trader = (WanderingTrader) svet.spawnEntity(location, EntityType.WANDERING_TRADER);
        trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

        MerchantRecipe shnileMaso = new MerchantRecipe(tovarnaNaZbrane.vyrobKorunu(), 99999);
        shnileMaso.addIngredient(new ItemStack(Material.ROTTEN_FLESH, 1));

        MerchantRecipe prasek = new MerchantRecipe(tovarnaNaZbrane.vyrobKorunu(), 999999);
        prasek.addIngredient(new ItemStack(Material.GUNPOWDER, 1));

        MerchantRecipe kost = new MerchantRecipe(tovarnaNaZbrane.vyrobKorunu(), 999999);
        kost.addIngredient(new ItemStack(Material.BONE, 1));
        trader.setRecipes(Lists.newArrayList(shnileMaso, prasek, kost));
    }
}
