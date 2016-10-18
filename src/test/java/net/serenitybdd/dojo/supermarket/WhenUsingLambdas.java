package net.serenitybdd.dojo.supermarket;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingLambdas {

   @Test
    public void should_be_able_sort_lists() {
       List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

       Collections.sort(names, (a, b) -> a.compareTo(b));

       assertThat(names).containsExactly("anna", "mike", "peter", "xenia");
    }

    @Test
    public void method_and_constructor_references() throws Exception {

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        assertThat(converted).isEqualTo(123);

    }

    @Test
    public void reference_object_methods() throws Exception {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        assertThat(converted).isEqualTo("J");

    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}
