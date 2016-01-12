package pl.grzegorz2047.lightguild.listeners;

/**
 * Created by grzegorz2047 on 12.01.2016.
 */

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.ServerCommandEvent;
import pl.grzegorz2047.lightguild.LightGuilds;

/**
 * author: MagicDroidX
 * NukkitExamplePlugin Project
 */
public class EventListener implements Listener {
    LightGuilds plugin;

    public EventListener(LightGuilds plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //DON'T FORGET THE ANNOTATION @EventHandler
    public void onServerCommand(ServerCommandEvent e) {
        this.plugin.getLogger().info("ServerCommandEvent is called!");
        //you can do more here!
    }
}