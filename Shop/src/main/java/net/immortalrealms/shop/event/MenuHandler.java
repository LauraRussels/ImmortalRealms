package net.immortalrealms.shop.event;

import net.immortalrealms.shop.inventory.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuHandler implements Listener {
    @EventHandler(ignoreCancelled = true) private void onClick(InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        if (!(holder instanceof Menu)) return;
        event.setCancelled(((Menu) holder).onClick((Player) event.getWhoClicked(), event.getSlot(), event.getClick()));
    }

    @EventHandler private void onOpen(InventoryOpenEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu) ((Menu) holder).onOpen((Player) event.getPlayer());
    }

    @EventHandler private void onClose(InventoryCloseEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu) ((Menu) holder).onClose((Player) event.getPlayer());
    }
}
