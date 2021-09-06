import java.util.*;

public class Test {
    public static void main(String[] args) {

        String str = "apbizprod,ifccardcenter,ifccardcenter,ifccardcenter,ifccardcenter,ifccardcenter,ifcauthcenter,apbizprod,apbizprod,apuserdataclient,apbizprod,ifcauthcenter,apbizprod,apbizprod,apuserdataclient,apuserdataclient,apmerchantprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,ifccardcenter,ifccardcenter,ifccardcenter,apuserdataclient,apuserdataclient,apuserdataclient,ifccardcenter,apbizprod,apuserdataclient,apuserdataclient,apbizprod,apmerchantprod,apmerchantprod,apmerchantprod,apmerchantprod,apmerchantprod,apbizprod,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,ifcauthcenter,apbizprod,apbizprod,apbizprod,ifccardcenter,ifcauthcenter,apbizprod,ifcauthcenter,ifcauthcenter,ifcauthcenter,apbizprod,apmerchantprod,apbizprod,apmerchantprod,ifccardcenter,ifccardcenter,ifcauthcenter,apbizprod,ifccardcenter,ifcauthcenter,ifcauthcenter,ifcauthcenter,ifccardcenter,ifccardcenter,ifccardcenter,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcriskcloud,ifcauthcenter,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,ifcauthcenter,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,apbizprod,ifcauthcenter,ifcauthcenter,ifcauthcenter,ifcauthcenter,apbizprod,apbizprod,apbizprod,ifcauthcenter";
        List<String> ll = Arrays.asList(str.split(","));
        Set<String> ss = new HashSet<>(ll);

        for (String s : ss)
            System.out.println(s);

    }
}
