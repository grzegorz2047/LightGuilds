package pl.grzegorz2047.lightguild.tasks;

import cn.nukkit.scheduler.PluginTask;
import pl.grzegorz2047.lightguild.LightGuilds;

/**
 * Created by grzegorz2047 on 12.01.2016.
 */

public class BroadcastPluginTask extends PluginTask<LightGuilds> {

    public BroadcastPluginTask(LightGuilds owner) {
        super(owner);
    }

    @Override
    public void onRun(int currentTick) {
        this.getOwner().getLogger().info("I've run on tick " + currentTick);
    }
}