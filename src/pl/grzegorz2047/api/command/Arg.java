package pl.grzegorz2047.api.command;


import cn.nukkit.command.CommandSender;

/**
 * Created by Grzegorz2047. 28.08.2015.
 */
public interface Arg {

    void execute(CommandSender sender, String args[]);

}
