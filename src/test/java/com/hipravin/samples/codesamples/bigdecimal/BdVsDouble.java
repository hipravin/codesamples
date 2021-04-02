package com.hipravin.samples.codesamples.bigdecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BdVsDouble {

    @Test
    void testDouble() {
        double v = 35.0/36.0;

        System.out.println("Prob: " +  (1 - Math.pow(v, 24)));
    }

    @Test
    void testBd() {
        BigDecimal b35 = new BigDecimal(35);

        BigDecimal v3536 = b35.divide(new BigDecimal(36), 17, RoundingMode.HALF_DOWN);

        BigDecimal prob = v3536;
        for (int i = 0; i < 23; i++) {
             prob = prob.multiply(v3536);
             prob = prob.setScale(17, RoundingMode.HALF_DOWN);
        }

        prob = new BigDecimal(1).subtract(prob);
        System.out.println(prob);
        //scale 1000
        //scale 100
        //scale 10
        //double
        //0.491403876130903259582071976824847548149932454761060469621267787998774274828410662048385073856911262518163665762234583047351497401389864350648616639889914432716681160394235186126541317471602599910284748442060331331
        //0.49140387613090325958207197682484754814993245476106046962126778799877427482841066204838507385691126279716496799899622350518629868604492365125709859953674252619263745820949013739840670807179065554753495085
        //0.491403876409904561745496132135597763358529533076490800402829419076942723656740558804915624972270737481641599589356502319899407918052793440703940632998314837276235994111938303313878509024354312977719123378892364909564296251469025
        //0.4914038761309034



    }
}
