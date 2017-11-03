package matryoshika.enderporter;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = EnderPorter.MODID, version = EnderPorter.VERSION, name = EnderPorter.NAME)
public class EnderPorter {
	public static final String MODID = "enderporter";
	public static final String VERSION = "1.0";
	public static final String NAME = "EnderPorter";

	public static final CreativeTabEnderPorter EnderPorterTab = new CreativeTabEnderPorter("EnderPorter") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.ENDER_EYE);
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEnderPorter.class, "enderporter:enderporter");
	}

	public static class CreativeTabEnderPorter extends CreativeTabs {

		public CreativeTabEnderPorter(String label) {
			super(label);
		}

		@Override
		public ItemStack getTabIconItem() {
			return ItemStack.EMPTY;
		}

		@Override
		public String getTranslatedTabLabel() {
			return this.getTabLabel();
		}
	}
}
