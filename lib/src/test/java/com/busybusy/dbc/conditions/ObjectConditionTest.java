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
public class ObjectConditionTest
{
	@Test
	public void isNull_enabled() throws Exception
	{
		ObjectCondition nullCondition = new ObjectCondition(null, true);
		nullCondition.isNull();

		ObjectCondition nonNullCondition = new ObjectCondition(new Object(), true);

		assertThatThrownBy(nonNullCondition::isNull)
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNull_disabled() throws Exception
	{
		ObjectCondition nullCondition = new ObjectCondition(null, false);
		nullCondition.isNull();

		ObjectCondition nonNullCondition = new ObjectCondition(new Object(), false);
		nonNullCondition.isNull();
	}

	@Test
	public void isNotNull_enabled() throws Exception
	{
		ObjectCondition nonNullCondition = new ObjectCondition(new Object(), true);
		nonNullCondition.isNotNull();

		ObjectCondition nullCondition = new ObjectCondition(null, true);

		assertThatThrownBy(nullCondition::isNotNull)
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(NullPointerException.class);
	}

	@Test
	public void isNotNull_disabled() throws Exception
	{
		ObjectCondition nonNullCondition = new ObjectCondition(new Object(), false);
		nonNullCondition.isNotNull();

		ObjectCondition nullCondition = new ObjectCondition(null, false);
		nullCondition.isNotNull();
	}

	@Test
	public void passes_enabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(new Object(), true);
		condition.passes(subject -> true);

		assertThatThrownBy(() -> condition.passes(subject -> false))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void passes_disabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(new Object(), false);
		condition.passes(subject -> true).passes(subject -> false);
	}

	@Test
	public void isEqualTo_enabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(2, true);
		condition.isEqualTo(2);

		assertThatThrownBy(() -> condition.isEqualTo(3))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualTo_disabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(2, false);
		condition.isEqualTo(2).isEqualTo(3);
	}

	@Test
	public void isEqualToCustomComparator_enabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(2, true);
		condition.isEqualTo(2, (integer, t1) -> 0);

		assertThatThrownBy(() -> condition.isEqualTo(2, (integer, t1) -> 1))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualToCustomComparator_disabled() throws Exception
	{
		ObjectCondition condition = new ObjectCondition(2, false);
		condition.isEqualTo(2, (integer, t1) -> 0).isEqualTo(2, (integer, t1) -> 1);
	}
}