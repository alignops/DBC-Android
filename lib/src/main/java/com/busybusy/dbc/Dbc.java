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
import com.busybusy.dbc.checks.FloatingPointChecks;
import com.busybusy.dbc.checks.ListChecks;
import com.busybusy.dbc.checks.MapChecks;
import com.busybusy.dbc.checks.NumberChecks;
import com.busybusy.dbc.checks.StringChecks;
import com.busybusy.dbc.conditions.BasicCondition;
import com.busybusy.dbc.conditions.BasicCondition_Disabled;
import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.FloatingPointCondition_Disabled;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.ListCondition_Disabled;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.MapCondition_Disabled;
import com.busybusy.dbc.conditions.NumberCondition_Disabled;
import com.busybusy.dbc.conditions.StringCondition;
import com.busybusy.dbc.conditions.StringCondition_Disabled;

import java.util.List;
import java.util.Map;

/**
 * The basis of the following design by contract concepts:
 * <ul>
 * <li>"Pre-condition" &#8660; "Require"</li>
 * <li>"Verify" &#8660; "Check"</li>
 * <li>"Post-condition" &#8660; "Ensure"</li>
 * </ul>
 * <p>
 * In debug code, the following methods assist in using "Design by contract" in java.  Each will
 * check the "condition" passed in.  If the condition fails, then each will display a
 * message to the debugger console and throw an AssertionError exception.  Although they
 * perform identical tasks, each is semantically different.
 * <p>
 * "require" is used to verify required conditions as you enter a method.  If the
 * contract specifies that certain conditions exist when entering a method, you should
 * check these conditions with "requires" before you start your method execution. Examples
 * of its use includes checking that parameters passed in are within a required range or non-null.
 * <p>
 * "check" is used to check conditions in the body of a method.  If, in your method, you
 * have a condition that must be true to safely execute the following code, you
 * should "check" that condition. Examples of its use include checking that a pointer is
 * non-nil after a function call that sets up the pointer, or that a value calculated
 * within the body of the method is within a required range.
 * <p>
 * "ensure" is used to ensure return conditions before you leave a method.  If the
 * contract specifies that certain conditions exist before leaving a method, you should
 * verify these conditions with "ensure" before you exit your method. Examples of its
 * use include checking that values returned are within a required range or non-nil.
 * <p>
 * In non-debug code, these methods can be disabled via the {@linkplain DbcManager} which will
 * result in disabled implementation of the returned condition object.
 * <p>
 * <pre>
 * {@code
 * int foo(ArrayList<Object> objectList, int listIndex, int otherIndex) {
 *      require(objectList).isNotNull();
 *      require(listIndex).isGreaterThanOrEqual(0);
 *      require(listIndex).isLessThan(someLimit);
 *
 *      List<Integer> object = objectList[listIndex];
 *      check(object).isNotNull();
 *
 *      int returnValue = object.getValue(returnIndex);
 *      ensure(returnValue).isGreaterThanOrEqual(valueMin);
 *      ensure(returnValue).isLessThanOrEqual(valueMax);
 *
 *      return returnValue;
 *    }
 * }
 * </pre>
 * <p>
 * In some cases more flexibility is needed and you may use the DbcBlock approach to capture the verification logic.
 * <pre><code class="java">Dbc.require(someParam).passes((it) -> it >= 0);</code></pre>
 *
 * @author Trevor
 * @see <a href="http://www.eiffel.com/developers/design_by_contract_in_detail.html">Eiffel-Design by contract in detail</a>
 * @see <a href="https://youtu.be/v1phSCx_Vvg">Eiffel-Design by contract-Part 1</a>
 * @see <a href="https://youtu.be/8XV0khSeKaw">Eiffel-Design by contract-Part 2</a>
 * @see <a href="http://www.cs.unc.edu/~stotts/Eiffel/contract.html">UNC-Programming by Contract</a>
 * @see <a href="http://se.ethz.ch/~meyer/publications/computer/contract.pdf">Bertrand Meyer-Applying &quot;Design by Contract&quot;</a>
 * @see <a href="https://en.wikipedia.org/wiki/Design_by_contract">Wikipedia : Design by Contract</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html">Java Tutorials : Catching and Handling Exceptions</a>
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

	public static FloatingPointChecks<Double> require(Double subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new DoubleCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static FloatingPointChecks<Float> require(Float subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new FloatCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Integer> require(Integer subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new IntegralCondition<>(subject);
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
			return new IntegralCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static <T extends List<E>, E> ListChecks<T, E> require(T subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new ListCondition<>(subject);
		}
		else
		{
			return new ListCondition_Disabled<>(subject);
		}
	}

	public static <T extends Map<K, V>, K, V> MapChecks<T, K, V> require(T subject)
	{
		if (DbcManager.getInstance().requireEnabled())
		{
			return new MapCondition<>(subject);
		}
		else
		{
			return new MapCondition_Disabled<>(subject);
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

	public static <T> BasicChecks<T> check(T subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new BasicCondition<>(subject);
		}
		else
		{
			return new BasicCondition_Disabled<>(subject);
		}
	}

	public static FloatingPointChecks<Double> check(Double subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new DoubleCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static FloatingPointChecks<Float> check(Float subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new FloatCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Integer> check(Integer subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new IntegralCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Long> check(Long subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new IntegralCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static <T extends List<E>, E> ListChecks<T, E> check(T subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new ListCondition<>(subject);
		}
		else
		{
			return new ListCondition_Disabled<>(subject);
		}
	}

	public static <T extends Map<K, V>, K, V> MapChecks<T, K, V> check(T subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new MapCondition<>(subject);
		}
		else
		{
			return new MapCondition_Disabled<>(subject);
		}
	}

	public static StringChecks check(String subject)
	{
		if (DbcManager.getInstance().checkEnabled())
		{
			return new StringCondition(subject);
		}
		else
		{
			return new StringCondition_Disabled(subject);
		}
	}

	public static <T> BasicChecks<T> ensure(T subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new BasicCondition<>(subject);
		}
		else
		{
			return new BasicCondition_Disabled<>(subject);
		}
	}

	public static FloatingPointChecks<Double> ensure(Double subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new DoubleCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static FloatingPointChecks<Float> ensure(Float subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new FloatCondition(subject);
		}
		else
		{
			return new FloatingPointCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Integer> ensure(Integer subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new IntegralCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static NumberChecks<Long> ensure(Long subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new IntegralCondition<>(subject);
		}
		else
		{
			return new NumberCondition_Disabled<>(subject);
		}
	}

	public static <T extends List<E>, E> ListChecks<T, E> ensure(T subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new ListCondition<>(subject);
		}
		else
		{
			return new ListCondition_Disabled<>(subject);
		}
	}

	public static <T extends Map<K, V>, K, V> MapChecks<T, K, V> ensure(T subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new MapCondition<>(subject);
		}
		else
		{
			return new MapCondition_Disabled<>(subject);
		}
	}

	public static StringChecks ensure(String subject)
	{
		if (DbcManager.getInstance().ensureEnabled())
		{
			return new StringCondition(subject);
		}
		else
		{
			return new StringCondition_Disabled(subject);
		}
	}
}
