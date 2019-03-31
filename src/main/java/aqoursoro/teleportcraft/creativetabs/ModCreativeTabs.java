package aqoursoro.teleportcraft.creativetabs;

import static aqoursoro.teleportcraft.util.Reference.MOD_ID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry.ItemStackHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTabs 
{
	public static final String TAB_ICON_ITEM_REGISTRY_NAME = MOD_ID + ":" + "mythinium_block";
	
	@ItemStackHolder(value = TAB_ICON_ITEM_REGISTRY_NAME)
	public static final ItemStack TAB_ICON_ITEMSTACK = null;
	
	public static final CustomCreativeTab CREATIVE_TAB = new CustomCreativeTab(MOD_ID, true) 
	{
		
		@Override
		public ItemStack createIcon() 
		{
			return TAB_ICON_ITEMSTACK;
		}
	};
	
	public abstract static class CustomCreativeTab extends CreativeTabs 
	{
		private final boolean hasSearchBar;
		
		public CustomCreativeTab(final String name, final boolean hasSearchBar) 
		{
			super(name);
			this.hasSearchBar = hasSearchBar;
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		abstract public ItemStack createIcon();
		
		@Override
		public String getBackgroundImageName() 
		{
			if (this.hasSearchBar) 
			{
				return "item_search.png";
			} 
			else 
			{
				return super.getBackgroundImageName();
			}
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public void displayAllRelevantItems(final NonNullList<ItemStack> items) 
		{
			super.displayAllRelevantItems(items);
		}
		
		@Override
		public boolean hasSearchBar() 
		{
			return this.hasSearchBar;
		}

	}
}
