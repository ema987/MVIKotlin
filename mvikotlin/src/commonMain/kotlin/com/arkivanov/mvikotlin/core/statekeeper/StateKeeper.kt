package com.arkivanov.mvikotlin.core.statekeeper

/**
 * Provides a way to save and restore state (e.g. a `Store`'s state).
 * A typical use case is Android Activity recreation due to system constraints.
 */
interface StateKeeper<T : Any> {

    /**
     * Returns a previously saved state, if any
     */
    fun getState(): T?

    /**
     * Registers the provided state supplier
     *
     * @param supplier a state supplier that will be called when it's time to save the state
     */
    fun register(supplier: () -> T)

    /**
     * Unregisters the provided state supplier
     *
     * @param supplier a state supplier that was previously registered via [register]
     */
    fun unregister(supplier: () -> T)
}
