package de.sh99.vaultx.manager;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface ChatManager
{
    public void setPermissionManager(PermissionManager permission);

    public PermissionManager getPermissionManager();

    public String getName();

    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public String getPrefix(Player player, World world);

    public String getPrefix(OfflinePlayer offlinePlayer, World world);

    public void setPrefix(Player player, String prefix, World world);

    public void setPrefix(OfflinePlayer offlinePlayer, String prefix, World world);

    public String getSuffix(Player player, World world);

    public String getSuffix(OfflinePlayer offlinePlayer, World world);

    public void setSuffix(Player player, String suffix, World world);

    public void setSuffix(OfflinePlayer offlinePlayer, String suffix, World world);

    public String getGroupPrefix(String group, String prefix, World world);

    public void setGroupPrefix(String group, String prefix, World world);

    public String getGroupSuffix(String group, String suffix, World world);

    public void setGroupSuffix(String group, String suffix, World world);

    public Object getPlayerInfoNode(Player player, String node, World world, Object defaultNode);

    public Object getPlayerInfoNode(OfflinePlayer offlinePlayer, String node, Object value, World world);

    public void setPlayerInfoNode(Player player, String node, Object value, World world);

    public void setPlayerInfoNode(OfflinePlayer offlinePlayer, String node, Object value, World world);

    public Object getGroupInfoNode(String group, String node, World world, Object defaultNode);

    public void setGroupInfoNode(String group, String node, Object value, World world);
}
