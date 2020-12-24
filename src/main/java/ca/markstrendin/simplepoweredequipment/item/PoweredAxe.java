package ca.markstrendin.simplepoweredequipment.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public class PoweredAxe extends AxeItem {
    public PoweredAxe() {
        // tier, attack damage, attack speed, builder ??
        super(ModItemTier.BASE, 2, -2.4F, new Item.Properties().maxStackSize(1));
    }
    
}
