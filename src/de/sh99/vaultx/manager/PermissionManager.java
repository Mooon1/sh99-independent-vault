package de.sh99.vaultx.manager;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface PermissionManager
{
    public String getName();

    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public boolean isSuperPermsCompatible();

    public boolean has(CommandSender sender, String permission);

    public boolean add(OfflinePlayer offlinePlayer, String permission, World world);

    public boolean add(Player player, String permission, World world);

    public boolean remove(OfflinePlayer offlinePlayer, String permission, World world);

    public boolean remove(Player player, String permission, World world);

    public boolean addTransient(Player player, String permission, World world);

    public boolean addTransient(OfflinePlayer offlinePlayer, String permission, World world);

    public boolean removeTransient(Player player, String permission, World world);

    public boolean removeTransient(OfflinePlayer offlinePlayer, String permission, World world);

    public boolean groupHas(String group, String permission, World world);

    public boolean groupRemove(String group, String permission, World world);

    public boolean isMember(String group, Player player, World world);

    public boolean isMember(String group, OfflinePlayer player, World world);

    public boolean addMember(String group, Player player, World world);

    public boolean addMember(String group, OfflinePlayer player, World world);

    public boolean removeMember(String group, Player player, World world);

    public boolean removeMember(String group, OfflinePlayer player, World world);

    public List<String> getGroupsByPlayer(Player player, World world);

    public List<String> getGroupsByPlayer(OfflinePlayer offlinePlayer, World world);

    public String getPrimaryGroup(Player player, World world);

    public String getPrimaryGroup(OfflinePlayer offlinePlayer, World world);

    public List<String> getGroups();

    public boolean hasGroupSupport();
}
