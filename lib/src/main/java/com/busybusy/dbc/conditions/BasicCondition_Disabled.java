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

import com.busybusy.dbc.DbcBlock;
import com.busybusy.dbc.checks.BasicChecks;

import org.jetbrains.annotations.NonNls;

import java.util.Comparator;


/**
 * Disabled version of basic condition checks
 *
 * @param <T>
 * @author Trevor
 */
@NonNls
public class BasicCondition_Disabled<T> implements BasicChecks<T>
{
	final T subject;

	public BasicCondition_Disabled(T subject)
	{
		this.subject = subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNull() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNotNull() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void passes(DbcBlock<T> testBlock) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isEqualTo(T toCompare) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isEqualTo(T toCompare, Comparator<T> customComparator) {}
}
