package ca.markstrendin.simplepoweredequipment.item;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class PoweredPickaxe extends PickaxeItem {
    public PoweredPickaxe() {
        // tier, attack damage, attack speed, builder ??
        super(ModItemTier.BASE, 0, -2.4F, new Item.Properties().maxStackSize(1));
    }
    
}
