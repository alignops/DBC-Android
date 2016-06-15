package com.busybusy.dbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class RequireTest
{

	public static final String INPUT_STRING = "ValidString";

	@Test
	public void that_basic() throws Exception
	{

		assertThat(Require.that(INPUT_STRING).isNotNull()).isNotNull().isEqualTo(INPUT_STRING);

		try
		{
			Require.that((String) null).isNotNull();
			fail("Unreachable");
		}
		catch (NullPointerException e)
		{
			assertThat(e).hasMessage("A non null argument was required but was null");
		}
	}

	@Test
	public void that1() throws Exception
	{
		assertThat(Require.that(StringChecks::isValid).isTrueOf(INPUT_STRING)).isEqualTo(INPUT_STRING);
	}

	private static class StringChecks
	{
		static boolean isValid(String subject)
		{
			return subject != null && subject.trim().length() > 0;
		}
	}

}