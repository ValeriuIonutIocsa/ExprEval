package com.personal.scripts.gen.eval_expr;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

import javax.script.ScriptEngine;

import com.utils.js.ScriptUtils;

final class AppStartEvalExpr {

	private static final ScriptEngine SCRIPT_ENGINE = ScriptUtils.createScriptEngine();

	private static String functions;

	private AppStartEvalExpr() {
	}

	public static void main(
			final String[] args) {

		String output = null;
		if (args.length >= 1) {

			final String formula = args[0];
			output = computeOutput(formula);
		}
		if (output == null) {
			output = "?";
		}
		System.out.print(output);
	}

	static String computeOutput(
			final String formula) {

		String output = null;
		try {
			if (functions == null) {
				functions = new Scanner(Objects.requireNonNull(
						Thread.currentThread().getContextClassLoader()
								.getResourceAsStream("com/personal/scripts/gen/eval_expr/functions.js")),
						StandardCharsets.UTF_8).useDelimiter("\\A").next();
			}
			final String processedFormula = functions + formula;
			final Object outputObj = SCRIPT_ENGINE.eval(processedFormula);
			if (outputObj != null) {
				output = outputObj.toString();
			}

		} catch (final Exception ignored) {
		}
		return output;
	}
}
