package matryoshika.enderporter;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(modid = EnderPorter.MODID)
public class RenderRegistry {
	
	@SubscribeEvent
	public static void registerBlockRenderer(ModelRegistryEvent event) {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEnderPorter.class, new EnderPorterTESR());
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Registry.ENDER_PORTER), 0, new ModelResourceLocation(Registry.ENDER_PORTER.getRegistryName(), "inventory"));
	}
	
	@SubscribeEvent
	public static void highlight(DrawBlockHighlightEvent event) {
		if(event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK) {
			if(event.getPlayer().world.getBlockState(event.getTarget().getBlockPos()).getBlock() == Registry.ENDER_PORTER )
				event.setCanceled(true);
		}
	}

}
