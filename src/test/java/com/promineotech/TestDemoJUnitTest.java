package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b,
			int expected, boolean expectException) {
	if(!expectException) {
		assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}else
		assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}

static Stream<Arguments> argumentsForAddPositive(){
	return Stream.of(Arguments.of(1, 2, 3, false),
			Arguments.of(2, 4, 6, false),
			Arguments.of(3, 6, 9, false),
			Arguments.of(4, -8, -4, true),
			Arguments.of(0, 5, 5, false)
		//, Arguments.of(-6, 6, 1, false)
			);
}
	@Test
	//@Disabled
	//void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
//		TestDemo mockDemo = spy(testDemo);
//		
//		doReturn(5).when(mockDemo).getRandomInt();
//		
//		assertThat(mockDemo.addPositive(4,5)).isEqualTo(9);
//		assertThat(mockDemo.addPositive(40,50)).isEqualTo(90);
//	}
//static class TestDemo {
//	int getRandomInt() {
	//	return 0;
//	}
//	int addPositive(int a, int b) {
//		return a + b;
//	}
//}			

void assertThatNumberSquaredIsCorrect () {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
}
//{ fail("Not yet implemented"); }

}
