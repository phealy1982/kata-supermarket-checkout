package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 66515 on 03/10/2016.
 */
public class DummyCatalogTest {

    @Test
    public void should_be_able_to_retrieve_product_details_by_name() throws Exception {

        Product product = SupermarketCatalog.productWithName("1kg of Rice");

        assertThat(product.name()).isEqualTo("1kg of Rice");
    }
}