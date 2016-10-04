package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 03/10/2016.
 */
public class ProductTest {

    @Test
    public void should_have_a_name_and_a_barcode() throws Exception {

        Product aProduct = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));

        assertThat(aProduct.name()).isEqualTo("1kg of Rice");
        assertThat(aProduct.barcode().value()).isEqualTo("123");

    }
}