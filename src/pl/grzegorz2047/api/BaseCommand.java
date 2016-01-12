package pl.grzegorz2047.api;

/**
 * Created by grzegorz2047 on 12.01.2016.
 */

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Color;

import java.util.HashMap;
import java.util.Map;

public class BaseCommand implements CommandExecutor {

    private String defaultArgumentMsg = "Wrong argument";

    private BaseCommand() {
    }

    protected String baseCmd;

    public BaseCommand(String basecmd) {
        this.baseCmd = basecmd;
    }

    public BaseCommand(String basecmd, String defaultArgumentMsg) {
        this.baseCmd = basecmd;
        this.defaultArgumentMsg = defaultArgumentMsg;
    }

    protected Map<String, Arg> commands = new HashMap<String, Arg>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase(baseCmd)) {
            String subCommand = "";
            if (args.length != 0) {
                subCommand = args[0].toLowerCase();//lower case to ensure that all command are correct key
            }
            if (commands.get(subCommand) != null) {
                this.commands.get(subCommand).execute(sender, args);
                return true;
            } else {
                sender.sendMessage(Color.RED + defaultArgumentMsg);
                return true;
            }
        }
        return true;
    }
}
