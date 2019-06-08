package com.github.kisaragieffective.opencommandblock.struct

interface AbstractEnumList<E : Enum<E>> : List<E>

/**
 * Gets by order.
 */
class AllOfEnumList<E : Enum<E>>(private val source: Class<E>) : AbstractEnumList<E> {
    private val values: Array<E> = source.enumConstants

    override val size: Int
        get() = values.size

    override fun contains(element: E): Boolean {
        return true
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        return true
    }

    /**
     * Returns the element at the specified index in the list.
     */
    override fun get(index: Int): E {
        return values[index]
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun indexOf(element: E): Int {
        return values.indexOf(element)
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun iterator(): Iterator<E> {
        return IteratorImpl(values.toList())
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun lastIndexOf(element: E): Int {
        return values.lastIndexOf(element)
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     */
    override fun listIterator(): ListIterator<E> {
        return listIterator(0)
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified [index].
     */
    override fun listIterator(index: Int): ListIterator<E> {
        return ListIteratorImpl(values.toList())
    }

    /**
     * Returns a view of the portion of this list between the specified [fromIndex] (inclusive) and [toIndex] (exclusive).
     * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
     *
     * Structural changes in the base list make the behavior of the view undefined.
     */
    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        return values.slice(fromIndex..(toIndex - 1))
    }

}

/*
class EnumList<E : Enum<E>> : AbstractEnumList<E> {
    init {

    }

    override val size: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override operator fun contains(element: E): Boolean {
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        if (elements.isEmpty()) {
            return true
        }
    }

    /**
     * Returns the element at the specified index in the list.
     */
    override fun get(index: Int): E {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun indexOf(element: E): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        return size != 0
    }

    override fun iterator(): Iterator<E> {
        if (size == 0) {
            return EmptyIterator()
        }

        return IteratorImpl(this)
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun lastIndexOf(element: E): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     */
    override fun listIterator(): ListIterator<E> {
        return listIterator(0)
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified [index].
     */
    override fun listIterator(index: Int): ListIterator<E> {
        return ListIteratorImpl(this)
    }

    /**
     * Returns a view of the portion of this list between the specified [fromIndex] (inclusive) and [toIndex] (exclusive).
     * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
     *
     * Structural changes in the base list make the behavior of the view undefined.
     */
    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
*/
