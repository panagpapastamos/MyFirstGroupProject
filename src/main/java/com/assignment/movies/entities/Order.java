package com.assignment.movies.entities;

import java.util.Objects;

public class Order {

    //this class is not related to a table of the db but it is necessary for the paypall payment to work so we
    //created it to make the payments
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;

    public Order() {
    }

    public Order(double price, String currency, String method, String intent, String description) {
        this.price = price;
        this.currency = currency;
        this.method = method;
        this.intent = intent;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.currency);
        hash = 67 * hash + Objects.hashCode(this.method);
        hash = 67 * hash + Objects.hashCode(this.intent);
        hash = 67 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        if (!Objects.equals(this.method, other.method)) {
            return false;
        }
        if (!Objects.equals(this.intent, other.intent)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
}
