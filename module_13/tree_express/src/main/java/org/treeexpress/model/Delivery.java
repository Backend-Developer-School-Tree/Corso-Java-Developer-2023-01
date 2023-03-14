package org.treeexpress.model;

import java.util.Objects;

public class Delivery {

    private long id;
    private double weight;
    private DeliveryType deliveryType;
    private TreeExpressUser sender, receiver;

    public Delivery(){}

    public Delivery(long id, double weight, DeliveryType deliveryType, TreeExpressUser sender, TreeExpressUser receiver) {
        this.id = id;
        this.weight = weight;
        this.deliveryType = deliveryType;
        this.sender = sender;
        this.receiver = receiver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public TreeExpressUser getSender() {
        return sender;
    }

    public void setSender(TreeExpressUser sender) {
        this.sender = sender;
    }

    public TreeExpressUser getReceiver() {
        return receiver;
    }

    public void setReceiver(TreeExpressUser receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Delivery delivery = (Delivery) o;
        return id == delivery.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", weight=" + weight +
                ", deliveryType=" + deliveryType +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}
