package net.immortalrealms.shop;

import net.immortalrealms.shop.event.MenuHandler;
import net.immortalrealms.shop.inventory.Menu;
import net.immortalrealms.utility.ChatUtility;
import net.immortalrealms.utility.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Shop extends JavaPlugin implements Menu {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuHandler(), this);
        super.onEnable();
    }

    private final Inventory shop = Bukkit.createInventory(this, 56, ChatUtility.colorText("&8Shop Browser"));

    public Shop() {
        ItemStack holder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        for(int i = 0; i < 56; i++) {
            switch(i) {
                case 19:
                    GUI.itemBuild(Material.STONE, 1,
                            ChatColor.GOLD + "* Blocks *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 20:
                    GUI.itemBuild(Material.DIAMOND_SWORD, 1,
                            ChatColor.GOLD + "* Weapons *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 21:
                    GUI.itemBuild(Material.BOW, 1,
                            ChatColor.GOLD + "* Archery *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 22:
                    GUI.itemBuild(Material.DIAMOND_CHESTPLATE, 1,
                            ChatColor.GOLD + "* Armour *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 23:
                    GUI.itemBuild(Material.ENCHANTED_BOOK, 1,
                            ChatColor.GOLD + "* Enchants *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 24:
                    GUI.itemBuild(Material.TNT, 1,
                            ChatColor.GOLD + "* Utility *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 25:
                    GUI.itemBuild(Material.BREWING_STAND_ITEM, 1,
                            ChatColor.GOLD + "* Potions *",
                            ChatColor.GRAY + "Left-click to view more options.");
                case 31:
                    GUI.itemBuild(Material.GOLD_NUGGET, 1,
                            ChatColor.GOLD + "* Balance *",
                            ChatColor.GRAY + "Current balance: " + ChatColor.YELLOW + "0");
                case 49:
                    GUI.itemBuild(Material.BARRIER, 1,
                            ChatColor.RED + "CLOSE",
                            ChatColor.GRAY + "Close inventory.");
                default:
                    shop.setItem(i, holder);
            }
        }
    }

    @Override
    public void onOpen(Player player) {

    }

    @Override
    public void onClose(Player player) {

    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        return false;
    }

    @Override
    public Inventory getInventory() {
        return shop;
    }
}
