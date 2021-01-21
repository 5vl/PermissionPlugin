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
            PermissionAttachment attachment = Bukkit.getPlayer(args[0]).addAttachment(this);
            Player p = (Player) sender;
            if (p.hasPermission("perm.perm")) {
                if (args.length < 3) {
                    p.sendMessage("Usage: /perm <player> <permission> <true/false>");
                }
                else if (args.length == 3) {
                    attachment.setPermission(args[1], Boolean.parseBoolean(args[2]));
                    p.sendMessage(ChatColor.WHITE + "Successfully set permission " + ChatColor.YELLOW + args[1] + ChatColor.WHITE + " to " + ChatColor.YELLOW + args[2] + ChatColor.WHITE + " for player " + ChatColor.YELLOW + args[0]);
                }
                else {
                    p.sendMessage("Usage: /perm <player> <permission> <true/false>");
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            }
        }
        return false;
    }
}
