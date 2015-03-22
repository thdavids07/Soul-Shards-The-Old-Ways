package com.whammich.sstow.utils;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.whammich.sstow.SSTheOldWays;
import com.whammich.sstow.block.BlockCage;
import com.whammich.sstow.block.BlockForge;
import com.whammich.sstow.block.BlockPetrified;
import com.whammich.sstow.block.BlockSoulium;
import com.whammich.sstow.block.BlockXenolith;
import com.whammich.sstow.enchantment.EnchantmentSoulStealer;
import com.whammich.sstow.guihandler.GuiHandler;
import com.whammich.sstow.item.ItemMaterials;
import com.whammich.sstow.item.ItemAxeSoul;
import com.whammich.sstow.item.ItemHoeSoul;
import com.whammich.sstow.item.ItemPickaxeSoul;
import com.whammich.sstow.item.ItemShardSoul;
import com.whammich.sstow.item.ItemSpadeSoul;
import com.whammich.sstow.item.ItemSwordSoul;
import com.whammich.sstow.item.ItemfixedAchievement;
import com.whammich.sstow.item.blocks.ItemBlockPetrified;
import com.whammich.sstow.tileentity.TileEntityCage;
import com.whammich.sstow.tileentity.TileEntityForge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {
	// Tool material for the soul tools/sword
	public static ToolMaterial SOULIUM = EnumHelper.addToolMaterial("SOULIUM",
			3, 3122, 12.0F, 6F, 30);

	// Setting up the enchantment details from the config
	public static Enchantment SOUL_STEALER = new EnchantmentSoulStealer(
			Config.ENCHANT_ID, Config.ENCHANT_WEIGHT);

	// Set the creative tab
	public static SoulShardTab CREATIVE_TAB = new SoulShardTab();

	// Set up the mod items
	public static Item ItemMaterials = new ItemMaterials();
	public static Item ItemFixedDummy = new ItemfixedAchievement();
	public static Item ItemShardSoul = new ItemShardSoul();
	public static Item ItemSwordSoul = new ItemSwordSoul(SOULIUM);
	public static Item ItemPickaxeSoul = new ItemPickaxeSoul(SOULIUM);
	public static Item ItemAxeSoul = new ItemAxeSoul(SOULIUM);
	public static Item ItemHoeSoul = new ItemHoeSoul(SOULIUM);
	public static Item ItemSpadeSoul = new ItemSpadeSoul(SOULIUM);

	// Set up the mod blocks
	public static Block BlockCage = new BlockCage();
	public static Block BlockForge = new BlockForge(false).setCreativeTab(CREATIVE_TAB);
	public static Block BlockForgeActive = new BlockForge(true).setBlockName("sstow.forge_block_active");;
	public static Block BlockSoulium = new BlockSoulium();
	public static Block BlockXenolith = new BlockXenolith();

	public static Block BlockPetrifiedOak;
	public static Block BlockPetrifiedSpruce;
	public static Block BlockPetrifiedBirch;
	public static Block BlockPetrifiedJungle;
	public static Block BlockPetrifiedAcacia;
	public static Block BlockPetrifiedBigOak;
	
	public static void registerObjs() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SSTheOldWays.modInstance,
				new GuiHandler());

		registerItems();
		registerBlocks();
		registerOreDictEntries();
		registerTileEntities();
		registerRecipes();


	}

	private static void registerItems() {
		if (Loader.isModLoaded("MineFactoryReloaded"))
			GameRegistry.registerItem(ItemFixedDummy, "ItemFixedDummy");

		GameRegistry.registerItem(ItemMaterials, "ItemMaterialsSoul");

		GameRegistry.registerItem(ItemSwordSoul, "ItemSwordSoul");
		GameRegistry.registerItem(ItemPickaxeSoul, "ItemPickaxeSoul");
		GameRegistry.registerItem(ItemAxeSoul, "ItemAxeSoul");
		GameRegistry.registerItem(ItemHoeSoul, "ItemHoeSoul");
		GameRegistry.registerItem(ItemSpadeSoul, "ItemSpadeSoul");
		GameRegistry.registerItem(ItemShardSoul, "ItemShardSoul");
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(BlockForge, "BlockForge");
		GameRegistry.registerBlock(BlockForgeActive, BlockForgeActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockSoulium, "sstow_soulium_block");
		GameRegistry.registerBlock(BlockCage, "sstow_soul_cage");
		GameRegistry.registerBlock(BlockXenolith, "sstow_xenolith");
		
		
		BlockPetrifiedOak = new BlockPetrified("Oak");
		GameRegistry.registerBlock(BlockPetrifiedOak, ItemBlockPetrified.class, "PetrifiedOak");
		
		BlockPetrifiedSpruce = new BlockPetrified("Spruce");
		GameRegistry.registerBlock(BlockPetrifiedSpruce, ItemBlockPetrified.class, "PetrifiedSpruce");
		
		BlockPetrifiedBirch = new BlockPetrified("Birch");
		GameRegistry.registerBlock(BlockPetrifiedBirch, ItemBlockPetrified.class, "PetrifiedBirch");
		
		BlockPetrifiedJungle = new BlockPetrified("Jungle");
		GameRegistry.registerBlock(BlockPetrifiedJungle, ItemBlockPetrified.class, "PetrifiedJungle");
		
		BlockPetrifiedAcacia = new BlockPetrified("Acacia");
		GameRegistry.registerBlock(BlockPetrifiedAcacia, ItemBlockPetrified.class, "PetrifiedAcacia");
		
		BlockPetrifiedBigOak = new BlockPetrified("Big_Oak");
		GameRegistry.registerBlock(BlockPetrifiedBigOak, ItemBlockPetrified.class, "PetrifiedBigOak");
	
	}

	private static void registerOreDictEntries() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(ItemMaterials, 1,
				0));
		OreDictionary.registerOre("nuggetSoulium", new ItemStack(ItemMaterials,
				1, 1));
		OreDictionary.registerOre("ingotSoulium", new ItemStack(ItemMaterials,
				1, 2));
		OreDictionary.registerOre("dustVile",
				new ItemStack(ItemMaterials, 1, 3));
		OreDictionary.registerOre("essenceCorrupted", new ItemStack(
				ItemMaterials, 1, 4));
	}

	private static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityForge.class,
				"sstow_soul_forge_tile");
		GameRegistry.registerTileEntity(TileEntityCage.class,
				"sstow_soul_cage_tile");
	}

	private static void registerRecipes() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
				ItemMaterials, 9, 2), BlockSoulium));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
				ItemMaterials, 9, 1), "ingotSoulium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
				ItemMaterials, 9, 0), "ingotIron"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockForge),
				"SSS", "SCS", "OOO", 'S', "cobblestone", 'C',
				"essenceCorrupted", 'O', Blocks.obsidian));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemMaterials,
				1, 2), "AAA", "AAA", "AAA", 'A', "nuggetSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				Items.iron_ingot), "AAA", "AAA", "AAA", 'A', "nuggetIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockSoulium),
				"AAA", "AAA", "AAA", 'A', "ingotSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(
				new ItemStack(ItemSwordSoul), "A", "A", "B", 'A',
				"ingotSoulium", 'B', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				ItemPickaxeSoul), "AAA", "CBC", "CBC", 'A', "ingotSoulium",
				'B', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemAxeSoul),
				"AA", "AB", "CB", 'A', "ingotSoulium", 'B', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemHoeSoul),
				"AA", "CB", "CB", 'A', "ingotSoulium", 'B', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(
				new ItemStack(ItemSpadeSoul), "A", "B", "B", 'A',
				"ingotSoulium", 'B', "ingotIron"));
		GameRegistry
				.addRecipe(new ShapedOreRecipe(new ItemStack(BlockCage), "SIS",
						"IXI", "SIS", 'I', Blocks.iron_bars, 'S',
						"ingotSoulium"));

		if (Loader.isModLoaded("Natura")) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
					ItemMaterials, 2, 3), Blocks.soul_sand, "dustGlowstone"));
			GameRegistry.addSmelting(new ItemStack(ItemMaterials, 1, 3),
					new ItemStack(ItemMaterials, 1, 4), 0.35F);
		} else {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
					ItemMaterials, 1, 4), "dustGlowstone", "dustVile"));
			GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(
					ItemMaterials, 1, 3), 0.35F);
		}
	}
}