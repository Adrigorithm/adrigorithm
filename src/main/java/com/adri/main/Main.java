package com.adri.main;

import static com.adri.main.Main.MOD_ID;

import com.adri.main.blocks.FirstBlock;
import com.adri.main.blocks.ModBlocks;
import com.adri.main.setup.ClientProxy;
import com.adri.main.setup.IProxy;
import com.adri.main.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MOD_ID)
public class Main {
    public static final String MOD_ID = "adrigorithm";
    private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);



    public Main(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> event){
            event.getRegistry().register(new FirstBlock());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event){
            event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, new Item.Properties()).setRegistryName("firstblock"));
        }
    }
}
