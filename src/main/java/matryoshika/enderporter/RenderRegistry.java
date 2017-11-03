package matryoshika.enderporter;

import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RenderRegistry {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerBlockRenderer(net.minecraftforge.client.event.ModelRegistryEvent event) {
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(TileEnderPorter.class, new EnderPorterTESR());
		
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Registry.ENDER_PORTER), 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(Registry.ENDER_PORTER.getRegistryName(), "inventory"));
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void highlight(net.minecraftforge.client.event.DrawBlockHighlightEvent event) {
		if(event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK) {
			if(event.getPlayer().world.getBlockState(event.getTarget().getBlockPos()).getBlock() == Registry.ENDER_PORTER )
				event.setCanceled(true);
		}
	}

}
