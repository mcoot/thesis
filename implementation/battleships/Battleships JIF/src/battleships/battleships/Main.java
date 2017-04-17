package battleships;

import java.io.PrintStream;
import jif.runtime.Runtime;

/**
 * This is the Main class for the BattleShip example. 
 *
 * It plays a game of BattleShip for the prinicipals Alice and Bob.
 */
class Main {
    public static final void main(final String[] args) throws SecurityException,
        IllegalArgumentException {
        final jif.lang.Principal p = Runtime.user(null);
        {
            PrintStream out = null;
            try {
                Runtime runtime = Runtime.getRuntime(p);
                out =
                  runtime ==
                    null
                    ? null
                    : runtime.stdout(
                                jif.lang.LabelUtil.singleton().noComponents());
            }
            catch (final SecurityException e) {  }
            PrintStream out1 = out;
            PrintStream out2 = out1;
            new BattleShip(jif.principals.Alice.getInstance(),
                           jif.principals.Bob.getInstance()).
              battleships$BattleShip$().play(out2);
        }
    }
    
    public Main battleships$Main$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1492411769607L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1ae3QU13m/uxISkniKlzCvRQiweEi8IQgbixUCiQWpEsS1" +
       "olgezd6VBmZnxjOzYoGSYKcG19i4weDYISb2Kc6xU4rdJG5ySnBtnzjgOE1q" +
       "J6lJWj8O/SNOHVzbdUp9Yux+3713njsCcY5TnaM7s3fu43v+vu9+MycvkmGW" +
       "SaZtVzJ19i6DWnWtSqZdMi2abtfVXVuhq0f+6LGfph+6xXgzTkq6yHDF2qZZ" +
       "UoamSJmUs/t1U7F32WRMars0INXnbEWtTymW3ZAiFbKuWbYpKZpt3U6+RGIp" +
       "MkaBHkmzFcmm6WZTz9pkZsqAjfpU3a6nebvekEwpW89IqW9PqpJlwUolrNdZ" +
       "ZLhh6gNKmpo2mZECwsVoVeqlan27eJbCXw15kySc5QV/nDm2Mufu6Pz6I1+7" +
       "dcx3isjoLjJa0TptyVbkpK7ZQE8XGZGl2V5qWo3pNE13kbEapelOaiqSquyG" +
       "gbrWRSotpU+T7JxJrQ5q6eoADqy0cgaQiHs6nSkygoskJ9u66bBTklGomnZ+" +
       "DcuoUp9lk4meWDh7zdgPsigHcVIzI8nUmVK8Q9HSKIvQDJfHmk0wAKaWZino" +
       "y92qWJOgg1RyzamS1lffaZuK1gdDh+k5GwV83aCLNqAiJHmH1Ed7bFIVHtfO" +
       "H8GoMiYInGKTCeFhbCXQ0nUhLfn0c3HLmkN7tI1anNGcprKK9A+HSdNDkzpo" +
       "hppUkymfOGJe6kFp4pm744TA4AmhwXzM9//i/ZsWTH/uHB8zJWJMW+92Kts9" +
       "8oneUa9MTdZ+roiboG4pqPwA58z428WThrwBjjXRXREf1jkPn+v48S37vk3f" +
       "iZPyFlIi62ouC3Y0VtazhqJScwPVqIku0kLKqJZOsuctpBTuU4pGeW9bJmNR" +
       "u4UUq6yrRGe/QUQZWAJFVAr3ipbRnXtDsvvZfd4g4q8c/ivg/01x/ZVNaNPq" +
       "7m0WNZthFau7SZdzWQoO3L1NU7rtfmopVreSNVSKvcz+u3sl24ax/Yphda/z" +
       "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" +
       "SI2x+tOY/wN+1G6OzCsAAA==");
    
    public Main() { super(); }
    
    public void jif$invokeDefConstructor() { this.battleships$Main$(); }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1492411769607L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM16Wczr2HmY7vXsXmbGiZd4vR5fux5zfCku4uKpi4oSJYqb" +
       "KFGkRHqSCXdS4r6TiQsnaGO3AdwiHacp0PjJBdJg6gAFgjwUAfLSNkGCAg26" +
       "A62DokBbuAaahzYvbVNK/733v/e/4+lTigrQ4dE53/nOd75d/M7bPxw9XeSj" +
       "O2kSdl6YlPfKLnWKe5KRF449C42i2A0Db1rfBsC3/tZPvfQP3jN6UR+9GMRy" +
       "aZSBNUvi0mlLffS+yIlMJy+mtu3Y+ujl2HFs2ckDIwz6ATCJ9dEHi8CLjbLK" +
       "nWLrFElYnwE/WFSpk1/2fDDIj95nJXFR5pVVJnlRjl7ij0ZtgFUZhCAfFOXr" +
       "/OgZN3BCu8hGf2l0ix897YaGNwB+mH9wCvCCEVycxwfwF4KBzNw1LOfBkqdO" +
       "QWyXo0/fXPHwxHe5AWBY+mzklH7ycKunYmMYGH3wiqTQiD1QLvMg9gbQp5Nq" +
       "2KUcfexHIh2AnksN62R4zpvl6KM34aSrqQHq+QtbzkvK0Ydugl0wtfnoYzdk" +
       "9oi0fij++W/9TMzEty80244Vnul/elj0qRuLto7r5E5sOVcL3/dF/peND//2" +
       "N2+PRgPwh24AX8H81s/+8V987VO/87tXMB9/B5i1eXSs8k3ru+YH/tknZq+S" +
       "7zmT8VyaFMFZFR47+UWq0v2Z19t00MUPP8R4nrz3YPJ3tv9Y+/qvOz+4PXph" +
       "NXrGSsIqGrTqZSuJ0iB08qUTO7lROvZq9LwT27PL/Gr07NDng9i5Gl27buGU" +
       "q9FT4WXomeTye2CRO6A4s+ipoR/EbvKgnxqlf+m36ej+54Xh+97h+/37z39R" +
       "jpz5l99QCidfDFiKN+aJVUVOXBZvKHHwRuk7RVC8EURp6JxHL9bwhmmU5QDr" +
       "B2nxBnXdv8OuFm8UufXYvGAE8b1j4Kb/rzZqzyd+f3Pr1iCMT9x0DOFgRUwS" +
       "2k7+pvVWRdF//L03f//2Q9O4z6vBaB9BfO+MeHTr1gXhj58t50qyg1xOg70P" +
       "Jv2+V+WfZH/6m6+8Z1CptHlq4OoZ9O5NBb92C6uhZwxa+6b14jf+8//4jV/+" +
       "WnKt6uXo7hMW+OTKswW9cvNweWI59uChrtF/8Y7xm2/+9tfu3j6rw/ODYyqH" +
       "s5yt/FM393jMkl5/4JXODLnNj97rJnlkhOepB67khdLPk+Z65ML19176H/jT" +
       "4XNr+P7v8/esdOeB83NwPbP7Cn/nocaXo1r6D7/wS1/+M1WOQfCdk5/V48sQ" +
       "SrwGo1+CifRKU85SvcHJi+f9ipz+6r/+p/8FuX3mwAMn/eIj3lx2ytcfcQxn" +
       "ZO+7uICXr5VklzvOAPfvfkX6m9/+4Te+etGQAeKz77Th3XN75o8x8CXJ/8rv" +
       "Zv/m+//+u//89rVWlaNn0soMA+tC+ScGRJ+/3mrwGeHgtwZKirtKHCV24AaG" +
       "GTpnDf2fL34O+s3/+q2XrtQsHEauhJaPXvu/I7ge/wlq9PXf/6k/+dQFzS3r" +
       "HLOu2XENduUIf+wa8zTPje5MR/tzf/jJv/1PjF8dXOrgxoqgd6480+V4o8up" +
       "Xrvo0J+7tMCNuXvn5uPtZe5Dl/H3FE8GhcU5ul7bgA6+/Xc+NvsLP7gQfW0D" +
       "Zxwfa590EarxiHnCvx7999uvPPOPbo+e1UcvXQK7EZeqEVZnqepDaC5m9wf5" +
       "0fsfm388zF7FlNcf2vgnbtrfI9vetL5r1zT0z9Dn/rNXBnfRg/bWoBlPI/cm" +
       "98bn3+hl4acv7Svn5nNXrDp3Pz+oUHFJfoYVbhAb4ZUqlaOPHEPr7gPrVIdk" +
       "aBDk3cFeLmg+OLjEizjPh7l3lTNcGc+5HT+gYhDGB67B+GRILH7xP/6NP/jr" +
       "n/3+wHx29HR9ZszA80dwidU58/qFt7/9yfe+9Ue/eNH1QdG/2r9tPXvG+pVz" +
       "gw1ZyZk6Oalyy+GNohQuyunYFwKf1AApD6LBJuv7aYHzzbf+2p/e+9Zbtx/J" +
       "nT77RPry6Jqr/OnCmheuDjfs8pl32+WyYvGffuNr//DXvvaNq9zig49nAnRc" +
       "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" +
       "kZKMY1V5UHZ0aznppYR3H+aVa5hVGDqe");
    public static final String jlc$ClassType$jl$1 =
      ("EU5z71JafQh62eqnz41Sjp6KjOBqMXW/8HF+0MNEnQRXh5IfHueV0f3mfJPg" +
       "Tx48n5DnufnMu5T1wneZu5RVg8GeHqnm3j1X5O9eq8o1Qc+e133+LNz71x1u" +
       "XZWd/+2TZec7X0j/zKvOVGLk9lXReUy8BmNfQsavfvlOVhlFkFVJ6Xzhqpp7" +
       "58zaOwPY3SCuk5Mzd9xHSv5fePXOz5R+UNx7ggNfePX1r72apo8azbn57EN2" +
       "XD7P3GTHeTZP03dhev0uc5cmLUcf/VH0nufdG3J57rz85Sfl8lv/v8olD+qB" +
       "mEcFE5RnQdz56k/Kd24y/aanulWOnr2PoX1cFs++kyx+9l1l8fPvMveXz01f" +
       "jp57QOKF9+1grGf9OBfhP/rEzbir+1vW977z4nMf+Y7yr67c24M7Vs/wo+fc" +
       "KgwfrTg/0n8mzR03uGz9zFX9+YoP3yxH732Ev+ehv5q+Q+H4qgre/h9ytRJe" +
       "ticAAA==");
}
