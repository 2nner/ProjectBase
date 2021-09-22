package com.inner.baseproject.libs

inline fun <T, R> nullCheck(variable: T?, block: (T) -> R) {
    if (variable != null) block(variable)
}