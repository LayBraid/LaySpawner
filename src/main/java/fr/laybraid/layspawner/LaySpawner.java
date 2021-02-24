package fr.laybraid.layspawner;

import fr.laybraid.layspawner.listeners.BlockBreakListener;
import fr.laybraid.layspawner.listeners.LayListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LaySpawner extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new LayListener(), this);
    }

}

