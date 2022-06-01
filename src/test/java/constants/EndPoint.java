package constants;

public enum EndPoint {
    // Help to store the unchanged value
    STORE("/store"),
    CHECKOUT("/checkout"),
    ADD_TO_CART("/?wc-ajax=add_to_cart");

    public final String url;

    EndPoint(String url){
        this.url= url;
    }


}
