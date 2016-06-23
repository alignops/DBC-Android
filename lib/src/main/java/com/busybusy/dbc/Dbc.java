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

import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.ObjectCondition;
import com.busybusy.dbc.conditions.StringCondition;

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

	public static <T> ObjectCondition require(T subject)
	{
		return new ObjectCondition(subject, DbcManager.getInstance().requireEnabled());
	}

	public static DoubleCondition require(Double subject)
	{
		return new DoubleCondition(subject, DbcManager.getInstance().requireEnabled());
	}

	public static FloatCondition require(Float subject)
	{
		return new FloatCondition(subject, DbcManager.getInstance().requireEnabled());
	}

	public static IntegralCondition<Integer> require(Integer subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().requireEnabled());
	}

	public static IntegralCondition<Long> require(Long subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().requireEnabled());
	}

	public static <T extends List<E>, E> ListCondition<T, E> require(T subject)
	{
		return new ListCondition<>(subject, DbcManager.getInstance().requireEnabled());
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> require(T subject)
	{
		return new MapCondition<>(subject, DbcManager.getInstance().requireEnabled());
	}

	public static StringCondition require(String subject)
	{
		return new StringCondition(subject, DbcManager.getInstance().requireEnabled());
	}

	public static <T> ObjectCondition check(T subject)
	{
		return new ObjectCondition(subject, DbcManager.getInstance().checkEnabled());
	}

	public static DoubleCondition check(Double subject)
	{
		return new DoubleCondition(subject, DbcManager.getInstance().checkEnabled());
	}

	public static FloatCondition check(Float subject)
	{
		return new FloatCondition(subject, DbcManager.getInstance().checkEnabled());
	}

	public static IntegralCondition<Integer> check(Integer subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().checkEnabled());
	}

	public static IntegralCondition<Long> check(Long subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().checkEnabled());
	}

	public static <T extends List<E>, E> ListCondition<T, E> check(T subject)
	{
		return new ListCondition<>(subject, DbcManager.getInstance().checkEnabled());
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> check(T subject)
	{
		return new MapCondition<>(subject, DbcManager.getInstance().checkEnabled());
	}

	public static StringCondition check(String subject)
	{
		return new StringCondition(subject, DbcManager.getInstance().checkEnabled());
	}

	public static <T> ObjectCondition ensure(T subject)
	{
		return new ObjectCondition(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static DoubleCondition ensure(Double subject)
	{
		return new DoubleCondition(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static FloatCondition ensure(Float subject)
	{
		return new FloatCondition(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static IntegralCondition<Integer> ensure(Integer subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static IntegralCondition<Long> ensure(Long subject)
	{
		return new IntegralCondition<>(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static <T extends List<E>, E> ListCondition<T, E> ensure(T subject)
	{
		return new ListCondition<>(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> ensure(T subject)
	{
		return new MapCondition<>(subject, DbcManager.getInstance().ensureEnabled());
	}

	public static StringCondition ensure(String subject)
	{
		return new StringCondition(subject, DbcManager.getInstance().ensureEnabled());
	}
}
