package com.kisaragieffective.opencommandblock.kotlinmagic.extension.common2each

import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.common.CommonWorld
import org.bukkit.BlockChangeDelegate
import org.bukkit.Chunk
import org.bukkit.ChunkSnapshot
import org.bukkit.Difficulty
import org.bukkit.Effect
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.TreeType
import org.bukkit.World
import org.bukkit.WorldBorder
import org.bukkit.WorldType
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.entity.Arrow
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.FallingBlock
import org.bukkit.entity.Item
import org.bukkit.entity.LightningStrike
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.ChunkGenerator
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.metadata.MetadataValue
import org.bukkit.plugin.Plugin
import org.bukkit.util.Consumer
import org.bukkit.util.Vector
import java.io.File
import java.util.UUID

@ToBukkit
fun com.kisaragieffective.opencommandblock.api.common.CommonPoint3.toBukkitStyle(): Location {
    return Location(this.world.toBukkitStyle(), x, y, z)
}

@ToBukkit
fun com.kisaragieffective.opencommandblock.api.common.CommonVector3.toBukkitStyle(): Vector {
    return Vector(x, y, z)
}

@ToBukkit
fun com.kisaragieffective.opencommandblock.api.common.CommonWorld.toBukkitStyle(): World {
    return object : World {
        /**
         * Sets the limit for number of water animals that can spawn in a chunk in
         * this world
         *
         *
         * **Note:** If set to a negative number the world will use the
         * server-wide spawn limit instead.
         *
         * @param limit the new mob limit
         */
        override fun setWaterAnimalSpawnLimit(limit: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the current PVP setting for this world.
         *
         * @return True if PVP is enabled
         */
        override fun getPVP(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the current state of the specified rule
         *
         *
         * Will return null if rule passed is null
         *
         * @param rule Rule to look up value of
         * @return String value of rule
         */
        override fun getGameRuleValue(rule: String?): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets whether animals can spawn in this world.
         *
         * @return whether animals can spawn in this world.
         */
        override fun getAllowAnimals(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the limit for number of animals that can spawn in a chunk in this
         * world
         *
         * @return The animal spawn limit
         */
        override fun getAnimalSpawnLimit(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Returns a list of previously set metadata values from the implementing
         * object's metadata store.
         *
         * @param metadataKey the unique metadata key being sought.
         * @return A list of values, one for commandblock plugin that has set the
         * requested value.
         */
        override fun getMetadata(metadataKey: String?): MutableList<MetadataValue> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets a set containing all the Plugin Channels that this client is
         * listening on.
         *
         * @return Set containing all the channels that this client may accept.
         */
        override fun getListeningPluginChannels(): MutableSet<String> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates a entity at the given [Location]
         *
         * @param loc The location to spawn the entity
         * @param type The entity to spawn
         * @return Resulting Entity of this method, or null if it was unsuccessful
         */
        override fun spawnEntity(loc: Location?, type: EntityType?): Entity {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the full in-game time on this world
         *
         * @return The current absolute time
         * @see .getTime
         */
        override fun getFullTime(): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get the thundering duration.
         *
         * @return Duration in ticks
         */
        override fun getThunderDuration(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Drops an item at the specified [Location] with a random offset
         *
         * @param location Location to drop the item
         * @param item ItemStack to drop
         * @return ItemDrop entity created as a result of this method
         */
        override fun dropItemNaturally(location: Location?, item: ItemStack?): Item {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Set whether there is a storm. A duration will be set for the new
         * current conditions.
         *
         * @param hasStorm Whether there is rain and snow
         */
        override fun setStorm(hasStorm: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the biome for the given block coordinates.
         *
         * @param x X coordinate of the block
         * @param z Z coordinate of the block
         * @return Biome of the requested block
         */
        override fun getBiome(x: Int, z: Int): Biome {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Returns a list of entities within a bounding box centered around a Location.
         *
         * Some implementations may impose artificial restrictions on the size of the search bounding box.
         *
         * @param location The center of the bounding box
         * @param x 1/2 the size of the box along x axis
         * @param y 1/2 the size of the box along y axis
         * @param z 1/2 the size of the box along z axis
         * @return the collection of entities near location. This will always be a non-null collection.
         */
        override fun getNearbyEntities(location: Location?, x: Double, y: Double, z: Double): MutableCollection<Entity> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Checks if the specified [Chunk] is loaded
         *
         * @param chunk The chunk to check
         * @return true if the chunk is loaded, otherwise false
         */
        override fun isChunkLoaded(chunk: Chunk?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Checks if the [Chunk] at the specified coordinates is loaded
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return true if the chunk is loaded, otherwise false
         */
        override fun isChunkLoaded(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun spigot(): World.Spigot {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the Difficulty of the world.
         *
         * @return The difficulty of the world.
         */
        override fun getDifficulty(): Difficulty {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Checks if the [Chunk] at the specified coordinates is loaded and
         * in use by one or more players
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return true if the chunk is loaded and in use by one or more players,
         * otherwise false
         */
        override fun isChunkInUse(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets a metadata value in the implementing object's metadata store.
         *
         * @param metadataKey A unique key to identify this metadata.
         * @param newMetadataValue The metadata value to apply.
         * @throws IllegalArgumentException If value is null, or the owning plugin
         * is null
         */
        override fun setMetadata(metadataKey: String?, newMetadataValue: MetadataValue?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the relative in-game time of this world.
         *
         *
         * The relative time is analogous to hours * 1000
         *
         * @return The current relative time
         * @see .getFullTime
         */
        override fun getTime(): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the relative in-game time on the server.
         *
         *
         * The relative time is analogous to hours * 1000
         *
         *
         * Note that setting the relative time below the current relative time
         * will actually move the clock forward a day. If you require to rewind
         * time, please see [.setFullTime]
         *
         * @param time The new relative time to set the in-game time to (in
         * hours*1000)
         * @see .setFullTime
         */
        override fun setTime(time: Long) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Set the thundering duration.
         *
         * @param duration Duration in ticks
         */
        override fun setThunderDuration(duration: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Regenerates the [Chunk] at the specified coordinates
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return Whether the chunk was actually regenerated
         */
        override fun regenerateChunk(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the world's ticks per animal spawns value
         *
         *
         * This value determines how many ticks there are between attempts to
         * spawn animals.
         *
         *
         * **Example Usage:**
         *
         *  * A value of 1 will mean the server will attempt to spawn animals in
         * this world every tick.
         *  * A value of 400 will mean the server will attempt to spawn animals
         * in this world every 400th tick.
         *  * A value below 0 will be reset back to Minecraft's default.
         *
         *
         *
         * **Note:**
         * If set to 0, animal spawning will be disabled for this world. We
         * recommend using [.setSpawnFlags] to control
         * this instead.
         *
         *
         * Minecraft default: 400.
         *
         * @param ticksPerAnimalSpawns the ticks per animal spawns value you want
         * to set the world to
         */
        override fun setTicksPerAnimalSpawns(ticksPerAnimalSpawns: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the lowest block at the given coordinates such that the block and
         * all blocks above it are transparent for lighting purposes.
         *
         * @param x X-coordinate of the block
         * @param z Z-coordinate of the block
         * @return Highest non-empty block
         */
        override fun getHighestBlockAt(x: Int, z: Int): Block {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the lowest block at the given [Location] such that the block
         * and all blocks above it are transparent for lighting purposes.
         *
         * @param location Coordinates to get the highest block
         * @return Highest non-empty block
         */
        override fun getHighestBlockAt(location: Location?): Block {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets whether or not the world will automatically save
         *
         * @return true if the world will automatically save, otherwise false
         */
        override fun isAutoSave(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Play a Sound at the provided Location in the World
         *
         *
         * This function will fail silently if Location or Sound are null.
         *
         * @param location The location to play the sound
         * @param sound The sound to play
         * @param volume The volume of the sound
         * @param pitch The pitch of the sound
         */
        override fun playSound(location: Location?, sound: Sound?, volume: Float, pitch: Float) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Play a Sound at the provided Location in the World.
         *
         *
         * This function will fail silently if Location or Sound are null. No
         * sound will be heard by the players if their clients do not have the
         * respective sound for the value passed.
         *
         * @param location the location to play the sound
         * @param sound the internal sound name to play
         * @param volume the volume of the sound
         * @param pitch the pitch of the sound
         */
        override fun playSound(location: Location?, sound: String?, volume: Float, pitch: Float) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Play a Sound at the provided Location in the World.
         *
         *
         * This function will fail silently if Location or Sound are null.
         *
         * @param location The location to play the sound
         * @param sound The sound to play
         * @param category the category of the sound
         * @param volume The volume of the sound
         * @param pitch The pitch of the sound
         */
        override fun playSound(location: Location?, sound: Sound?, category: SoundCategory?, volume: Float, pitch: Float) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Play a Sound at the provided Location in the World.
         *
         *
         * This function will fail silently if Location or Sound are null. No sound
         * will be heard by the players if their clients do not have the respective
         * sound for the value passed.
         *
         * @param location the location to play the sound
         * @param sound the internal sound name to play
         * @param category the category of the sound
         * @param volume the volume of the sound
         * @param pitch the pitch of the sound
         */
        override fun playSound(location: Location?, sound: String?, category: SoundCategory?, volume: Float, pitch: Float) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sends this recipient a Plugin Message on the specified outgoing
         * channel.
         *
         *
         * The message may not be larger than [Messenger.MAX_MESSAGE_SIZE]
         * bytes, and the plugin must be registered to send messages on the
         * specified channel.
         *
         * @param source The plugin that sent this message.
         * @param channel The channel to send this message on.
         * @param message The raw message to send.
         * @throws IllegalArgumentException Thrown if the source plugin is
         * disabled.
         * @throws IllegalArgumentException Thrown if source, channel or message
         * is null.
         * @throws MessageTooLargeException Thrown if the message is too big.
         * @throws ChannelNotRegisteredException Thrown if the channel is not
         * registered for this plugin.
         */
        override fun sendPluginMessage(source: Plugin?, channel: String?, message: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the Difficulty of the world.
         *
         * @param difficulty the new difficulty you want to set the world to
         */
        override fun setDifficulty(difficulty: Difficulty?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the world's ticks per monster spawns value
         *
         *
         * This value determines how many ticks there are between attempts to
         * spawn monsters.
         *
         *
         * **Example Usage:**
         *
         *  * A value of 1 will mean the server will attempt to spawn monsters in
         * this world every tick.
         *  * A value of 400 will mean the server will attempt to spawn monsters
         * in this world every 400th tick.
         *  * A value below 0 will be reset back to Minecraft's default.
         *
         *
         *
         * **Note:**
         * If set to 0, monsters spawning will be disabled for this world. We
         * recommend using [.setSpawnFlags] to control
         * this instead.
         *
         *
         * Minecraft default: 1.
         *
         * @return The world's ticks per monster spawns value
         */
        override fun getTicksPerMonsterSpawns(): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the y coordinate of the lowest block at this position such that the
         * block and all blocks above it are transparent for lighting purposes.
         *
         * @param x X-coordinate of the blocks
         * @param z Z-coordinate of the blocks
         * @return Y-coordinate of the described block
         */
        override fun getHighestBlockYAt(x: Int, z: Int): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the y coordinate of the lowest block at the given [Location]
         * such that the block and all blocks above it are transparent for lighting
         * purposes.
         *
         * @param location Location of the blocks
         * @return Y-coordinate of the highest non-air block
         */
        override fun getHighestBlockYAt(location: Location?): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a collection of all entities in this World matching the given
         * class/interface
         *
         * @param <T> an entity subclass
         * @param classes The classes representing the types of entity to match
         * @return A List of all Entities currently residing in this world that
         * match the given class/interface
        </T> */
        override fun <T : Entity?> getEntitiesByClass(vararg classes: Class<T>?): MutableCollection<T> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a collection of all entities in this World matching the given
         * class/interface
         *
         * @param <T> an entity subclass
         * @param cls The class representing the type of entity to match
         * @return A List of all Entities currently residing in this world that
         * match the given class/interface
        </T> */
        override fun <T : Entity?> getEntitiesByClass(cls: Class<T>?): MutableCollection<T> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the folder of this world on disk.
         *
         * @return The folder of this world.
         */
        override fun getWorldFolder(): File {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Set the specified gamerule to specified value.
         *
         *
         * The rule may attempt to validate the value passed, will return true if
         * value was set.
         *
         *
         * If rule is null, the function will return false.
         *
         * @param rule Rule to set
         * @param value Value to set rule to
         * @return True if rule was set
         */
        override fun setGameRuleValue(rule: String?, value: String?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets whether or not the world will automatically save
         *
         * @param value true if the world should automatically save, otherwise
         * false
         */
        override fun setAutoSave(value: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets whether the world's spawn area should be kept loaded into memory
         * or not.
         *
         * @param keepLoaded if true then the world's spawn area will be kept
         * loaded into memory.
         */
        override fun setKeepSpawnInMemory(keepLoaded: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the in-game time on the server
         *
         *
         * Note that this sets the full time of the world, which may cause adverse
         * effects such as breaking redstone clocks and any scheduled events
         *
         * @param time The new absolute time to set this world to
         * @see .setTime
         */
        override fun setFullTime(time: Long) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawn an entity of a specific class at the given [Location]
         *
         * @param location the [Location] to spawn the entity at
         * @param clazz the class of the [Entity] to spawn
         * @param <T> the class of the [Entity] to spawn
         * @return an instance of the spawned [Entity]
         * @throws IllegalArgumentException if either parameter is null or the
         * [Entity] requested cannot be spawned
        </T> */
        override fun <T : Entity?> spawn(location: Location?, clazz: Class<T>?): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawn an entity of a specific class at the given [Location], with
         * the supplied function run before the entity is added to the world.
         * <br></br>
         * Note that when the function is run, the entity will not be actually in
         * the world. Any operation involving such as teleporting the entity is undefined
         * until after this function returns.
         *
         * @param location the [Location] to spawn the entity at
         * @param clazz the class of the [Entity] to spawn
         * @param function the function to be run before the entity is spawned.
         * @param <T> the class of the [Entity] to spawn
         * @return an instance of the spawned [Entity]
         * @throws IllegalArgumentException if either parameter is null or the
         * [Entity] requested cannot be spawned
        </T> */
        override fun <T : Entity?> spawn(location: Location?, clazz: Class<T>?, function: Consumer<T>?): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get existing rules
         *
         * @return An array of rules
         */
        override fun getGameRules(): Array<String> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the limit for number of animals that can spawn in a chunk in this
         * world
         *
         *
         * **Note:** If set to a negative number the world will use the
         * server-wide spawn limit instead.
         *
         * @param limit the new mob limit
         */
        override fun setAnimalSpawnLimit(limit: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the spawn location of the world.
         * <br></br>
         * The location provided must be equal to this world.
         *
         * @param location The [Location] to set the spawn for this world at.
         * @return True if it was successfully set.
         */
        override fun setSpawnLocation(location: Location?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the spawn location of the world
         *
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @return True if it was successfully set.
         */
        override fun setSpawnLocation(x: Int, y: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the default spawn [Location] of this world
         *
         * @return The spawn location of this world
         */
        override fun getSpawnLocation(): Location {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the type of this world.
         *
         * @return Type of this world.
         */
        override fun getWorldType(): WorldType {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawn a [FallingBlock] entity at the given [Location] of
         * the specified [Material]. The material dictates what is falling.
         * When the FallingBlock hits the ground, it will place that block.
         *
         *
         * The Material must be a block type, check with [ material.isBlock()][Material.isBlock]. The Material may not be air.
         *
         * @param location The [Location] to spawn the FallingBlock
         * @param data The block data
         * @return The spawned [FallingBlock] instance
         * @throws IllegalArgumentException if [Location] or [     ] are null or [Material] of the [MaterialData] is not a block
         */
        override fun spawnFallingBlock(location: Location?, data: MaterialData?): FallingBlock {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawn a [FallingBlock] entity at the given [Location] of
         * the specified [Material]. The material dictates what is falling.
         * When the FallingBlock hits the ground, it will place that block.
         *
         *
         * The Material must be a block type, check with [ material.isBlock()][Material.isBlock]. The Material may not be air.
         *
         * @param location The [Location] to spawn the FallingBlock
         * @param material The block [Material] type
         * @param data The block data
         * @return The spawned [FallingBlock] instance
         * @throws IllegalArgumentException if [Location] or [     ] are null or [Material] is not a block
         */
        override fun spawnFallingBlock(location: Location?, material: Material?, data: Byte): FallingBlock {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawn a [FallingBlock] entity at the given [Location] of
         * the specified blockId (converted to [Material])
         *
         * @param location The [Location] to spawn the FallingBlock
         * @param blockId The id of the intended material
         * @param blockData The block data
         * @return The spawned FallingBlock instance
         * @throws IllegalArgumentException if location is null, or blockId is
         * invalid
         * @see .spawnFallingBlock
         */
        override fun spawnFallingBlock(location: Location?, blockId: Int, blockData: Byte): FallingBlock {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Returns whether there is thunder.
         *
         * @return Whether there is thunder
         */
        override fun isThundering(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the world's ticks per animal spawns value
         *
         *
         * This value determines how many ticks there are between attempts to
         * spawn animals.
         *
         *
         * **Example Usage:**
         *
         *  * A value of 1 will mean the server will attempt to spawn animals in
         * this world every tick.
         *  * A value of 400 will mean the server will attempt to spawn animals
         * in this world every 400th tick.
         *  * A value below 0 will be reset back to Minecraft's default.
         *
         *
         *
         * **Note:**
         * If set to 0, animal spawning will be disabled for this world. We
         * recommend using [.setSpawnFlags] to control
         * this instead.
         *
         *
         * Minecraft default: 400.
         *
         * @return The world's ticks per animal spawns value
         */
        override fun getTicksPerAnimalSpawns(): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Loads the specified [Chunk]
         *
         * @param chunk The chunk to load
         */
        override fun loadChunk(chunk: Chunk?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Loads the [Chunk] at the specified coordinates
         *
         *
         * If the chunk does not exist, it will be generated.
         *
         *
         * This method is analogous to [.loadChunk] where
         * generate is true.
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         */
        override fun loadChunk(x: Int, z: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Loads the [Chunk] at the specified coordinates
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @param generate Whether or not to generate a chunk if it doesn't
         * already exist
         * @return true if the chunk has loaded successfully, otherwise false
         */
        override fun loadChunk(x: Int, z: Int, generate: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the limit for number of monsters that can spawn in a chunk in this
         * world
         *
         *
         * **Note:** If set to a negative number the world will use the
         * server-wide spawn limit instead.
         *
         * @param limit the new mob limit
         */
        override fun setMonsterSpawnLimit(limit: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets limit for number of monsters that can spawn in a chunk in this
         * world
         *
         * @return The monster spawn limit
         */
        override fun getMonsterSpawnLimit(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Checks if string is a valid game rule
         *
         * @param rule Rule to check
         * @return True if rule exists
         */
        override fun isGameRule(rule: String?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the world's ticks per monster spawns value
         *
         *
         * This value determines how many ticks there are between attempts to
         * spawn monsters.
         *
         *
         * **Example Usage:**
         *
         *  * A value of 1 will mean the server will attempt to spawn monsters in
         * this world on every tick.
         *  * A value of 400 will mean the server will attempt to spawn monsters
         * in this world every 400th tick.
         *  * A value below 0 will be reset back to Minecraft's default.
         *
         *
         *
         * **Note:**
         * If set to 0, monsters spawning will be disabled for this world. We
         * recommend using [.setSpawnFlags] to control
         * this instead.
         *
         *
         * Minecraft default: 1.
         *
         * @param ticksPerMonsterSpawns the ticks per monster spawns value you
         * want to set the world to
         */
        override fun setTicksPerMonsterSpawns(ticksPerMonsterSpawns: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Saves world to disk
         */
        override fun save() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get empty chunk snapshot (equivalent to all air blocks), optionally
         * including valid biome data. Used for representing an ungenerated chunk,
         * or for fetching only biome data without loading a chunk.
         *
         * @param x - chunk x coordinate
         * @param z - chunk z coordinate
         * @param includeBiome - if true, snapshot includes per-coordinate biome
         * type
         * @param includeBiomeTempRain - if true, snapshot includes per-coordinate
         * raw biome temperature and rainfall
         * @return The empty snapshot.
         */
        override fun getEmptyChunkSnapshot(x: Int, z: Int, includeBiome: Boolean, includeBiomeTempRain: Boolean): ChunkSnapshot {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the Unique ID of this world
         *
         * @return Unique ID of this world.
         */
        override fun getUID(): UUID {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Chunk] at the given coordinates
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return Chunk at the given coordinates
         */
        override fun getChunkAt(x: Int, z: Int): Chunk {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Chunk] at the given [Location]
         *
         * @param location Location of the chunk
         * @return Chunk at the given location
         */
        override fun getChunkAt(location: Location?): Chunk {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Chunk] that contains the given [Block]
         *
         * @param block Block to get the containing chunk from
         * @return The chunk that contains the given block
         */
        override fun getChunkAt(block: Block?): Chunk {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the world border for this world.
         *
         * @return The world border for this world.
         */
        override fun getWorldBorder(): WorldBorder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the limit for number of ambient mobs that can spawn in a chunk in
         * this world
         *
         * @return The ambient spawn limit
         */
        override fun getAmbientSpawnLimit(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Drops an item at the specified [Location]
         *
         * @param location Location to drop the item
         * @param item ItemStack to drop
         * @return ItemDrop entity created as a result of this method
         */
        override fun dropItem(location: Location?, item: ItemStack?): Item {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Safely unloads and saves the [Chunk] at the specified coordinates
         *
         *
         * This method is analogous to [.unloadChunk] where safe and saveis true
         *
         * @param chunk the chunk to unload
         * @return true if the chunk has unloaded successfully, otherwise false
         */
        override fun unloadChunk(chunk: Chunk?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Safely unloads and saves the [Chunk] at the specified coordinates
         *
         *
         * This method is analogous to [.unloadChunk] where safe and saveis true
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return true if the chunk has unloaded successfully, otherwise false
         */
        override fun unloadChunk(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Safely unloads and optionally saves the [Chunk] at the specified
         * coordinates
         *
         *
         * This method is analogous to [.unloadChunk] where save is true
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @param save Whether or not to save the chunk
         * @return true if the chunk has unloaded successfully, otherwise false
         */
        override fun unloadChunk(x: Int, z: Int, save: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Unloads and optionally saves the [Chunk] at the specified
         * coordinates
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @param save Controls whether the chunk is saved
         * @param safe Controls whether to unload the chunk when players are
         * nearby
         * @return true if the chunk has unloaded successfully, otherwise false
         */
        override fun unloadChunk(x: Int, z: Int, save: Boolean, safe: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Returns whether the world has an ongoing storm.
         *
         * @return Whether there is an ongoing storm
         */
        override fun hasStorm(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Set the remaining time in ticks of the current conditions.
         *
         * @param duration Time in ticks
         */
        override fun setWeatherDuration(duration: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the maximum height of this world.
         *
         *
         * If the max height is 100, there are only blocks from y=0 to y=99.
         *
         * @return Maximum height of the world
         */
        override fun getMaxHeight(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets whether the world's spawn area should be kept loaded into memory
         * or not.
         *
         * @return true if the world's spawn area will be kept loaded into memory.
         */
        override fun getKeepSpawnInMemory(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         */
        override fun spawnParticle(particle: Particle?, location: Location?, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         */
        override fun spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, location: Location?, count: Int, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         */
        override fun spawnParticle(particle: Particle?, location: Location?, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         */
        override fun spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, location: Location?, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param extra the extra data for this particle, depends on the
         * particle used (normally speed)
         */
        override fun spawnParticle(particle: Particle?, location: Location?, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param extra the extra data for this particle, depends on the
         * particle used (normally speed)
         */
        override fun spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param location the location to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param extra the extra data for this particle, depends on the
         * particle used (normally speed)
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, location: Location?, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Spawns the particle (the number of times specified by count)
         * at the target location. The position of commandblock particle will be
         * randomized positively and negatively by the offset parameters
         * on commandblock axis.
         *
         * @param particle the particle to spawn
         * @param x the position on the x axis to spawn at
         * @param y the position on the y axis to spawn at
         * @param z the position on the z axis to spawn at
         * @param count the number of particles
         * @param offsetX the maximum random offset on the X axis
         * @param offsetY the maximum random offset on the Y axis
         * @param offsetZ the maximum random offset on the Z axis
         * @param extra the extra data for this particle, depends on the
         * particle used (normally speed)
         * @param data the data to use for the particle or null,
         * the type of this depends on [Particle.getDataType]
         */
        override fun <T : Any?> spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the limit for number of water animals that can spawn in a chunk in
         * this world
         *
         * @return The water animal spawn limit
         */
        override fun getWaterAnimalSpawnLimit(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates an [Arrow] entity at the given [Location]
         *
         * @param location Location to spawn the arrow
         * @param direction Direction to shoot the arrow in
         * @param speed Speed of the arrow. A recommend speed is 0.6
         * @param spread Spread of the arrow. A recommend spread is 12
         * @return Arrow entity spawned as a result of this method
         */
        override fun spawnArrow(location: Location?, direction: Vector?, speed: Float, spread: Float): Arrow {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates an arrow entity of the given class at the given [Location]
         *
         * @param <T> type of arrow to spawn
         * @param location Location to spawn the arrow
         * @param direction Direction to shoot the arrow in
         * @param speed Speed of the arrow. A recommend speed is 0.6
         * @param spread Spread of the arrow. A recommend spread is 12
         * @param clazz the Entity class for the arrow
         * [org.bukkit.entity.SpectralArrow],[org.bukkit.entity.Arrow],[org.bukkit.entity.TippedArrow]
         * @return Arrow entity spawned as a result of this method
        </T> */
        override fun <T : Arrow?> spawnArrow(location: Location?, direction: Vector?, speed: Float, spread: Float, clazz: Class<T>?): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get the remaining time in ticks of the current conditions.
         *
         * @return Time in ticks
         */
        override fun getWeatherDuration(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the sea level for this world.
         *
         *
         * This is often half of [.getMaxHeight]
         *
         * @return Sea level
         */
        override fun getSeaLevel(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the spawn flags for this.
         *
         * @param allowMonsters - if true, monsters are allowed to spawn in this
         * world.
         * @param allowAnimals - if true, animals are allowed to spawn in this
         * world.
         */
        override fun setSpawnFlags(allowMonsters: Boolean, allowAnimals: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a list of all living entities in this World
         *
         * @return A List of all LivingEntities currently residing in this world
         */
        override fun getLivingEntities(): MutableList<LivingEntity> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the unique name of this world
         *
         * @return Name of this world
         */
        override fun getName(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets an array of all loaded [Chunk]s
         *
         * @return Chunk[] containing all loaded chunks
         */
        override fun getLoadedChunks(): Array<Chunk> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets whether or not structures are being generated.
         *
         * @return True if structures are being generated.
         */
        override fun canGenerateStructures(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Removes the given metadata value from the implementing object's
         * metadata store.
         *
         * @param metadataKey the unique metadata key identifying the metadata to
         * remove.
         * @param owningPlugin This plugin's metadata value will be removed. All
         * other values will be left untouched.
         * @throws IllegalArgumentException If plugin is null
         */
        override fun removeMetadata(metadataKey: String?, owningPlugin: Plugin?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Safely queues the [Chunk] at the specified coordinates for
         * unloading
         *
         *
         * This method is analogous to [.unloadChunkRequest] where safe is true
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return true is the queue attempt was successful, otherwise false
         */
        override fun unloadChunkRequest(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Queues the [Chunk] at the specified coordinates for unloading
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @param safe Controls whether to queue the chunk when players are nearby
         * @return Whether the chunk was actually queued
         */
        override fun unloadChunkRequest(x: Int, z: Int, safe: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Strikes lightning at the given [Location] without doing damage
         *
         * @param loc The location to strike lightning
         * @return The lightning entity.
         */
        override fun strikeLightningEffect(loc: Location?): LightningStrike {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates explosion at given coordinates with given power
         *
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @param power The power of explosion, where 4F is TNT
         * @return false if explosion was canceled, otherwise true
         */
        override fun createExplosion(x: Double, y: Double, z: Double, power: Float): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates explosion at given coordinates with given power and optionally
         * setting blocks on fire.
         *
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @param power The power of explosion, where 4F is TNT
         * @param setFire Whether or not to set blocks on fire
         * @return false if explosion was canceled, otherwise true
         */
        override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates explosion at given coordinates with given power and optionally
         * setting blocks on fire or breaking blocks.
         *
         * @param x X coordinate
         * @param y Y coordinate
         * @param z Z coordinate
         * @param power The power of explosion, where 4F is TNT
         * @param setFire Whether or not to set blocks on fire
         * @param breakBlocks Whether or not to have blocks be destroyed
         * @return false if explosion was canceled, otherwise true
         */
        override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean, breakBlocks: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates explosion at given coordinates with given power
         *
         * @param loc Location to blow up
         * @param power The power of explosion, where 4F is TNT
         * @return false if explosion was canceled, otherwise true
         */
        override fun createExplosion(loc: Location?, power: Float): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates explosion at given coordinates with given power and optionally
         * setting blocks on fire.
         *
         * @param loc Location to blow up
         * @param power The power of explosion, where 4F is TNT
         * @param setFire Whether or not to set blocks on fire
         * @return false if explosion was canceled, otherwise true
         */
        override fun createExplosion(loc: Location?, power: Float, setFire: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the PVP setting for this world.
         *
         * @param pvp True/False whether PVP should be Enabled.
         */
        override fun setPVP(pvp: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Resends the [Chunk] to all clients
         *
         * @param x X-coordinate of the chunk
         * @param z Z-coordinate of the chunk
         * @return Whether the chunk was actually refreshed
         *
         */
        override fun refreshChunk(x: Int, z: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the Seed for this world.
         *
         * @return This worlds Seed
         */
        override fun getSeed(): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a list of all players in this World
         *
         * @return A list of all Players currently residing in this world
         */
        override fun getPlayers(): MutableList<Player> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the temperature for the given block coordinates.
         *
         *
         * It is safe to run this method when the block does not exist, it will
         * not create the block.
         *
         * @param x X coordinate of the block
         * @param z Z coordinate of the block
         * @return Temperature of the requested block
         */
        override fun getTemperature(x: Int, z: Int): Double {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a collection of all entities in this World matching any of the
         * given classes/interfaces
         *
         * @param classes The classes representing the types of entity to match
         * @return A List of all Entities currently residing in this world that
         * match one or more of the given classes/interfaces
         */
        override fun getEntitiesByClasses(vararg classes: Class<*>?): MutableCollection<Entity> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets a list of all applied [BlockPopulator]s for this World
         *
         * @return List containing any or none BlockPopulators
         */
        override fun getPopulators(): MutableList<BlockPopulator> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the biome for the given block coordinates
         *
         * @param x X coordinate of the block
         * @param z Z coordinate of the block
         * @param bio new Biome type for this block
         */
        override fun setBiome(x: Int, z: Int, bio: Biome?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Strikes lightning at the given [Location]
         *
         * @param loc The location to strike lightning
         * @return The lightning entity.
         */
        override fun strikeLightning(loc: Location?): LightningStrike {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Block] at the given coordinates
         *
         * @param x X-coordinate of the block
         * @param y Y-coordinate of the block
         * @param z Z-coordinate of the block
         * @return Block at the given coordinates
         * @see .getBlockTypeIdAt
         */
        override fun getBlockAt(x: Int, y: Int, z: Int): Block {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Block] at the given [Location]
         *
         * @param location Location of the block
         * @return Block at the given location
         * @see .getBlockTypeIdAt
         */
        override fun getBlockAt(location: Location?): Block {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Get a list of all entities in this World
         *
         * @return A List of all Entities currently residing in this world
         */
        override fun getEntities(): MutableList<Entity> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets whether monsters can spawn in this world.
         *
         * @return whether monsters can spawn in this world.
         */
        override fun getAllowMonsters(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Tests to see whether the implementing object contains the given
         * metadata value in its metadata store.
         *
         * @param metadataKey the unique metadata key being queried.
         * @return the existence of the metadataKey within subject.
         */
        override fun hasMetadata(metadataKey: String?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates a tree at the given [Location]
         *
         * @param location Location to spawn the tree
         * @param type Type of the tree to create
         * @return true if the tree was created successfully, otherwise false
         */
        override fun generateTree(location: Location?, type: TreeType?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Creates a tree at the given [Location]
         *
         * @param loc Location to spawn the tree
         * @param type Type of the tree to create
         * @param delegate A class to call for commandblock block changed as a result of
         * this method
         * @return true if the tree was created successfully, otherwise false
         */
        override fun generateTree(loc: Location?, type: TreeType?, delegate: BlockChangeDelegate?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the [Environment] type of this world
         *
         * @return This worlds Environment type
         */
        override fun getEnvironment(): World.Environment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Plays an effect to all players within a default radius around a given
         * location.
         *
         * @param location the [Location] around which players must be to
         * hear the sound
         * @param effect the [Effect]
         * @param data a data bit needed for some effects
         */
        override fun playEffect(location: Location?, effect: Effect?, data: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Plays an effect to all players within a given radius around a location.
         *
         * @param location the [Location] around which players must be to
         * hear the effect
         * @param effect the [Effect]
         * @param data a data bit needed for some effects
         * @param radius the radius around the location
         */
        override fun playEffect(location: Location?, effect: Effect?, data: Int, radius: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Plays an effect to all players within a default radius around a given
         * location.
         *
         * @param <T> data dependant on the type of effect
         * @param location the [Location] around which players must be to
         * hear the sound
         * @param effect the [Effect]
         * @param data a data bit needed for some effects
        </T> */
        override fun <T : Any?> playEffect(location: Location?, effect: Effect?, data: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Plays an effect to all players within a given radius around a location.
         *
         * @param <T> data dependant on the type of effect
         * @param location the [Location] around which players must be to
         * hear the effect
         * @param effect the [Effect]
         * @param data a data bit needed for some effects
         * @param radius the radius around the location
        </T> */
        override fun <T : Any?> playEffect(location: Location?, effect: Effect?, data: T, radius: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Sets the limit for number of ambient mobs that can spawn in a chunk in
         * this world
         *
         *
         * **Note:** If set to a negative number the world will use the
         * server-wide spawn limit instead.
         *
         * @param limit the new mob limit
         */
        override fun setAmbientSpawnLimit(limit: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the block type ID at the given coordinates
         *
         * @param x X-coordinate of the block
         * @param y Y-coordinate of the block
         * @param z Z-coordinate of the block
         * @return Type ID of the block at the given coordinates
         * @see .getBlockAt
         */
        override fun getBlockTypeIdAt(x: Int, y: Int, z: Int): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the block type ID at the given [Location]
         *
         * @param location Location of the block
         * @return Type ID of the block at the given location
         * @see .getBlockAt
         */
        override fun getBlockTypeIdAt(location: Location?): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the chunk generator for this world
         *
         * @return ChunkGenerator associated with this world
         */
        override fun getGenerator(): ChunkGenerator {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Set whether it is thundering.
         *
         * @param thundering Whether it is thundering
         */
        override fun setThundering(thundering: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        /**
         * Gets the humidity for the given block coordinates.
         *
         *
         * It is safe to run this method when the block does not exist, it will
         * not create the block.
         *
         * @param x X coordinate of the block
         * @param z Z coordinate of the block
         * @return Humidity of the requested block
         */
        override fun getHumidity(x: Int, z: Int): Double {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}