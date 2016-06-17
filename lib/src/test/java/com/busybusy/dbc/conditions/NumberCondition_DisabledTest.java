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
public class NumberCondition_DisabledTest
{
	@Test
	public void isGreaterThan() throws Exception
	{
		NumberCondition_Disabled<Integer> condition = new NumberCondition_Disabled<>(2);
		condition.isGreaterThan(1);
		condition.isGreaterThan(7);
	}

	@Test
	public void isGreaterThanOrEqual() throws Exception
	{
		NumberCondition_Disabled<Integer> condition = new NumberCondition_Disabled<>(2);
		condition.isGreaterThanOrEqual(2);
		condition.isGreaterThanOrEqual(7);
	}

	@Test
	public void isLessThan() throws Exception
	{
		NumberCondition_Disabled<Integer> condition = new NumberCondition_Disabled<>(2);
		condition.isLessThan(3);
		condition.isLessThan(1);
	}

	@Test
	public void isLessThanOrEqual() throws Exception
	{
		NumberCondition_Disabled<Integer> condition = new NumberCondition_Disabled<>(2);
		condition.isLessThanOrEqual(2);
		condition.isLessThanOrEqual(1);
	}
}