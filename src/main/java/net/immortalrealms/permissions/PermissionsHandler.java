package net.immortalrealms.permissions;

import net.immortalrealms.database.Database;
import org.bson.Document;
import org.bukkit.entity.Player;

public abstract class PermissionsHandler {
    /*
    Group Handling
     */

    public String getGroup(Player player) {
        final Document users = new Document("UUID", player.getUniqueId().toString());
        final Document found = Database.getUserDatabase().find(users).first();

        if(found != null) {
            return users.getString("GROUP");
        }
        return null;
    }

    public void setGroup(Player player, String group) {
        final Document users = new Document("UUID", player.getUniqueId().toString());
        final Document found = Database.getUserDatabase().find(users).first();

        if(found != null) {
            users.replace("GROUP", group);
        }
    }

    public boolean isAdministrator(Player player) {
        final Document users = new Document("UUID", player.getUniqueId().toString());
        final Document found = Database.getUserDatabase().find(users).first();

        return users.getString("GROUP").equals("Administrator") || users.getString("GROUP").equals("Owner");
    }
}
