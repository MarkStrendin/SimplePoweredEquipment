package ca.markstrendin.simplepoweredequipment;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.markstrendin.simplepoweredequipment.item.PoweredAxe;
import ca.markstrendin.simplepoweredequipment.item.PoweredPickaxe;
import ca.markstrendin.simplepoweredequipment.item.PoweredShovel;
import ca.markstrendin.simplepoweredequipment.item.PoweredSword;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("simplepoweredequipment")
public class SimplePoweredEquipment {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public SimplePoweredEquipment() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // preinit code
        LOGGER.info("Initializing SimplePoweredEquipment");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // client only code
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // send inter-mod comms
        // InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello
        // world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // receive inter-mod comms
        /*
         * LOGGER.info("Got IMC {}", event.getIMCStream().
         * map(m->m.getMessageSupplier().get()). collect(Collectors.toList()));
         */
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // On server start
        // LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the
    // contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        // Register blocks
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            // LOGGER.info("HELLO from Register Block");
        }

        // Register items
        @SubscribeEvent
        public static void  RegisterItems(final Register<Item> event) {
            event.getRegistry().registerAll(
                new PoweredSword().setRegistryName("powered_sword"),
                new PoweredPickaxe().setRegistryName("powered_pickaxe"),
                new PoweredAxe().setRegistryName("powered_axe"),
                new PoweredShovel().setRegistryName("powered_shovel")
            );
        }
    }
}
