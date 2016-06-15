package com.busybusy.dbc;

/**
 * @author Trevor
 */

public class Require<T>
{
	public static <T> NullChecks<T> that(T subject)
	{
		return new BasicCondition<>(subject);
	}

	public static <T> BlockChecks<T> that(DbcBlock<T> codeBlock)
	{
		return new CustomCondition<>(codeBlock);
	}
}
