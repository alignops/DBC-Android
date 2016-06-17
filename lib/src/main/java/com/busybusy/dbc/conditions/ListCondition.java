/*
 * Copyright 2016 Busy, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.busybusy.dbc.conditions;

import com.busybusy.dbc.DbcAssertionException;
import com.busybusy.dbc.checks.ListChecks;

import java.util.List;

/**
 * {@linkplain ListChecks} primary implementation
 *
 * @author Trevor
 */
public class ListCondition<T extends List<E>, E> extends BasicCondition<T> implements ListChecks<T, E>
{
	public ListCondition(T subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNotEmpty()
	{
		this.isNotNull();

		if (this.subject.isEmpty())
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected non empty list"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hasSize(int size)
	{
		this.isNotNull();

		if (!(this.subject.size() == size))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected list size to be <" + size + "> but was <" + this.subject.size() + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hasSizeBetween(int startInclusive, int endInclusive)
	{
		this.isNotNull();

		int listSize = this.subject.size();
		if (!((listSize >= startInclusive && listSize <= endInclusive) || (listSize <= startInclusive && listSize >= endInclusive)))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected list size to be between <" + startInclusive + "> and < " + endInclusive + "> but was <" + listSize + ">"));
		}
	}
}
