package com.personal.scripts.gen.eval_expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import com.utils.test.TestInputUtils;

class AppStartEvalExprTest {

	@Test
	void testMain() {

		final String[] args;
		final int input = TestInputUtils.parseTestInputNumber("1");
		if (input == 1) {
			args = new String[] { "12 + 3" };

		} else if (input == 21) {
			args = new String[] { "sqrt(25)" };

		} else if (input == 101) {
			args = new String[] { "some random text" };

		} else if (input == 1_001) {
			args = new String[] {};

		} else {
			throw new RuntimeException();
		}

		AppStartEvalExpr.main(args);
	}

	@TestFactory
	List<DynamicTest> testComputeOutput() {

		final List<DynamicTest> dynamicTestList = new ArrayList<>();
		final List<Integer> testCaseList = Arrays.asList(0, 1, 2, 3, 4, 5,
				11, 21, 22, 31, 32, 41, 42, 43, 44, 45, 46, 47, 48, 51, 52, 61, 62, 63, 64, 71, 72, 101);

		if (testCaseList.contains(1)) {
			dynamicTestList.add(DynamicTest.dynamicTest("1",
					() -> testComputeOutputCommon("12 + 3", "15")));
		}
		if (testCaseList.contains(2)) {
			dynamicTestList.add(DynamicTest.dynamicTest("2",
					() -> testComputeOutputCommon("14 - 5", "9")));
		}
		if (testCaseList.contains(3)) {
			dynamicTestList.add(DynamicTest.dynamicTest("3",
					() -> testComputeOutputCommon("5 * 7", "35")));
		}
		if (testCaseList.contains(4)) {
			dynamicTestList.add(DynamicTest.dynamicTest("4",
					() -> testComputeOutputCommon("30 / 5", "6")));
		}
		if (testCaseList.contains(5)) {
			dynamicTestList.add(DynamicTest.dynamicTest("5",
					() -> testComputeOutputCommon("4 / 3", "1.3333333333333333")));
		}

		if (testCaseList.contains(11)) {
			dynamicTestList.add(DynamicTest.dynamicTest("11",
					() -> testComputeOutputCommon("1 + 2 + 3 + 4", "10")));
		}

		if (testCaseList.contains(21)) {
			dynamicTestList.add(DynamicTest.dynamicTest("12",
					() -> testComputeOutputCommon("3 + 4 * 2", "11")));
		}
		if (testCaseList.contains(22)) {
			dynamicTestList.add(DynamicTest.dynamicTest("13",
					() -> testComputeOutputCommon("4 + 12 / 3", "8")));
		}

		if (testCaseList.contains(31)) {
			dynamicTestList.add(DynamicTest.dynamicTest("31",
					() -> testComputeOutputCommon("(3 + 4) * (1 + 2)", "21")));
		}
		if (testCaseList.contains(32)) {
			dynamicTestList.add(DynamicTest.dynamicTest("13",
					() -> testComputeOutputCommon("(8 + 4) / 3", "4")));
		}

		if (testCaseList.contains(41)) {
			dynamicTestList.add(DynamicTest.dynamicTest("41 (power)",
					() -> testComputeOutputCommon("pow(2, 3)", "8")));
		}
		if (testCaseList.contains(42)) {
			dynamicTestList.add(DynamicTest.dynamicTest("42 (power)",
					() -> testComputeOutputCommon("pow(3, 4)", "81")));
		}
		if (testCaseList.contains(43)) {
			dynamicTestList.add(DynamicTest.dynamicTest("43 (root of order n)",
					() -> testComputeOutputCommon("pow(27, 1 / 3)", "3")));
		}
		if (testCaseList.contains(44)) {
			dynamicTestList.add(DynamicTest.dynamicTest("44 (sqrt)",
					() -> testComputeOutputCommon("sqrt(25)", "5")));
		}
		if (testCaseList.contains(45)) {
			dynamicTestList.add(DynamicTest.dynamicTest("45 (ln)",
					() -> testComputeOutputCommon("ln(21)", "3.044522437723423")));
		}
		if (testCaseList.contains(46)) {
			dynamicTestList.add(DynamicTest.dynamicTest("46 (lg)",
					() -> testComputeOutputCommon("lg(100)", "2.0")));
		}
		if (testCaseList.contains(47)) {
			dynamicTestList.add(DynamicTest.dynamicTest("47 (log)",
					() -> testComputeOutputCommon("log(2, 8)", "3.0")));
		}
		if (testCaseList.contains(48)) {
			dynamicTestList.add(DynamicTest.dynamicTest("48 (log)",
					() -> testComputeOutputCommon("log(3, 81)", "4.0")));
		}

		if (testCaseList.contains(51)) {
			dynamicTestList.add(DynamicTest.dynamicTest("51 (composite with pow)",
					() -> testComputeOutputCommon("(pow(6, 2) + pow(8, 2)) * 2", "200.0")));
		}
		if (testCaseList.contains(52)) {
			dynamicTestList.add(DynamicTest.dynamicTest("52 (composite with sqrt)",
					() -> testComputeOutputCommon("sqrt(25) + 3 + sqrt(16)", "12.0")));
		}

		if (testCaseList.contains(61)) {
			dynamicTestList.add(DynamicTest.dynamicTest("61 (hex to dec)",
					() -> testComputeOutputCommon("0x12 + 0", "18")));
		}
		if (testCaseList.contains(62)) {
			dynamicTestList.add(DynamicTest.dynamicTest("62 (hex to dec)",
					() -> testComputeOutputCommon("dec('0xcafe')", "51966")));
		}
		if (testCaseList.contains(63)) {
			dynamicTestList.add(DynamicTest.dynamicTest("63 (dec to hex)",
					() -> testComputeOutputCommon("hex(12)", "0xc")));
		}
		if (testCaseList.contains(64)) {
			dynamicTestList.add(DynamicTest.dynamicTest("64 (dec to hex)",
					() -> testComputeOutputCommon("hex(51966)", "0xcafe")));
		}

		if (testCaseList.contains(71)) {
			dynamicTestList.add(DynamicTest.dynamicTest("71 (bin to dec)",
					() -> testComputeOutputCommon("dec('0b1010')", "10")));
		}
		if (testCaseList.contains(72)) {
			dynamicTestList.add(DynamicTest.dynamicTest("72 (dec to bin)",
					() -> testComputeOutputCommon("bin(10)", "0b1010")));
		}

		if (testCaseList.contains(101)) {
			dynamicTestList.add(DynamicTest.dynamicTest("101 (random text)",
					() -> testComputeOutputCommon("some random text", null)));
		}

		return dynamicTestList;
	}

	private static void testComputeOutputCommon(
			final String formula,
			final String expectedOutput) {

		final String output = AppStartEvalExpr.computeOutput(formula);
		Assertions.assertEquals(expectedOutput, output);
	}
}
