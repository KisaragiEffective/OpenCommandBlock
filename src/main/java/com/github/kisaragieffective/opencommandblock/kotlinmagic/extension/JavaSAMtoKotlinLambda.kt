package com.github.kisaragieffective.opencommandblock.kotlinmagic.extension

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
fun <R : Any?> Supplier<R>.toLambda(): () -> R = ::get

fun IntSupplier.toLambda(): () -> Int = ::getAsInt

fun LongSupplier.toLambda(): () -> Long = ::getAsLong

fun DoubleSupplier.toLambda(): () -> Double = ::getAsDouble

fun BooleanSupplier.toLambda(): () -> Boolean = ::getAsBoolean

// Consumer
fun <T : Any?> Consumer<T>.toLambda(): (T) -> Unit = ::accept

fun IntConsumer.toLambda(): (Int) -> Unit = ::accept

fun LongConsumer.toLambda(): (Long) -> Unit = ::accept

fun DoubleConsumer.toLambda(): (Double) -> Unit = ::accept

fun <P1 : Any?, P2 : Any?> BiConsumer<P1, P2>.toLambda(): (P1, P2) -> Unit = ::accept

// Obj~Consumer

fun <P : Any?> ObjIntConsumer<P>.toLambda(): (P, Int) -> Unit = ::accept

fun <P : Any?> ObjLongConsumer<P>.toLambda(): (P, Long) -> Unit = ::accept

fun <P : Any?> ObjDoubleConsumer<P>.toLambda(): (P, Double) -> Unit = ::accept

// Function
fun <P : Any?, R : Any?> Function<P, R>.toLambda(): (P) -> R = ::apply

fun <R : Any?> IntFunction<R>.toLambda(): (Int) -> R = ::apply

fun <R : Any?> LongFunction<R>.toLambda(): (Long) -> R = ::apply

fun <R : Any?> DoubleFunction<R>.toLambda(): (Double) -> R = ::apply

// - Int -> ?
fun IntToDoubleFunction.toLambda(): (Int) -> Double = ::applyAsDouble

fun IntToLongFunction.toLambda(): (Int) -> Long = ::applyAsLong

// - Long -> ?
fun LongToIntFunction.toLambda(): (Long) -> Int = ::applyAsInt

fun LongToDoubleFunction.toLambda(): (Long) -> Double = ::applyAsDouble

// - Double -> ?
fun DoubleToIntFunction.toLambda(): (Double) -> Int = ::applyAsInt

fun DoubleToLongFunction.toLambda(): (Double) -> Long = ::applyAsLong

// P -> P
fun <PR : Any?> UnaryOperator<PR>.toLambda(): (PR) -> PR = ::apply

// ~UnaryOperator
fun IntUnaryOperator.toLambda(): (Int) -> Int = ::applyAsInt

fun LongUnaryOperator.toLambda(): (Long) -> Long = ::applyAsLong

fun DoubleUnaryOperator.toLambda(): (Double) -> Double = ::applyAsDouble

// ~BinaryOperator
fun IntBinaryOperator.toLambda(): (Int, Int) -> Int = ::applyAsInt

fun LongBinaryOperator.toLambda(): (Long, Long) -> Long = ::applyAsLong

fun DoubleBinaryOperator.toLambda(): (Double, Double) -> Double = ::applyAsDouble

// BiFunction
fun <P1 : Any?, P2: Any?, R: Any?> BiFunction<P1, P2, R>.toLambda(): (P1, P2) -> R = ::apply

// To~BiFunc

fun <P1 : Any?, P2 : Any?> ToIntBiFunction<P1, P2>.toLambda(): (P1, P2) -> Int = ::applyAsInt

fun <P1 : Any?, P2 : Any?> ToLongBiFunction<P1, P2>.toLambda(): (P1, P2) -> Long = ::applyAsLong

fun <P1 : Any?, P2 : Any?> ToDoubleBiFunction<P1, P2>.toLambda(): (P1, P2) -> Double = ::applyAsDouble

// To~Func
fun <P1 : Any?> ToIntFunction<P1>.toLambda(): (P1) -> Int = ::applyAsInt

fun <P1 : Any?> ToLongFunction<P1>.toLambda(): (P1) -> Long = ::applyAsLong

fun <P1 : Any?> ToDoubleFunction<P1>.toLambda(): (P1) -> Double = ::applyAsDouble

// Predicate
fun <P : Any?> Predicate<P>.toLambda(): (P) -> Boolean = ::test

fun IntPredicate.toLambda(): (Int) -> Boolean = ::test

fun LongPredicate.toLambda(): (Long) -> Boolean = ::test

fun DoublePredicate.toLambda(): (Double) -> Boolean = ::test

fun <P1 : Any?, P2 : Any?> BiPredicate<P1, P2>.toLambda(): (P1, P2) -> Boolean = ::test




