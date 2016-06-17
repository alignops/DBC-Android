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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class BasicCondition_DisabledTest
{
	@Test
	public void isNull() throws Exception
	{
		BasicCondition_Disabled<?> nullCondition = new BasicCondition_Disabled<>(null);
		nullCondition.isNull();

		BasicCondition_Disabled<?> nonNullCondition = new BasicCondition_Disabled<>(new Object());
		nonNullCondition.isNull();
	}

	@Test
	public void isNotNull() throws Exception
	{
		BasicCondition_Disabled<?> nullCondition = new BasicCondition_Disabled<>(null);
		nullCondition.isNotNull();

		BasicCondition_Disabled<?> nonNullCondition = new BasicCondition_Disabled<>(new Object());
		nonNullCondition.isNotNull();
	}

	@Test
	public void passes() throws Exception
	{
		BasicCondition_Disabled<?> condition = new BasicCondition_Disabled<>(null);
		condition.passes(subject -> true);
		condition.passes(subject -> false);
	}

	@Test
	public void isEqualTo() throws Exception
	{
		BasicCondition_Disabled<Object> condition = new BasicCondition_Disabled<>(null);
		condition.isEqualTo(null);
		condition.isEqualTo(new Object());
	}

	@Test
	public void isEqualToCustomComparator() throws Exception
	{
		BasicCondition_Disabled<Object> condition = new BasicCondition_Disabled<>(null);
		condition.isEqualTo(null, (o, t1) -> 0);
		condition.isEqualTo(null, (o, t1) -> 1);
	}

}