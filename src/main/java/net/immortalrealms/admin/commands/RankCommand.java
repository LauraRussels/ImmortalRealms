package net.immortalrealms.admin.commands;

import net.immortalrealms.permissions.PermissionsHandler;
import net.immortalrealms.utils.ChatUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand extends PermissionsHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) commandSender.sendMessage("Player-only command.");

        final Player player = (Player) commandSender;

        if (!isAdministrator(player)) {
            player.sendMessage(ChatUtility.colorText("&4&l│ &cInsufficient permission."));
        }

        if (args.length < 2) {
            player.sendMessage(ChatUtility.colorText("&4&l│ &cUsage: /rank <user> <rank>."));
        }

        final Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            player.sendMessage(ChatUtility.colorText("&4&l│ &cThat player is not online."));
        } else {
            setGroup(target, args[1]);
            player.sendMessage(ChatUtility.colorText("&6&l│ &eSet " + target.getName() + "'s group to " + args[2] + "."));
        }
        return true;
    }
}
