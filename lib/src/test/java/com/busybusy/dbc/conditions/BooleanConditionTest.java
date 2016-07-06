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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
public class BooleanConditionTest
{
	@Test
	public void isTrue() throws Exception
	{
		BooleanCondition condition = new BooleanCondition(true);

		condition.isTrue();

		assertThatThrownBy(condition::isFalse).isInstanceOf(DbcAssertionError.class)
		                                      .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void isFalse() throws Exception
	{
		BooleanCondition condition = new BooleanCondition(false);

		condition.isFalse();

		assertThatThrownBy(condition::isTrue).isInstanceOf(DbcAssertionError.class)
		                                     .hasCauseInstanceOf(IllegalStateException.class);
	}

}