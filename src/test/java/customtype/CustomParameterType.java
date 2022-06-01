package customtype;

import io.cucumber.java.ParameterType;
import objects.Product;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name){
        return new Product(name.replace("\"", ""));
    }

}
