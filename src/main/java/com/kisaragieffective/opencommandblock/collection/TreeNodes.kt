package com.kisaragieffective.opencommandblock.collection

import com.kisaragieffective.opencommandblock.interfaces.MustImplementContains

interface AbstractTreeNode<T> : MustImplementContains<T> {
    fun addChild(child: TreeNode<T>)

    fun removeChild(child: TreeNode<T>)
}

/**
 * The tree collection.
 * @param here current value
 * @param children the children nodes
 * @param parent the parent. If doesn't have parent, it may null
 */
class TreeNode<T>(private val here: T, private var children: List<TreeNode<T>>, var parent: TreeNode<T>?) : AbstractTreeNode<T> {
    override operator fun contains(other: T): Boolean {
        if (here == other) return true
        if (children.isNotEmpty() && children.any { it.contains(other)}) {
            return true
        }

        val e = parent
        if (e != null && e.contains(here)) {
            return true
        }

        return false
    }

    override fun addChild(child: TreeNode<T>) {
        children += child
    }

    override fun removeChild(child: TreeNode<T>) {
        children -= child
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode<*>

        if (here != other.here) return false
        if (children != other.children) return false
        if (parent != other.parent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = here?.hashCode() ?: 0
        result = 31 * result + children.hashCode()
        result = 31 * result + (parent?.hashCode() ?: 0)
        return result
    }
}