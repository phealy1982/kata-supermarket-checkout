package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 03/10/2016.
 */
public class ProductTest {

    @Test
    public void should_have_a_name_a_barcode_and_a_price() throws Exception {

        Product aProduct = Product.withName("1kg of Rice").andBarcode(new Barcode("123")).andWithPrice(2.45);

        assertThat(aProduct.name()).isEqualTo("1kg of Rice");
        assertThat(aProduct.price()).isEqualTo(2.45);
        assertThat(aProduct.barcode().value()).isEqualTo("123");

    }
}