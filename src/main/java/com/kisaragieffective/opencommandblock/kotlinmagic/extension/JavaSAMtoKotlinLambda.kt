package com.kisaragieffective.opencommandblock.kotlinmagic.extension

import java.util.function.BiConsumer
import java.util.function.BiFunction
import java.util.function.BiPredicate
import java.util.function.BooleanSupplier
import java.util.function.Consumer
import java.util.function.DoubleBinaryOperator
import java.util.function.DoubleConsumer
import java.util.function.DoubleFunction
import java.util.function.DoublePredicate
import java.util.function.DoubleSupplier
import java.util.function.DoubleToIntFunction
import java.util.function.DoubleToLongFunction
import java.util.function.DoubleUnaryOperator
import java.util.function.Function
import java.util.function.IntBinaryOperator
import java.util.function.IntConsumer
import java.util.function.IntFunction
import java.util.function.IntPredicate
import java.util.function.IntSupplier
import java.util.function.IntToDoubleFunction
import java.util.function.IntToLongFunction
import java.util.function.IntUnaryOperator
import java.util.function.LongBinaryOperator
import java.util.function.LongConsumer
import java.util.function.LongFunction
import java.util.function.LongPredicate
import java.util.function.LongSupplier
import java.util.function.LongToDoubleFunction
import java.util.function.LongToIntFunction
import java.util.function.LongUnaryOperator
import java.util.function.ObjDoubleConsumer
import java.util.function.ObjIntConsumer
import java.util.function.ObjLongConsumer
import java.util.function.Predicate
import java.util.function.Supplier
import java.util.function.ToDoubleBiFunction
import java.util.function.ToDoubleFunction
import java.util.function.ToIntBiFunction
import java.util.function.ToIntFunction
import java.util.function.ToLongBiFunction
import java.util.function.ToLongFunction
import java.util.function.UnaryOperator

// P stands for Parameter, R stands for Return, PR stands for both Parameter and Return.

// Supplier
fun <R : Any?> Supplier<R>.toLambda(): () -> R {
    return ::get
}

fun IntSupplier.toLambda(): () -> Int {
    return ::getAsInt
}

fun LongSupplier.toLambda(): () -> Long {
    return ::getAsLong
}

fun DoubleSupplier.toLambda(): () -> Double {
    return ::getAsDouble
}

fun BooleanSupplier.toLambda(): () -> Boolean {
    return ::getAsBoolean
}

// Consumer
fun <T : Any?> Consumer<T>.toLambda(): (T) -> Unit {
    return ::accept
}

fun IntConsumer.toLambda(): (Int) -> Unit {
    return ::accept
}

fun LongConsumer.toLambda(): (Long) -> Unit {
    return ::accept
}

fun DoubleConsumer.toLambda(): (Double) -> Unit {
    return ::accept
}

fun <P1 : Any?, P2 : Any?> BiConsumer<P1, P2>.toLambda(): (P1, P2) -> Unit {
    return ::accept
}

// Obj~Consumer

fun <P : Any?> ObjIntConsumer<P>.toLambda(): (P, Int) -> Unit {
    return ::accept
}

fun <P : Any?> ObjLongConsumer<P>.toLambda(): (P, Long) -> Unit {
    return ::accept
}

fun <P : Any?> ObjDoubleConsumer<P>.toLambda(): (P, Double) -> Unit {
    return ::accept
}

// Function
fun <P : Any?, R : Any?> Function<P, R>.toLambda(): (P) -> R {
    return ::apply
}

fun <R : Any?> IntFunction<R>.toLambda(): (Int) -> R {
    return ::apply
}

fun <R : Any?> LongFunction<R>.toLambda(): (Long) -> R {
    return ::apply
}

fun <R : Any?> DoubleFunction<R>.toLambda(): (Double) -> R {
    return ::apply
}

// - Int -> ?
fun IntToDoubleFunction.toLambda(): (Int) -> Double {
    return ::applyAsDouble
}

fun IntToLongFunction.toLambda(): (Int) -> Long {
    return ::applyAsLong
}

// - Long -> ?
fun LongToIntFunction.toLambda(): (Long) -> Int {
    return ::applyAsInt
}

fun LongToDoubleFunction.toLambda(): (Long) -> Double {
    return ::applyAsDouble
}

// - Double -> ?
fun DoubleToIntFunction.toLambda(): (Double) -> Int {
    return ::applyAsInt
}

fun DoubleToLongFunction.toLambda(): (Double) -> Long {
    return ::applyAsLong
}

// P -> P
fun <PR : Any?> UnaryOperator<PR>.toLambda(): (PR) -> PR {
    return ::apply
}

// ~UnaryOperator
fun IntUnaryOperator.toLambda(): (Int) -> Int {
    return ::applyAsInt
}

fun LongUnaryOperator.toLambda(): (Long) -> Long {
    return ::applyAsLong
}

fun DoubleUnaryOperator.toLambda(): (Double) -> Double {
    return ::applyAsDouble
}

// ~BinaryOperator
fun IntBinaryOperator.toLambda(): (Int, Int) -> Int {
    return ::applyAsInt
}

fun LongBinaryOperator.toLambda(): (Long, Long) -> Long {
    return ::applyAsLong
}

fun DoubleBinaryOperator.toLambda(): (Double, Double) -> Double {
    return ::applyAsDouble
}

// BiFunction
fun <P1 : Any?, P2: Any?, R: Any?> BiFunction<P1, P2, R>.toLambda(): (P1, P2) -> R {
    return ::apply
}

// To~BiFunc

fun <P1 : Any?, P2 : Any?> ToIntBiFunction<P1, P2>.toLambda(): (P1, P2) -> Int {
    return ::applyAsInt
}

fun <P1 : Any?, P2 : Any?> ToLongBiFunction<P1, P2>.toLambda(): (P1, P2) -> Long {
    return ::applyAsLong
}

fun <P1 : Any?, P2 : Any?> ToDoubleBiFunction<P1, P2>.toLambda(): (P1, P2) -> Double {
    return ::applyAsDouble
}

// To~Func
fun <P1 : Any?> ToIntFunction<P1>.toLambda(): (P1) -> Int {
    return ::applyAsInt
}

fun <P1 : Any?> ToLongFunction<P1>.toLambda(): (P1) -> Long {
    return ::applyAsLong
}

fun <P1 : Any?> ToDoubleFunction<P1>.toLambda(): (P1) -> Double {
    return ::applyAsDouble
}

// Predicate
fun <P : Any?> Predicate<P>.toLambda(): (P) -> Boolean {
    return ::test
}

fun IntPredicate.toLambda(): (Int) -> Boolean {
    return ::test
}

fun LongPredicate.toLambda(): (Long) -> Boolean {
    return ::test
}

fun DoublePredicate.toLambda(): (Double) -> Boolean {
    return ::test
}

fun <P1 : Any?, P2 : Any?> BiPredicate<P1, P2>.toLambda(): (P1, P2) -> Boolean {
    return ::test
}




