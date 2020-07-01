package net.immortalrealms.shop;

import net.immortalrealms.shop.event.MenuHandler;
import net.immortalrealms.shop.inventory.Menu;
import net.immortalrealms.utility.ChatUtility;
import org.bukkit.Bukkit;
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

    private final Inventory shop = Bukkit.createInventory(this, 56, ChatUtility.colorText("&8Shop"));

    public Shop() {
        shop.setItem(0, new ItemStack(Material.AIR));
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
