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

import com.busybusy.dbc.DbcAssertionError;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class FloatConditionTest
{
	@Test
	public void isGreaterThan_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0f);
		condition.isGreaterThan(1f);

		assertThatThrownBy(() -> condition.isGreaterThan(3f))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThanOrEqual_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isGreaterThanOrEqual(2F);

		assertThatThrownBy(() -> condition.isGreaterThanOrEqual(3F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThan_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isLessThan(3F);

		assertThatThrownBy(() -> condition.isLessThan(1F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThanOrEqual_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isLessThanOrEqual(2F);

		assertThatThrownBy(() -> condition.isLessThanOrEqual(1F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNear_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isNear(2F);

		assertThatThrownBy(() -> condition.isNear(1F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearCustomTolerance_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isNearWithTolerance(3F, 2.5F);

		assertThatThrownBy(() -> condition.isNearWithTolerance(1F, .5F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZero_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(0.19e-07F);
		condition.isNearZero();

		FloatCondition badCondition = new FloatCondition(2F);
		assertThatThrownBy(badCondition::isNearZero)
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZeroCustomTolerance_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(1F);
		condition.isNearZeroWithTolerance(1.5F);

		FloatCondition badCondition = new FloatCondition(2F);
		assertThatThrownBy(() -> badCondition.isNearZeroWithTolerance(1.5F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualTo_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F);
		condition.isEqualTo(2F);

		assertThatThrownBy(() -> condition.isEqualTo(1F))
				.isInstanceOf(DbcAssertionError.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}
}