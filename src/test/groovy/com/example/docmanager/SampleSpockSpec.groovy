package com.example.docmanager

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Spock Frameworkのサンプルテスト
 *
 * Spockの主な機能を示すサンプルSpecificationクラス
 */
class SampleSpockSpec extends Specification {

    def "simple assertion test"() {
        expect: "2 + 2 should equal 4"
        2 + 2 == 4
    }

    def "test with given-when-then blocks"() {
        given: "a list with some elements"
        def list = [1, 2, 3]

        when: "we add a new element"
        list.add(4)

        then: "the list should contain 4 elements"
        list.size() == 4
        list.contains(4)
    }

    @Unroll
    def "test parameterized: #a + #b should equal #expected"() {
        expect:
        a + b == expected

        where:
        a | b | expected
        1 | 2 | 3
        2 | 3 | 5
        5 | 5 | 10
        0 | 0 | 0
    }

    def "test exception handling"() {
        when: "we divide by zero"
        def result = 10 / 0

        then: "an ArithmeticException should be thrown"
        thrown(ArithmeticException)
    }

    def "test with setup and cleanup"() {
        setup: "initialize test data"
        def testList = []

        when: "we add elements"
        testList.addAll([1, 2, 3])

        then: "list should have 3 elements"
        testList.size() == 3

        cleanup: "clear the list"
        testList.clear()
    }
}
