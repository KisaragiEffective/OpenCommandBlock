package com.github.kudasure.opencommandblock.api.common

import com.github.kudasure.opencommandblock.interfaces.MustImplementContains

data class Version(val major: Int = 1, val minor: Int = 0, val fix: Int = 0, val build: Int = 0) : Comparable<Version> {
    /**
     * @inherited
     */
    override operator fun compareTo(other: Version): Int {
        return when {
            major > other.major || minor > other.minor || fix > other.fix || build > other.build -> 1
            major < other.major || minor < other.minor || fix < other.fix || build < other.build -> -1
            else -> 0
        }
    }

    override fun toString(): String {
        return "$major.$minor.$fix.$build"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Version) {
            major == other.major && minor == other.minor && fix == other.fix && build == other.build
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = major
        result = 31 * result + minor
        result = 31 * result + fix
        result = 31 * result + build
        return result
    }

    companion object {
        /**
         * The HIGHEST version, in my opinion.
         */
        val LATEST = Version(9999, 9999, 9999, 9999)
    }
}

data class TargetVersionRange(val lowerInclusive: Version, val upperExclusive: Version) : MustImplementContains<Version> {
    init {
        if (upperExclusive < lowerInclusive) {
            throw IllegalArgumentException("$upperExclusive > $lowerInclusive")
        }
    }

    override operator fun contains(other: Version): Boolean {
        return (lowerInclusive <= other && other < upperExclusive)
    }
}
