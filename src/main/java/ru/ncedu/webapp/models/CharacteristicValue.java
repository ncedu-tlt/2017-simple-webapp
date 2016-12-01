package ru.ncedu.webapp.models;

/**
 * Created by Alexander on 01.12.2016.
 */
public class CharacteristicValue {
    private int characteristicId;
    private int productId;
    private String value;

    public CharacteristicValue(int characteristicId, int productId, String value) {
        this.characteristicId = characteristicId;
        this.productId = productId;
        this.value = value;
    }

    public CharacteristicValue() {
    }

    public int getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(int characteristicId) {
        this.characteristicId = characteristicId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
