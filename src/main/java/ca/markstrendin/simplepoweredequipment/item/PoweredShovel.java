package ca.markstrendin.simplepoweredequipment.item;

import ca.markstrendin.simplepoweredequipment.energy.EnergyCapabilityProvider;
import ca.markstrendin.simplepoweredequipment.energy.ItemEnergyStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

public class PoweredShovel extends ShovelItem {
    public PoweredShovel() {
        // tier, attack damage, attack speed, builder ??
        super(ModItemTier.BASE, -1, -2.4F, new Item.Properties().maxStackSize(1));
    }
    private static int EnergyCapacity = 500;

    private static final IEnergyStorage storedEnergy = new EnergyStorage(EnergyCapacity);

    public IEnergyStorage getEnergyStorage(ItemStack stack) {
		if (CapabilityEnergy.ENERGY == null)
			return storedEnergy;

		return stack.getCapability(CapabilityEnergy.ENERGY).orElse(storedEnergy);
    }

    @Override
	public double getDurabilityForDisplay(ItemStack stack) {
		IEnergyStorage energy = this.getEnergyStorage(stack);
		double stored = energy.getMaxEnergyStored() - energy.getEnergyStored();
		return stored / energy.getMaxEnergyStored();
    }
    
    @Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
    }
    
    @Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
		return new EnergyCapabilityProvider(new ItemEnergyStorage(stack, EnergyCapacity));
    }
    
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockPos blockpos1 = blockpos.offset(context.getFace());
        PlayerEntity playerEntity = context.getPlayer();

        IEnergyStorage energy = this.getEnergyStorage(context.getItem());

        // This is just debug code to see how this works
        energy.receiveEnergy(10, false);

        return ActionResultType.SUCCESS;

        
    }

}
