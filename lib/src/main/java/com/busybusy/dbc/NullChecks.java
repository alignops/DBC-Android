package com.busybusy.dbc;

/**
 * The basis of the following design by contract concepts:
 * <ul>
 * <li>"Pre-condition" &#8660; "Require"</li>
 * <li>"Invariant" &#8660; "Check"</li>
 * <li>"Post-condition" &#8660; "Ensure"</li>
 * </ul>
 * <p>
 * In the case of a "Pre-condition" one may use the following approach
 * <pre><code class="java">Require.that(someParam).isNotNull();</code></pre>
 *
 * In many cases more flexibility is needed and you may use the DbcBlock approach to capture the verification logic.
 * <pre><code class="java">Require.that((Integer it) -> it >= 0).isTrueOf(someParam);</code></pre>
 *
 * @author Trevor
 */

public interface NullChecks<T>
{
	T isNull();

	T isNotNull();
}
