package permission.permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class permissions extends JavaPlugin {

    @Override
    public void onEnable() {
    }

    HashMap<UUID, PermissionAttachment> attachments = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("perm")) {
            Player ps = Bukkit.getPlayer(args[0]);
            PermissionAttachment attachment = ps.addAttachment(this);
            Player p = (Player) sender;
            if (sender instanceof Player) {
                if (p.hasPermission("perm.setperm")) {
                    if (args.length > 2) {
                        attachment.setPermission(args[1], Boolean.parseBoolean(args[2]));
                    } else {
                        p.sendMessage("Please specify correct arguments: /perm <player> <permission> <true/false>");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
                }
            }
            else {
                if (args.length > 2) {
                    attachment.setPermission(args[1], Boolean.parseBoolean(args[2]));
                } else {
                    System.out.println("Please specify correct arguments: /perm <player> <permission> <true/false>");
                }
            }
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
