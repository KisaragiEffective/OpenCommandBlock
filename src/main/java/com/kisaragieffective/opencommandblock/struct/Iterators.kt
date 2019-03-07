package com.kisaragieffective.opencommandblock.struct

class EmptyIterator<E> : Iterator<E> {
    override fun hasNext(): Boolean {
        return false
    }

    override fun next(): E {
        throw NoMoreElementsException
    }
}

class EmptyListIterator<E> : ListIterator<E> {
    override fun hasNext(): Boolean {
        return false
    }

    override fun hasPrevious(): Boolean {
        return false
    }

    override fun next(): E {
        throw NoMoreElementsException
    }

    override fun nextIndex(): Int {
        return 0
    }

    override fun previous(): E {
        throw NoSuchElementException()
    }

    override fun previousIndex(): Int {
        return 0
    }
}

class IteratorImpl<E>(private val source: List<E>) : Iterator<E> {
    private var ptr: Int = 0
    override fun hasNext(): Boolean {
        return ptr != source.size
    }

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

    override fun nextIndex(): Int {
        return ptr + 1
    }

    override fun previous(): E {
        if (!hasPrevious()) {
            throw NoMoreElementsException
        }

        ptr--
        return source[ptr]
    }

    override fun previousIndex(): Int {
        return ptr - 1
    }
}

object NoMoreElementsException : Throwable()