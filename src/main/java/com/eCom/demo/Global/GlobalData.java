package com.eCom.demo.Global;

import com.eCom.demo.Model.Products;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Products> cart;

    static {
        cart = new ArrayList<>();
    }
}
