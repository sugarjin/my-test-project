package com.charter.test;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class Test {

    @org.junit.Test
    public void test() {
        TestObject obj1 = new TestObject(new TestField("test"), null);

        Optional<TestField> optionalField = Optional.ofNullable(obj1.getField2());

        assertThat(optionalField.get(), is(nullValue()));

    }

    private class TestObject {
        private TestField field1;
        private TestField field2;

        public TestObject(TestField field1, TestField field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public TestField getField1() {
            return field1;
        }

        public TestField getField2() {
            return field2;
        }
    }

    private class TestField {
        private String subField;

        public TestField(String subField) {
            this.subField = subField;
        }

        public String getSubField() {
            return subField;
        }
    }

}