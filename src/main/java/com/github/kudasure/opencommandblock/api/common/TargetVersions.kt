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

    companion object {
        /**
         * The HIGHEST version, in my opinion.
         */
        val LATEST = Version(9999, 9999, 9999, 9999)
    }
}

data class TargetVersionRange(val lowerInclusive: Version, val upperExclusive: Version) : MustImplementContains<Version> {
    override operator fun contains(other: Version): Boolean {
        return (lowerInclusive <= other && other < upperExclusive)
    }
}
