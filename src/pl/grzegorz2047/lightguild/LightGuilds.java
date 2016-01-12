package pl.grzegorz2047.lightguild;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;
import pl.grzegorz2047.lightguild.listeners.EventListener;
import pl.grzegorz2047.lightguild.tasks.BroadcastPluginTask;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
/**
 * Created by grzegorz2047 on 12.01.2016.
 */
public class LightGuilds extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "I've been loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "I've been enabled!");

        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));

        //Register the EventListener
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        //PluginTask
        this.getServer().getScheduler().scheduleRepeatingTask(new BroadcastPluginTask(this), 200);

        //Save resources

        //Config reading and writing
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //Default values (not necessary)
                new LinkedHashMap<String, Object>() {
                    {
                        put("this-is-a-key", "Hello! Config!");
                        put("another-key", true); //you can also put other standard objects!
                    }
                });
        //Now try to get the value, the default value will be given if the key isn't exist!
        this.getLogger().info(String.valueOf(config.get("this-is-a-key", "this-is-default-value")));
        //Don't forget to save it!
        config.save();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "I've been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":

        }
        return true;
    }

}
