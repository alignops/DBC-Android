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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class IntegralConditionTest
{
	@Test
	public void isGreaterThan() throws Exception
	{
		IntegralCondition<Integer> condition = new IntegralCondition<>(2);
		condition.isGreaterThan(1);

		assertThatThrownBy(() -> condition.isGreaterThan(7))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThanOrEqual() throws Exception
	{
		IntegralCondition<Integer> condition = new IntegralCondition<>(2);
		condition.isGreaterThanOrEqual(2);

		assertThatThrownBy(() -> condition.isGreaterThanOrEqual(7))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThan() throws Exception
	{
		IntegralCondition<Integer> condition = new IntegralCondition<>(2);
		condition.isLessThan(3);

		assertThatThrownBy(() -> condition.isLessThan(1))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThanOrEqual() throws Exception
	{
		IntegralCondition<Integer> condition = new IntegralCondition<>(2);
		condition.isLessThanOrEqual(2);

		assertThatThrownBy(() -> condition.isLessThanOrEqual(1))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

}