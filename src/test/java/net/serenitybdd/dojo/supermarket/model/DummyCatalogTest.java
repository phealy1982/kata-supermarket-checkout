package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 66515 on 03/10/2016.
 */
public class DummyCatalogTest {



    @Test public void should_be_able_to_add_a_product() throws Exception {
        DummyCatalog dummyCatalog  = new DummyCatalog();
        Product riceProduct = Product.withName("1kg of Rice").andWithPrice(2.45);
        dummyCatalog.add(riceProduct);

        assertThat(dummyCatalog.productList()).contains(riceProduct);

    }

    @Test
    public void should_be_able_to_retrieve_product_details_by_name() throws Exception {
        DummyCatalog dummyCatalog  = new DummyCatalog();
        Product riceProduct = Product.withName("1kg of Rice").andWithPrice(2.45);
        dummyCatalog.add(riceProduct);

        assertThat(dummyCatalog.productWithName("1kg of Rice").name()).isEqualTo("1kg of Rice");
    }
}
