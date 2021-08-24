package tovarny;


import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class TovarnaNaZbrane {

    public static final String FROZEN_SWORD = "FROZEN SWORD";
    public static final String HEALING_SWORD = "HEALING SWORD";

    //NORMALNI ZBRANE
    public ItemStack vyrobTrainingSword() {
        var trainingSword = new ItemStack(Material.WOODEN_SWORD, 1);
        var itemMeta = trainingSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        trainingSword.setItemMeta(itemMeta);
        return trainingSword;
    }

    public ItemStack vyrobNormalSword() {
        var normalSword = new ItemStack(Material.IRON_SWORD, 1);
        var itemMeta = normalSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Normal Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        normalSword.setItemMeta(itemMeta);
        return normalSword;
    }

    public ItemStack vyrobProSword() {
        var proSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        var itemMeta = proSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Pro Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        proSword.setItemMeta(itemMeta);
        return proSword;
    }

    public ItemStack vyrobGladiatorSword() {
        var gladiatorSword = new ItemStack(Material.GOLDEN_SWORD, 1);
        var itemMeta = gladiatorSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        gladiatorSword.setItemMeta(itemMeta);
        return gladiatorSword;
    }

//VECI
    public ItemStack vyrobStit() {
        var stit = new ItemStack(Material.SHIELD, 1);
        var itemMeta = stit.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Shield");
        stit.setItemMeta(itemMeta);
        return stit;
    }

    public ItemStack horaMasa() {
        var maso = new ItemStack(Material.COOKED_RABBIT, 64);
        return maso;
    }

    public ItemStack vyrobZlateJabko() {
        var zlateJabko = new ItemStack(Material.GOLDEN_APPLE, 1);
        return zlateJabko;
    }

    public ItemStack vyrobOcarovaneZlateJablko() {
        var ocarovaneZlateJabloko = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        return ocarovaneZlateJabloko;
    }

    public ItemStack vyrobKorunu() {
        var koruna = new ItemStack(Material.GOLD_NUGGET, 1);
        return koruna;
    }

    public ItemStack vyrobLapizLazuli() {
        var lapiz = new ItemStack(Material.LAPIS_LAZULI);
        return lapiz;
    }

    //ARTEFAKTY
    public ItemStack vyrobFrozenSword() {
        var frozenSword = new ItemStack(Material.DIAMOND_SWORD);
        var itemMeta = frozenSword.getItemMeta();
        itemMeta.setDisplayName(FROZEN_SWORD);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 6, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        frozenSword.setItemMeta(itemMeta);
        return frozenSword;
    }

    public ItemStack vyrobHealingSword() {
        var healingSword = new ItemStack(Material.IRON_SWORD);
        var itemMeta = healingSword.getItemMeta();
        itemMeta.setDisplayName(HEALING_SWORD);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        healingSword.setItemMeta(itemMeta);
        return healingSword;
    }

    public ItemStack vyrobBrokovnici() {
        var brokovnice = new ItemStack(Material.CROSSBOW);
        brokovnice.addEnchantment(Enchantment.MULTISHOT, 1);
        brokovnice.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        var itemMeta = brokovnice.getItemMeta();
        itemMeta.setDisplayName("SHOTGUN");
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        brokovnice.setItemMeta(itemMeta);
        return brokovnice;
    }

    public ItemStack vyrobSnipu() {
        var snipa = new ItemStack(Material.CROSSBOW);
        snipa.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        var itemMeta = snipa.getItemMeta();
        itemMeta.setDisplayName("SNIPE");
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        snipa.setItemMeta(itemMeta);
        return snipa;
    }

    public ItemStack vyrobFlamingSword() {
        var flaminSword = new ItemStack(Material.GOLDEN_SWORD);
        var itemMeta = flaminSword.getItemMeta();
        itemMeta.setDisplayName("FLAMING SWORD");
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 7, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        flaminSword.setItemMeta(itemMeta);
        return flaminSword;
    }

    public ItemStack vyrobEndSword(){
        var endSword = new ItemStack(Material.NETHERITE_SWORD);
        var itemMeta = endSword.getItemMeta();
        itemMeta.setDisplayName("END SWORD");
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 8, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        endSword.setItemMeta(itemMeta);
        return endSword;
    }

    public ItemStack vyrobInfinytyPerl(){
        var pearl = new ItemStack(Material.ENDER_PEARL);
        var itemMeta = pearl.getItemMeta();
        itemMeta.setDisplayName("INFINITY PERL");
        pearl.setItemMeta(itemMeta);
        return pearl;
    }

    public ItemStack vyrobWaterTrident() {
        var waterTrident = new ItemStack(Material.TRIDENT);
        waterTrident.addEnchantment(Enchantment.LOYALTY,1);
        waterTrident.addEnchantment(Enchantment.CHANNELING,1);
        var itemMeta = waterTrident.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("WATER TRIDENT");
        waterTrident.setItemMeta(itemMeta);
        return waterTrident;
    }
}
