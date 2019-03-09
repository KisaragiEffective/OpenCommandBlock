package com.kisaragieffective.opencommandblock.struct

import com.kisaragieffective.opencommandblock.interfaces.MustImplementContains

/**
 * The tree struct.
 * @param here current value
 * @param children the children nodes
 * @param parent the parent. If doesn't have parent, it may null
 */
class TreeNode<T>(private val here: T, private var children: List<TreeNode<T>>, var parent: TreeNode<T>?): MustImplementContains<T> {
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

    fun addChild(child: TreeNode<T>) {
        children += child
    }

    fun removeChild(child: TreeNode<T>) {
        children -= child
    }
}