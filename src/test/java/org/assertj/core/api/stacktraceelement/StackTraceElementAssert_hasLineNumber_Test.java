/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2022 the original author or authors.
 */
package org.assertj.core.api.stacktraceelement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.error.ShouldNotBeNull.shouldNotBeNull;
import static org.assertj.core.error.stacktraceelement.ShouldHaveLineNumber.shouldHaveLineNumber;

import org.assertj.core.api.AbstractStackTraceElementAssert;
import org.assertj.core.api.StackTraceElementAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link StackTraceElementAssert#hasLineNumber(int)}
 *
 * @author Ashley Scopes
 */
class StackTraceElementAssert_hasLineNumber_Test {

  @Test
  void should_fail_if_actual_is_null() {
    // Given
    AbstractStackTraceElementAssert<?> assertion = assertThat((StackTraceElement) null);
    // Then
    assertThatThrownBy(() -> assertion.hasLineNumber(4212))
      .isInstanceOf(AssertionError.class)
      .hasMessage(shouldNotBeNull().create());
  }

  @Test
  void should_succeed_if_expected_matches_actual() {
    // Given
    StackTraceElement stackTraceElement = someStackTraceElement();
    AbstractStackTraceElementAssert<?> assertion = assertThat(stackTraceElement);
    // Then
    assertion.hasLineNumber(492);
  }

  @Test
  void should_fail_if_expected_does_not_match_actual() {
    // Given
    StackTraceElement stackTraceElement = someStackTraceElement();
    AbstractStackTraceElementAssert<?> assertion = assertThat(stackTraceElement);
    // Then
    assertThatThrownBy(() -> assertion.hasLineNumber(123))
      .isInstanceOf(AssertionError.class)
      .hasMessage(shouldHaveLineNumber(stackTraceElement, 123).create());
  }

  static StackTraceElement someStackTraceElement() {
    return new StackTraceElement(
      "org.assertj.core.example.ExampleClass",
      "exampleMethod",
      "ExampleClass.java",
      492
    );
  }
}
