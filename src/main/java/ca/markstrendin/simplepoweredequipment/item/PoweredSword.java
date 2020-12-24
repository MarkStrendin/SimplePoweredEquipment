package ca.markstrendin.simplepoweredequipment.item;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class PoweredSword extends SwordItem {
    public PoweredSword() {
        super(ModItemTier.BASE, 4, -2.4F, new Item.Properties().maxStackSize(1));
    }    
}
