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

package com.busybusy.dbc;

import com.busybusy.dbc.checks.BasicChecks;
import com.busybusy.dbc.checks.NumberChecks;
import com.busybusy.dbc.checks.StringChecks;
import com.busybusy.dbc.conditions.BasicCondition;
import com.busybusy.dbc.conditions.BasicCondition_Disabled;
import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegerCondition;
import com.busybusy.dbc.conditions.NumberCondition_Disabled;
import com.busybusy.dbc.conditions.StringCondition;
import com.busybusy.dbc.conditions.StringCondition_Disabled;

/**
 * The basis of the following design by contract concepts:
 * <ul>
 * <li>"Pre-condition" &#8660; "Require"</li>
 * <li>"Invariant" &#8660; "Check"</li>
 * <li>"Post-condition" &#8660; "Ensure"</li>
 * </ul>
 * <p>
 * In the case of a "Pre-condition" one may use the following approach
 * <pre><code class="java">Dbc.require(someParam).isNotNull();</code></pre>
 *
 * In some cases more flexibility is needed and you may use the DbcBlock approach to capture the verification logic.
 * <pre><code class="java">Dbc.require(someParam).passes((it) -> it >= 0);</code></pre>
 *
 * @author Trevor
 */
public class Dbc
{
	private Dbc() {}

	public static <T> BasicChecks<T> require(T subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new BasicCondition<>(subject);
		}
		else
		{
			return new BasicCondition_Disabled<>(subject);
		}
	}

	public static StringChecks require(String subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new StringCondition(subject);
		}
		else
		{
			return new StringCondition_Disabled(subject);
		}
	}

	public static NumberChecks<Integer> require(Integer subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new IntegerCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Long> require(Long subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new IntegerCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Float> require(Float subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new FloatCondition(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Double> require(Double subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new DoubleCondition(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}
}
