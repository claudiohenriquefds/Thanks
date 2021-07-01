package com.dm.thanks.Model;

public class Solicitation {
    private String title;
    private String sub_title;
    private String description;
    private String objective;
    private String reached;
    private Integer payment_method_id;

    public Solicitation(String title, String sub_title, String description, String objective, String reached, Integer payment_method_id) {
        this.title = title;
        this.sub_title = sub_title;
        this.description = description;
        this.objective = objective;
        this.reached = reached;
        this.payment_method_id = payment_method_id;
    }

    public String getTitle() {
        return title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public String getDescription() {
        return description;
    }

    public String getObjective() {
        return objective;
    }

    public String getReached() {
        return reached;
    }

    public Integer getPayment_method_id() {
        return payment_method_id;
    }
}
