package net.zappfire.beyond_complex;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zappfire.beyond_complex.block.ModBlocks;
import net.zappfire.beyond_complex.block.entity.ModBlockEntities;
import net.zappfire.beyond_complex.item.ModItems;
import net.zappfire.beyond_complex.screen.ModMenuTypes;
import net.zappfire.beyond_complex.screen.SimpleAlloyKilnScreen;
import org.slf4j.Logger;

@Mod(BeyondComplex.MODID)
public class BeyondComplex
{
    public static final String MODID = "beyond_complex";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BeyondComplex()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void clientSetup(final FMLCommonSetupEvent event) {

        MenuScreens.register(ModMenuTypes.SIMPLE_ALLOY_KILN_MENU.get(), SimpleAlloyKilnScreen::new);
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
