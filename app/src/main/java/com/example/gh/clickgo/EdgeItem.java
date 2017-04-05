package com.example.gh.clickgo;

/**
 * Created by GH on 4/4/2017.
 */

public class EdgeItem extends AbstractItem {
    public EdgeItem(String label) {
        super(label);
    }
    @Override
    public int getType() {
        return TYPE_EDGE;
    }
}
