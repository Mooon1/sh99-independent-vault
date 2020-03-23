package de.sh99.vaultx.serializer;

public class MoneySerializer
{
    public static String serialize(double money)
    {
//        String moneyStr = ((int) money) + "";
//
//        if(moneyStr.length() >= 3){
//
//            //100000,00
//            String str = Math.round((money)*100.0)/100.0 + "";
//
//            //100000
//            String intMoneyStr = str.substring(0, str.length()-3);
//            int moneyStrPartials = intMoneyStr.length() / 3;
//
//            String realMoneyStr = "";
//
//            int strCount = 0;
//
//            //6
//            for(int i = 0;i < moneyStrPartials;++i){
//                realMoneyStr += intMoneyStr.substring(strCount, strCount+2) + ".";
//            }
//
//            realMoneyStr = realMoneyStr.substring(0, realMoneyStr.length()-1);
//
//            realMoneyStr += str.substring(str.length()-2, str.length());
//            return realMoneyStr;
//        }

        if(money >= 1000000){
            return Math.round((money/1000000)*100.0)/100.0 + " Mio.";
        }

        if(money >= 1000000000){
            return Math.round((money/1000000000)*100.0)/100.0 + " Mrd.";
        }

        return "" + money;
    }
}
