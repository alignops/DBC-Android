package com.busybusy.dbc;

import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Trevor
 */
class CustomCondition<T> implements BlockChecks<T>
{
	private final List<DbcBlock<T>> dbcBlocks = new LinkedList<>();

	CustomCondition(DbcBlock<T> dbcBlock) {this.dbcBlocks.add(dbcBlock);}

	@Override
	public BlockChecks<T> and(@NonNull DbcBlock<T> andBlock)
	{
		Require.that((Object) andBlock).isNotNull();

		this.dbcBlocks.add(andBlock);
		return this;
	}

	@Override
	public T isTrueOf(T subject)
	{
		List<Throwable> errors = new LinkedList<>();

		//noinspection Convert2streamapi
		for (DbcBlock<T> block : this.dbcBlocks)
		{
			if (!block.checkState(subject))
			{
				throw new IllegalStateException("The provided " + subject.getClass().getSimpleName() + " failed the check condition: " + block);
			}
		}

		return subject;
	}
}
