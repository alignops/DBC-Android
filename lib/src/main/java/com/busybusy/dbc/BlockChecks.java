package com.busybusy.dbc;

/**
 * @author Trevor
 */
public interface BlockChecks<T>
{
	BlockChecks<T> and(DbcBlock<T> andBlock);

	T isTrueOf(T subject);
}
