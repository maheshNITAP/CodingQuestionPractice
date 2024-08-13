import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProductsQuestion {
    public static void main(String args[]){
        ProductsQuestion pq= new ProductsQuestion();
        List<List<String>> products = new ArrayList<>();
        List<List<String>> discounts = new ArrayList<>();
        String[][] productsArray = {
                {"10", "sale", "january-sale"},
                {"200", "sale", "EMPTY"}
        };

        String[][] discountsArray = {
                {"sale", "0", "10"},
                {"january-sale", "1", "10"}
        };//O/P-19

//        String[][] productsArray = {
//                {"10", "d0", "d1"},
//                {"15", "EMPTY", "EMPTY"},
//                {"20", "d1", "EMPTY"}
//        };
//
//        String[][] discountsArray = {
//                {"d0", "1", "27"},
//                {"d1", "2", "5"}
//        };//o/p--35

        // Converting to List<List<String>>

        // Convert products array
        for (String[] row : productsArray) {
            products.add(Arrays.asList(row));
        }

        // Convert discounts array
        for (String[] row : discountsArray) {
            discounts.add(Arrays.asList(row));
        }
        System.out.println(pq.findLowestPrice(products,discounts));
    }

    private int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        HashMap<String,Pair<String ,String>> map = new HashMap<>();
        for(List<String > x:discounts){
            map.put(x.get(0),new Pair<>(x.get(1),x.get(2)));
        }
        int totalAmount=0;
        for(List<String> product:products){
            int minPrice=Integer.parseInt(product.get(0));
            for(int i=1;i<product.size();i++){
                if(product.get(i).equals("EMPTY")) continue;
                String type=map.get(product.get(i)).getKey();
                if(type.equals("0")){// same price
                    minPrice=Math.min(minPrice,Integer.parseInt(map.get(product.get(i)).getValue()));
                } else if (type.equals("1")) {//% discount
                        minPrice=Math.min(minPrice,(Integer.parseInt(product.get(0))-(Integer.parseInt(product.get(0))*Integer.parseInt(map.get(product.get(i)).getValue())/100 )));
                }else if(type.equals("2")){
                    minPrice=Math.min(minPrice,Integer.parseInt(product.get(0))-Integer.parseInt(map.get(product.get(i)).getValue()));
                }
            }
            totalAmount+=minPrice;
        }
        return totalAmount;

    }
}
