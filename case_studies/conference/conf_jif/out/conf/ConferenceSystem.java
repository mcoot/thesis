package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers
 to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() {
        this.jif$init();
        {
            this.organiser = new Organiser().conf$Organiser$("TheOrganiser");
            this.submissions = (new Paper[5]);
            this.numSubmissions = 0;
            this.allocations =
              new HashMap(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg()),
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg())).
                jif$util$HashMap$();
        }
        return this;
    }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under
     the double-blind conditions
     */
    public void handleSubmission(final Paper paper) {
        try {
            if (!this.allocationsVisible) {
                this.submissions[this.numSubmissions] = paper;
                this.numSubmissions++;
                if (this.numSubmissions >= this.submissions.length) {
                    Paper[] newSubmissions = new Paper[this.numSubmissions * 2];
                    for (int i = 0; i < this.submissions.length; ++i) {
                        newSubmissions[i] = this.submissions[i];
                    }
                    this.submissions = newSubmissions;
                }
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NegativeArraySizeException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public Paper[] getSubmissions() {
        try { return (Paper[]) this.submissions.clone(); }
        catch (final NullPointerException ex) { return new Paper[2]; }
    }
    
    public int getSessionNumber(final Paper paper) {
        if (this.allocationsVisible) { return -1; } else { return -1; }
    }
    
    private int declassifySessionNumber(final Paper paper) {
        jif.lang.JifObject sNoObj;
        try {
            sNoObj =
              this.allocations.
                get(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()), paper);
        }
        catch (final NullPointerException e) { return -1; }
        jif.lang.JifObject sNoObjDeclass = sNoObj;
        jif.lang.JifInteger sNo;
        try {
            sNo =
              jif.lang.JifInteger.
                jif$cast$jif_lang_JifInteger(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()),
                  sNoObjDeclass);
        }
        catch (final ClassCastException ex) { return -1; }
        int r;
        try { r = sNo.intValue(); }
        catch (final NullPointerException ex) { return -1; }
        int result = r;
        return result;
    }
    
    public void performAllocations() {
        try {
            for (int i = 0; i < this.numSubmissions; ++i) {
                this.allocations.
                  put(
                    this.submissions[i],
                    new jif.lang.JifInteger(
                      jif.lang.LabelUtil.
                          singleton().
                          toLabel(
                            jif.lang.LabelUtil.
                                singleton().
                                readerPolicy(
                                  this.jif$conf_ConferenceSystem_O,
                                  jif.lang.PrincipalUtil.topPrincipal()),
                            jif.lang.LabelUtil.singleton().topInteg())).
                        jif$lang$JifInteger$(i));
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501366858220L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1cCXxURZqv7oSEEI5wBMLdhHBroogCRkdCAAEDiQRQDg0v" +
       "3S/Jk06/Tr/XIYA46qg4HqwioA7H6g54DYi6MDoKoq4KHniNBzqjODq7ywzj" +
       "jLoe4+46bn1f1bvqVT8adnbz+6Xqdb36vqr6vv/31VdH987PSCcjRQZfoTWV" +
       "myuTqlE+W2uqU1KGGqvT4yvn06KG6Hf3vhq7a1HyaJjkLSadNWNBwlCa1BpS" +
       "oKTNFj2lmStNUlRzhdKuVKRNLV5RoxlmZQ0pjOoJw0wpWsI02shVJFRDijRa" +
       "oiRMTTHV2IyU3mqSYTVJ2lBzXDcr1A6zIqmklNYK7EpFXXVcMQzKKQ9LLSad" +
       "kym9XYupKZMMraEd57XjSqMar6jj72rgU2VHikQs9nx8bHDImY1u47iKDXde" +
       "XvRYDumxmPTQEvWmYmrRaj1h0v4sJl1b1dZGNWVUxWJqbDHpmVDVWL2a0pS4" +
       "topW1BOLSS9Da04oZjqlGvNUQ4+3Q8VeRjpJuwhtWoU1pCsTSTpq6ilrOHlN" +
       "mhqPWZ86NcWVZsMkfR2xsOHNgHIqiy5UnGqqSYmqFknuci0RA1kIFPYYyy6i" +
       "FShpfqtK9WU3lZtQaAHpxTQXVxLNFfVmSks006qd9LQJAh6QkWklKEKJLlea" +
       "1QaTlIj16tgrWqsABQEkJikWqyEnqqUBgpZc+vls7nnrVidmJsLY55gajUP/" +
       "O1OiIQLRPLVJTamJqMoIu46t2aT03X9jmBBauViozOo8fuUXU04b8swhVmeg" +
       "pE5t4xVq1GyIbm/s/uag6jGTcxgEdUMD5XtGjuCv428qO5LUsPraHOFlufXy" +
       "mXkvLrr6IfV4mHSZRfKiejzdSnHUM6q3JrW4mrpQTagpMJFZpEBNxKrx/SyS" +
       "T59rtITKSmubmgzVnEVy41iUp+NnKqImygJElE+ftUSTbj0nFbMFnzuShJB8" +
       "+k8G0//O9P9hnt9lkmXTz126wFBTMygXY+k0PZpuVakBL12Q0JaaLaqhGUuj" +
       "iqE2GGY6ptEaFNFc6vjYQA1yqZGK4oel1fbL+pWGqbaW07fJ/4c2OmCcRStC" +
       "IaqCQaIDiFPbmanHqZNoiG5IT53+xcMNr4Rtg+ASolgF7uUidxIKIdc+YDRM" +
       "qVQly6lxU6fXdUz9ZbOX3ViaQ9GUXJFLBQpVSz3OtdrxALPQGUYpDH99QXLZ" +
       "urMHnhcmnRZTJ2lMU5uUdNysq56qpxPUmfSxi+ap1M8k0LtJPWx+Moo0Junn" +
       "843MJ1KylMMEyAZS6JeJBijrZo+1x77ZvWmN7piiScp8HsJPCRZeKqohpUfV" +
       "GPWZDvuxEWVvw/41ZWGSS90GHZtJRwZeaIjYhsfSKy2vCWPpRIfXpKdalTi8" +
       "sqTSxWxJ6SucEsRHd3zuSbVUaNkC/c9ZzXMN3vZOQtqH4QnULowCvfL59cmt" +
       "R177w1lhEnYceA/XhFivmpUupwHMeqB76OmgaH5KVWm9D++qu2PjZ2uXIIRo" +
       "jeGyBssgrabOgk6LVMzXH2p7/+hH298OO7Az6ZyZboxr0Q57kFBOuvDBtfC8" +
       "0TVI2tpIpz/U6cSp46PdNcoWJFr1mNakKY1xFXD+3z1GnLn3T+uKGA7itIRJ" +
       "NUVOOzEDp7z/VHL1K5d/OwTZhKIw6Tkyc6oxT9rb4VyVSikroR8d17w1+O6D" +
       "ylbqk6kfNLRVKro2gjIgqLQzcPzjMK0Q3o2HJELNWXxJmxvoGC0aD40bNBZU" +
       "NET7fllakZwx7WPUdxdwEzRW0qI0Chrks7lq+y0YHszdzVblwb7Ks5zXYDL9" +
       "xD7w9nMvi8S+jJQuQTspjKlGNKUlLWBRT9/F0FqTcSpuNYbmTWMMU59NxWcH" +
       "TCklYcTpBMNcwnx8Ob0jmYLpul1JoZ5QKsM7AKR2N+ogDmuITrx5bUofftM5" +
       "YS7I7pAM66BRYIx5qUgyGolb7uVcgDHysJp1hOk03RDdWnznvl6/WF/F5uKh" +
       "Xgpf7fPOqL6hYcKjhxH0AJAhorTmqQr18UycDdEvt32gzjv7uz8zI9VXJMT4" +
       "MUlDn6iWVCCG5E8QeqaQC4xjCu1ViQ8WnP05t96z+7OP6qYgll0KgADBF6Ny" +
       "DbtEB2m1d66w+1M+X0/aXWqIXt73jXGD9i36qVtMAoGr9roHt+T/5bTv7sFh" +
       "2zAYLsDAJgiEAqSTWX/RV3gU5O6kW0/9ij98+1D7zD+z7oo4kFFcML7P08dK" +
       "+q/mmoUGp/FWIZspVfYldBniKDtSXvPcgfx5L7uUjRqkIliBFZk+Ia1yFDCX" +
       "Mh4hk+dU3TT1VpdUzx/+wRWV37+5xzKA6bZUxngHKFC6h5k39qn+635zda3F" +
       "YxYbaq1rqBezognMh/9A/0L0/2/wD34KCiCnMXw1jxwjduiYTFJ77Oy2wwXI" +
       "5jwDHIsQvMxUjBY6+RyJv7d444djhzBduSYn/v7Jaddv3PTE4xNYfNOVNl10" +
       "wRRCmM8E5hdAshCHc5kzmoWe0UiK5jhkjY6+F9r69hexvAT9NSxgB3lirBmw" +
       "onLiiuiq8/9t/d/aaFyRs5h0b1GMWQk6D8MCjq4TwSnbn0zS02Wt6O0guoi7" +
       "IyVx1SE0trhi55YB1T86jo7ACWKAemiHPxpdqLjiq/EPtX4dLs17IUzyaRiI" +
       "wR1dLC9U4mkIDRbTtZ9RzQtrSDfPe+86ji1aKu0gbZAYQLmaFcMnJwqmz1Ab" +
       "nrsIERP8k3HsIXw2zwe6I6YQwYcEkpRiOgKS0aizMDyOMWnLWkKJC0FKEec3" +
       "gOfdXXxNUqCnmpWERpcPhmeKxBlCjbF13Y4Hdj5c2fXBHegAClB/VJsmnw47" +
       "A4X1mQ2tm3doEd70WNnQ3EZJ3w+QEZS5CTDr4OYH6WKp8dgcB0LhUM5pDM9H" +
       "iPHolXT8ZVL3D7h1eatBWmt6+1cv1yEku+FeiqV8k/QXAe8E7ejZvJ0axDsz" +
       "UtYpwzdrI0O30ztS8/228999eq89a/cXggvHGM556aGc1xcu3cpU6FoNuCdU" +
       "WFC5diT4VsiQTGNiOyE4sOX2wIbAwMbwFfCTPN/tHhhhWF4rx3IOx3KegTtH" +
       "8CmFTSw0SajW8HsMqppW6nLa+T6FeuOGm34oX7ch7NrMGe7bT3HTuIbRjbvF" +
       "FBkW1ApSzPj33WueemDNWubee3m3JqYn0q273v3+1fK7Pn5JshousOFlLYUG" +
       "ZdAcNlX6af7aWcdm70CXWwRuC2MJ6rfAFLFoVsJbVKgZNmZxaLdDcgesoXHa" +
       "8OpLtI7RPgN1zy0rkeHdzvyz0j8leYuKTdIdNwBqLW+D4yYuU26xewTGTE6n" +
       "/8W0J5t4npZ4w3vkCKLLtXwqXxqZqYIrLOTMTJ63elxhLyUe16O4C2ks1AzN" +
       "CtXS3p7158TXynomOLPeMoIrfc7sweydWR8oLOGcruH5GtGZ7cL6V3mpinnt" +
       "q2RUWPVal2E6COkna/LqQIQ8hL3Y68DhIT9CvEW3ugKS26gCG3U9rioJF0we" +
       "lMFkBOtfeD/Pt0tgsp/BBJKf+/EAVD/n+RYPHrpTG65PN7ZqhgGQkGGhmBPu" +
       "kjUvYKGHjOB+Hxaezx4LMLOjaoHTTp4/IGLhkIAFpOJ6DT8oowrAQm9Zk78I" +
       "xMIL2Is3HMW/4MfCC0FYyKHrfBcOnpfhYAKDaPhLnr8swcGRQBwA1Us8f86D" +
       "g0IjGASjONW/ytoWQDBMRnDUB4Kj2YOgFApHck6/5/nHIgg+FUCAVMN57d/J" +
       "qAJAMELW5KeBIPgYe3Hc0fjHfhA4RSkywJkOMUbHTSo2wR88q2Tj2ju+7Ucj" +
       "mcUkn8fwGM3P1RP4QXIC4qL/fOfR4291G/ww7vfkNioGC8nFoyP/yZDnwAfH" +
       "09ULhGGWPjMCQUDOUF7xwyyQ019G8J4POd9kjxyMtIdwTr/l+REROf8pIAep" +
       "BvLa78uoApAzWNbkbwKR8y30IhR2YPKtHznfupDjPXyl/tswXcdfl45e+Ox1" +
       "/Y2bWdA2xkaJ2mGWYyjPSUW694/kjC80y/4Bw2cbNJ3pYs+AmiaJZD54RV4s" +
       "viy0JYEHRr3ofx79X8LzOpMs+Hse5tQpSTXFT4n+bxijcrpYMR7u3pbjSzzU" +
       "8WmiIdpz8ubGpmunHMSguAcKDyPWeibGkd7VCCcqq/fW855ES3XXED22+9ZD" +
       "w/64sDceMVpqcp8jzFGSleK5AWzN0PJO+R88+y99l72ZQ8IzSJe4rsRmKHgE" +
       "QwrMlpRqtOjxWEeSG1ZoBSxxwsSKra/zzpZlXLmtPF8KIusKcA9142uhUL+g" +
       "tRAkN0Nir4MKq/CqAApENmPaWywhtsewAR6HkBARfArgDyM7MMN3ef6G6FNC" +
       "kex9Co64H+f0Ds/fFHxKqEzwKXZUAbXfklH5fMo0m7ivrMm3fcQzHZ8Swg3K" +
       "0Gm2AwkN8/kUp6ijw7szkBmWZ1ZG5z6nTx6D2M4zWzSj7Aw8hpFAupKJtg82" +
       "UoEoyrURhAfL/8HjltDZcnCEbXDYuMiLq4lmk4VGacZDdvgyn/aMH35s+qbP" +
       "vGsv+esC9GvhKMZZQ2tI56Z0PD7XXrFCOpHxM8kUZBLRmyLUbUSMpBrVlHjE" +
       "2tyOlMK4SyNaIoJ+YMnq2k9uWL/mMsw+uWnHmiWXJe2NYXtno1pJJHTTdyqR" +
       "F9X2flbR9L21qXs+08/nfGj2ML/Gt9+gL4JkAu6dSM/OprcmTTztWvVEvz3n" +
       "3b/tI9w78WlBnEfm4NTvbKdMvHda2aDn2tb9/Y6Y4eNA+WnyUCGYETvz4Jyd" +
       "L104Mro+THLsPUrf/RUvUaV3Z7ILa3W+Z39yCBMzCPQCJ3QeiVjDz9JzwNDs" +
       "gHc1kFxIHVQ0rifUEyszmUyGQoT4eDE/xpwe2sjFJ3RRrDLUnc8ciMtlSjfF" +
       "nRCEkS1y4o2gLXhIF3TAJkRJJgOAKu+gWJmBY2wQmgpJNQnBW77UOSpb6pzB" +
       "4q+cpTyf5HZ13GU0BC51gGoiz89wUdOJxbUFIgSs+ZaPhsluB7FvuEyqaNFb" +
       "1Yor1FjFCj21vAKcXYzaFz7EtcbTadCAzzjn8vmVxySnTOsAILSMAaAlGwDQ" +
       "ypAud7z8Mr/jX+aLQTlZxjr+olA+JCqSpa3oqAg8ijvKwJpFmBbzzuZgLIHu" +
       "XYglcJ9uBJf7L4mzrxpqQgE0W7HEqgyxhH2Jwd5bFQ4MTvZEzCShhXb0EboG" +
       "BzsYknZIhgqxBux147ITUDeX5zPd2MXeX599rIGLiWGc0xyez3JzBIY/FWIN" +
       "ewkCtWfLqAJijYisyRofsTvWuAF7cbsDlBv82PEWOTqH3SIUHOh6F8/vk+h8" +
       "U+b4MXQVJD+G5GrsyjVUbxfBw3UZdYXbhQP48GbwfIpPV5uz1xWOpD/nNJ3n" +
       "VaKu/lHQFVL15bWnyqgCdFUia3JaoK62YC/udxSzxa+rLa64ED6fCQm70cR0" +
       "0dLhmizt3uBfHlfhnTy/3dUbrFniXJkZnOkOJ54IbL92w7ZY7Y4zrcjodpOu" +
       "TPTk6XG1nS8JGKs87KMjFLybBSieRD16Mc+JoAdSJBuBfeOJkuT9wPPvxBE4" +
       "8747oHWmEdj7Iufyhit4PsijFc/uD4tYq1LNPGB9oNsLr3xWMuMQ7t6Eoxpc" +
       "/PFdmYupmeKcdJJOye54K9yON9NaWYxrd3OCrJtj3N00SSO026qnki0avxcA" +
       "QTG7LhdRUs24wI4kIQiAF2z3KNKiJGJx1dlXjoxuhO6osYjSqLerkcaVETtU" +
       "GMOmCBb2hgC7ob1MQfD4yyCBQ4WnGEL3QXIAof0MIvTZk+PnP2ZfkFie0Fck" +
       "2NZIfeHO9E/2n37EgiI/Q8P2XgqIBQ9DsodOi6JE7DnFtaLNbde1mCwQlFxe" +
       "4b3jgOlT8aettX/95BGrexPZqJMe0f5aKKQzI+rNCTMOMJf3fvYuD87xyWQO" +
       "nXKejxVd3m8Fl4dU5/Da42RUPpfnbK9NkjV5uo/YHdowXPze8W8H/C7PKRKv" +
       "htTQYDHuLETm33LwvXPuPrYeF8DB9zwEyvj2+MGar1a+ZmnJOU9GhzGFj+Vs" +
       "mcPgMe9x+RyI8bS9QnaplZsIarXN2sXyGAskX6DBSPUNb+CkIPQXm8dxZIRv" +
       "ng+A/lcIfUheg+R1Irk02eaZkcFl45Y7jH6g5b/dUkAZnMTuL55EjOCcBvC8" +
       "rwhPcfcXqUp57X4yqgB4lsma7B8IT9z9DTu7vyH/7q9TBOkCCHNBx6NkSvlV" +
       "ZqWEC06sFBQxtiKbVqHmxXSKfJbnWwVhnmBaBZItPN/kIg3oclHAu16QFJqk" +
       "e7NqZj7FtOMBaPUxWccFIA6QEewUgRjumz0Q7es5wOlRnu8SZBceIADRvj8D" +
       "tR+WUQUAcYisyUeCgBjuh70otVFHC0QgCkWfe4U8wJJVRiGDQwqPdi1tC2mQ" +
       "UWLdAVbgBCsCJw/2HcTw2BNKmbGBuuWOwRT6bajQb3qM7KzsyNr4bg18oSOD" +
       "LwNuXdEOKuFxcjZ9ZwRhVmsaK8Bn146NUDTHIatyVNPVr62uHrchM2hwVYvo" +
       "8y08T52cQQNJG8+XZzZoeZx8GnC5gFPfx/M7RMyE9tkEk2UE97gJTjViBQei" +
       "oveYm4Yv751cxBq+0I4wwzODhg4V5jgRa7gWdViH7uTik+IHVV9B6kUBDnIJ" +
       "JDNo/CmOT+Yi+3CBrpZBQXCR3WUEnltCOKaG7F0kXh3pzTmt4nm7gMZwVHCR" +
       "SFXEa6+QUQW4yF6yJlf6iN0uEnfJws7mWti/S+YUQfpOhp1dDMepnv0xurvQ" +
       "F6NTxKBg27MXLKzwyI/46Hbw/F5RsCsFwSJVJa/9TzKqAMGeL2vSf2/ILVhm" +
       "Cdc4Uqz1C9ZTFPqD149M583slPkRFj6Hb2C+DNNsw2dqryjwNk/4bFkuJLcw" +
       "64V0HiQ3WfXDN7RZUVl4foCVrkMrhWSp0+zl+KqBYciZb5wFq2sDAY5Kq+1T" +
       "l4Zozdfv9G0frb/Ivlpi38NEJuI32WCHDwSGQnuG53t8upI7NAcvlwCbSzn5" +
       "AZ4/7ceLFLGIIRzvRtHR4D2ccZzfemuy8jman2VvD7DCIGM5p9t5fqtoD9uE" +
       "8SHVKF57nYwqwB7GyJq8LdAeNmMv7nPAv9lvD5s9s7t7UeCD30UB8Nt1CvCD" +
       "l7CzF74jAzzg3Sbk8RimP8M+ChEInvWA9TbS5zt5vkJQhTsCkRz0AEk7z3UX" +
       "aVYRyFnAZQanfpTn20TFuCKQKTICz91Ak2inFIHAkaZCZ+imlf+bQGSPEzjs" +
       "PVEg8qQrENmHStqPtvT0SfFrswORFwMwdgiSfzZJvwzDFPSCwOjDxftjGTAE" +
       "N9FDRrDK4yaY4ZyXFNwBXhXtzSmu4vlq0R28LrgD+4Ip1L5SRuVzByjPN/xx" +
       "/GFs4F3HrA/7Lf1w9iHFHllIsScopNiXUTZV1sQKo3uE596FsCAXpJjKa+6S" +
       "UQS4yWmy5nb7iN1ukuHWuXNJC3zC25chbEDjr+HNPC4zfh42fH4qYcOT2LPf" +
       "tXnDBm5nkHyDtpZpPgwfgOQri0f48zbblz8bYGffoZ1B8pLTFWaer4rY8fhy" +
       "WypwT480c2m8xfMXfUo4UTygApsmTv4mz9/wsTlRPPCDaOgY643n/LZaU4cH" +
       "kjTLyZUDGr5xQc7kVFt4fpdg7Dn5wliQqpzXvltGFQDqM2RNbg4CdU4n7EUP" +
       "G8G0QAS1UOTIB06dyXzezAGe/8onnz7Zx0u1UFjPOT3N8ydFmZUIMkOqOl77" +
       "KRlVgMzmyZrcHyizYuxFxBFQsV9mdpEnVBLN64nM5pUz6lTNC5LvM4dKOYz9" +
       "aZjm2goSN2tgU/onVFWLeD5V0MIJNmuApIrnlS7SgAGPD3gHk0fO6SbpRSUJ" +
       "0U2Vc6+mLbsdf7yhX8Z7tMQanA+sE08IVqg1CTtV6ah7kh8Bk/zAYWRTsiOD" +
       "NOM22m00IjjG89dOTjNAcpjnB7PTTMAVNLytkTPdJMWGalb5vvCVpXJw5TWK" +
       "d+qP1vh8yqnNSjl12K96R6R1finX+ZXDyC7NjgyVAz8pIf4CD5zplfh+1Iv9" +
       "EFX04W09OvfbtuA99lUJ68eiCvj9UPc3m13PecmU2qShYgvYejqJPW0wSS7c" +
       "D4fnZfbXAovwmiZ8zbqcfc26g3mJEunMaZ+Owu2Jgzz3T8BBM2cANDTvV6Dh" +
       "2mea/WpaQ/Tz8WdOe/rQyIP8hxcyXj53KHZvmz139RfnsC9Nd6KR/SqMuTvX" +
       "kHy23sE+wM+8DMvIzeKVN3PMf3V/pGCE");
    public static final String jlc$ClassType$jif$1 =
      ("5ydCermMp8SN0xInBFvrfI3Y/TMb7p91a4guJ2tufn5tr2vwGzUFmjE/labQ" +
       "iMH3hK1LJ8DrenZ+nmTYbqOMR4m/P+Fi677HG7ri7tqa/B8ute/xSvXDbj7+" +
       "D3cppwRETwAA");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) {
        super();
        this.jif$conf_ConferenceSystem_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O,
                                         final Object o) {
        if (o instanceof ConferenceSystem) {
            ConferenceSystem c = (ConferenceSystem) o;
            return jif.lang.PrincipalUtil.equivalentTo(
                                            c.jif$conf_ConferenceSystem_O,
                                            jif$O);
        }
        return false;
    }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(
      final jif.lang.Principal jif$O, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501366858220L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "Pf/gFd0ucQu5ViuSwS2zoMNZTcCbubqW");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "ZdSFJbeeHoLRM27n9jPpFXX/H15udAdEPgAA");
}
