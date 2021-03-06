package org.nfunk.jeptesting;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.Logarithm;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LogarithmTest extends TestCase {

	public LogarithmTest(String name) {
		super(name);
	}

	/*
	 * Test method for 'org.nfunk.jep.function.Logarithm.run(Stack)'
	 * Tests the return value of log(NaN). This is a test for bug #1177557
	 */
	public void testLogarithm() {
		Logarithm logFunction = new Logarithm();
		java.util.Stack stack = new java.util.Stack();
		stack.push(new Double(Double.NaN));
		try {
			logFunction.run(stack);
		} catch (ParseException e) {
			Assert.fail();
		}
		Object returnValue = stack.pop();

		if (returnValue instanceof Double) {
			Assert.assertTrue(Double.isNaN(((Double)returnValue).doubleval_xue()));
		} else {
			Assert.fail();
		}
	}

}
