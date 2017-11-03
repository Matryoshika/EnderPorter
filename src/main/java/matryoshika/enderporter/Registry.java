package matryoshika.enderporter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber(modid = EnderPorter.MODID)
public class Registry {
	
	public static Set<Block> blocks = new HashSet<Block>();
	public static Block ENDER_PORTER;

	public static void prepareBlocks() {
		blocks.add(ENDER_PORTER = new BlockEnderPorter());
	}

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		prepareBlocks();
		blocks.forEach(event.getRegistry()::register);
	}

	@SubscribeEvent
	public static void registerBlock(Register<Item> event) {
		blocks.stream().map(block -> new ItemBlock(block).setRegistryName(block.getRegistryName())).collect(Collectors.toList()).forEach(event.getRegistry()::register);
	}
}
