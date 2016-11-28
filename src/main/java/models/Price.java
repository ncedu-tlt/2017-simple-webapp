package models;

import java.math.BigDecimal;


public class Price {
    private long marketId;
    private long productId;
    private BigDecimal price;

    public Price() {
    }

    public Price(long marketId, long productId, BigDecimal price) {
        this.marketId = marketId;
        this.productId = productId;
        this.price = price;
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "price{" +
                "marketId=" + marketId +
                ", productId=" + productId +
                ", price=" + price +
                '}';
    }
}
