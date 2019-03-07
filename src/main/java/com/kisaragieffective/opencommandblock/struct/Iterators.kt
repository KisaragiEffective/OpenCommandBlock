package com.kisaragieffective.opencommandblock.struct

class EmptyIterator<E> : Iterator<E> {
    /**
     * Returns `true` if the iteration has more elements.
     */
    override fun hasNext(): Boolean {
        return false
    }

    /**
     * Returns the next element in the iteration.
     */
    override fun next(): E {
        throw NoMoreElementsException
    }
}

class EmptyListIterator<E> : ListIterator<E> {
    override fun hasNext(): Boolean {
        return false
    }

    /**
     * Returns `true` if there are elements in the iteration before the current element.
     */
    override fun hasPrevious(): Boolean {
        return false
    }

    override fun next(): E {
        throw NoMoreElementsException
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to [next].
     */
    override fun nextIndex(): Int {
        return 0
    }

    /**
     * Returns the previous element in the iteration and moves the cursor position backwards.
     */
    override fun previous(): E {
        throw NoSuchElementException()
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to [previous].
     */
    override fun previousIndex(): Int {
        return 0
    }
}

class IteratorImpl<E>(private val source: List<E>) : Iterator<E> {
    private var ptr: Int = 0
    /**
     * Returns `true` if the iteration has more elements.
     */
    override fun hasNext(): Boolean {
        return ptr != source.size
    }

    /**
     * Returns the next element in the iteration.
     */
    override fun next(): E {
        if (!hasNext()) {
            throw NoMoreElementsException
        }

        ptr++
        return source[ptr]
    }
}

class ListIteratorImpl<E>(private val source: List<E>) : ListIterator<E> {
    private var ptr: Int = 0
    override fun hasNext(): Boolean {
        return ptr != source.size
    }

    /**
     * Returns `true` if there are elements in the iteration before the current element.
     */
    override fun hasPrevious(): Boolean {
        return ptr > 0
    }

    override fun next(): E {
        if (!hasNext()) {
            throw NoMoreElementsException
        }

        ptr++
        return source[ptr]
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to [next].
     */
    override fun nextIndex(): Int {
        return ptr + 1
    }

    /**
     * Returns the previous element in the iteration and moves the cursor position backwards.
     */
    override fun previous(): E {
        if (!hasPrevious()) {
            throw NoMoreElementsException
        }

        ptr--
        return source[ptr]
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to [previous].
     */
    override fun previousIndex(): Int {
        return ptr - 1
    }

}

object NoMoreElementsException : Throwable()