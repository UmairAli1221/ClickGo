package com.example.gh.clickgo;

/**
 * Created by GH on 4/4/2017.
 */

public class EmptyItem extends AbstractItem {
    public EmptyItem(String label) {
        super(label);
}
    @Override
    public int getType() {
        return TYPE_EMPTY;
    }

}
