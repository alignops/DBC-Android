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

import android.os.Bundle;
import android.support.annotation.CheckResult;

import com.busybusy.dbc.conditions.BooleanCondition;
import com.busybusy.dbc.conditions.BundleCondition;
import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.ObjectCondition;
import com.busybusy.dbc.conditions.SetCondition;
import com.busybusy.dbc.conditions.StringCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * In debug code, the following methods assist in using "Design by contract" in java
 * <p>
 * In non-debug code, these methods can be stripped out via the provided proguard config file
 *
 * @author Trevor
 * @see <a href="https://en.wikipedia.org/wiki/Design_by_contract">Wikipedia : Design by Contract</a>
 */
@SuppressWarnings("WeakerAccess")
public class Dbc
{
	private Dbc() {}

	@CheckResult
	public static <T> ObjectCondition<T> require(T subject)
	{
		return new ObjectCondition<>(subject);
	}

	@CheckResult
	public static BooleanCondition require(Boolean subject)
	{
		return new BooleanCondition(subject);
	}

	@CheckResult
	public static BundleCondition require(Bundle bundle)
	{
		return new BundleCondition(bundle);
	}

	@CheckResult
	public static DoubleCondition require(Double subject)
	{
		return new DoubleCondition(subject);
	}

	@CheckResult
	public static FloatCondition require(Float subject)
	{
		return new FloatCondition(subject);
	}

	@CheckResult
	public static IntegralCondition<Integer> require(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static IntegralCondition<Long> require(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static <T extends List<E>, E> ListCondition<T, E> require(T subject)
	{
		return new ListCondition<>(subject);
	}

	@CheckResult
	public static <E> ListCondition<List<E>, E> require(E[] subject)
	{
		List<E> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			Collections.addAll(listSub, subject);
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Short>, Short> require(short[] subject)
	{
		List<Short> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (short i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Integer>, Integer> require(int[] subject)
	{
		List<Integer> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (int i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Long>, Long> require(long[] subject)
	{
		List<Long> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (long i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Float>, Float> require(float[] subject)
	{
		List<Float> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (float i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Double>, Double> require(double[] subject)
	{
		List<Double> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (double i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Character>, Character> require(char[] subject)
	{
		List<Character> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (char i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Boolean>, Boolean> require(boolean[] subject)
	{
		List<Boolean> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (boolean i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Byte>, Byte> require(byte[] subject)
	{
		List<Byte> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (byte i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> require(T subject)
	{
		return new MapCondition<>(subject);
	}

	@CheckResult
	public static <T extends Set<E>, E> SetCondition<T, E> require(T subject)
	{
		return new SetCondition<>(subject);
	}

	@CheckResult
	public static StringCondition require(CharSequence subject)
	{
		return new StringCondition(subject);
	}

	@CheckResult
	public static <T> ObjectCondition<T> check(T subject)
	{
		return new ObjectCondition<>(subject);
	}

	@CheckResult
	public static BooleanCondition check(Boolean subject)
	{
		return new BooleanCondition(subject);
	}

	@CheckResult
	public static BundleCondition check(Bundle bundle)
	{
		return new BundleCondition(bundle);
	}

	@CheckResult
	public static DoubleCondition check(Double subject)
	{
		return new DoubleCondition(subject);
	}

	@CheckResult
	public static FloatCondition check(Float subject)
	{
		return new FloatCondition(subject);
	}

	@CheckResult
	public static IntegralCondition<Integer> check(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static IntegralCondition<Long> check(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static <T extends List<E>, E> ListCondition<T, E> check(T subject)
	{
		return new ListCondition<>(subject);
	}

	@CheckResult
	public static <E> ListCondition<List<E>, E> check(E[] subject)
	{
		List<E> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			Collections.addAll(listSub, subject);
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Short>, Short> check(short[] subject)
	{
		List<Short> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (short i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Integer>, Integer> check(int[] subject)
	{
		List<Integer> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (int i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Long>, Long> check(long[] subject)
	{
		List<Long> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (long i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Float>, Float> check(float[] subject)
	{
		List<Float> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (float i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Double>, Double> check(double[] subject)
	{
		List<Double> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (double i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Character>, Character> check(char[] subject)
	{
		List<Character> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (char i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Boolean>, Boolean> check(boolean[] subject)
	{
		List<Boolean> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (boolean i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Byte>, Byte> check(byte[] subject)
	{
		List<Byte> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (byte i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> check(T subject)
	{
		return new MapCondition<>(subject);
	}

	@CheckResult
	public static <T extends Set<E>, E> SetCondition<T, E> check(T subject)
	{
		return new SetCondition<>(subject);
	}

	@CheckResult
	public static StringCondition check(CharSequence subject)
	{
		return new StringCondition(subject);
	}

	@CheckResult
	public static <T> ObjectCondition<T> ensure(T subject)
	{
		return new ObjectCondition<>(subject);
	}

	@CheckResult
	public static BooleanCondition ensure(Boolean subject)
	{
		return new BooleanCondition(subject);
	}

	@CheckResult
	public static BundleCondition ensure(Bundle bundle)
	{
		return new BundleCondition(bundle);
	}

	@CheckResult
	public static DoubleCondition ensure(Double subject)
	{
		return new DoubleCondition(subject);
	}

	@CheckResult
	public static FloatCondition ensure(Float subject)
	{
		return new FloatCondition(subject);
	}

	@CheckResult
	public static IntegralCondition<Integer> ensure(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static IntegralCondition<Long> ensure(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	@CheckResult
	public static <T extends List<E>, E> ListCondition<T, E> ensure(T subject)
	{
		return new ListCondition<>(subject);
	}

	@CheckResult
	public static <E> ListCondition<List<E>, E> ensure(E[] subject)
	{
		List<E> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			Collections.addAll(listSub, subject);
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Short>, Short> ensure(short[] subject)
	{
		List<Short> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (short i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Integer>, Integer> ensure(int[] subject)
	{
		List<Integer> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (int i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Long>, Long> ensure(long[] subject)
	{
		List<Long> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (long i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Float>, Float> ensure(float[] subject)
	{
		List<Float> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (float i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Double>, Double> ensure(double[] subject)
	{
		List<Double> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (double i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Character>, Character> ensure(char[] subject)
	{
		List<Character> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (char i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Boolean>, Boolean> ensure(boolean[] subject)
	{
		List<Boolean> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (boolean i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static ListCondition<List<Byte>, Byte> ensure(byte[] subject)
	{
		List<Byte> listSub = null;
		if (subject != null)
		{
			listSub = new ArrayList<>();
			for (byte i : subject)
			{
				listSub.add(i);
			}
		}

		return new ListCondition<>(listSub);
	}

	@CheckResult
	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> ensure(T subject)
	{
		return new MapCondition<>(subject);
	}

	@CheckResult
	public static <T extends Set<E>, E> SetCondition<T, E> ensure(T subject)
	{
		return new SetCondition<>(subject);
	}

	@CheckResult
	public static StringCondition ensure(CharSequence subject)
	{
		return new StringCondition(subject);
	}
}
