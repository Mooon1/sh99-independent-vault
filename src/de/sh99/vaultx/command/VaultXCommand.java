package de.sh99.vaultx.command;

import com.sun.istack.internal.NotNull;
import de.sh99.vaultx.Environment;
import de.sh99.vaultx.VaultX;
import de.sh99.vaultx.env.Chat;
import de.sh99.vaultx.env.Economy;
import de.sh99.vaultx.env.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class VaultXCommand implements CommandExecutor, TabCompleter
{
    private VaultX vaultX;

    public VaultXCommand(@NotNull VaultX vaultX)
    {
        this.vaultX = vaultX;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if(!sender.isOp()){
            return false;
        }

        if(args.length <= 0){
            sender.sendMessage("§7§6§lVaultX§r§7 is §2§lhealthy§r§7.");
            return true;
        }

        if(args.length <= 2){
            switch (args[0]){
                case "firewall":
                    switch(args[1]){
                        case "list":
                            for (Environment env:this.vaultX.registeredEnvironments().values()){

                                String[] envParts = env.getClass().getName().split("\\.");
                                //TODO: could probably get the string/name of environment automatically by using reflection and checking each interface against Environment interface and than extract the name from the interface on the same way did on class
                                if(env instanceof Economy){
                                    sender.sendMessage("§7Economy: §6§l" + envParts[envParts.length-1]);
                                    continue;
                                }

                                if(env instanceof Permission){
                                    sender.sendMessage("§Permission: §6§l" + envParts[envParts.length-1]);
                                    continue;
                                }

                                if(env instanceof Chat){
                                    sender.sendMessage("§Chat: §6§l" + envParts[envParts.length-1]);
                                }
                            }
                            return true;
                        case "economy": return true;
                        case "chat": return true;
                        case "permission": return true;
                    }
                    return true;
                case "env":
                    switch(args[1]){
                        case "list": return true;
                        case "economy": return true;
                        case "chat": return true;
                        case "permission": return true;
                    }
                    return true;
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args)
    {
        List<String> l = new ArrayList<>();

        if(!sender.isOp()){
            return l;
        }

        if(args.length <= 1){
            l.add("firewall");
            l.add("env");
            return l;
        }

        if(args.length <= 2){
            if(args[0].equals("firewall") || args[0].equals("env")){
                l.add("list");
                l.add("economy");
                l.add("chat");
                l.add("permission");
                return l;
            }
        }

        return l;
    }
}
