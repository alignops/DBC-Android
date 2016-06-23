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
public class FloatConditionTest
{
	@Test
	public void isGreaterThan_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0f, true);
		condition.isGreaterThan(1f);

		assertThatThrownBy(() -> condition.isGreaterThan(3f))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThan_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0f, false);
		condition.isGreaterThan(1f).isGreaterThan(3f);
	}

	@Test
	public void isGreaterThanOrEqual_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isGreaterThanOrEqual(2F);

		assertThatThrownBy(() -> condition.isGreaterThanOrEqual(3F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThanOrEqual_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isGreaterThanOrEqual(2F).isGreaterThanOrEqual(3F);
	}

	@Test
	public void isLessThan_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isLessThan(3F);

		assertThatThrownBy(() -> condition.isLessThan(1F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThan_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isLessThan(3F).isLessThan(1F);
	}

	@Test
	public void isLessThanOrEqual_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isLessThanOrEqual(2F);

		assertThatThrownBy(() -> condition.isLessThanOrEqual(1F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThanOrEqual_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isLessThanOrEqual(2F).isLessThanOrEqual(1F);
	}

	@Test
	public void isNear_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isNear(2F);

		assertThatThrownBy(() -> condition.isNear(1F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNear_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isNear(2F).isNear(1F);
	}

	@Test
	public void isNearCustomTolerance_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isNearWithTolerance(3F, 2.5F);

		assertThatThrownBy(() -> condition.isNearWithTolerance(1F, .5F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearCustomTolerance_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isNearWithTolerance(3F, 2.5F).isNearWithTolerance(1F, .5F);
	}

	@Test
	public void isNearZero_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(0.19e-07F, true);
		condition.isNearZero();

		FloatCondition badCondition = new FloatCondition(2F, true);
		assertThatThrownBy(badCondition::isNearZero)
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZero_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(0.19e-07F, false);
		condition.isNearZero();

		FloatCondition badCondition = new FloatCondition(2F, false);
		badCondition.isNearZero();
	}

	@Test
	public void isNearZeroCustomTolerance_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(1F, true);
		condition.isNearZeroWithTolerance(1.5F);

		FloatCondition badCondition = new FloatCondition(2F, true);
		assertThatThrownBy(() -> badCondition.isNearZeroWithTolerance(1.5F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZeroCustomTolerance_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(1F, false);
		condition.isNearZeroWithTolerance(1.5F);

		FloatCondition badCondition = new FloatCondition(2F, false);
		badCondition.isNearZeroWithTolerance(1.5F);
	}

	@Test
	public void isEqualTo_enabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, true);
		condition.isEqualTo(2F);

		assertThatThrownBy(() -> condition.isEqualTo(1F))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualTo_disabled() throws Exception
	{
		FloatCondition condition = new FloatCondition(2.0F, false);
		condition.isEqualTo(2F).isEqualTo(1F);
	}
}