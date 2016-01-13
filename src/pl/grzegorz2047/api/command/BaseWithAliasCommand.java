package pl.grzegorz2047.api.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import pl.grzegorz2047.bukkitalikeClasses.ChatColor;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz2047. 18.09.2015.
 */
public class BaseWithAliasCommand extends BaseCommand {

    private String defaultArgumentMsg = "&cWrong argument";
    PluginBase plugin;
    String[] aliases;

    protected Map<String[], Arg> commands = new HashMap<String[], Arg>();

    public BaseWithAliasCommand(String baseCmd, String[] aliases, PluginBase plugin) {
        super(baseCmd);
        this.plugin = plugin;
        this.aliases = aliases;
        //this.command.put(aliases, new KlasaTypeArg(levels)); example
    }
    public BaseWithAliasCommand(String baseCmd, String[] aliases, PluginBase plugin, String defaultArgumentMsg) {
        super(baseCmd);
        this.plugin = plugin;
        this.aliases = aliases;
        this.defaultArgumentMsg = defaultArgumentMsg;
        //this.command.put(aliases, new KlasaTypeArg(levels)); example
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Arg argument = null;
            if (cmd.getName().equalsIgnoreCase(baseCmd)) {
                String subCommand = "";
                if (args.length != 0) {
                    subCommand = args[0].toLowerCase();//lower case to ensure that all command are correct key
                }
                for (String[] key : commands.keySet()) {
                    for (String alias : key) {
                        if (alias.equals(subCommand)) {
                            argument = commands.get(key);
                            //System.out.print("Znalazlem klucz "+key.toString()+" arg "+argument.toString());
                            break;
                        }
                    }
                }


                if (argument != null) {
                    argument.execute(sender, args);
                    return true;
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',defaultArgumentMsg));
                    return true;
                }
            }else{
                plugin.getLogger().warning("Plugin has wrong code near getCommand("+baseCmd+").set ...");
            }



        return true;
    }
}
