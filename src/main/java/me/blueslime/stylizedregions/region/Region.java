package me.blueslime.stylizedregions.region;

import dev.mruniverse.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.stylizedregions.region.utils.Cuboid;

import java.util.UUID;

public class Region {

    private final String name;
    private final UUID uuid;
    private Cuboid region;

    public Region(String uuid, String name, Cuboid cuboid) {
        this.region = cuboid;
        this.uuid   = UUID.fromString(uuid);
        this.name   = name;
    }

    /**
     * Replace the region
     * @param cuboid Cuboid
     */
    public void replaceRegion(Cuboid cuboid) {
        this.region = cuboid;
    }

    /**
     * Get the UniqueId of the owner of the region
     * @return UUID
     */
    public UUID getUniqueId() {
        return uuid;
    }

    /**
     * Get the owner's name of the region
     * @return Username
     */
    public String getOwner() {
        return name;
    }

    /**
     * Get the region Cuboid
     * @return Cuboid
     */
    public Cuboid getRegion() {
        return region;
    }

    public enum Flags {
        CREEPER_EXPLOSION("creeper-explosion"),
        QUIT_MESSAGE("quit-message"),
        JOIN_MESSAGE("join-message"),
        BLOCK_PLACE("block-place"),
        BLOCK_BREAK("block-break"),
        QUIT_TITLE("quit-title"),
        JOIN_TITLE("join-title"),
        INTERACT("interact"),
        PVP("pvp");

        private final String path;
        private final Object def;

        Flags(String path) {
            this.path = path;
            this.def = null;
        }

        public Object getDefault(ConfigurationHandler configuration) {
            if (def == null) {
                return configuration.get("default-region-flags." + path);
            }
            return def;
        }

        public String getPath() {
            return path;
        }
    }
}