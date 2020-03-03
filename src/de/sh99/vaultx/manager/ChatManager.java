package de.sh99.vaultx.manager;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import de.sh99.vaultx.env.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface ChatManager
{
    public void setPermission(Permission permission);

    public Permission getPermission();

    public String getName();

    public boolean isEnabled();

    public void setEnabled();

    public String getPrefix(@NotNull Player player, @Nullable World world);

    public String getPrefix(@NotNull OfflinePlayer offlinePlayer, @Nullable World world);

    public void setPrefix(@NotNull Player player, @NotNull String prefix, @Nullable World world);

    public void setPrefix(@NotNull OfflinePlayer offlinePlayer, @NotNull String prefix, @Nullable World world);

    public String getSuffix(@NotNull Player player, @Nullable World world);

    public String getSuffix(@NotNull OfflinePlayer offlinePlayer, @Nullable World world);

    public void setSuffix(Player player, @NotNull String suffix, @Nullable World world);

    public void setSuffix(OfflinePlayer offlinePlayer, @NotNull String suffix, @Nullable World world);

    public String getGroupPrefix(String group, @NotNull String prefix, @Nullable World world);

    public void setGroupPrefix(String group, @NotNull String prefix, @Nullable World world);

    public String getGroupSuffix(String group, @NotNull String suffix, @Nullable World world);

    public void setGroupSuffix(String group, @NotNull String suffix, @Nullable World world);

    public Object getPlayerInfoNode(Player player, @NotNull String node, @Nullable World world, @Nullable Object defaultNode);

    public Object getPlayerInfoNode(OfflinePlayer offlinePlayer, @NotNull String node, @NotNull Object value, @Nullable World world);

    public void setPlayerInfoNode(Player player, @NotNull String node, @NotNull Object value, @Nullable World world);

    public void setPlayerInfoNode(OfflinePlayer offlinePlayer, @NotNull String node, @NotNull Object value, @Nullable World world);

    public Object getGroupInfoNode(String group, @NotNull String node, @Nullable World world, @Nullable Object defaultNode);

    public void setGroupInfoNode(String group, @NotNull String node, @NotNull Object value, @Nullable World world);
}
