package com.kisaragieffective.opencommandblock.kotlinmagic.extension

import com.kisaragieffective.opencommandblock.annotations.InlineOnly
import org.bukkit.Instrument
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Note
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.util.Vector

@InlineOnly
inline val Material.isCommand: Boolean
    get() {
        return when (this.name) {
            // for 1.12.2 and below
            "COMMAND", "COMMAND_CHAIN", "COMMAND_REPEATING" -> true

            // for 1.13+
            "COMMAND_BLOCK", "CHAIN_COMMAND_BLOCK", "REPEATING_COMMAND_BLOCK" -> true
            else -> false
        }
    }

@InlineOnly
inline val Material.isChest: Boolean
    get() {
        return when (this) {
            Material.CHEST, Material.ENDER_CHEST, Material.TRAPPED_CHEST -> true
            else -> false
        }
    }

@InlineOnly
inline val Material.isContainerBlock: Boolean
    get() {
        return when {
            !this.isBlock -> false
            this.isChest || this == Material.FURNACE || this == Material.HOPPER  -> true
            else -> false
        }
    }

@InlineOnly
inline val Player.footBlock: Block
    get() = foot.block

@InlineOnly
inline val Player.foot: Location
    get() = this.location.add(0.0, -1.0, 0.0)

operator fun Vector.plus(other: Vector): Vector {
    return this.add(other)
}

operator fun Vector.minus(other: Vector): Vector {
    return this.subtract(other)
}

operator fun Vector.times(other: Vector): Vector {
    return this.multiply(other)
}

operator fun Vector.times(other: Int): Vector {
    return this.multiply(other)
}

operator fun Vector.times(other: Float): Vector {
    return this.multiply(other)
}

operator fun Vector.times(other: Double): Vector {
    return this.multiply(other)
}

operator fun Vector.div(other: Vector): Vector {
    return this.divide(other)
}

@InlineOnly
inline val Vector.ZERO: Vector
    get() = Vector(0, 0, 0)

fun Player.playSoundThere(sound: Sound, category: SoundCategory, volume: Float, pitch: Float) {
    return playSound(location, sound, category, volume, pitch)
}

fun Player.playSoundThere(sound: Sound, volume: Float, pitch: Float) {
    return playSound(location, sound, volume, pitch)
}

fun Player.playNoteThere(instrument: Instrument, note: Note) {
    return playNote(location, instrument, note)
}




