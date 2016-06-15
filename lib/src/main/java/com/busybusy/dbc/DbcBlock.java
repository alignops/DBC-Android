package com.busybusy.dbc;

/**
 * This functional interface is intended to be implemented to verify state on the provided subject
 *
 * @author Trevor
 */
public interface DbcBlock<T>
{
	boolean checkState(T subject);
}
