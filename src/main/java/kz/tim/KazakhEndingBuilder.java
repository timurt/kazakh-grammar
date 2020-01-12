package kz.tim;

import kz.tim.enums.Declension;
import kz.tim.enums.Form;
import kz.tim.enums.Layout;
import kz.tim.enums.Quantity;

public class KazakhEndingBuilder {
    private String text;
    private Quantity quantitative;
    private Declension declensional;
    private Form possessive;
    private Form personal;
    private Layout layout;

    public KazakhEndingBuilder(String text) {
        this.text = text;
    }

    public KazakhEndingBuilder() {

    }

    public KazakhEndingBuilder text(String text) {
        this.text = text;
        return this;
    }

    public KazakhEndingBuilder quantitative(Quantity quantitative) {
        this.quantitative = quantitative;
        return this;
    }

    public KazakhEndingBuilder declensional(Declension declensional) {
        this.declensional = declensional;
        return this;
    }

    public KazakhEndingBuilder possessive(Form possessive, Quantity quantitative) {
        this.possessive = possessive;
        return this;
    }

    public KazakhEndingBuilder personal(Form personal) {
        this.personal = personal;
        return this;
    }

    public KazakhEndingBuilder layout(Layout layout) {
        this.layout = layout;
        return this;
    }

    public String get() {
        return text;
    }
}
