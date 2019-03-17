package com.kisaragieffective.opencommandblock.collection

class RepeatedString(val original: CharSequence, val count: Int) : CharSequence {
    /**
     * Returns the length of this character sequence.
     */
    override val length: Int
        get() = original.length * count

    /**
     * Returns the character at the specified [index] in this character sequence.
     */
    override fun get(index: Int): Char {
        return original[index % original.length]
    }

    /**
     * Returns a new character sequence that is a subsequence of this character sequence,
     * starting at the specified [startIndex] and ending right before the specified [endIndex].
     *
     * @param startIndex the start index (inclusive).
     * @param endIndex the end index (exclusive).
     */
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        if (startIndex <= original.length && endIndex <= original.length) {
            return original.subSequence(startIndex, endIndex)
        }
        return ""
    }
}