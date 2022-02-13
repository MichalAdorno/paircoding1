package org.michalzalewski;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PairCodingExercisesTest {

    @ParameterizedTest(name = "{index}: Test some task with params {0} and {1}")
    @MethodSource("provideTestArguments1")
    void task_shouldAlwaysReturnTrue(String input1, String input2, boolean expected) {
        assertThat(PairCodingExercises.validateIfAnagrams(input1, input2)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestArguments1() {
        return Stream.of(
                Arguments.of("ABCD", "DABC", true),
                Arguments.of("AABB", "BBAA", true),
                Arguments.of("AAAB", "AABC", false),
                Arguments.of("ACBA", "ABBC", false),
                Arguments.of("A", "A", true),
                Arguments.of("A", "B", false),
                Arguments.of("A", "BC", false),
                Arguments.of("", "BC", false),
                Arguments.of("X", "", false),
                Arguments.of(null, "ZXC", false),
                Arguments.of("ZXC", null,  false),
                Arguments.of(null, null,  true)

        );
    }

    @ParameterizedTest(name = "{index}: Test some task2 with params {0} and {1}")
    @MethodSource("provideTestParenthesisExpressionArguments")
    void task_shouldCheckParenthesisValidator(String expression, boolean expected) {
        assertThat(PairCodingExercises.validateParentheses(expression)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestParenthesisExpressionArguments() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of(")(", false),
                Arguments.of("([)]", false),
                Arguments.of("{[]}", true),
                Arguments.of(")", false),
                Arguments.of("(", false),
                Arguments.of("[", false),
                Arguments.of("]", false),
                Arguments.of("{", false),
                Arguments.of("}", false),
                Arguments.of("([]", false),
                Arguments.of("(((((((((())))))))))", true),
                Arguments.of("", true),
                Arguments.of(null, true),
                Arguments.of("()]]", false)

        );
    }
}
